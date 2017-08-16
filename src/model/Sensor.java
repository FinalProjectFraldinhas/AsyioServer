/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.HashMap;

/**
 *
 * @author missym
 */
public class Sensor extends Hardware {
    
    private int sensor_number;
    private String sensor_name;
    private HashMap <Date, String> counts;
    
    
    
}
