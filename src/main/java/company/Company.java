package company;

import person.Person;
import util.Date;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Company {
    private List<Department> departments;
    private List<Job> jobs;
    private HumanResources humanResources;

    public Company(HumanResources humanResources, List<Department> departments, List<Job> jobs) {
        this.humanResources = humanResources;
        this.departments = departments;
        this.jobs = jobs;

        jobs.add(new Job("Manager", 100000));

        
        // add employees from employees.txt to the company and set their jobs
        try {
                File employeesFile = new File("./ex2/src/main/resources/employees.txt");
                Scanner scanner = new Scanner(employeesFile);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] employeeData = line.split(" - ");
                    String name = employeeData[0];
                    Date birthDate = new Date(employeeData[1]);
                    String jobName = employeeData[2];

                    Person newPerson = new Person(name, birthDate);
                    newPerson.setJob(getJobFromString(jobName));
                    newPerson.getJob().setStartDate("03/03/2020");

                    humanResources.hire(newPerson);
                    this.getDepartmentFromString(jobName).addEmployee(newPerson);
                } 
    } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
}

    public void hireEmployee(Person newPerson) {
        humanResources.hire(newPerson);
    }
    
    public void dismissEmployee(Person newPerson) {
        humanResources.dismiss(newPerson);

        for (Department department : departments) {
            department.removeEmployee(newPerson);
        }
        
    }

    public void startProject(Project newProject, Department department) {
        department.start(newProject);
        
    }

    public void sellProject(Project newProject, Department department) {
        department.sell(newProject);
    }

    public void finishProject(Project newProject, Department department) {
        department.finish(newProject);
    }

    public void addDepartment(Department newDepartment) {
        departments.add(newDepartment);
        System.out.println("Department " + newDepartment.getName() + " was added to the company with" + newDepartment.getManager().getName() + " as manager!");
    }

    // Added for searching for departments by name
    public Department getDepartmentFromString(String departmentName) {
        for (Department department : departments) {
            if (department.getName().equals(departmentName)) {
                return department;
            }
        }

        return null;
    }

    // Add job
    public void addJob(Job newJob) {
        jobs.add(newJob);
        System.out.println("Job " + newJob.getName() + " was added to the company!");
    }

    // Added for searching for jobs by name
    public Job getJobFromString(String jobName) {
        for (Job job : jobs) {
            if (job.getName().equals(jobName)) {
                return job;
            }
        }

        return null;
    }

    // Print jobs by salary in descending order
    public void printJobsBySalary() {
        Collections.sort(this.jobs);

        for (Job job : jobs) {
            System.out.println(job.toString());
        }
    }

    public Person getEmployeeFromString(String name) {
        for (Department department : departments) {
            for (Person employee : department.getEmployees()) {
                if (employee.getName().equals(name)) {
                    return employee;
                }
            }
        }

        return null;
    }

    public List<Department> getDepartments() {
        return this.departments;
    }

}