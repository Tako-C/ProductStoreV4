<%--
  Created by IntelliJ IDEA.
  User: Phakp
  Date: 15/11/2566
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Offices</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Arial', sans-serif;
        }

        .container {
            background-color: #ffffff;
            padding: 30px;
            width: 40%;
            margin-top: 50px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #007bff;
            text-align: center;
        }

        label {
            font-weight: bold;
            margin-top: 10px;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            margin-top: 5px;
            border: 1px solid #ced4da;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #ffffff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Update product</h1>
    <form action="product-update" method="post">
        <div>
            <label for="productID">productID</label>
            <input type="text" name="productID" class="form-control" value="${selectedProduct.productID}" readonly>
        </div>
        <div>
            <label for="productName">productName</label>
            <input type="text" name="productName" class="form-control" value="${selectedProduct.productName}">
        </div>
        <div>
            <label for="price">price</label>
            <input type="text" name="price" class="form-control" value="${selectedProduct.price}">
        </div>
        <div>
            <label for="quantity">quantity</label>
            <input type="text" name="quantity" class="form-control" value="${selectedProduct.quantity}">
        </div>
        <br>
        <input type="submit" value="Submit" class="btn btn-primary">
    </form>
</div>
</body>
</html>
