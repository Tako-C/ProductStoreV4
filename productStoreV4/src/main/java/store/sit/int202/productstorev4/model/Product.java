package store.sit.int202.productstorev4.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Productinfo")
@Getter
@Setter
@NamedQueries(
        {
        @NamedQuery(name = "PRODUCT.FIND_ALL", query = "select p from Product p"),
        @NamedQuery(name = "PRODUCT.FIND_BY_PRODUCT_NAME", query = "select p from Product p where p.productName like :productName")
})
public class Product {
    @Id
    private int productID;
    private String productName;
    private int price;
    private int quantity;

}
