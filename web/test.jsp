
<%@page import="Controller.Test"%>
<%@page import="Controller.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="TestServlet" method="post">
            <input name="email" type="text">
            <input name="password" type="password">
            <button type="submit">do</button>
            <%
                
            out.println(Database.checkEmail((String)session.getAttribute("notregister")));
            %>
        </form>
    </body>
</html>
