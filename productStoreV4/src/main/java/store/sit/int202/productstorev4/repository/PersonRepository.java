package store.sit.int202.productstorev4.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import store.sit.int202.productstorev4.model.Person;
import store.sit.int202.productstorev4.model.Product;


import java.util.List;

import static store.sit.int202.productstorev4.repository.EntityManagerBuilder.getEntityManager;

public class PersonRepository {
    private EntityManager entityManager;
    public boolean insertPerson(Person person) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(person);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public List<Person> findByPersonName(String username) {
        username = username.toLowerCase()+'%';
        Query query =
                getEntityManager().createNamedQuery("PERSON.FIND_PASSWORD_BY_USERNAME");
        query.setParameter("username", username);
        return query.getResultList();
    }
    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
