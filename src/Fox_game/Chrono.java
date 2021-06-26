package Fox_game;

import Fox_sprite.Calcul;

public class Chrono implements Runnable{

	private final int PAUSE = 4; // temps de pause entre chaque boucle pour le rafraichissement de l'ecran
	private int tempsCreationCalcul;
	private int i;
	
	public Chrono(){
		this.i = 0;	
		this.tempsCreationCalcul = 2500;
	}
	
	@Override
	public void run() {		
		while(Main.scene.ship.isMort()==false){				
			this.i += PAUSE;	
						
			if(this.i > this.tempsCreationCalcul){	
				System.out.println("ajout calcul");
				Main.scene.tabCalcul.add(new Calcul());
				this.i=0;
			}
			
			Main.scene.repaint();
			
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {}			
		}
		
	}

}
