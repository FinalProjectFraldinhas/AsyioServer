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
    
    private int inst_number;
    private String inst_address;
    private ArrayList<Hardware> arduinos;

    public Instalation(int inst_number, String inst_address, ArrayList<Hardware> arduinos) {
        this.inst_number = inst_number;
        this.inst_address = inst_address;
        this.arduinos=new ArrayList<>();
    }

    public Instalation(int inst_number, String inst_address) {
        this.inst_number = inst_number;
        this.inst_address = inst_address;
    }

    public Instalation() {
    }
    
    public int getInst_number() {
        return inst_number;
    }

    public void setInst_number(int inst_number) {
        this.inst_number = inst_number;
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
    
    public String insert(){
	return "INSERT INTO instalation (inst_address) VALUES('"+this.inst_address+"');";
    }
	
    public String update(){
	return "UPDATE instalation SET inst_address='"+this.inst_address+"' WHERE inst_number="+Integer.toString(this.inst_number)+";";
    }
	
    public String select(){
	return "SELECT * FROM instalation;";
    }
	
    public Instalation sqlObjectContructor(ResultSet rs) throws SQLException{
	return new Instalation(rs.getInt(1), rs.getString(2));
    }
    
    
    
}
