<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
 
<body>
<form action="performAction.do" method="post" >
NAME:<input type="text" name="name"/><br/>
EMAIL:<input type="text" name="email"/><br/>
PASSWORD:<input type="password" name="password" /><br/>
<input type="submit" name="signup" value="REGISTER"/><br>
<h2>
    <% if(!(request.getAttribute("msg") == null)){
    out.println(request.getAttribute("msg")); }%>
</h2>
</form>
</body>