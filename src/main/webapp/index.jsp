<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>Index</title>
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

    </body>
</html>