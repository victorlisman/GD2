package company;

import person.Person;

import java.util.List;
import java.util.ArrayList;

public class HumanResources {
    public List<Person> employees;

    public HumanResources() {
        employees = new ArrayList<Person>();
    }

    public void hire(Person newPerson) {
        employees.add(newPerson);
        System.out.println("Employee " + newPerson.getName() + " was hired!");
    }

    public void dismiss(Person newPerson) {
        employees.remove(newPerson);
        System.out.println("Employee " + newPerson.getName() + " was dismissed!");
        
    }
}
