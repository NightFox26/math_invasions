package Fox_sprite;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Alien extends Sprite{
	
	private ImageIcon icoAlienDroite;
	private ImageIcon icoAlienGauche;
	private Image imgAlien;
	private int minX;
	private int maxX;
	private String regarde;
	private double vitesseDescente;

	public Alien(int x, double y, int depLong, double vitesseDescente) {
		super(62, 45, x, y);
		this.icoAlienDroite = new ImageIcon(getClass().getResource("/Sprite/alienDroite.png"));
		this.icoAlienGauche = new ImageIcon(getClass().getResource("/Sprite/alienGauche.png"));
		this.setImgAlien(this.icoAlienDroite.getImage());	
		this.regarde = "droite";
		this.minX = x;
		this.maxX = x+depLong;
		this.vitesseDescente = vitesseDescente;
	}
	
	public void regarde(String sens){
		if(sens == "droite"){
			this.setImgAlien(this.icoAlienDroite.getImage());
			this.regarde = "droite";
		}else if(sens == "gauche"){
			this.setImgAlien(this.icoAlienGauche.getImage());
			this.regarde = "gauche";
		}
	}

	
	//GETTERS
	public Image getImgAlien() {return imgAlien;}
	public int getMinX() {return minX;}
	public int getMaxX() {return maxX;}
	public String getRegarde() {return regarde;}
	public double getVitesseDescente() {return vitesseDescente;}

	//SETTERS
	public void setImgAlien(Image imgAlien) {this.imgAlien = imgAlien;}

	

	

	

}
