/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author missym
 */
public class MountObjects {
    
    
    @SuppressWarnings("unchecked")
	public ArrayList<Album> getAllAlbums() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Album a= new Album();
		Music m=new Music();
		ArrayList<Album> allAlbums= (ArrayList<Album>)(ArrayList<?>) getAll(a);
		
		for (Album alb : allAlbums){
			alb.setOwnerArtist((Artist)selectOneById(alb.getOwnerArtist()));
			alb.setAlbunMusics((ArrayList<Music>)(ArrayList<?>)selectFillArrayInObject(alb, m));
		}		
		return allAlbums;
	}
    
}
