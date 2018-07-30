package InputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class App {

	public static void main(String[] args) throws Exception {
		
		File f = new File("C:\\Users\\AJC\\Desktop\\Coucou.txt");
		
//		FileOutputStream fos = new FileOutputStream(f, true);
//		
//		fos.write("Hello world".getBytes());
//		fos.close();
		
		FileInputStream fis = new FileInputStream(f);
		
		int byteLu;
		while((byteLu= fis.read()) !=-1) {
			System.out.print((char)byteLu);
		}
		fis.close();
	}

}
