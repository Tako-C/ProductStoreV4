package store.sit.int202.productstorev4.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import store.sit.int202.productstorev4.model.Product;
import store.sit.int202.productstorev4.repository.ProductRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProductlistServlet", value = "/product-list")
public class ProductlistServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ProductRepository productRepository = new ProductRepository();
        List<Product> products = productRepository.findAll();
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/product-edit.jsp").forward(request, response);
        productRepository.close();
    }


}