package org.example;

import javax.naming.InvalidNameException;
import java.util.ArrayList;

public class Employee {
    String firstName;
    String lastName;
    Integer id;
    Character gender;
    String role;
    Double salary;
    String type;
    ArrayList<String> projects;

    public Employee(String firstName, String lastName, Integer id, Character gender, String role, Double salary, String type, ArrayList<String> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.gender = gender;
        this.role = role;
        this.salary = salary;
        this.type = type;
        this.projects = projects;
    }

    public Employee(String firstName, String lastName, Integer id, Character gender, String role, Double salary, String type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.gender = gender;
        this.role = role;
        this.salary = salary;
        this.type = type;
        this.projects = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<String> projects) {
        this.projects = projects;
    }

    public void addProject(String project){
        this.projects.add(project);
    }

    public void adjustSalary(double adjAmount) {
        salary = salary + adjAmount;
    }

    public void validateLastName() throws Exception {
        if(!this.lastName.matches("^[a-zA-Z]*$")) {
            throw new InvalidNameException("The last name can only contain alphabets");
        }
    }
}
