package com.ds.algo.datastructures.stack.array;

import java.util.Objects;

/**
 * Simple Employee POJO for stack demos.
 */
public class Employee {
    private final int id;
    private final String firstName;
    private final String lastName;

    public Employee(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId()           { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee e = (Employee) o;
        return id == e.id && Objects.equals(firstName, e.firstName) && Objects.equals(lastName, e.lastName);
    }

    @Override public int hashCode() { return Objects.hash(id, firstName, lastName); }
    @Override public String toString() { return "Employee{id=" + id + ", name='" + firstName + " " + lastName + "'}"; }
}
