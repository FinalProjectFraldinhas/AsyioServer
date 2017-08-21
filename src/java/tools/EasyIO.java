/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Scanner;

/**
 *
 * @author missym
 */
public class EasyIO {
	
	private final Scanner scanner;

	public static void write(String arg) {
		System.out.print(arg);
	}

    public EasyIO() {
        this.scanner = new Scanner(System.in);
    }
	
	public void writeL(String arg) {
		System.out.println(arg);
	}

	public void writeN(int arg) {
		System.out.print(arg);
	}
	
	public String readS() {		
		return scanner.nextLine();
	}
	
	public int readN() {
		return scanner.nextInt();
	}
	
	public double readD() {
		return scanner.nextDouble();
	}
	
	public char readC() {
		return scanner.nextLine().charAt(0);
	}
}
