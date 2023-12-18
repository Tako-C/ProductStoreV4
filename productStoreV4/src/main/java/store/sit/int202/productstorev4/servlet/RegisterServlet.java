package store.sit.int202.productstorev4.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import store.sit.int202.productstorev4.model.Person;
import store.sit.int202.productstorev4.repository.PersonRepository;

import java.io.IOException;
import java.util.Random;

@WebServlet(name = "RegisterServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Random random = new Random();
        Person person = new Person();
        person.setPersonID(random.nextInt(1000));
        person.setUsername(username);
        person.setEmail(email);
        person.setPassword(password);

        PersonRepository personRepository = new PersonRepository();
        personRepository.insertPerson(person);
        resp.sendRedirect( "loginServlet");

    }
}
