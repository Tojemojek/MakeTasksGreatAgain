package pl.kostrowski.mtga.MakeTasksGreatAgain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <h1>The simpliest class ever</h1>
 * It has only two fields where <br>
 * {@code id} should be string made of 3 digits and <br>
 * {@code name} should be name of city where branch is.
 *  @author Krzysztof Ostrowski
 */

@Entity
@Table(name = "mtga_branch")
public class Branch {


    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

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

    @Override
    public String toString() {
        return "Branch{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
