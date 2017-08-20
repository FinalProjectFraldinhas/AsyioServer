/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.ArduinoClient;
import model.Client;

/**
 *
 * @author missym
 */
public class DataTrimNSave {
    
    public DataTrimNSave(){}
    
    ArduinoClient c=new ArduinoClient(new Client());
    
    
    String data = c.clientData;
    
    
    
}
