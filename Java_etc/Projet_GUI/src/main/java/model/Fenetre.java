package model;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

	public Fenetre(String name, int width, int height) {
		this.setTitle(name);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);

		JPanel pan = new JPanel();

		pan.setBackground(Color.ORANGE);
		
		this.setContentPane(pan); 
		
		this.setVisible(true);
		
	}



}
