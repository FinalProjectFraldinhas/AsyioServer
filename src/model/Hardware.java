/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author missym
 */
public class Hardware {
    
    private int hard_number;
    private String hard_name;

    public Hardware(int hard_number, String hard_name) {
        this.hard_number = hard_number;
        this.hard_name = hard_name;
    }
    
    public Hardware(String hard_name) {
        this.hard_name = hard_name;
    }
    
    public Hardware() {
    }

    public int getHard_number() {
        return hard_number;
    }

    public void setHard_number(int hard_number) {
        this.hard_number = hard_number;
    }

    public String getHard_name() {
        return hard_name;
    }

    public void setHard_name(String hard_name) {
        this.hard_name = hard_name;
    }

       
    public String delete(){
        return "DELETE FROM hardware WHERE hard_number="+this.hard_number+";";
    }
	
	
    public String insert(){
	return "INSERT INTO hardware (hard_name) VALUES('"+this.hard_name+"');";
    }
	
    public String update(){
	return "UPDATE client SET hard_name='"+this.hard_name+"' WHERE hard_number="+Integer.toString(this.hard_number)+";";
    }
	
    public String select(){
	return "SELECT * FROM hardware;";
    }
	
    public Hardware sqlObjectContructor(ResultSet rs) throws SQLException{
	return new Hardware(rs.getInt(1), rs.getString(2));
    }
    
    
    
    
}
