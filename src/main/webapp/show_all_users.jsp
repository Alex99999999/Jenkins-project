<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>All Users</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
    </head>

    <body>

  <hr>
     <div class="row center-block text-center">
          <h1> List of All Users </h1>
      </div>
  <hr>

         <nav class="navbar navbar-light bg-light">
                  <div class="container-fluid">
                      <div class="col-4">
                            <form action="user" method = "get" class="d-flex">
                                <input type="hidden" name="command" value="find_user_by_family_name">
                                <div class="col-8">
                                   <input class="form-control me-2" type="text" placeholder="Enter family name" name="family_name">
                                </div>
                                <div class="col-4">
                                    <button class="btn btn-outline-secondary btn-md btn-block" type="submit">Search</button>
                                </div>
                            </form>
                      </div>
                  </div>
         </nav>

${message}

       <form action="user" method="post">
             <input type="hidden" name="command" value="create_user">
             <button class="btn btn-outline-dark btn-sm btn-block" type="submit">Create</button>
       </form>

       <table class="table table-striped table-hover">
        <thead class="table-light">
          <tr>
            <th class="text-center">ID</th>
            <th class="text-center">Given name</th>
            <th class="text-center">Family name</th>
            <th class="text-center">Age</th>
            <th></th>
            <th></th>
           </tr>
        </thead>

        <c:forEach var="item" items="${user_list}">
        <tr>
            <td class="text-center">${item.id}</td>
            <td class="text-center">${item.given_name}</td>
            <td class="text-center">${item.family_name}</td>
            <td class="text-center">${item.age}</td>
            <td>
                <form action="user" method="post">
                    <input type="hidden" name="command" value="update_user">
                    <input type="hidden" name="id" value=${item.id}>
                    <button class="btn btn-outline-dark btn-sm btn-block" type="submit">Update</button>
                 </form>
            </td>
            <td>
                <form action="user" method="post">
                     <input type="hidden" name="command" value="delete_user">
                     <input type="hidden" name="id" value=${item.id}>
                     <button class="btn btn-outline-dark btn-sm btn-block" type="submit">Delete</button>
                </form>
            </td>
        </tr>
        </c:forEach>
        </table>


    </body>
</html>

<c:remove var = "message" />