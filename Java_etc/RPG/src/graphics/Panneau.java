package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panneau extends JPanel {

	public String text;
	public int posX;
	public int posY;

	public Panneau(String text, int posX, int posY) {
		this.text = text;
		this.posX = posX;
		this.posY = posY;
	}
	
	public void paintComponent(Graphics g) {
		Font font = new Font("Courier", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.red);
		g.drawString(this.text, this.posX, this.posY);
	}
}
