<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<h1>Login</h1><br/>
    <form action="loginServlet" method="post">
      Username: <input type="text" name="username"><br>
      Password: <input type="password" name="password"><br>
      <input type="submit" value="Login">
    </form>

<h1>Register</h1><br/>
<form action="registerServlet" method="post">
    Username: <input type="text" name="username"><br>
    Email: <input type="text" name="email"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Submit">
</form>

    <h2>Product</h2>
    <table>
      <tr>
        <th>productID</th>
        <th>productName</th>
        <th>price</th>
        <th>quantity</th>

      </tr>
      <c:forEach items="${products}" var="product">
        <tr>
          <td>${product.productID}</td>
          <td>${product.productName}</td>
          <td>${product.price}</td>
          <td>${product.quantity}</td>

        </tr>
      </c:forEach>
    </table>
</body>
</html>