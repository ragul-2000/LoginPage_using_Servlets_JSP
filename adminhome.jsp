<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home Page</title>
</head>
<body>
  <h1>Admin Home Page</h1>
  <p>Welcome <%= session.getAttribute("username") %></p>
</body>
</html>