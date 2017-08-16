/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asyioserver;

import connection.DbConn;

/**
 *
 * @author missym
 */
public class AsyioServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        DbConn dao = new DbConn();
        try {
           // dao.readDataBase();
        } catch (Exception ex) {
            //Logger.getLogger(AsyioServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
