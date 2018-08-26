package persos;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import equipements.Carriable;
import equipements.Equipement;
import equipements.Materiaux;

public enum Inventaire implements Carriable {

	RIEN("Rien", 4, 0), PETITE_POCHE("Petite poche", 12, 70), BALUCHON("Baluchon", 16, 25),
	SAC_DE_VOYAGE("Sac de voyage", 24, 15), MARMITE("Marmite", 20, 30), SAC_SANS_FOND("Sac sans fond", 999, 5);

	private String nom;
	private Integer size;
	private Integer tauxDrop;
	private Map<String, Carriable> contenu;

	private Inventaire(String nom, Integer size, Integer tauxDrop) {
		this.nom = nom;
		this.size = size;
		this.tauxDrop = tauxDrop;
		this.contenu = new HashMap<String, Carriable>();
	}

	private Map<String, Carriable> sortByItemName(Map<String, Carriable> unsortMap) {

		// 1. Convert Map to List of Map
		List<Map.Entry<String, Carriable>> list = new LinkedList<Map.Entry<String, Carriable>>(unsortMap.entrySet());

		// 2. Sort list with Collections.sort(), provide a custom Comparator
		// Try switch the o1 o2 position for a different order

		Collections.sort(list, new Comparator<Map.Entry<String, Carriable>>() {
			public int compare(Map.Entry<String, Carriable> o1, Map.Entry<String, Carriable> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// 3. Loop the sorted list and put it into a new insertion order Map
		// LinkedHashMap
		Map<String, Carriable> sortedMap = new LinkedHashMap<String, Carriable>();
		for (Map.Entry<String, Carriable> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		/*
		 * //classic iterator example for (Iterator<Map.Entry<String, Integer>> it =
		 * list.iterator(); it.hasNext(); ) { Map.Entry<String, Integer> entry =
		 * it.next(); sortedMap.put(entry.getKey(), entry.getValue()); }
		 */

		return sortedMap;
	}

	public void afficher() {
		System.out.println("\nContenu de l'inventaire:");

		if (!contenu.isEmpty()) {

			for (Carriable item : contenu.values()) {

				System.out.println("- " + item.getNom() + " (x" + item.getQuantite() + ")");

			}
		} else {
			System.out.println("\nVide");
		}
	}

	public void ajouter(Carriable objet) {
		if (size > 0) {
			if (contenu.containsKey(objet.getNom())) {
				
			Carriable oldObjet = contenu.get(objet.getNom());
			Integer oldQuantite = (oldObjet).getQuantite();
			Integer newQuantite = oldQuantite + objet.getQuantite();

			this.jeter(oldObjet, false);

			objet.setQuantite(newQuantite);

			}
			for (int i = 1; i <= objet.getQuantite(); i++) {
				contenu.put(objet.getNom(), objet);
				size -= 1;
			}

			System.out.println("\n" + objet.getNom() + " (x" + objet.getQuantite() + ") a été ajouté à l'inventaire !");
			contenu = this.sortByItemName(contenu);
		} else {
			System.out.println("\n" + objet.getNom() + " n'a pas été ajouté à l'inventaire car ce dernier est plein !");
		}

//			if (objet instanceof Materiaux) {
//				if (contenu.containsKey(objet.getNom())) {
//
//					Carriable oldObjet = (Materiaux) contenu.get(objet.getNom());
//					Integer oldQuantite = (oldObjet).getQuantite();
//					Integer newQuantite = oldQuantite + ((Materiaux) objet).getQuantite();
//
//					this.jeter(oldObjet, false);
//
//					((Materiaux) objet).setQuantite(newQuantite);
//				}
//				for (int i = 1; i <= ((Materiaux) objet).getQuantite(); i++) {
//					contenu.put(objet.getNom(), objet);
//					size -= 1;
//				}
//			} else {
//
//				if (contenu.containsKey(objet.getNom())) {
//
//					Carriable oldObjet = (Equipement) contenu.get(objet.getNom());
//					Integer oldQuantite = (oldObjet).getQuantite();
//					Integer newQuantite = oldQuantite + ((Equipement) objet).getQuantite();
//
//					this.jeter(oldObjet, false);
//
//					((Equipement) objet).setQuantite(newQuantite);
//
//				}
//
//				for (int i = 1; i <= ((Equipement) objet).getQuantite(); i++) {
//					contenu.put(objet.getNom(), objet);
//					size -= 1;
//				}
//			}

	}

	public void equiper(Equipement equipement, Player p) {
		if (contenu.values().contains(equipement)) {
			equipement.equiper(p);
			contenu.remove(equipement.getNom());
			contenu = this.sortByItemName(contenu);
			size += 1;
			System.out.println("\n" + equipement.getNom() + " a été équipé !");
		} else {
			System.out.println("\nEquipement impossible !");
		}
	}

	public void desequiper(Equipement equipement, Player p) {
		if (size > 0) {
			equipement.retirer(p);
			contenu.put(equipement.getNom(), equipement);
			contenu = this.sortByItemName(contenu);
			size -= 1;
			System.out.println("\n" + equipement.getNom() + " a été déséquipé et ajouté à l'inventaire!");
		} else {
			System.out.println("\nLe sac est plein, impossible de déséquiper " + equipement.getNom());
		}
	}

	public void jeter(Carriable objet, Boolean message) {
		if (contenu.values().contains(objet)) {
			contenu.remove(objet.getNom());
			contenu = this.sortByItemName(contenu);
			size += 1;
			if (message) {

				System.out.println("\n" + objet.getNom() + " a été jeté. Quel gachi !");
			}
		} else {
			if (message) {

				System.out.println("\nOn ne peut pas jeter ce qu'on ne possède pas...");
			}
		}
	}

	@Override
	public Integer getTauxDrop() {

		return tauxDrop;
	}

	public void setTauxDrop(Integer tauxDrop) {
		this.tauxDrop = tauxDrop;
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

	public Map<String, Carriable> getContenu() {
		return contenu;
	}

	public void setContenu(Map<String, Carriable> contenu) {
		this.contenu = contenu;
	}

	@Override
	public int compareTo(Carriable value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer getQuantite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setQuantite(Integer quantite) {
		// TODO Auto-generated method stub

	}

}
