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

@WebServlet(name = "ProductUpdateServlet", value = "/product-update")
public class ProductUpdateServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ProductID = req.getParameter("productID");

        if (ProductID != null && !ProductID.isEmpty()) {
            ProductRepository productRepository = new ProductRepository();

            Product selectedProduct = productRepository.find(ProductID);

            if (selectedProduct != null) {
                List<Product> products = productRepository.findAll(); // กำหนด set attribute req สโคป
                req.setAttribute("selectedProduct", selectedProduct);
                productRepository.close();

                req.setAttribute("products", products);
                req.getRequestDispatcher("/product-update.jsp").forward(req, resp);
            }
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<h2>No product found for the given product.</h2>");
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productID = req.getParameter("productID");
        String productName = req.getParameter("productName");
        String price = req.getParameter("price");
        String quantity = req.getParameter("quantity");

        Product product = new Product();
        product.setProductID(Integer.parseInt(productID));
        product.setProductName(productName);
        product.setPrice(Integer.parseInt(price));
        product.setQuantity(Integer.parseInt(quantity));

        ProductRepository productRepository = new ProductRepository();

        boolean insertionResult = productRepository.update(product);
        productRepository.close();

        if (insertionResult) {

            resp.sendRedirect( "product-list");
        } else {

            resp.getWriter().println("Failed to insert product. Please try again.");
        }
    }
}