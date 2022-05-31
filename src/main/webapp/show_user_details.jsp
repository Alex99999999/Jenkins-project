<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>All Users</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>

    <body>

  <hr>
     <div class="row center-block text-center">
          <h1> User Profile </h1>
     </div>

  <hr>

         <nav class="navbar navbar-light bg-light">
                <div class="container-fluid">
                    <div class="col-4">
                          <form action="user" method = "get" class="d-flex">
                              <input type="hidden" name="command" value="get_user_by_name">
                              <div class="col-8">
                                 <input class="form-control me-2" type="text" placeholder="Enter family name" name="family_name">
                              </div>
                              <div class="col-4">
                                  <button class="btn btn-outline-secondary btn-md btn-block" type="submit">Search</button>
                              </div>
                          </form>
                    </div>
                    <div class="col-4">
                        <form action="user" method = "get" class="d-flex">
                              <input type="hidden" name="command" value="show_all_users">
                              <div class="col-4">
                                  <button class="btn btn-outline-secondary btn-md btn-block" type="submit">All users</button>
                              </div>
                        </form>
                    </div>
                </div>
         </nav>

${message}

<form action="user" method="post">
    <table class="table table-striped table-hover">
        <tr>
            <th>Given name</th>
            <td><input type="text" name = "given_name"
                    <c:choose>
                      <c:when test="${user == null}">
                        placeholder="Enter given name"/>
                      </c:when>
                      <c:otherwise>
                        placeholder=${user.givenName}/>
                      </c:otherwise>
                    </c:choose>
                required>
            </td>
        </tr>
        <tr>
            <th>Family name</th>
            <td><input type="text" name = "family_name"
                    <c:choose>
                      <c:when test="${user == null}">
                        placeholder="Enter family name"/>
                      </c:when>
                      <c:otherwise>
                        placeholder=${user.familyName}/>
                      </c:otherwise>
                    </c:choose>
                >
            </td>
        </tr>
        <tr>
            <th>Phone number</th>
            <td><input type="text" name = "phone_number"
                    <c:choose>
                      <c:when test="${user == null}">
                        placeholder="Enter phone number"/>
                      </c:when>
                      <c:otherwise>
                        placeholder=${user.phoneNumber}/>
                      </c:otherwise>
                    </c:choose>
                >
            </td>
        </tr>
        <tr>
            <th>Age</th>
            <td><input type="text" name = "age"
                    <c:choose>
                      <c:when test="${user == null}">
                        placeholder="Enter age"/>
                      </c:when>
                      <c:otherwise>
                        placeholder=${user.age}/>
                      </c:otherwise>
                    </c:choose>
                >
            </td>
        </tr>
        </table>

    <hr>

    <input type="hidden" name="command" value = "update_user">
        <div class="d-grid gap-2 col-6 mx-auto">
            <button class="btn btn-secondary btn-md btn-block" type="submit">Apply</button>
        </div>
</form>

      <form action="user" method="get">
           <input type="hidden" name="command" value="get_all_users">
           <button class="btn btn-outline-dark btn-sm btn-block" type="submit">Show all users</button>
      </form>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>

<c:remove var = "message" />