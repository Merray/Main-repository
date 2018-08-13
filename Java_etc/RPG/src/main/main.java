package main;

import mesClasses.Character;
import mesClasses.Player;

public class main {

	public static void main(String[] args) {
		
		
		
		Character gob = new Character("Gobelin", 7, 3, 0, 0, 0, 1);
		Player jim = Player.playerGenerator();
		
		if (jim.do_p_dmg(gob)) {System.out.println("Il est mort");}
		
		System.out.println(jim);
		System.out.println(gob);
	}


	

	
}
