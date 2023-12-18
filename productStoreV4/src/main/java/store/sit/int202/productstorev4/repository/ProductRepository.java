package store.sit.int202.productstorev4.repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import store.sit.int202.productstorev4.model.Product;
import java.util.List;
public class ProductRepository {
    private EntityManager entityManager;

    private EntityManager getEntityManager() {
        if
        (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Product> findAll() {
        return getEntityManager().createNamedQuery("PRODUCT.FIND_ALL").getResultList();
    }


    public Product find(String productID) {
        return getEntityManager().find(Product.class, productID);
    }

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }

    public boolean insert(Product product) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public boolean delete(String productID) {
        EntityManager entityManager = getEntityManager();
        Product product = find(productID);
        if (product != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(product);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }
    public List<Product> findByProductName(String productName) {
        productName = productName.toLowerCase()+'%';
        Query query =
                getEntityManager().createNamedQuery("PRODUCT.FIND_BY_PRODUCT_NAME");
        query.setParameter("productName", productName);
        return query.getResultList();
    }

    public boolean update(Product newProduct) {
        if (newProduct != null) {
            EntityManager entityManager = getEntityManager();
            Product product = find(String.valueOf(newProduct.getProductID()));
            if (product != null) {
                entityManager.getTransaction().begin();
                product.setProductID(newProduct.getProductID());
                product.setProductName(newProduct.getProductName());
                product.setPrice(newProduct.getPrice());
                product.setQuantity(newProduct.getQuantity());


                //set all attributes office with newOffice
                //example : office.setCountry(newOffice.getCountry());

                entityManager.getTransaction().commit();
                return true;
            }
        }
        return false;
    }

}
