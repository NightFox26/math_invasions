package Fox_sprite;

import java.awt.Color;

import Fox_game.Main;

public class Chiffre extends Sprite{
	
	private final Color COLOR = new Color(0,255,0);	
	private int num;
	private boolean visible;

	public Chiffre(int x, double y, int pChiffre) {		
		super(69, 42, x, y);
		super.setX(this.getX()+Main.scene.ship.getLargeur()/2-this.getLargeur()/2+3);
		super.setY(this.getY()+this.getLargeur()/6);
		this.setNum(pChiffre);
		this.visible = true;
	}
	
	public void sortieEcran(){
		if(this.getY()<0){
			this.visible = false;
		}else{
			this.visible = true;
		}		
	}
	
	public boolean proche(Calcul calc){
		if(this.getY() < calc.getY()+10 && this.getY() > calc.getY() && this.getX() >= calc.getX() && this.getX() <= calc.getX()+calc.getLargeur()){
			return true;
		}
		return false;
	}
	
	//GETTERS	
	public Color getCOLOR() {return COLOR;}
	public int getNum() {return num;}	
	public boolean getVisible() {return visible;}
	
	//SETTERS
	public void setNum(int num) {this.num = num;}




	

}
