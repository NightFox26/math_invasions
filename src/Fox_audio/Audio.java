package Fox_audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Audio {
	
	private Clip sound;
	
	public Audio(String son){
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource(son));
			sound = AudioSystem.getClip();
			sound.open(audio);
		}catch (Exception e) {}		
	}
	
	//Getters
	public Clip getSound() {return sound;}
	
	//Methodes
	public void play(){sound.start();}

	public void stop(){sound.stop();}
	
	public static void playSound(String son){
		Audio s = new Audio(son);
		s.play();
	}
	
}
