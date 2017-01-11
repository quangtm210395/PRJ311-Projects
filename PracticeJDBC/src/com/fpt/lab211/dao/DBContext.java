/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.lab211.dao;

import com.fpt.lab211.entity.Stock;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rin's
 */
public class DBContext {
    private Connection conn;

    public DBContext() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = ("jdbc:derby://localhost:1527/sample");
            conn = DriverManager.getConnection(url, "app", "app");
        } catch (Exception ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() throws Exception {
        conn.close();
    }
    
    public void insertBatch(ArrayList<Stock> list) throws SQLException {
        String sql = "insert into Stocks(StockID,StockName,StockAdd,StockDate,Note) values(?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (Stock stock : list) {
                ps.setInt(1, stock.getId());
                ps.setString(2, stock.getName());
                ps.setString(3, stock.getAdd());
                ps.setString(4, stock.getDate());
                ps.setString(5, stock.getNote());
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }
    
    public void insert(ArrayList<Stock> list) throws SQLException {
        String sql = "insert into Stocks(StockID,StockName,StockAdd,StockDate,Note) values(?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (Stock stock : list) {
                ps.setInt(1, stock.getId());
                ps.setString(2, stock.getName());
                ps.setString(3, stock.getAdd());
                ps.setString(4, stock.getDate());
                ps.setString(5, stock.getNote());
                ps.executeUpdate();
            }
            ps.close();
        }
    }
    
    public void insertTrans(ArrayList<Stock> list) throws SQLException{
        String sql = "insert into Stocks(StockID,StockName,StockAdd,StockDate,Note) values(?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            for (Stock stock : list) {
                ps.setInt(1, stock.getId());
                ps.setString(2, stock.getName());
                ps.setString(3, stock.getAdd());
                ps.setString(4, stock.getDate());
                ps.setString(5, stock.getNote());
                ps.executeUpdate();
                conn.commit();
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
            if (conn != null) {
                System.err.print("Transaction is being rolled back");
                conn.rollback();
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            conn.setAutoCommit(true);
        }
    }
    
}
