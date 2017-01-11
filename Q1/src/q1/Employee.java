/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

import java.util.Date;

/**
 *
 * @author Rin's
 */
public class Employee {
    String id, name;
    double salary;
    Date date;
    boolean type;

    public Employee(String id, String name, double salary, Date date, boolean type) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.date = date;
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        Employee e = (Employee)obj;
        return id.equalsIgnoreCase(e.getId());
    }

    public Object[] toObject() {
        return new Object[] {id,name,salary,date,type?"Partime":"Fulltime"};
    }
    
}
