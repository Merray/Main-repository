package graphics;

import javax.swing.JFrame;

public class Fenetre extends JFrame {
  public Fenetre(){                
    this.setTitle("RPG");
    this.setSize(600, 400);
    this.setLocationRelativeTo(null);               
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(new Panneau("RPG", 250, 50));

    this.setVisible(true);
  }     
}
