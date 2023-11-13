package person;

import util.Date;
import company.Project;
import company.Job;

import java.util.List;
import java.util.ArrayList;

public class Person {
    private String name;
    private Date birthDate;
    private int registryNumber;
    private static int id = 1;
    private List<Project> projects;
    Job job;

    public Person(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.registryNumber = id++;
        this.projects = new ArrayList<Project>();
        this.job = null;
    }
    
    // Added for keeping track of employee's projects
    public void addProject(Project project) {
        projects.add(project);
    }

    public void removeProject(Project project) {
        projects.remove(project);
    }

    // Added to check for projects
    public void checkProjects() {
        for (Project project : projects) {
            System.out.println(project.toString());
        }
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Job getJob() {
        return job;
    }

    public String getName() {
        return name;
    }

    public int getRegistryNumber() {
        return registryNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nBirth Date: " + birthDate + "\nRegistry Number: " + registryNumber + "\nJob: " + job.getName() + "\nSalary: " + job.getSalary() + "\nStart Date: " + job.getStartDate() + "\n";
    }
}
