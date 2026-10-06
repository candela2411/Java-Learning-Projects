package org.ardaY.todolist;



public class Task {
    private String name;
    private Boolean isDone;
    private String deadline;
    private Boolean isHighlighted;
    Task (String name, Boolean isDone, String deadline) {
        this.name = name;
        this.isDone = isDone;
        this.deadline = deadline;
    }
    Task (String name, Boolean isDone) {
        this.name = name;
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        if (deadline == null) {
            return name;
        } else {
            return name + " - Deadline: " + deadline;
        }
    }

    public String getName() {
        return name;
    }

    public String getDeadline() {
        return deadline;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public Boolean getIsHighlighted() { return isHighlighted; }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setDeadline(String newDeadline) {
        this.deadline = newDeadline;
    }

    public void setDone(Boolean newIsDone) {
        this.isDone = newIsDone;
    }

    public void setHighlighted(Boolean highlighted) {
        isHighlighted = highlighted;
    }
}
