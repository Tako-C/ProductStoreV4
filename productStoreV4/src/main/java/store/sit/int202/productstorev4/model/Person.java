package store.sit.int202.productstorev4.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Person")
@Getter
@Setter
@NamedQuery(name = "PERSON.FIND_PASSWORD_BY_USERNAME", query = "select ps from Person ps where ps.username like :username")

public class Person {
    @Id
    private int personID;
    private String username;
    private String password;
    private String email;
}
