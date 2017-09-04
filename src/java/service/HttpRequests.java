/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connection.DbConn;
import java.lang.reflect.InvocationTargetException;
import model.client;

/**
 *
 * @author Miss M
 */
public class HttpRequests {
    
    public  static DbConn conn=new DbConn();
    public static client temp=new client();
    
    public Object checkLogin(String username, String id, String password) {
        
        
        temp.setId(Integer.parseInt(id));
        try{
        temp=(client) conn.selectOneById(temp);
        }catch(Exception e){} 
        
        return username.equals(temp.getClient_email()) && password.equals(temp.getClient_password())? temp : null; 
    }
    
    
    public String totalGastoMes(String id) {
     
}
    

    

