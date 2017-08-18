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
public class Sensor {
    
    private int id;
    private String sensor_name;
    private ArrayList <Counts> counts;

    public Sensor(String sensor_name, ArrayList<Counts> counts) {
        this.sensor_name = sensor_name;
        this.counts = counts;
    }

    public Sensor(int id, String sensor_name) {
        this.id = id;
        this.sensor_name = sensor_name;
        this.counts=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getSensor_name() {
        return sensor_name;
    }

    public void setSensor_name(String sensor_name) {
        this.sensor_name = sensor_name;
    }

    public ArrayList <Counts> getCounts() {
        return counts;
    }

    public void setCounts(ArrayList <Counts> counts) {
        this.counts = counts;
    }
    
    public String delete(){
        return "DELETE FROM Sensor WHERE id="+this.id+";";
    }	
	
    public String insert(){
	return "INSERT INTO Sensor (sensor_name) VALUES('"+this.sensor_name+"');";
    }
	
    public String update(){
	return "UPDATE Sensor SET sensor_name='"+this.sensor_name+"' WHERE id="+Integer.toString(this.id)+";";
    }
	
    public String select(){
	return "SELECT * FROM Sensor;";
    }
	
    public Sensor sqlObjectContructor(ResultSet rs) throws SQLException{
	return new Sensor(rs.getInt(1), rs.getString(2));
    }

        
    
    
    
    
    
}
