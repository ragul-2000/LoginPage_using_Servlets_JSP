<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
  <h1>Login Page</h1>
  <form action="LoginServlet" method="post">
    <table>
      <tr>
        <td>Username:</td>
        <td><input type="text" name="username"></td>
      </tr>
      <tr>
        <td>Password:</td>
        <td><input type="password" name="password"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Login"></td>
      </tr>
    </table>
  </form>
  <%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
  %>
  <p style="color:red">
    <%= errorMessage %>
  </p>
  <%
    }
  %>
</body>
</html>