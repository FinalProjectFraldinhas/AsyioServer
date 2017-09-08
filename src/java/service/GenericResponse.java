/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;

/**
 *
 * @author Miss M
 */
public class GenericResponse {
    
    ArrayList<String> x= new ArrayList<>();
    
    public void setObjectAtribute(String o){
        x.add(o);
    }
    
    public ArrayList<String> getGenericResponse(){
        return x;
    }
    
}
