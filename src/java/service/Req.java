/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author Miss M
 */
public class Req {
    
    private String execute;
    private String[] params;

    public Req(String execute, String[] params) {
        this.execute = execute;
        this.params = params;
    }
    
    public Req() {
        this.execute = null;
        this.params = null;
    }

    public String getExecute() {
        return execute;
    }

    public void setExecute(String execute) {
        this.execute = execute;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }
    
    
    
}
