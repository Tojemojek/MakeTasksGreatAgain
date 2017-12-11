package pl.kostrowski.mtga.MakeTasksGreatAgain.model;

import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Table(name = "mtga_customer")
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
