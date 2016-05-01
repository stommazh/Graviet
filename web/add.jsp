
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action ="Upload" method="post">
            <input type="text" name="title" placeholder="Title" required>
            <textarea name="desc" cols="40" rows="5" placeholder="Description" required></textarea>
            <input type="text" name="picture" placeholder="Picture URL" required>
            <input type="text" name="thumb" placeholder="Thumbs URL" required>
            <input type="text" name="cat" placeholder="Category" required>
            <button type="submit">Insert</button>
        </form>
    </body>
</html>
