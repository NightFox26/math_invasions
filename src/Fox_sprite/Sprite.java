package Fox_sprite;

abstract class Sprite {
	
	private int hauteur;
	private int largeur;
	private int x;
	private double y;
	public int compteur;
	//private boolean moving;
	
	public Sprite(int hauteur, int largeur, int x, double y){		
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.x=x;
		this.y=y;	
		this.compteur = 0;
		//this.moving = false;
	}	

	//GETTERS
	public int getHauteur() {return hauteur;}
	public int getLargeur() {return largeur;}
	public int getX() {return x;}
	public double getY() {return y;}
	public int getCompteur() {return compteur;}

	//SETTERS
	public void setHauteur(int hauteur) {this.hauteur = hauteur;}	
	public void setLargeur(int largeur) {this.largeur = largeur;}
	public void setX(int x) {this.x = x;}
	public void setY(double d) {this.y = d;}
	public void setCompteur(int compteur) {this.compteur = compteur;}

}
