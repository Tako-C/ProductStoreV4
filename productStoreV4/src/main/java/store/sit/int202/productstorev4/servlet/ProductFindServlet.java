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


@WebServlet(name = "ProductFindServlet", value = "/product-find")
public class ProductFindServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("productName");

        if (productName != null && !productName.isEmpty()) {
            ProductRepository productRepository = new ProductRepository();
            List<Product> products = productRepository.findByProductName(productName);
            productRepository.close();

            if (products.isEmpty()) {
                resp.setContentType("text/html");
                PrintWriter out = resp.getWriter();
                out.println("<h2>No offices found for the given ProductName.</h2>");
            } else {
                req.setAttribute("products", products);
                req.getRequestDispatcher("/product-find.jsp").forward(req, resp);

            }
        } else {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<h2>Please enter a valid ProductName.</h2>");
        }
    }
}