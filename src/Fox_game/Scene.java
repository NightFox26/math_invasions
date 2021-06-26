package Fox_game;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Fox_audio.Audio;
import Fox_sprite.Alien;
import Fox_sprite.Calcul;
import Fox_sprite.Chiffre;
import Fox_sprite.Ship;

@SuppressWarnings("serial")
public class Scene extends JPanel {
	
	private ImageIcon icoSpaceBg;
	private Image imgSpaceBg1;
	private Image imgSpaceBg2;	
			
	private int yFond1;
	private int yFond2;
	private int deltaYFond;
	
	public Ship ship;	
	private int deltaXShip;
	
	private int score;
	private int level;
	
	private Font police1;
	private Font police2;
	
	public ArrayList<Chiffre> tabTir;
	public ArrayList<Calcul> tabCalcul;
	public ArrayList<Alien> tabAlien;
		
		
	//Constructeur de la Scene
	public Scene(){
		
		super();
		this.yFond1 = 0;
		this.yFond2 = -1024;		
		this.deltaYFond = 1;
		
		this.score = 0;
		this.level = 0;
		
		ship = new Ship(265,570);		
		this.deltaXShip=0;
				
		icoSpaceBg = new ImageIcon(getClass().getResource("/Sprite/Arriere-plan.png"));
		this.imgSpaceBg1 = this.icoSpaceBg.getImage();	
		this.imgSpaceBg2 = this.icoSpaceBg.getImage();		
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		Calcul.vitesse = 0.10d;
		
		this.tabTir = new ArrayList<Chiffre>();		
		this.tabCalcul = new ArrayList<Calcul>();
		this.tabAlien = new ArrayList<Alien>();
		
		police1 = new Font("Arial", Font.PLAIN, 22);
		police2 = new Font("Arial", Font.PLAIN, 38);		
						
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
		
		
	}
	
	/****************************METHODE****************************/
	//methode qui gere le deplacement de l'ecran
	public void deplacementFond(){
		this.yFond1 += this.deltaYFond;
		this.yFond2 += this.deltaYFond;
		if(this.yFond1 == 1024){
			this.yFond1 = -1024;
		}else if(this.yFond2 == 1024){
			this.yFond2 = -1024;
		}
	}
	
	//methode qui gere le deplacement du vaisseau
	public void deplacementShip(){		
		ship.setX(ship.getX()+this.deltaXShip);		
	}
	
	public void deplacementAlien(Graphics g2){		
		if(tabAlien.size()>0){
			for(Alien alien : tabAlien){
				if(alien.getX() <= alien.getMaxX() && alien.getRegarde()=="droite"){					
					alien.regarde("droite");					
				}else if(alien.getX() > alien.getMaxX() && alien.getRegarde()=="droite"){					
					alien.regarde("gauche");
				}else if(alien.getX() < alien.getMinX() && alien.getRegarde()=="gauche"){					
					alien.regarde("droite");
				}
				
				if(alien.getRegarde() == "droite"){
					alien.setX(alien.getX()+1);
				}else{
					alien.setX(alien.getX()-1);
				}
				alien.setY(alien.getY()+Calcul.vitesse);
				g2.drawImage(alien.getImgAlien(), alien.getX(), (int) alien.getY(), null);
			}
		}		
	}
	
	//methode qui gere le deplacement des nombres
	public void deplacementChiffre(Graphics g2){		
		for(int i=0; i<this.tabTir.size();i++){
			if(this.tabTir.get(i).getVisible()==true){				
				g2.setColor(this.tabTir.get(i).getCOLOR());	
				g2.drawString(""+this.tabTir.get(i).getNum(), this.tabTir.get(i).getX(), (int)this.tabTir.get(i).getY());
				this.tabTir.get(i).setY(this.tabTir.get(i).getY()-1);
				this.tabTir.get(i).sortieEcran();
			}else{				
				this.tabTir.remove(this.tabTir.get(i));
			}			
		}
	}
	
	public void collisions(){
		for(Chiffre tir : tabTir){
			for(Calcul calc : tabCalcul){
				if(tir.proche(calc)){
					if(tir.getNum() == calc.getChiffreMistere()){
						this.tabCalcul.remove(calc);
						this.tabTir.remove(tir);
						this.tabAlien.remove(calc.getAlien());
						Audio.playSound("/Audio/alienMort.wav");
						this.score++;
						return;
					}
				}
			}
		}
	}
	
	public void verifScore(){		
		int palier = this.score / 5;
		int modulo = this.score % 5;
		if(this.level < palier && modulo == 0){
			this.level++;
			Calcul.vitesse += 0.1d;
			Audio.playSound("/Audio/levelUp.wav");
		}
	}
	
	//methode qui gere le deplacement des calculs mathematique
	public void deplacementCalcul(Graphics g2){		
		for(Calcul calcul : tabCalcul){		
			calcul.setY(calcul.getY()+calcul.getVitesse());	
			g2.setFont(police2);
			g2.setColor(calcul.getColor());			
			g2.drawString(calcul.getStrCalcul(), calcul.getX(), (int)calcul.getY());				
			
			if(calcul.getY()>570){
				this.ship.setMort(true);
				this.repaint();
			}
		}
	}
	
	
	//methode qui redessine l'ecran
	public void paintComponent(Graphics g){		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;		
		if(this.ship.isMort()==false){
			this.deplacementFond();	
			this.deplacementShip();	
			this.collisions();
			this.verifScore();
			
			g2.drawImage(this.imgSpaceBg1, 0, this.yFond1, null);
			g2.drawImage(this.imgSpaceBg2, 0, this.yFond2, null);
			g2.drawImage(ship.getImgShip(), ship.getX(),(int)ship.getY(), null);
						
			g2.setFont(police1);
			g2.setColor(Color.ORANGE);	
			g2.drawString("Score = "+this.score+" pts", 15, 660);
			
			g2.setColor(Color.green);
			g2.drawString("Niveau = "+this.level, 400, 660);
			
			this.deplacementCalcul(g2);	
			this.deplacementAlien(g2);
			
			if(this.tabTir.size() > 0){		
				g2.setFont(police2);
				deplacementChiffre(g2);
			}				
		}else{	
			Audio.playSound("/Audio/boom.wav");
			g2.setFont(police2);
			g2.setColor(Color.RED);	
			g2.drawString("Vous avez perdu !!!", 120, 300);	
			g2.setColor(Color.black);	
			g2.drawString("Votre score est de : "+this.score, 80, 400);	
		}
	}

	/****************************************************************/
	//GETTERS
	public int getYFond1() {return yFond1;}	
	public int getDeltaYFond() {return deltaYFond;}	
	public int getDeltaXShip() {return deltaXShip;}

	//SETTERS
	public void setYFond1(int yFond1) {this.yFond1 = yFond1;}
	public void setDeltaYFond(int deltaYFond) {this.deltaYFond = deltaYFond;}	
	public void setDeltaXShip(int deltaXShip) {this.deltaXShip = deltaXShip;}
	
}
