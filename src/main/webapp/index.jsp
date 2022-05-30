<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>Index</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
    </head>

    <body>
        <h2>Hello Cats With DB Running!</h2>

        <div class="col-sm-4 center-block text-center">
            <div class="p-3">
                <form action="users" method="get">
                    <input type="hidden" name="command" value="show_all_users">
                    <button type="submit" class="btn btn-primary btn-lg">"Show All Users"</button>
                </form>
            </div>
        </div>

    </body>
</html>
