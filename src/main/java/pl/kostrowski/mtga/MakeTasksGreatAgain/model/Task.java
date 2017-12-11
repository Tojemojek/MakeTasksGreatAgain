package pl.kostrowski.mtga.MakeTasksGreatAgain.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "mtga_task")
public class Task {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "requested_on")
    private LocalDateTime requestedOn;

    @Column(name = "must_be_made_before")
    private LocalDate mustBeMadeBefore;

    @Column(name = "finished_on")
    private LocalDateTime finishedOn;

    @Column(name = "structure_element")
    private String structureElement;

    @Column(name = "work_type")
    private String workType;

    @Column(name = "work_description")
    private String workDescription;

    @Column(name = "task_status")
    private String Status;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name="ordered_by_id")
    private User orderedBy;

    @ManyToOne
    @JoinColumn(name="executed_by_id")
    private User executedBy;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getRequestedOn() {
        return requestedOn;
    }

    public void setRequestedOn(LocalDateTime requestedOn) {
        this.requestedOn = requestedOn;
    }

    public LocalDate getMustBeMadeBefore() {
        return mustBeMadeBefore;
    }

    public void setMustBeMadeBefore(LocalDate mustBeMadeBefore) {
        this.mustBeMadeBefore = mustBeMadeBefore;
    }

    public LocalDateTime getFinishedOn() {
        return finishedOn;
    }

    public void setFinishedOn(LocalDateTime finishedOn) {
        this.finishedOn = finishedOn;
    }

    public String getStructureElement() {
        return structureElement;
    }

    public void setStructureElement(String structureElement) {
        this.structureElement = structureElement;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(User orderedBy) {
        this.orderedBy = orderedBy;
    }

    public User getExecutedBy() {
        return executedBy;
    }

    public void setExecutedBy(User executedBy) {
        this.executedBy = executedBy;
    }
}



