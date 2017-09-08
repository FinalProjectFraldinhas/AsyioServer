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
    
    private int id;
    private String inst_address;
    private String inst_zipCode;
    private String inst_longit;
    private String inst_latit;
    private String inst_designation;
    private State state;
    private ArrayList<Hardware> Hardware;

    public Instalation(String inst_address, String inst_zipCode, String inst_longit, String inst_latit, String inst_designation,int state, ArrayList<Hardware> Hardware) {        
        this.inst_address = inst_address;
        this.inst_zipCode=inst_zipCode;
        this.inst_longit = inst_longit;
        this.inst_latit = inst_latit;
        this.inst_designation = inst_designation;  
        this.state = State.getEnum(state);
        this.Hardware=Hardware;
    }

    public Instalation(int id, String inst_address, String inst_zipCode, String inst_longit, String inst_latit, String inst_designation, int state) {
        this.id = id;
        this.inst_address = inst_address;
        this.inst_zipCode=inst_zipCode;
        this.inst_longit = inst_longit;
        this.inst_latit = inst_latit;        
        this.inst_designation = inst_designation;
        this.state = State.getEnum(state);
        this.Hardware=new ArrayList<>();
    }
    
    public Instalation(Integer id) {
        this.id = id;
        this.inst_address = "";
        this.inst_zipCode="";
        this.inst_longit = "";
        this.inst_latit = "";
        this.inst_designation = "";
        this.state = null;
        this.Hardware=new ArrayList<>();
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

    public ArrayList<Hardware> getHardware() {
        return Hardware;
    }

    public void setHardware(ArrayList<Hardware> Hardware) {
        this.Hardware = Hardware;
    }
    
        public String getInst_zipCode() {
        return inst_zipCode;
    }

    public void setInst_zipCode(String inst_zipCode) {
        this.inst_zipCode = inst_zipCode;
    }

    public String getInst_longit() {
        return inst_longit;
    }

    public void setInst_longit(String inst_longit) {
        this.inst_longit = inst_longit;
    }

    public String getInst_latit() {
        return inst_latit;
    }

    public void setInst_latit(String inst_latit) {
        this.inst_latit = inst_latit;
    }

    public String getInst_designation() {
        return inst_designation;
    }

    public void setInst_designation(String inst_designation) {
        this.inst_designation = inst_designation;
    }

    
    
    
  /*  public String delete(){
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
    }*/
	
    public Instalation sqlObjectContructor(ResultSet rs) throws SQLException{
	return new Instalation(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
    }


    
    
    
}
