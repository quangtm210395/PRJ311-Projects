/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

/**
 *
 * @author Rin's
 */
public class Student {
    private String id, name;
    private boolean activated;

    public Student() {
    }

    public Student(String id, String name, boolean activated) {
        this.id = id;
        this.name = name;
        this.activated = activated;
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

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
    
    public Object[] toObject() {
        return new Object[]{id, name, activated};
    }

    @Override
    public boolean equals(Object obj) {
        Student st = (Student)obj;
        return id.equalsIgnoreCase(st.id);
    }
    
    
    
}
