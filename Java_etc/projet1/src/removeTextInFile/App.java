package removeTextInFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {

	public static void main(String[] args) throws Exception {
		

		Scanner sc = new Scanner(System.in);
		

		String chemin = "C:\\Users\\AJC\\Desktop\\f";
		String chemin2 = "C:\\Users\\AJC\\Desktop\\f2";
		
		
		
//		System.out.println("\nChemin du fichier à traiter ?");
//		
//		String chemin = sc.nextLine();
		
		File f = new File(chemin);
		File f2 = new File(chemin2);
//		
//		FileOutputStream fos1 = new FileOutputStream(f);
//		
//		fos1.write("aaaaaaaaaaaaaaaaaaaaaeeeeeeeeeeeeeeeeeeeeeeeeeeeiiiiiiiiiiiiiiiiiiiieeeeeeeeeeeeeeeeeeooooooooooooooooooo".getBytes());
//		
//		fos1.close();
		
		
		System.out.println("Pattern à supprimer dans le fichier ?");
		
		String pat = sc.nextLine();
		
		FileInputStream fis = new FileInputStream(f);

		
		FileOutputStream fos = new FileOutputStream(f2);
		
		String s = "";
		
		int byteLu;
		while((byteLu= fis.read()) !=-1) {
			
			s += (char) byteLu;
			
			
			
		}
		
		s = s.replaceAll(pat, "");
		
		System.out.println(s);
		
		fos.write(s.getBytes());
		
		
		
		
		fos.close();
		fis.close();
		sc.close();

	}

}
