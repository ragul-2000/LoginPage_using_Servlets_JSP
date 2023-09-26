package com.servletproj;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
    	
      conn = Database.getConnection();
      stmt = conn.createStatement();

      String sql = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
      rs = stmt.executeQuery(sql);

      if (rs.next()) {
    	  HttpSession session = request.getSession();
          session.setAttribute("username", username);
        String userType = rs.getString("userType");
        

        if (userType.equals("A")) {
          request.getRequestDispatcher("adminhome.jsp").forward(request, response);
        } else if (userType.equals("E")) {
          request.getRequestDispatcher("employeehome.jsp").forward(request, response);
        }
      } else {
    	  RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
          rd.forward(request, response);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (stmt != null) {
          stmt.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
