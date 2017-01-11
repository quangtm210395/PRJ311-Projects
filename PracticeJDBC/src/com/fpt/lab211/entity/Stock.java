/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.lab211.entity;

/**
 *
 * @author Rin's
 */
public class Stock {
    private int id;
    private String name;
    private String add;
    private String date;
    private String note;

    public Stock(int id, String name, String add, String date, String note) {
        this.id = id;
        this.name = name;
        this.add = add;
        this.date = date;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    public Object[] toObject () {
        return new Object[] {id,name,add,date,note};
    }
}
