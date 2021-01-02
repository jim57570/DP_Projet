package exodecorateur_angryballs.modele;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound implements AutoCloseable{
	private final Clip audioClip;
	
	public Sound(String name) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        final URL url = Sound.class.getResource("/sounds/"+name);
        audioClip = AudioSystem.getClip();
        audioClip.open(AudioSystem.getAudioInputStream(url));
    }
    public void jouer() {
       audioClip.start();
    }
    public void jouerEnBoucle() {
       audioClip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void jouerPlusieursFois(int nb) {
       audioClip.loop(nb);
    }
    public void arreter() {
        audioClip.stop();
    }

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
