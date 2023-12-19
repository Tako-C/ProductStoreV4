<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        .hidden {
            display: none;
        }
    </style>
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

<%--<h2>Products</h2>--%>

<%--<div class="container" id="product-container">--%>
<%--    <div class="row">--%>
<%--        <c:forEach items="${products}" var="product" varStatus="loop">--%>
<%--            <div class="col-md-4 mb-4 product-card ${loop.index >= 6 ? 'hidden' : ''}">--%>
<%--                <div class="card">--%>
<%--                    <img src="product-image.jpg" class="card-img-top" alt="Product Image">--%>
<%--                    <div class="card-body">--%>
<%--                        <h5 class="card-title">${product.productName}</h5>--%>
<%--                        <p class="card-text">--%>
<%--                            <strong>Price:</strong> ${product.price}<br>--%>
<%--                            <strong>Quantity:</strong> ${product.quantity}--%>
<%--                        </p>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </c:forEach>--%>
<%--    </div>--%>
<%--    <button id="next-btn" class="btn btn-primary">Next</button>--%>
<%--</div>--%>

<%--<script>--%>
<%--    document.addEventListener("DOMContentLoaded", function () {--%>
<%--        const productContainer = document.getElementById("product-container");--%>
<%--        const productCards = document.querySelectorAll(".product-card");--%>
<%--        const nextBtn = document.getElementById("next-btn");--%>

<%--        let currentPage = 1;--%>
<%--        const cardsPerPage = 6;--%>
<%--        const totalCards = productCards.length;--%>
<%--        const totalPages = Math.ceil(totalCards / cardsPerPage);--%>

<%--        function showPage(page) {--%>
<%--            const start = (page - 1) * cardsPerPage;--%>
<%--            const end = start + cardsPerPage;--%>

<%--            productCards.forEach((card, index) => {--%>
<%--                card.classList.toggle("hidden", index < start || index >= end);--%>
<%--            });--%>
<%--        }--%>

<%--        nextBtn.addEventListener("click", function () {--%>
<%--            currentPage = (currentPage % totalPages) + 1;--%>
<%--            showPage(currentPage);--%>
<%--        });--%>

<%--        showPage(currentPage);--%>
<%--    });--%>
<%--</script>--%>


<h2>Products</h2>

<div class="container" id="product-container">
    <div class="row">
        <c:forEach items="${products}" var="product" varStatus="loop">
            <div class="col-md-4 mb-4 product-card ${loop.index >= 6 ? 'hidden' : ''}">
                <div class="card">
                    <img src="product-image.jpg" class="card-img-top" alt="Product Image">
                    <div class="card-body">
                        <h5 class="card-title">${product.productName}</h5>
                        <p class="card-text">
                            <strong>Price:</strong> ${product.price}<br>
                            <strong>Quantity:</strong> ${product.quantity}
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <div class="text-center mt-3">
        <ul class="pagination" id="pagination">
            <c:forEach begin="1" end="${totalPages}" var="page">
                <li class="page-item">
                    <a class="page-link" href="#" onclick="changePage(${page})">${page}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        const productContainer = document.getElementById("product-container");
        const productCards = document.querySelectorAll(".product-card");
        const pagination = document.getElementById("pagination");

        let currentPage = 1;
        const cardsPerPage = 6;
        const totalCards = productCards.length;
        const totalPages = Math.ceil(totalCards / cardsPerPage);

        function showPage(page) {
            const start = (page - 1) * cardsPerPage;
            const end = start + cardsPerPage;

            productCards.forEach((card, index) => {
                card.classList.toggle("hidden", index < start || index >= end);
            });
        }

        function updatePagination() {
            pagination.innerHTML = "";
            for (let page = 1; page <= totalPages; page++) {
                const li = document.createElement("li");
                li.classList.add("page-item");
                const a = document.createElement("a");
                a.classList.add("page-link");
                a.href = "#";
                a.textContent = page;
                a.onclick = function () {
                    changePage(page);
                };
                li.appendChild(a);
                pagination.appendChild(li);
            }
        }

        function changePage(page) {
            currentPage = page;
            showPage(currentPage);
            updatePagination();
        }

        showPage(currentPage);
        updatePagination();
    });
</script>

</body>
</html>

