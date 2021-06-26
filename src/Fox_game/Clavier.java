package Fox_game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Fox_audio.Audio;
import Fox_sprite.Chiffre;


public class Clavier implements KeyListener {
	private boolean leftPressed;
	private boolean rightPressed;

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			rightPressed = true;
			if(Main.scene.ship.getX()<530){
				Main.scene.setDeltaXShip(1);
			}else{
				Main.scene.ship.setX(-30);//mettre a 500, si on ne veux pas que le vaisseau tp a gauche
				Main.scene.setDeltaXShip(0);
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			leftPressed = true;
			if(Main.scene.ship.getX()>-30){
				Main.scene.setDeltaXShip(-1);
			}else{
				Main.scene.ship.setX(530);//mettre a 0, si on ne veux pas que le vaisseau tp a droite
				Main.scene.setDeltaXShip(0);
			}
		}
		
		switch(e.getKeyCode()){
			case KeyEvent.VK_NUMPAD0:				
				Main.scene.tabTir.add(new Chiffre(Main.scene.ship.getX(),Main.scene.ship.getY(),0));	
				Audio.playSound("/Audio/tir2.wav");
				break;
			case KeyEvent.VK_NUMPAD1:
				Main.scene.tabTir.add(new Chiffre(Main.scene.ship.getX(),Main.scene.ship.getY(),1));	
				Audio.playSound("/Audio/tir2.wav");
				break;
			case KeyEvent.VK_NUMPAD2:
				Main.scene.tabTir.add(new Chiffre(Main.scene.ship.getX(),Main.scene.ship.getY(),2));	
				Audio.playSound("/Audio/tir2.wav");
				break;
			case KeyEvent.VK_NUMPAD3:
				Main.scene.tabTir.add(new Chiffre(Main.scene.ship.getX(),Main.scene.ship.getY(),3));
				Audio.playSound("/Audio/tir2.wav");
				break;
			case KeyEvent.VK_NUMPAD4:
				Main.scene.tabTir.add(new Chiffre(Main.scene.ship.getX(),Main.scene.ship.getY(),4));
				Audio.playSound("/Audio/tir2.wav");
				break;
			case KeyEvent.VK_NUMPAD5:
				Main.scene.tabTir.add(new Chiffre(Main.scene.ship.getX(),Main.scene.ship.getY(),5));
				Audio.playSound("/Audio/tir2.wav");
				break;
			case KeyEvent.VK_NUMPAD6:
				Main.scene.tabTir.add(new Chiffre(Main.scene.ship.getX(),Main.scene.ship.getY(),6));	
				Audio.playSound("/Audio/tir2.wav");
				break;
			case KeyEvent.VK_NUMPAD7:
				Main.scene.tabTir.add(new Chiffre(Main.scene.ship.getX(),Main.scene.ship.getY(),7));	
				Audio.playSound("/Audio/tir2.wav");
				break;
			case KeyEvent.VK_NUMPAD8:
				Main.scene.tabTir.add(new Chiffre(Main.scene.ship.getX(),Main.scene.ship.getY(),8));
				Audio.playSound("/Audio/tir2.wav");
				break;
			case KeyEvent.VK_NUMPAD9:
				Main.scene.tabTir.add(new Chiffre(Main.scene.ship.getX(),Main.scene.ship.getY(),9));	
				Audio.playSound("/Audio/tir2.wav");
				break;			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			rightPressed = false;
			if(leftPressed == false){
				Main.scene.setDeltaXShip(0);
			}
		}else if (e.getKeyCode() == KeyEvent.VK_LEFT ){
			leftPressed = false;
			if(rightPressed == false){
				Main.scene.setDeltaXShip(0);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

}
