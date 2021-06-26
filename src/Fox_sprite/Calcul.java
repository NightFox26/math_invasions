package Fox_sprite;

import java.awt.Color;
import java.util.Random;

import Fox_game.Main;


public class Calcul extends Sprite{
	
	private String strCalcul;
	private Color color;
	public static double vitesse;
	private int chiffrePossible[] = {0,1,2,3,4,5,6,7,8,9};
	private int chiffreMistere;
	private Alien alien;
	
	public Calcul() {
		super(69, 400, 0, 50);				
		this.color =  new Color(240,137,55);		
		this.strCalcul = this.creationFormule();
		this.setLargeur(this.strCalcul.length()*18);
		
		int xRand = this.randomEntreDeuxNombre(0, 575-this.getLargeur());
		
		this.setX(xRand);
		this.alien = new Alien(this.getX(),this.getY()-35, this.getLargeur(),this.getVitesse());
		Main.scene.tabAlien.add(this.alien);
	}
	
	private String creationFormule(){		
		int i = randomEntreDeuxNombre(0, this.chiffrePossible.length);
		int num1 = this.randomEntreDeuxNombre(1, 20);
		
		this.chiffreMistere = this.chiffrePossible[i];
		int res = num1 + this.chiffreMistere;
		
		return num1+" + ?  = "+res;
	}
	
	private int randomEntreDeuxNombre(int min, int max){		
		Random hasard = new Random();
		int num = hasard.nextInt(max-min);
		return num+min;		
	}
	
	
	
	
	//GETTERS
	public String getStrCalcul() {return strCalcul;}
	public Color getColor() {return color;}
	public double getVitesse() {return vitesse;}
	public int getChiffreMistere() {return chiffreMistere;}
	public Alien getAlien(){return this.alien;}	

}
