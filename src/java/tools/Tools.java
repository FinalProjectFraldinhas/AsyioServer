/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import connection.DbConn;
import java.lang.reflect.*;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.Counts;

/**
 *
 * @author missym
 */
public class Tools {

    public static ArrayList<Integer> convertStringToInts(String dump, ArrayList<Integer> values) {
        String[] s = dump.split(" ");
        for (int i = 0; i < s.length; values.add(Integer.parseInt(s[i++])));
        return values;
    }

    public static String convertIntsArrayToString(ArrayList<Integer> values) {
        String s = "";
        for (int i = 0; i < values.size(); s += String.valueOf(values.get(i++)) + " ");
        return s;
    }

    public static Helper h = new Helper() {
        @Override
        public Object buildObjectMap(Helper h, Object obj) {

            DbConn conn = new DbConn();

            Field[] fields = obj.getClass().getDeclaredFields();

            for (Field f : fields) {

                if (f.getType().isAssignableFrom(ArrayList.class)) {

                    try {

                        Object temp = new Object();
                        Class<?> x = Class.forName("model." + f.getName().toString());
                        try {
                            Constructor<?> c = x.getConstructor(Integer.class);
                            temp = c.newInstance(0);

                            Method mset = obj.getClass().getMethod("set" + f.getName().toString(), ArrayList.class);

                            Method mget = obj.getClass().getMethod("get" + f.getName());

                            mset.invoke(obj, conn.selectFillArrayInObject(obj, temp));

                            ArrayList<Object> tempArr = (ArrayList<Object>) mget.invoke(obj);

                            for (int i = 0; i < tempArr.size(); i++) {
                                temp = tempArr.get(i);
                                buildObjectMapHelper(h, temp);
                            }

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }

                        return x.equals(Class.forName("model.Counts")) ? obj : buildObjectMap(h, temp);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return obj;
        }
    };

    public static Object buildObjectMapHelper(Helper h, Object o) throws ClassNotFoundException {
        return buildObjectMapHelper((Helper) h.buildObjectMap(h, o), o);
    }

    public static java.sql.Date stringToSqlDate(String date) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed;
        try {
            parsed = format.parse(date);

            java.sql.Date sql = new java.sql.Date(parsed.getTime());
            return sql;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static java.sql.Date addDaysToSqlDate(java.sql.Date date, int days) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, days);
        return new java.sql.Date(cal.getTime().getTime());
    }

   

}
