package projet1;

public class Rectangle extends FormeGeometrique {
	private Point2d hautGauche;
	private double longueur;
	private double largeur;

	public Rectangle(Point2d hautGauche, double longueur, double largeur) {
		super();
		this.hautGauche = hautGauche;
		this.longueur = longueur;
		this.largeur = largeur;

	}

	public double perimetre() {
		double p = 2 * (this.longueur + this.largeur);

		return p;
	}

	public double surface() {
		double s = this.longueur * this.largeur;

		return s;
	}

	public void dessiner() {
	}

	public Point2d getHautGauche() {
		return hautGauche;
	}

	public void setHautGauche(Point2d hautGauche) {
		this.hautGauche = hautGauche;
	}

	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

}
