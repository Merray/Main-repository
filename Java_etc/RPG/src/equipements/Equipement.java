package equipements;

import java.util.List;

import persos.Player;

public interface Equipement extends Carriable{

	public void afficher();
	public Equipement ameliorer();
	public List<Materiaux> scrap(); 
	public void equiper(Player player);
	public void retirer(Player player);
	public void setStats(Player player);
	public void removeStats(Player player);
	
	
}
