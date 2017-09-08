/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import tools.RowMapper;
/**
 *
 * @author missym
 */
public class Counts{
    
    private int id;
    private Date date;
    private ArrayList <Float> values;

    public Counts(int id, Date date, String rawValues) {
        this.id=id;
        this.date = date;
        this.values = new ArrayList <Float>();
        String[] temp=rawValues.split(" ");
        for(int i=0; i<temp.length; this.values.add(Float.parseFloat(temp[i++])));
        
    }

   /* public Counts(int id, Date date, String dump) {
        this.id = id;
        this.date = date;
     //   this.values=convertStringToFloats(dump,  new ArrayList<>());
    } */ 

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList <Float> getValues() {
        return values;
    }

    public void setValues(ArrayList <Float> values) {
        this.values = values;
    }
    
    public String delete(){
        return "DELETE FROM Counts WHERE id="+this.id+";";
    }	
	
    /*public String insert(){
	return "INSERT INTO Counts (id, date, count_dump) VALUES('"+Float.toString(this.id)+"', '"+this.date+"', '"+convertIntsArrayToString(this.values)+"');";
    }
	
    public String update(){
//	return "UPDATE Counts SET date='"+this.date+"', count_dump='"+convertIntsArrayToString(this.values)+"' WHERE id="+Integer.toString(this.id)+";";
    }*/
	
    public String select(){
	return "SELECT * FROM Counts;";
    }
	
    public Counts sqlObjectContructor(ResultSet rs) throws SQLException{
	return new Counts(rs.getInt(1), rs.getDate(2), rs.getString(3));
    }

   
    public Counts rowMapper(ResultSet rs) throws SQLException {
        return new Counts(rs.getInt("id"), rs.getDate("date"), rs.getString("rawValues"));
    }
    
    
    
}
