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

/**
 *
 * @author missym
 */
public class DbConn {

	static String user = "missym";
	static String pass = "456";
	static String db   = "AsyioDB";
	static String url  = "jdbc:mysql://localhost:3306/"+db;
	
	static Connection con;
	static Statement st ;
	static ResultSet rs ;
	static PreparedStatement prep;
	
	public DbConn() {
		
	}
	
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pass);
			return con;
		} catch (ClassNotFoundException | SQLException e) {
		}
		return null;	
	}
	
	public void deleteFrom(Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method temp=obj.getClass().getMethod("delete");
		String s=(String) temp.invoke(obj);
		try {
			prep = getConnection().prepareStatement(s);			
			prep.execute();
			con.close();
		} catch (SQLException e) {
		}
	}
	
	public void insertInto(Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method temp=obj.getClass().getMethod("insert");
		String s=(String) temp.invoke(obj);
		try {
			prep = getConnection().prepareStatement(s);			
			prep.execute();
			con.close();
		} catch (SQLException e) {
		}
		
	}
	
	public void updateWhere(Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method temp=obj.getClass().getMethod("update");
		String s=(String) temp.invoke(obj);
		try {
			prep = getConnection().prepareStatement(s);			
			prep.execute();
			con.close();
		} catch (SQLException e) {
		}
		
	}
	
	public ArrayList<Object> getAll(Object o) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method temp=o.getClass().getMethod("select");
		String s=(String) temp.invoke(o);
		Method temp1=o.getClass().getMethod("sqlObjectContructor");		
		ArrayList<Object> all = new ArrayList<>();
		try {
			prep = getConnection().prepareStatement(s);
			rs = prep.executeQuery();
			while(rs.next()) {
				
				all.add(temp1.invoke(o, rs));
			}
			con.close();
			return all;
		} catch (SQLException e) {
		}
		
		return null;
	}
	
	public Object selectOneById(Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method temp=obj.getClass().getMethod("getId");
		int i=(int) temp.invoke(obj);		
		String x="SELECT * FROM "+obj.getClass().getSimpleName()+" WHERE id="+Integer.toString(i)+";";
		Method temp1=obj.getClass().getMethod("sqlObjectContructor");		
				
		try {
			prep = getConnection().prepareStatement(x);			
			rs = prep.executeQuery();
			Object o=temp1.invoke(obj, rs);
			con.close();
			return o;
		} catch (SQLException e) {
		}
		
		return null;		
	} 
	
	public ArrayList<Object> selectFillArrayInObject(Object obj, Object arr) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		String clas=""+arr.getClass().getSimpleName()+"";
		Method temp=obj.getClass().getMethod("getId");
		int i=(int) temp.invoke(obj);
		Method temp0=obj.getClass().getMethod("liga");
		String liga=(String) temp0.invoke(obj);
		//select * from music left join liga on liga.music=music.id WHERE liga.album= bla.getid();
		String x="SELECT * FROM "+clas+" LEFT JOIN "+liga+" ON "+liga+"."+clas+" = "+clas+".id  WHERE "+liga+"."+obj.getClass().getSimpleName()+"="+Integer.toString(i)+";";
		
		Method temp1=arr.getClass().getMethod("sqlObjectContructor");		
		ArrayList<Object> all = new ArrayList<>();		
		try {
			prep = getConnection().prepareStatement(x);			
			rs = prep.executeQuery();
			while(rs.next()) {
				
				all.add(temp1.invoke(arr, rs));
			}
			con.close();
			return all;
		} catch (SQLException e) {
		}		
		return null;		
	}
	
}
