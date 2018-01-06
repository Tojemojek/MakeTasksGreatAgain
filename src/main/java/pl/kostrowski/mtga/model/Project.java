package pl.kostrowski.mtga.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Project</h1>
 * First class that have more interesting features <br>
 * {@code id} is a String and should be made of 6 digits<br>
 * {@code name and type} will hopefully be a descriptive texts<br>
 * {@code salesman} will be one of users with specified role<br>
 * @see Customer
 * @see User
 *
 * @author Krzysztof Ostrowski
 */


@Entity
@Table(schema = "mtgadb", name = "mtga_project")
public class Project {

    @Id
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name="branch_id", nullable=false)
    private Branch branch;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="salesman_id")
    private User salesman;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<Task>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getSalesman() {
        return salesman;
    }

    public void setSalesman(User salesman) {
        this.salesman = salesman;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
