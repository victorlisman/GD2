package company;

import util.Date;

public class Job implements Comparable<Job> {
    private double salary;
    private Date startDate;
    private String name;

    public Job(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Added for toString() method
    public double getSalary() {
        return this.salary;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public String getName() {
        return this.name;
    }

    public Date setStartDate(String startDate) {
        return this.startDate = new Date(startDate);
    }

    @Override
    public int compareTo(Job job) {
        return (this.salary > job.salary) ? -1 : 1;
    }

    @Override
    public String toString() {
        return "Job: " + name + "\nSalary: " + salary;
    }
}
