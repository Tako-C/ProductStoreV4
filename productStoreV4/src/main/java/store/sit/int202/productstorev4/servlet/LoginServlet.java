package store.sit.int202.productstorev4.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import store.sit.int202.productstorev4.model.Person;
import store.sit.int202.productstorev4.model.Product;
import store.sit.int202.productstorev4.repository.PersonRepository;
import store.sit.int202.productstorev4.repository.ProductRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ProductRepository productRepository = new ProductRepository();
        List<Product> products = productRepository.findAll();
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        productRepository.close();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username == null || username.isEmpty() || password.isEmpty()) {
            resp.sendRedirect("login.jsp");
        } else {
            PersonRepository personRepository = new PersonRepository();
            List<Person> persons = personRepository.findByPersonName(username);
            personRepository.close();

            if (!persons.isEmpty()) {
                Person person = persons.get(0); // เลือก Person ที่ถูกพบ (ในกรณีที่มีหลาย Person ที่มี username เดียวกัน)

                if (password.equals(person.getPassword())) {
                    HttpSession session = req.getSession();
                    session.setAttribute("username", username);
                    resp.sendRedirect("product-list");
                } else {
                    resp.setContentType("text/html");
                    PrintWriter out = resp.getWriter();
                    out.println("<h2>Error: Invalid Password</h2>");
                }
            } else {
                resp.setContentType("text/html");
                PrintWriter out = resp.getWriter();
                out.println("<h2>Error: User Not Found</h2>");
            }
        }
    }
}
