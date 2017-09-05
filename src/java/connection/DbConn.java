/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import model.Client;

/**
 *
 * @author missym
 */
public class DbConn {

    static String user = "missym";
    static String pass = "456";
    static String db = "asyio";
    static String url = "jdbc:mysql://localhost:3306/" + db;

    static Connection con;
    static Statement st;
    static ResultSet rs;
    static PreparedStatement prep;

    public DbConn() {

    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteFrom(Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method temp = obj.getClass().getMethod("delete");
        String s = (String) temp.invoke(obj);
        try {
            prep = getConnection().prepareStatement(s);
            prep.execute();
            con.close();
        } catch (SQLException e) {
        }
    }

    public void insertInto(Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method temp = obj.getClass().getMethod("insert");
        String s = (String) temp.invoke(obj);
        try {
            prep = getConnection().prepareStatement(s);
            prep.execute();
            con.close();
        } catch (SQLException e) {
        }

    }

    public void updateWhere(Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method temp = obj.getClass().getMethod("update");
        String s = (String) temp.invoke(obj);
        try {
            prep = getConnection().prepareStatement(s);
            prep.execute();
            con.close();
        } catch (SQLException e) {
        }

    }

    public ArrayList<Object> getAll(Object o) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Method temp = o.getClass().getMethod("select");
        String s = (String) temp.invoke(o);
        Method temp1 = o.getClass().getMethod("sqlObjectContructor");
        ArrayList<Object> all = new ArrayList<>();
        try {
            prep = getConnection().prepareStatement(s);
            rs = prep.executeQuery();
            while (rs.next()) {

                all.add(temp1.invoke(o, rs));
            }
            con.close();
            return all;
        } catch (SQLException e) {
        }

        return null;
    }

    public Object selectOneById(Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        Method temp = obj.getClass().getMethod("getId");
        int i = (int) temp.invoke(obj);

        String x = "SELECT * FROM " + obj.getClass().getSimpleName() + " WHERE id=" + Integer.toString(i) + " AND id_State=1;";

        Method temp1 = obj.getClass().getMethod("sqlObjectContructor", ResultSet.class);

        try {

            prep = getConnection().prepareStatement(x);

            rs = prep.executeQuery();
            rs.next();
            Object o = temp1.invoke(obj, rs);

            //new client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9))
            con.close();
            return o;
        } catch (Exception e) {
            System.out.println("OLAAAAAAAAAA" + e.getCause().toString());
        }

        return null;
    }

    public ArrayList<Object> selectFillArrayInObject(Object obj, Object arr) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        Method temp = obj.getClass().getMethod("getId");
        int i = (int) temp.invoke(obj);
        String x = "SELECT * FROM " + arr.getClass().getSimpleName() + " LEFT JOIN " + obj.getClass().getSimpleName() + " ON " + arr.getClass().getSimpleName() + ".id_" + obj.getClass().getSimpleName() + " = " + obj.getClass().getSimpleName() + ".id  WHERE " + arr.getClass().getSimpleName() + ".id_" + obj.getClass().getSimpleName() + "=" + Integer.toString(i) + " AND " + arr.getClass().getSimpleName() + ".id_State=1;";

        Method temp1 = arr.getClass().getMethod("sqlObjectContructor", ResultSet.class);
        ArrayList<Object> all = new ArrayList<>();
        try {
            prep = getConnection().prepareStatement(x);
            rs = prep.executeQuery();
            while (rs.next()) {

                all.add(temp1.invoke(arr, rs));
            }
            con.close();
            return all;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Object> customSelect(String query) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        ArrayList<Object> temp = new ArrayList<>();
        int i = 1;
        try {
            prep = getConnection().prepareStatement(query);
            rs = prep.executeQuery();
            while (rs.next()) {
                temp.add(rs.getObject(i));
                i++;
            };
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return temp;
    }

}
