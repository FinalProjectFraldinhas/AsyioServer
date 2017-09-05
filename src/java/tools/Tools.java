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

                    Class x = Class.forName("model." + f.getName().toString());
                    Constructor c = x.getConstructor(Integer.class);
                    Object temp = c.newInstance(0);

                    Method m = obj.getClass().getMethod("set" + f.getName().toString(), ArrayList.class);
                    m.invoke(obj, conn.selectFillArrayInObject(obj, temp));

                    return obj;

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
