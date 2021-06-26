package Fox_game;

import javax.swing.JFrame;

public class Main {
	
	public static Scene scene;

	//methode qui lance le programme
	public static void main(String[] args) {
		
		//creation de la fenetre de jeu
		JFrame fenetre = new JFrame("Math Invasion");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(575, 700);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);
		
		scene = new Scene();
		fenetre.setContentPane(scene);
		fenetre.setVisible(true);			
	}

}
