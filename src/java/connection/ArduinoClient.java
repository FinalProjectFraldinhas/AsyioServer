/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import model.client;

/**
 *
 * @author missym
 */
public class ArduinoClient {
    
private final static int port=3450;	
public static String clientData;
	
	private client c;
	private ObjectInputStream is;
	private Socket s;
	
	public ArduinoClient( client c) {
		this.c = c;		
	}
	
	public void run() {
		try {
			s = new Socket();
			//s.connect(new InetSocketAddress(c.getIpAdd(), port));
			is = new ObjectInputStream(s.getInputStream());
			do {	
                            clientData=(String) is.readObject();;
                            }while(true);
                        
			
		} catch (IOException | ClassNotFoundException e) {}
	}
        
        
}
	