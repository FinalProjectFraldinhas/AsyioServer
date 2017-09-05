/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author Miss M
 */
public enum State {
    
        INACTIVE(1), ACTIVE(2);
    
	public int code;
        
	private static HashMap<Integer, State> codeValue = new HashMap<Integer, State>();
	
	private State(int code){
		this.code=code;
	}
	
	public int getCode(){
		return code;
	}

    static
    {
        for (State  s : State.values())
        {
            codeValue.put(s.code, s);
        }
    }

    public static State getEnum(int code)
    {
        return codeValue.get(code);
    }
  
    
}
