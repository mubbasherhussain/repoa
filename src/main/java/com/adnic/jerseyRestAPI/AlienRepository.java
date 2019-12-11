package com.adnic.jerseyRestAPI;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AlienRepository {
	
	List <Alien> aliens;

	public AlienRepository() {
		aliens = new ArrayList<>();
		Alien a1 = new Alien();
		a1.setId(101);
		a1.setName("Mubbasher");
		a1.setPoints(60);
		
		Alien a2 = new Alien();
		a2.setId(102);
		a2.setName("Gill");
		a2.setPoints(70);
		
		aliens.add(a1);
		aliens.add(a2);
	}
	
	public List<Alien> getAliens(){
		return aliens;
	}
	
	public Alien getAliensById(int id){
		for (Alien a : aliens) {
			if (a.getId() == id) {
				System.out.println("ID "+a.getId());
				return a;
			}				
		}
		return null;
	}

	public void createAlien(Alien a) {
		// TODO Auto-generated method stub
		aliens.add(a);
	}

}
