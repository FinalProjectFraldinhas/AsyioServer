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
    
        private int client_num;
	private String client_name;
        private String client_address;
        private int client_phone;
        private int client_nif;
        private String client_email;
        private String client_password;
        private ArrayList<Instalation> instalations;

    public Client(int client_num, String client_name, String client_address, int client_phone, int client_nif, String client_email, String client_password, ArrayList<Instalation> instalations) {
        this.client_num = client_num;
        this.client_name = client_name;
        this.client_address = client_address;
        this.client_phone = client_phone;
        this.client_nif = client_nif;
        this.client_email = client_email;
        this.client_password = client_password;
        this.instalations=new ArrayList<>();
    }
        public Client(int client_num, String client_name, String client_address, int client_phone, int client_nif, String client_email, String client_password) {
        this.client_num = client_num;
        this.client_name = client_name;
        this.client_address = client_address;
        this.client_phone = client_phone;
        this.client_nif = client_nif;
        this.client_email = client_email;
        this.client_password = client_password;
    }

    public Client() {
    }
        
    public int getClient_num() {
        return client_num;
    }

    public void setClient_num(int client_num) {
        this.client_num = client_num;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_address() {
        return client_address;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address;
    }

    public int getClient_phone() {
        return client_phone;
    }

    public void setClient_phone(int client_phone) {
        this.client_phone = client_phone;
    }

    public int getClient_nif() {
        return client_nif;
    }

    public void setClient_nif(int client_nif) {
        this.client_nif = client_nif;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public String getClient_password() {
        return client_password;
    }

    public void setClient_password(String client_password) {
        this.client_password = client_password;
    }

    public String delete(){
        return "DELETE FROM client WHERE client_num="+this.client_num+";";
    }
	
	
    public String insert(){
	return "INSERT INTO client (client_name, client_address, client_phone, client_nif, client_email, client_password ) VALUES('"+this.client_name+"', "+this.client_address+", "+Integer.toString(this.client_phone)+", "+Integer.toString(this.client_nif)+", "+this.client_email+", '"+this.client_password+"');";
    }
	
    public String update(){
	return "UPDATE client SET client_name='"+this.client_name+"', client_address="+this.client_address+", client_phone="+Integer.toString(this.client_phone)+", client_nif="+Integer.toString(this.client_nif)+", client_email="+this.client_email+", client_password='"+this.client_password+"'  WHERE client_num="+Integer.toString(this.client_num)+";";
    }
	
    public String select(){
	return "SELECT * FROM client;";
    }
	
    public Client sqlObjectContructor(ResultSet rs) throws SQLException{
	return new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7));
    }
		
}