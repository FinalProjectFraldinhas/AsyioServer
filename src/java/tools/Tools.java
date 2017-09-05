/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;


import java.util.ArrayList;
/**
 *
 * @author missym
 */
public class Tools {
    
    public static ArrayList<Integer> convertStringToInts(String dump, ArrayList<Integer> values){
        String[] s= dump.split(" ");
        for(int i=0; i<s.length; values.add(Integer.parseInt(s[i++])));
        return values;
    }
    
    public static String convertIntsArrayToString(ArrayList<Integer> values){
        String s="";
        for(int i=0; i<values.size(); s+=String.valueOf(values.get(i++))+" ");
        return s;
    }
    
   
    
}
