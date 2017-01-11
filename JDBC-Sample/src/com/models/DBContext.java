/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entiti.ProductCode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rin's
 */
public class DBContext {
    Connection conn = null;
    //open db connection
    public DBContext() throws Exception {
        //loading the driver
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        //get connection object = connection string
        String url = "jdbc:derby://localhost:1527/sample";
        conn = DriverManager.getConnection(url, "app", "app");
    }
    //close db connection
    public void close() throws Exception {
        if (conn != null) {
            conn.close();
        }
    }
    //scrollable + updateable resultset
    public ResultSet getAllScrollableProductCode() throws Exception {
        String sql = "select * from Product_code";
        PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = ps.executeQuery();
        
        return rs;
    }
    public void commit() throws Exception {
        conn.commit();
    }
    
    //excute sql statement
    //select
    public List<ProductCode> getAllProductCode() throws Exception {
        //create an empty list
        List<ProductCode> pc = new ArrayList<>();
        String sql = "Select * from Product_Code";
        //create sql command
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql); // forward only, read only
        while(rs.next()) {
            //col 1. row i
            String pCode = rs.getString(1);
            String dCode = rs.getString(2);
            String desc = rs.getString(3);
            //create product code object
            ProductCode p = new ProductCode();
            p.setpCode(pCode);
            p.setdCode(dCode);
            p.setDescription(desc);
            //save p to the list
            pc.add(p);
        }
        rs.close();
        conn.close();
        
        return pc;
    }
    
    public List<ProductCode> getProductCodeByCode(String pCode) throws Exception {
        //create an empty list
        List<ProductCode> pc = new ArrayList<>();
        String sql = "Select * from Product_Code where PROD_CODE like '%"+ pCode +"%'";
        //create sql command
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql); // forward only, read only
        while(rs.next()) {
            //col 1. row i
            pCode = rs.getString(1);
            String dCode = rs.getString(2);
            String desc = rs.getString(3);
            //create product code object
            ProductCode p = new ProductCode();
            p.setpCode(pCode);
            p.setdCode(dCode);
            p.setDescription(desc);
            //save p to the list
            pc.add(p);
        }
        rs.close();
        conn.close();
        
        return pc;
    }
    //update
    public boolean updateProductCode(ProductCode pc) throws Exception {
        String sql = "update Product_code set Discount_Code = ?, Description = ? "
                + "where Prod_code = ?";
        PreparedStatement ps = conn.prepareCall(sql);
        ps.setString(1, pc.getdCode());
        ps.setString(2, pc.getDescription());
        ps.setString(3, pc.getpCode());
        
        return (ps.executeUpdate() != 0);
    }
    //delete
    public boolean deleteProductCode(String pCode) throws Exception {
        String sql = "delete from Product_code where Prod_code = '" + pCode + "'";
        PreparedStatement ps = conn.prepareCall(sql);
        //specify values for place holders
//        ps.setString(1, pc.getpCode());
//        ps.setString(2, pc.getdCode());
//        ps.setString(3, pc.getDescription());
        
        return (ps.executeUpdate() != 0);
    }
    //insert
    public boolean addNewProductCode(ProductCode pc) throws Exception {
//        String sql = String.format("insert into Product_code values('%s','%s','%s')", pc.getpCode(), pc.getdCode(), pc.getDescription());
        
        String sql = "insert into Product_code values(?, ?, ?)";
        PreparedStatement ps = conn.prepareCall(sql);
        //specify values for place holders
        ps.setString(1, pc.getpCode());
        ps.setString(2, pc.getdCode());
        ps.setString(3, pc.getDescription());
        
        return (ps.executeUpdate() != 0);
    }
    
}
