package model;

public class Task {
    private Long id;
    private String name;
    private String description;
    private String deadlineDate;

    public Task() {

    }

    public Task(String name, String description, String deadlineDate) {
        this.name = name;
        this.description = description;
        this.deadlineDate = deadlineDate;
    }

    public Task(Long id, String name, String description, String deadlineDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadlineDate = deadlineDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", deadlineDate='" + deadlineDate + '\'' +
                '}';
    }
}
