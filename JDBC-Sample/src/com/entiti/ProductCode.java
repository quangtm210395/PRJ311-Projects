/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entiti;

import java.io.Serializable;

/**
 *
 * @author Rin's
 */
public class ProductCode implements Serializable{
    private String pCode, dCode, description;

    public ProductCode() {
    }

    public ProductCode(String pCode, String dCode, String description) {
        this.pCode = pCode;
        this.dCode = dCode;
        this.description = description;
    }
    
    

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getdCode() {
        return dCode;
    }

    public void setdCode(String dCode) {
        this.dCode = dCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Object[] toObject() {
        return new Object[]{pCode, dCode, description};
    }
}
