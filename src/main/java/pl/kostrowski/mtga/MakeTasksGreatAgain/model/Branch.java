package pl.kostrowski.mtga.MakeTasksGreatAgain.model;

import pl.kostrowski.mtga.MakeTasksGreatAgain.springjpa.BranchRespository;

import javax.persistence.*;

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
