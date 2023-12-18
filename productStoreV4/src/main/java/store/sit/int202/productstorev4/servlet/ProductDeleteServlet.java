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

@WebServlet(name = "ProductDeleteServlet", value = "/product-delete")
public class ProductDeleteServlet extends HttpServlet {



    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productID = req.getParameter("productID");
        if (productID == null || productID.isEmpty()){
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<html><body><h2>Invalid ProductID. Please provide a valid ProductID.</h2></body></html>");

        }else {
            ProductRepository productRepository = new ProductRepository();
            Product productCheck = productRepository.find(productID);

            if (productCheck != null) {
                productRepository.delete(productID);
                productRepository.close();
                resp.sendRedirect( "product-list");

            }else{
                resp.setContentType("text/html");
                PrintWriter out = resp.getWriter();
                out.println("<html><body><h2>Not find Product </h2></body></html>");
            }
        }
    }

    public void destroy() {
    }
}