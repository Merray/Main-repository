package projet1;

public class App {
	public static void main(String[] args) {

		// Points
		Point2d monPoint1 = new Point2d(1, 6);
		Point2d monPoint2 = new Point2d(8);
		Point2d monPoint3 = new Point2d();

		// Strings
		//String s = "Salut cher destinataire ! Comment vas tu ?\nMoi je vais très bien, je programme des objets trop cools!\nAllez je dois te laisser parce que le cours reprends !\nGros bisous <3";

		// Personnes
		// Personne jimmy = new Personne("Delamuerte", "Jimmy", "8 rue des jambons");
		// Personne marine = new Personne("Delavida", "Marine", "8 rue des saucissons");

		// Formateurs
		Formateur olivier = new Formateur("Gozlan", "Olivier", "Chez lui", 5);

		// Stagiaires
		Stagiaire jim = new Stagiaire("Carrillo", "Jimmy", "Chez moi", 8);

		// Lettres
		// Lettre lettre = new Lettre(s, jimmy, marine);

		// Cercles et Rectangles
		Cercle c = new Cercle(monPoint1, 3);
		Rectangle r = new Rectangle(monPoint2, 5, 2);

		// Partie POINTS
		System.out.println("\n===================== PARTIE POINTS ========================\n");
		System.out.println("monPoint1 x : " + monPoint1.getX());
		System.out.println("monPoint1 y : " + monPoint1.getY());
		System.out.println("monPoint2 x : " + monPoint2.getX());
		System.out.println("monPoint2 y : " + monPoint2.getY());
		System.out.println("monPoint3 x : " + monPoint3.getX());
		System.out.println("monPoint3 y : " + monPoint3.getY());

		monPoint1.setX(1);
		monPoint1.setY(1);
		monPoint2.setX(10.0);
		monPoint2.setY(12.0);
		monPoint3.setX(1.0);
		monPoint3.setY(2.0);

		System.out.println("monPoint1 New x : " + monPoint1.getX());
		System.out.println("monPoint1 New y : " + monPoint1.getY());
		System.out.println("monPoint2 New x : " + monPoint2.getX());
		System.out.println("monPoint2 New y : " + monPoint2.getY());
		System.out.println("monPoint3 New x : " + monPoint3.getX());
		System.out.println("monPoint3 New y : " + monPoint3.getY());

		monPoint1.deplacer(1.0, 2.0);
		System.out.println("On deplace le monPoint1 : " + monPoint1.getCoord());
		System.out.println("Distance E pour monPoint1 et monPoint2: " + monPoint1.distanceE(monPoint2));

		// Partie LETTRE
		System.out.println("\n===================== PARTIE PERSONNES ========================\n");
		// lettre.afficher();

		System.out.println(olivier.sePresenter());
		System.out.println(jim.sePresenter());
		jim.situationProfessionelle();

		System.out.println("\n===================== PARTIE GEOMETRIE ========================\n");

		System.out.println("Perimètre d'un rectangle de longueur " + r.getLongueur() + " et de largeur "
				+ r.getLargeur() + ": " + r.perimetre());
		System.out.println("surface d'un rectangle de longueur " + r.getLongueur() + " et de largeur " + r.getLargeur()
				+ ": " + r.surface());
		System.out.println("\n");
		System.out.println("Périmètre d'un cerle de rayon " + c.getRayon() + ": " + c.perimetre());
		System.out.println("Surface d'un cerle de rayon " + c.getRayon() + ": " + c.surface());

		
		System.out.println("\n===================== PARTIE INTERFACE ========================\n");
		
		ToStringable ts= new Formateur("olivier", "gozlan", "chez lui", 2);
		System.out.println(ts.getString());
		
		System.out.println("\n===================== PARTIE ENUM ========================\n");
		
		System.out.println(Jour.MARDI.getEn());
		
		Jour unJour = Jour.valueOf("MERCREDI");
		System.out.println(unJour.getFr());
		
		
	}

}
