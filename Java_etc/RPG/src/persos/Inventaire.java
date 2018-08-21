package persos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import equipements.Carriable;
import equipements.Equipement;
import equipements.Materiaux;

public enum Inventaire implements Carriable {

	RIEN("Rien", 4), PETITE_POCHE("Petite poche", 12), BALUCHON("Baluchon", 16), SAC_DE_VOYAGE("Sac de voyage", 24),
	SAC_SANS_FOND("Sac sans fond", 999);

	private String nom;
	private Integer size;
	private List<Carriable> contenu;

	private Inventaire(String nom, Integer size) {
		this.nom = nom;
		this.size = size;
		this.contenu = new ArrayList<Carriable>();
	}

	public void afficher() {
		System.out.println("\nContenu de l'inventaire:");

		if (!contenu.isEmpty()) {

			for (Carriable item : contenu) {
				System.out.println("- " + item.getNom());
			}
		} else {
			System.out.println("\nVide");
		}
	}

	public void ajouter(Carriable objet) {
		if (size > 0) {
			if (objet instanceof Materiaux) {
				for (int i = 1 ; i <= ((Materiaux) objet).getQuantite(); i++) {
					contenu.add(objet);
					size -= 1;
				}
				System.out.println("\n" + objet.getNom() + " (x" +((Materiaux)objet).getQuantite() +") a été ajouté à l'inventaire !");
			} else {
				
			
			contenu.add(objet);
			size -= 1;
			System.out.println("\n" + objet.getNom() + " a été ajouté à l'inventaire !");
			}
			
			contenu.sort(Comparator.comparing(Carriable::getNom));

		} else {
			System.out.println("\n" + objet.getNom() + " n'a pas été ajouté à l'inventaire car ce dernier est plein !");
		}
	}

	public void equiper(Equipement equipement, Player p) {
		if (contenu.contains(equipement)) {
			equipement.equiper(p);
			contenu.remove(equipement);
			contenu.sort(Comparator.comparing(Carriable::getNom));
			size += 1;
			System.out.println("\n" + equipement.getNom() + " a été équipé !");
		} else {
			System.out.println("\nEquipement impossible !");
		}
	}

	public void desequiper(Equipement equipement, Player p) {
		if (size > 0) {
			equipement.retirer(p);
			contenu.add(equipement);
			contenu.sort(Comparator.comparing(Carriable::getNom));
			size -= 1;
			System.out.println("\n" + equipement.getNom() + " a été déséquipé et ajouté à l'inventaire!");
		} else {
			System.out.println("\nLe sac est plein, impossible de déséquiper " + equipement.getNom());
		}
	}

	public void jeter(Carriable objet) {
		if (contenu.contains(objet)) {
			contenu.remove(objet);
			contenu.sort(Comparator.comparing(Carriable::getNom));
			size += 1;
			System.out.println("\n" + objet.getNom() + " a été jeté. Quel gachi !");
		} else {
			System.out.println("\nOn ne peut pas jeter ce qu'on ne possède pas...");
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public List<Carriable> getContenu() {
		return contenu;
	}

	public void setContenu(List<Carriable> contenu) {
		this.contenu = contenu;
	}

}
