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
public class Instalation {
    
    private Integer id;
    private String inst_address;
    private ArrayList<Hardware> arduinos;

    public Instalation(String inst_address, Hardware arduino, ArrayList<Hardware> arduinos) {        
        this.inst_address = inst_address;        
        this.arduinos=arduinos;
    }

    public Instalation(int id, String inst_address) {
        this.id = id;
        this.inst_address = inst_address;
        this.arduinos=new ArrayList<>();
    }
    
    public Instalation(Integer id) {
        this.id = id;
        this.inst_address = "";
        this.arduinos=new ArrayList<>();
    } 
    
    public int getId() {
        return id;
    }

    public String getInst_address() {
        return inst_address;
    }

    public void setInst_address(String inst_address) {
        this.inst_address = inst_address;
    }

    public ArrayList<Hardware> getArduinos() {
        return arduinos;
    }

    public void setArduinos(ArrayList<Hardware> arduinos) {
        this.arduinos = arduinos;
    }
    
    public String delete(){
        return "DELETE FROM Instalation WHERE id="+this.id+";";
    }
    
    public String insert(){
	return "INSERT INTO Instalation (inst_address) VALUES('"+this.inst_address+"');";
    }
	
    public String update(){
	return "UPDATE Instalation SET inst_address='"+this.inst_address+"' WHERE id="+Integer.toString(this.id)+";";
    }
	
    public String select(){
	return "SELECT * FROM Instalation;";
    }
	
    public Instalation sqlObjectContructor(ResultSet rs) throws SQLException{
	return new Instalation(rs.getInt(1), rs.getString(2));
    }
    
    
    
}
