package main;

import java.util.Random;
import java.util.Scanner;
import mesClasses.Character;
import mesClasses.Player;

public class main {

	public static void main(String[] args) {
		
		
		//Player jim = new Player("Jim", 10, 5, 2, 1, 1, 3, 1);
		Character gob = new Character("Gobelin", 7, 3, 0, 0, 0, 1);
		Player jim = playerGenerator();
		
		if (jim.do_p_dmg(gob)) {System.out.println("Il est mort");}
		
		System.out.println(jim);
		System.out.println(gob);
	}

	private static int randomNumber(int min, int max) {
		if (min >= max) {throw new IllegalArgumentException("Max must be greater than min");}
		
		Random r = new Random();
		return r.nextInt((max - min)+1) + min;
		
	}
	
	public static Player playerGenerator() 
	{
		
		String name;
		int pvMax, sTr, mag, pDef, mDef, con, pd;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Nom du personnage ?");
		name = sc.nextLine();
		
		pvMax = 10 + randomNumber(-3, 3);
		sTr = 5 + randomNumber(-1, 1);
		mag = 3 + randomNumber(-1, 1);
		pDef = 2 + randomNumber(-1, 1);
		mDef = 2 + randomNumber(-1, 1);
		con = 3 + randomNumber(-1, 1);
		pd = randomNumber(0, 1);
		
		Player player = new Player(name, pvMax, sTr, mag, pDef, mDef, con, pd);
		
		sc.close();
		return player;
		
	}
	
}
