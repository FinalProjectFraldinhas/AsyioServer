/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connection.DbConn;
import model.*;
import static tools.Tools.h;

/**
 *
 * @author Miss M
 */
public class HttpRequests {

    public DbConn conn = new DbConn();

    public Object checkLogin(String username, String id, String password) {

        try {

            if (conn.customSelect("SELECT * FROM login WHERE login='"+username+"' AND password='"+password+"' AND id_Client="+id+" AND id_State=1;").size()>0) {

                Client temp_client = new Client(Integer.parseInt(id), "", "", "", "", "", "", 0);
                
                temp_client = (Client) conn.selectOneById(temp_client);
               
               temp_client=(Client) h.buildObjectMap(temp_client, h);
                return temp_client;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

   /* public String totalGasto(String id, String dataI, String dataF) {
        temp.setId(Integer.parseInt(id));

        return null;
    }*/

    
}
