/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author missym
 */
public class Client {
    
private int num;
	private  String name;
	private String ipAdd;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIpAdd() {
		return ipAdd;
	}

	public void setIpAdd(String ipAdd) {
		this.ipAdd = ipAdd;
	}

	public Client(int num, String name, String ipAdd) {
		super();
		this.num = num;
		this.name = name;
		this.ipAdd = ipAdd;
	}
        
        public Client(){}


}