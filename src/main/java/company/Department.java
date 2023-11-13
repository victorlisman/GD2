package company;

import person.Manager;
import person.Person;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Project> projects;
    private List<Project> finishedProjects;
    private List<Department> subDepartments;
    private List<Person> employees;
    private Manager manager;
    private String jobName;

    public Department(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
        this.jobName = name;

        projects = new ArrayList<Project>();
        finishedProjects = new ArrayList<Project>();
        subDepartments = new ArrayList<Department>();
        employees = new ArrayList<Person>();
    }

    public void start(Project newProject) {
        projects.add(newProject);

        for (Person employee : employees) {
            employee.addProject(newProject);
        }

        manager.addProject(newProject);

        System.out.println("Project " + newProject.getName() + " was started!");
    }

    public void sell(Project newProject) {
        for (Project project : finishedProjects) {
            if (project.equals(newProject)) {
                projects.remove(project);

                System.out.println("Project " + project.getName() + " was sold!");
            }
        }
    }

    public void finish(Project newProject) {
        for (Person employee : employees) {
            employee.removeProject(newProject);
        }

        manager.removeProject(newProject);

        projects.remove(newProject);
        finishedProjects.add(newProject);
        System.out.println("Project " + newProject.getName() + " was finished!");
    }

    public void addEmployee(Person newEmployee) {
        employees.add(newEmployee);
        System.out.println("Employee " + newEmployee.getName() + " was added to the department " + name + " working in " + newEmployee.getJob().getName() + " and earning " + newEmployee.getJob().getSalary() + "!");
    }

    public void removeEmployee(Person newEmployee) {
        employees.remove(newEmployee);
    }

    public Person findEmployee(int registryNumber) {
        for (Person employee : employees) {
            if (employee.getRegistryNumber() == registryNumber) {
                return employee;
            }
        }

        return null;
    }

    public void addSubDepartment(Department newDepartment) {
        subDepartments.add(newDepartment);
        System.out.println("Subdepartment " + newDepartment.getName() + " was added to the department " + name + "!");
    }

    public List<Person> getEmployees() {
        return this.employees;
    }

    public String getName() {
        return name;
    }

    public Manager getManager() {
        return manager;
    }
}
