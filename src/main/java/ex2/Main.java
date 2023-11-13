package ex2;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import company.Company;
import company.Department;
import company.HumanResources;
import person.Manager;
import person.Person;
import util.Date;
import company.Job;
import company.Project;

public class Main {
    public static void main(String[] args) {
        HumanResources hr = new HumanResources();
        List<Department> departments = new ArrayList<Department>();
        
        Person person = new Person("Rob", new Date(1, 1, 2000));
        Person person2 = new Person("JOhn", new Date(1, 1, 2000));
        Person person3 = new Person("Mike", new Date(1, 1, 2000));


        Manager manager = new Manager("Alex", new Date(1, 1, 2000));
        Department department = new Department("IT", manager);
        departments.add(department);

        Department department2 = new Department("Sales", manager);
        departments.add(department2);

        Department department3 = new Department("Finance", manager);
        departments.add(department3);

        List<Job> jobs = new ArrayList<Job>();
        jobs.add(new Job("Finance", 2000));
        jobs.add(new Job("IT", 4000));
        jobs.add(new Job("Sales", 1000));

        Company company = new Company(hr, departments, jobs);

        company.hireEmployee(person);
        company.hireEmployee(person2);
        company.hireEmployee(person3);

        person.setJob(company.getJobFromString("IT"));
        person2.setJob(company.getJobFromString("IT"));
        person3.setJob(company.getJobFromString("IT"));
        
        department.addEmployee(person);
        department.addEmployee(person2);
        department.addEmployee(person3);
        
        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Start Project");
            System.out.println("3. Add Department");
            System.out.println("4. Add Job");
            System.out.println("5. Print jobs by salary in descending order"); 
            System.out.println("6. Fire Employee");
            System.out.println("7. Add Sub Department");

            int choice = Integer.parseInt(System.console().readLine());

            switch (choice) {
                // Add employee
                case 1:
                    System.out.println("Enter name: ");
                    String name = System.console().readLine();
                    System.out.println("Enter birth date: ");
                    String birthDate = System.console().readLine();
                    Person newPerson = new Person(name, new Date(birthDate));
                    hr.hire(newPerson);
                    System.out.println("Enter department: ");
                    String departmentName = System.console().readLine();
                    System.out.println("Enter job: ");
                    String jobName = System.console().readLine();
                    Job employeeJob = company.getJobFromString(jobName);
                    System.out.println("Enter start date: ");
                    String startDate = System.console().readLine();
                    newPerson.setJob(employeeJob);
                    employeeJob.setStartDate(startDate);
                    company.getDepartmentFromString(departmentName).addEmployee(newPerson);
                    break;
                
                // Add project
                case 2:
                    System.out.println("Enter project name: ");
                    String projectName = System.console().readLine();
                    System.out.println("Enter project end date: ");
                    String projectEndDate = System.console().readLine();
                    System.out.println("Enter project department: ");
                    String projectDepartment = System.console().readLine();
                    Project newProject = new Project(projectName, new Date(projectEndDate));
                    company.startProject(newProject, company.getDepartmentFromString(projectDepartment));
                    break;

                // Add department
                case 3:
                    System.out.println("Enter department name: ");
                    String departmentName2 = System.console().readLine();
                    System.out.println("Enter department manager name: ");
                    String departmentManagerName = System.console().readLine();
                    System.out.println("Enter department manager birth date: ");
                    String departmentManagerBirthDate = System.console().readLine();
                    System.out.println("Enter department manager start date: ");
                    String departmentManagerStartDate = System.console().readLine();
                    Manager newManager = new Manager(departmentManagerName, new Date(departmentManagerBirthDate));
                    Department newDepartment = new Department(departmentName2, newManager);
                    company.addDepartment(newDepartment);
                    break;

                // Add a job
                case 4:
                    System.out.println("Enter job name: ");
                    String jobName2 = System.console().readLine();
                    System.out.println("Enter job salary: ");
                    double jobSalary = Double.parseDouble(System.console().readLine());
                    Job newJob = new Job(jobName2, jobSalary);
                    company.addJob(newJob);
                    break;

                // Print jobs by salary in descending order
                case 5:
                    company.printJobsBySalary();
                    break;

                // Fire employee
                case 6:
                    System.out.println("Enter employee name: ");
                    String employeeName = System.console().readLine();
                    hr.dismiss(company.getEmployeeFromString(employeeName));
                    break;

                // Add sub department
                case 7:
                    System.out.println("Enter sub department name: ");
                    String subDepartmentName = System.console().readLine();
                    System.out.println("Enter sub department manager name: ");
                    String subDepartmentManagerName = System.console().readLine();
                    System.out.println("Enter sub department manager birth date: ");
                    String subDepartmentManagerBirthDate = System.console().readLine();
                    System.out.println("Enter sub department manager start date: ");
                    String subDepartmentManagerStartDate = System.console().readLine();
                    Manager newSubManager = new Manager(subDepartmentManagerName, new Date(subDepartmentManagerBirthDate));
                    Department newSubDepartment = new Department(subDepartmentName, newSubManager);
                    System.out.println("Enter parent department name: ");
                    String parentDepartmentName = System.console().readLine();
                    company.getDepartmentFromString(parentDepartmentName).addSubDepartment(newSubDepartment);
                    break;
                
            }
        }
        

    }
}