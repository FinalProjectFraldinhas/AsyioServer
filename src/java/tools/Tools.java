/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import connection.DbConn;
import java.lang.reflect.*;
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

    public static Helper h = new Helper() {
        @Override
        public Object buildObjectMap(Object obj, Helper h) {

            DbConn conn = new DbConn();

            Field[] fields = obj.getClass().getDeclaredFields();

            for (Field f : fields) {

                if (f.getType().isAssignableFrom(ArrayList.class)) {

                    try {

                        Object temp = new Object();
                        Class x = Class.forName("model." + f.getName().toString());
                        try {
                            Constructor c = x.getConstructor(Integer.class);
                            temp = c.newInstance(0);

                            Method mset = obj.getClass().getMethod("set" + f.getName().toString(), ArrayList.class);
                            Method mget = obj.getClass().getMethod("get" + f.getName().toString());

                            mset.invoke(obj, conn.selectFillArrayInObject(obj, temp));

                            ArrayList<Object> tempArr = (ArrayList<Object>) mget.invoke(obj);

                            for (int i = 0; i < tempArr.size(); i++) {
                                temp = tempArr.get(i);
                                buildObjectMapHelper(h, temp);
                            }

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }

                        return x.equals(Class.forName("model.Counts")) ? (Object) obj : buildObjectMap(temp, h);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return obj;
        }
    };

    public static Object buildObjectMapHelper(Helper h, Object o) throws ClassNotFoundException {
        return buildObjectMapHelper((Helper) h.buildObjectMap(o, h), o);
    }

}
