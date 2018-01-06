package pl.kostrowski.mtga.model;

import javax.persistence.*;

/**
 * <h1>Customers info </h1>
 * It has only two fields where
 * {@code id} is auto-generated integer <br>
 * {@code name} should be descriptive name of customer <br>
 * @author Krzysztof Ostrowski
 */

@Entity
@Table(schema = "mtgadb", name = "mtga_customer")
public class Customer {


    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
