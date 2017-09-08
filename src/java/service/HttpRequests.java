/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import static AsyioServer.NewServlet.*;
import connection.DbConn;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import org.apache.commons.lang3.time.DateFormatUtils;
import static tools.Tools.*;

/**
 *
 * @author Miss M
 */
public class HttpRequests {

    public DbConn conn = new DbConn();

    public Object setIp(String id_Client, String id_Instalation, String id_Hardware) {
        //Hardware h=new Hardware();
        try {
            if (conn.customRequest("SELECT ip FROM hardware JOIN instalation ON hardware.id_Instalation=instalation.id JOIN client on client.id=instalation.id_Client WHERE hardware.id=" + id_Hardware + " AND instalation.id=" + id_Instalation + " AND client.id=" + id_Client + ";").get(0).getGenericResponse().size() > 0) {
                conn.stringExecuteOnDb("UPDATE hardware SET ip='" + ip + "' WHERE id=" + id_Hardware + ";");
                return '1';
            }
        } catch (Exception e) {
        }
        return '0';
    }

    public Object setToken(String token) {
        return "RECEBIDO";
    }

    public Object checkLogin(String username, String id, String password) {

        try {

            if (conn.customRequest("SELECT * FROM login WHERE login='" + username + "' AND password='" + password + "' AND id_Client=" + id + " AND id_State=1;").get(0).getGenericResponse().size() > 0) {

                Client temp_client = new Client(Integer.parseInt(id), "", "", "", "", "", "", 0);

                temp_client = (Client) conn.selectOneById(temp_client);

                temp_client = (Client) h.buildObjectMap(h, temp_client);

                session = req.getSession(true);
                session.setAttribute("sessionClient", temp_client);
                session.setAttribute("userAgent", req.getHeaders("User-Agent"));
                //já se vê validar se é android por causa do token

                return temp_client;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String updateIp(String id_Client, String id_Instalation) {

        return null;
    }

    public float totalComsuptionByDate(String dateI, String dateF, String selectedInstalation, String t) {

        float total = Float.parseFloat(t);
        Date init = stringToSqlDate(dateI);

        try {
            ArrayList<GenericResponse> dump = conn.customRequest("SELECT dump FROM dump JOIN sensor on sensor.id=dump.id_Sensor JOIN hardware ON hardware.id=sensor.id_Hardware JOIN instalation ON instalation.id=hardware.id_Instalation WHERE instalation.id_Client=" + ((Client) session.getAttribute("sessionClient")).getId() + " AND instalation.id=1 AND dump.date='2017-09-07';");
            GenericResponse temp = dump.get(0);
            String d = temp.getGenericResponse().get(0);
            String[] tempArr = d.split(" ");
            for (int i = 0; i < tempArr.length; total += Float.parseFloat(tempArr[i++]));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return init.equals(stringToSqlDate(dateF)) ? total : totalComsuptionByDate(DateFormatUtils.format(addDaysToSqlDate((java.sql.Date) init, 1), "yyyy-MM-dd"), dateF, selectedInstalation, Float.toString(total));
    }

}
