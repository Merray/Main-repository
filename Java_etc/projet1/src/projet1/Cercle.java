package projet1;

public class Cercle extends FormeGeometrique {

	private Point2d centre;
	private double rayon;

	public Cercle(Point2d centre, double rayon) {
		super();
		this.centre = centre;
		this.rayon = rayon;

	}

	public double perimetre() {
		double p = 2 * Math.PI * rayon;

		return p;
	}

	public double surface() {
		double s = Math.PI * Math.pow(rayon, 2);

		return s;
	}

	public void dessiner() {
	}

	public Point2d getCentre() {
		return centre;
	}

	public void setCentre(Point2d centre) {
		this.centre = centre;
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

}
