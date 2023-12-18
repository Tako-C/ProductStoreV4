package store.sit.int202.productstorev4.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import store.sit.int202.productstorev4.model.Environment;
public class EntityManagerBuilder {
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.UnitName);
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
