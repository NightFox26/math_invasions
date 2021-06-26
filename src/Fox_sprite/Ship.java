package Fox_sprite;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Ship extends Sprite{
	
	private ImageIcon icoShip;
	private Image imgShip;
	private boolean mort;
	
	public Ship(int x, int y) {
		super(77, 77, x, y);
		this.icoShip = new ImageIcon(getClass().getResource("/Sprite/spaceship.png"));
		this.setImgShip(this.icoShip.getImage());
		this.setMort(false);
	}

	//GETTERS
	public Image getImgShip() {return imgShip;}
	public boolean isMort() {return mort;}

	//SETTERS
	public void setImgShip(Image imgShip) {this.imgShip = imgShip;}
	public void setMort(boolean mort) {this.mort = mort;}


}
