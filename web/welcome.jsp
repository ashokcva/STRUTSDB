<%-- 
    Document   : welcome
    Created on : 6 Apr, 2020, 2:42:01 PM
    Author     : Ashok
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h2>
    <% if(!(request.getAttribute("msg") == null)){
    out.println(request.getAttribute("msg")); }%>
</h2>
    </body>
</html>
