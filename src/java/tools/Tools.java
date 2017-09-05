/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import connection.DbConn;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

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
    
    
    
    public static Object buildObjectMap(Object obj) {

        DbConn conn = new DbConn();

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field f : fields) {

            if (f.getType().isAssignableFrom(ArrayList.class)) {

                try {
                    Object temp=new Object();
                    Class x = Class.forName("model." + f.getName().toString());
                    try{
                    Constructor c = x.getConstructor(Integer.class);
                    temp = c.newInstance(0);

                    Method mset = obj.getClass().getMethod("set" + f.getName().toString(), ArrayList.class);
                    Method mget = obj.getClass().getMethod("set" + f.getName().toString(), ArrayList.class);
                    
                    mset.invoke(obj, conn.selectFillArrayInObject(obj, temp));
                    ArrayList<Object> tempArr=(ArrayList<Object>) mget.invoke(obj);
                    
                    temp=tempArr.get(0);
                   }
                    catch(NoSuchMethodException e){}
                       
                    return x.equals(Class.forName("model.Counts" ))? obj : buildObjectMap(temp);  
                    

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
          return obj;   
    }

}
