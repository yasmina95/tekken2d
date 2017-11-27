package Animacion;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



public class Musica {
	private Clip clip;
	public Musica(String s){
		try{
			AudioInputStream sal= AudioSystem.getAudioInputStream(getClass().getResourceAsStream(s));
		
	AudioFormat formatoBase= sal.getFormat();
	AudioFormat formatodecodi= new AudioFormat(
	AudioFormat.Encoding.PCM_SIGNED, formatoBase.getSampleRate(),16, formatoBase.getChannels(),
	formatoBase.getChannels()*2,formatoBase.getSampleRate(),false);

		AudioInputStream dsal= AudioSystem.getAudioInputStream(formatodecodi,sal);
		clip=AudioSystem.getClip();
		clip.open(dsal);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void play(){
		if(clip==null)return;
		stop();
		clip.setFramePosition(0);
		clip.start();
		
	}
	public void stop(){
		if(clip.isRunning())
			clip.stop();
	}
	public void close(){
		stop();
		clip.close();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
