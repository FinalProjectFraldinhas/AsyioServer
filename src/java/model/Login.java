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
 * @author Miss M
 */
public class Login {
    
    private int id;    
    private String login;
    private String password;
    private String permission;
    private State state;

    public Login(String login, String password, String permission, int state) {
        this.login = login;
        this.password = password;
        this.permission = permission;
        this.state = State.getEnum(state);
    }

    public Login(Integer id) {
        this.id = id;
        this.password = "";
        this.permission = "";
        this.state = null;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    public String delete(int id_Client){
        return "UPDATE login SET id_state=0  WHERE id_Client="+id_Client+" AND login="+this.login+";";
    }
	
	
   /* public String insert(int id_Client){
	return "INSERT INTO login (client_name, client_address, client_phone, client_nif, client_email, client_password ) VALUES('"+this.client_name+"', "+this.client_address+", "+Integer.toString(this.client_phone)+", "+Integer.toString(this.client_nif)+", "+this.client_email+", '"+this.client_password+"');";
    }
	
    public String update(int id_Client){
	return "UPDATE login SET client_name='"+this.client_name+"', client_address="+this.client_address+", client_phone="+Integer.toString(this.client_phone)+", client_nif="+Integer.toString(this.client_nif)+", client_email="+this.client_email+", client_password='"+this.client_password+"'  WHERE id="+Integer.toString(this.id)+";";
    }
	
    public String select(){
	return "SELECT * FROM login;";
    }*/
	
    public Login sqlObjectContructor(ResultSet rs) throws SQLException{
	return new Login(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
    }


    
    
    
    
}
