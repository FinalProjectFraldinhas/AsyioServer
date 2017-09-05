/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connection.DbConn;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author Miss M
 */
public class HttpRequests {

    public DbConn conn = new DbConn();

    public Object checkLogin(String username, String id, String password) {

        try {

            if (conn.customSelect("SELECT * FROM login WHERE login='"+username+"' AND password='"+password+"' AND id_Client="+id+" AND state='ACTIVE';").size()>0) {

                Client temp = new Client(Integer.parseInt(id));
                Login log = new Login(username, password, State.ACTIVE);

                ArrayList<Login> logs = (ArrayList<Login>) (ArrayList<?>) conn.selectFillArrayInObject(temp, log);

                temp = (Client) conn.selectOneById(temp);
                temp.setLogins(logs);
                return temp;
                //3 temp.setInstalations(instalations);
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
