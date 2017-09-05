/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author missym
 */
public class Hardware {
    
    private int id;
    private String hard_name;
    private String hard_ip;
    private ArrayList<Sensor> Sensor;

    public Hardware(String hard_name, String hard_ip, ArrayList<Sensor> Sensor) {
        this.hard_name = hard_name;
        this.hard_ip=hard_ip;
        this.Sensor=Sensor;
    }
    
    public Hardware(int id, String hard_name, String hard_ip) {
        this.id = id;
        this.hard_name = hard_name;
        this.hard_ip=hard_ip;
        this.Sensor=new ArrayList<>();
    }
    
    public Hardware(Integer id) {
        this.id = 0;
        this.hard_name = "";
        this.hard_ip="";
        this.Sensor=new ArrayList<>();
    }
    
    public Hardware() {
    }

    public int getId() {
        return id;
    }

    public String getHard_name() {
        return hard_name;
    }

    public void setHard_name(String hard_name) {
        this.hard_name = hard_name;
    }
    
    public String getHard_ip() {
        return hard_ip;
    }

    public void setHard_ip(String hard_ip) {
        this.hard_ip = hard_ip;
    }

    public ArrayList<Sensor> getSensor() {
        return Sensor;
    }

    public void setSensor(ArrayList<Sensor> Sensor) {
        this.Sensor = Sensor;
    }
       
    public String delete(){
        return "DELETE FROM Hardware WHERE id="+this.id+";";
    }	
	
    public String insert(){
	return "INSERT INTO Hardware (hard_name, hard_ip) VALUES('"+this.hard_name+"', '"+this.hard_ip+"');";
    }
	
    public String update(){
	return "UPDATE Hardware SET hard_name='"+this.hard_name+"', hard_ip='"+this.hard_ip+"' WHERE id="+Integer.toString(this.id)+";";
    }
	
    public String select(){
	return "SELECT * FROM Hardware;";
    }
	
    public Hardware sqlObjectContructor(ResultSet rs) throws SQLException{
	return new Hardware(rs.getInt(1), rs.getString(2), rs.getString(3));
    }

        
    
    
}
