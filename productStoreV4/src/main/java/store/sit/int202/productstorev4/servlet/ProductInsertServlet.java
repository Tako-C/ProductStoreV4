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

@WebServlet(name = "ProductInsertServlet", value = "/product-insert")
public class ProductInsertServlet extends HttpServlet {


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int productID = Integer.parseInt(req.getParameter("productID"));
    String productName = req.getParameter("productName");
    int price = Integer.parseInt(req.getParameter("price"));
    int quantity = Integer.parseInt(req.getParameter("quantity"));

    Product product = new Product();
    product.setProductID(productID);
    product.setProductName(productName);
    product.setPrice(price);
    product.setQuantity(quantity);

    ProductRepository productRepository = new ProductRepository();

        boolean insertionResult = productRepository.insert(product);
        productRepository.close();

        if (insertionResult) {

            resp.sendRedirect( "product-list");
        } else {

            resp.getWriter().println("Failed to insert product. Please try again.");
        }
    }

    public void destroy() {
    }
}