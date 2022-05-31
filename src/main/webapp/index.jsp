<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>Index</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>

    <body>
        <h2>Hello Cats With DB Running!</h2>

        <div class="col-sm-4 center-block text-center">
            <div class="p-3">
                <form action="user" method="get">
                    <input type="hidden" name="command" value="get_all_users">
                    <button type="submit" class="btn btn-primary btn-lg">Show All Users</button>
                </form>
            </div>
        </div>



        <a href="user/show_all_users">get all users</a>
        <hr>
        <a href="user/show_user_details">show user details</a>
             <hr>
        <a href="user/error">error</a>
             <hr>
        <a href="show_all_users">get all users</a>
          <hr>
        <a href="show_user_details">show user details</a>
               <hr>
        <a href="error">error</a>
               <hr>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>