package person;

import java.util.List;
import java.util.ArrayList;

import company.Department;
import company.Job;
import util.Date;

public class Manager extends Person {
    private List<Department> managedDepartments;

    public Manager(String name, Date birthDate) {
        super(name, birthDate);
        this.managedDepartments = new ArrayList<Department>();
        this.setJob(new Job("Manager", 100000));
    }
}
