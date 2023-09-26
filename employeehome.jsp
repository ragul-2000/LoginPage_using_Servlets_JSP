<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Home Page</title>
</head>
<body>
  <h1>Employee Home Page</h1>
  <h3>Welcome</h3> <h3> <%= session.getAttribute("username") %> </h3>
</body>
</html>



