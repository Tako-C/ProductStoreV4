<%--
  Created by IntelliJ IDEA.
  User: Phakp
  Date: 12/11/2566
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h2 {
            color: #333;
        }

        table {
            border-collapse: collapse;
            margin: 20px auto;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        a {
            text-decoration: none;
            padding: 8px 16px;
            background-color: #333;
            color: #fff;
            border-radius: 4px;
        }

        button {
            margin-top: 20px;
            border: none;
            outline: none;
            cursor: pointer;
        }
        .row{
            width: auto;
            display: flex;
        }

        .form-box {
            margin-top: 20px;
            margin-bottom: 20px;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: auto;
        }
        .col-md-3{
            margin-left: 5%;
        }
        .container4 {
            align-content: center;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 60%;
            margin: 0 auto;
            justify-content: center;
        }
        .rowInsert{
            display: flex;
            flex-wrap: wrap;
        }
        .rowInsert div {
            margin: 10px 10px;
        }
        .submitInsert {
            text-align: center;
            height: auto;
            margin-top: 10%;
        }

    </style>
</head>

<body>
<div class="container">
<%--  login complet--%>
    <p>Hello, <%= session.getAttribute("username") %></p>
        <form action="logoutServlet" method="post">
            <input type="submit" value="Logout">
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
                <td><a href="product-update?productID=${product.productID}">Edit</a></td>


            </tr>
        </c:forEach>
    </table>
    <br>

    <div class="row">
        <div class="col-md-3">
            <div class="form-box">
                <h3>Delete Product:</h3>
                <form action="product-delete" method="post">
                    <div>
                        <input type="text" name="productID" placeholder="productID">
                    </div><br>
                    <input type="submit" value="Delete">
                </form>
            </div>
        </div>

        <div class="col-md-3">
            <div class="form-box">
                <h3>Find Product:</h3>
                <form action="product-find" method="post">
                    <div>
                        <input type="text" name="productName" placeholder="productName">
                    </div><br>
                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>

<%--        <div class="col-md-3">--%>
<%--            <div class="form-box">--%>
<%--                <h3>Update Product:</h3>--%>
<%--                <form action="product-update" method="post">--%>
<%--                    <div>--%>
<%--                        <input type="text" name="productID" placeholder="productID">--%>
<%--                    </div><br>--%>
<%--                    <input type="submit" value="Submit">--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>

        <div class="container4">
            <div class="row bg-light">
                <h1>insert Product:</h1>
            </div>
            <div class="boxform">
                <form action="product-insert" method="post" class="rowInsert">
                    <div>
                        <input type="text" id="productID" name="productID" placeholder="productID">
                    </div>
                    <div>
                        <input type="text" id="productName" name="productName" placeholder="productName">
                    </div>
                    <div>
                        <input type="text" id="price" name="price" placeholder="price">
                    </div>
                    <div>
                        <input type="text" id="quantity" name="quantity" placeholder="quantity">
                    </div>
                    <input class="submitInsert" type="submit" value="submit">
                </form>
            </div>
        </div>
    </div>
    <a href="index.jsp" style="color: white; text-decoration: none;">Index</a>
</div>
</body>
</html>
