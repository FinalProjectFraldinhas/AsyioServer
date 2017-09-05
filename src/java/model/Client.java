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
public class Client {
    
        private int id;
	private String client_name;        
        private String client_phone;
        private String client_nif;
        private String client_email;
        private String client_address;
        private String client_zipCode;
        private State state;
        private ArrayList<Instalation> instalations;
        private ArrayList<Login> logins;

    public Client(int id, String client_name, String client_phone, String client_nif, String client_email, String client_address, String client_zipCode, int state) {
        this.id = id;
        this.client_name = client_name;
        this.client_phone = client_phone;
        this.client_nif = client_nif;
        this.client_email = client_email;
        this.client_address = client_address;
        this.client_zipCode = client_zipCode;
        this.state = State.getEnum(state);
        this.instalations=new ArrayList<>();
        this.logins=new ArrayList<>();
    }

    public Client(int id) {
        this.id = id;
    }

    public String delete(){
        return "UPDATE client SET id_state=0  WHERE id="+Integer.toString(this.id)+";";
    }
	
	
   /* public String insert(){
	return "INSERT INTO client (client_name, client_address, client_phone, client_nif, client_email, client_password ) VALUES('"+this.client_name+"', "+this.client_address+", "+Integer.toString(this.client_phone)+", "+Integer.toString(this.client_nif)+", "+this.client_email+", '"+this.client_password+"');";
    }
	
    public String update(){
	return "UPDATE client SET client_name='"+this.client_name+"', client_address="+this.client_address+", client_phone="+Integer.toString(this.client_phone)+", client_nif="+Integer.toString(this.client_nif)+", client_email="+this.client_email+", client_password='"+this.client_password+"'  WHERE id="+Integer.toString(this.id)+";";
    }*/
	
    public String select(){
	return "SELECT * FROM client;";
    }
	
    public Client sqlObjectContructor(ResultSet rs) throws SQLException{
	return new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_phone() {
        return client_phone;
    }

    public void setClient_phone(String client_phone) {
        this.client_phone = client_phone;
    }

    public String getClient_nif() {
        return client_nif;
    }

    public void setClient_nif(String client_nif) {
        this.client_nif = client_nif;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public String getClient_address() {
        return client_address;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address;
    }

    public String getClient_zipCode() {
        return client_zipCode;
    }

    public void setClient_zipCode(String client_zipCode) {
        this.client_zipCode = client_zipCode;
    }

    public ArrayList<Instalation> getInstalations() {
        return instalations;
    }

    public void setInstalations(ArrayList<Instalation> instalations) {
        this.instalations = instalations;
    }

    public ArrayList<Login> getLogins() {
        return logins;
    }

    public void setLogins(ArrayList<Login> logins) {
        this.logins = logins;
    }
    
    
		
}