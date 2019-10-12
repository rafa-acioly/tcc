<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ops...</title>
    </head>
        <% String error = (String)request.getParameter("erro"); %>
        <h1><%= error %></h1>
</html>
