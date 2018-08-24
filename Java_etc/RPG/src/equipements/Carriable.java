package equipements;

public interface Carriable {

	public Integer getTauxDrop();
	public String getNom();
	public Integer getQuantite();
	public void setQuantite(Integer quantite);
	public int compareTo(Carriable objet);
}
