/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sample_15_7;

/**
 *
 * @author Rin's
 */
public class Users {
    private String name;
    private String password;
    private String type;
    private String state;

    public Users() {
    }

    public Users(String name, String password, String type, String state) {
        this.name = name;
        this.password = password;
        this.type = type;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("%1$-17s %2$-12s %3$-12s %4$-17s %5$-2s", "| " + name, "| " + type, "| " + state, "| " + password, " |");
    }
    
    public String display() {
        return String.format("%1$-17s %2$-12s %3$-12s %4$-2s", "| " + name, "| " + type, "| " + state, " |");
    }
    
    
}
