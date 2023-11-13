package company;

import util.Date;

public class Project {
    private String name;
    private Date deadline;
    private boolean finished;

    public Project(String name, Date deadline) {
        this.name = name;
        this.deadline = deadline;
        this.finished = false;
    }

    public String getName() {
        return name;
    }

    public boolean isFinished() {
        return finished;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nDeadline: " + deadline + "\nFinished: " + finished + "\n";
    }

}
