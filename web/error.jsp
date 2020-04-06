<%-- 
    Document   : error
    Created on : 6 Apr, 2020, 11:19:29 AM
    Author     : Ashok
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page</title>
</head>
<body>

<h2><%out.println(request.getAttribute("errormsg")); %></h2>
</body>
</html>