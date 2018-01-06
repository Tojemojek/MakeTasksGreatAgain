package pl.kostrowski.mtga.model;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * <h1>Comment</h1>
 * Here every single user will be able to share ideas about task
 * {@code id} is auto-generated integer <br>
 * {@code contents} is a place to share ideas and thoughts <br>
 * @author Krzysztof Ostrowski
 */

@Entity
@Table(schema = "mtgadb", name = "mtga_comment")
public class Comment {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "contents", nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name="task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name="user_id" ,nullable = false)
    private User whoCommented;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getWhoCommented() {
        return whoCommented;
    }

    public void setWhoCommented(User whoCommented) {
        this.whoCommented = whoCommented;
    }
}
