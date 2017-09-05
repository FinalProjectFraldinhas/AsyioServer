/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connection.DbConn;
import java.util.ArrayList;
import model.*;
import tools.Helper;
import tools.Tools;
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
                /*Login temp_log = new Login("", "", "", 0);
                Instalation temp_instalation= new Instalation(0, "");
                Hardware temp_hardware=new Hardware(0, "", "");*/
                
                temp_client = (Client) conn.selectOneById(temp_client);
               /* temp_client.setLogins((ArrayList<Login>) (ArrayList<?>) conn.selectFillArrayInObject(temp_client, temp_log));
                temp_client.setInstalations( (ArrayList<Instalation>) (ArrayList<?>) conn.selectFillArrayInObject(temp_client, temp_instalation));
                for( int i=0; i<temp_client.getInstalations().size(); temp_client.getInstalations().get(i++).setArduinos((ArrayList<Hardware>) (ArrayList<?>) conn.selectFillArrayInObject(temp_client.getInstalations().get(i), temp_hardware)));
                
                */
           
               
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
