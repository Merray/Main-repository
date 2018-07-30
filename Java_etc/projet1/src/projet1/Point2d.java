package projet1;

public class Point2d {

	// Attributs
	private double x, y;

	// Constructeurs

	public Point2d(double param) {
		this.x = param;
		this.y = param;
	}

	public Point2d() {
		this.x = 0;
		this.y = 0;
	}

	public Point2d(double x, double y) {

		this.x = x;
		this.y = y;
	}

	// Methodes

	public void setX(double x) {

		this.x = x;

	}

	public double getX() {
		return this.x;

	}

	public void setY(double y) {

		this.y = y;

	}

	public double getY() {
		return this.y;

	}

	public String getCoord() {

		return "Coordonnes x: " + this.x + " Coordonnes y: " + this.y;

	}

	public void deplacer(double dx, double dy) {

		this.x += dx;
		this.y += dy;

	}

	public double distanceE(Point2d p) {

		return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));

	}
}
