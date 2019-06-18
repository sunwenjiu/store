package wenjiu.sound;

import java.io.FileInputStream;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.swing.JApplet;



public class Sound {
	byte[] data;
	AudioFormat format;
	int length;

	
	
	public Sound(String name)   {
		//URL url = null;
		try {
		//	url = new URL("file:src/main/resources/"+ name);
		/*	AudioInputStream in = 
					AudioSystem.getAudioInputStream(
							getClass().getResource(name));//本目录*/
			AudioInputStream in= AudioSystem.getAudioInputStream(
					getClass().getResource(name)) ;
			
			format = in.getFormat();
			length = (int)in.getFrameLength();
			//System.out.println(length);
			data = new byte[length];
			in.read(data);
			//System.out.println(data.length);
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void play(){
		Runnable runner = new Runnable(){
			public void run() {
			
				try {
					
					Clip clip = AudioSystem.getClip();
					//System.out.println(format);
					//System.out.println(data);
					//System.out.println(length);
					clip.open(format, data, 0, length);
					clip.start();
					clip.drain();
					clip.stop();
					clip.close();
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				}
			}
		};
		//pool.execute(runner);
		new Thread(runner).start();
	}
	
	/*World里面
	 * 
	 * 
	 * 先声明
	 * Sound hitSound;
	Sound flappySound;
	Sound scoreSound;
	Sound startSound;
	
	//初始化  也可以直接声明后赋值
		hitSound = new Sound("hit.wav");
		flappySound = new Sound("flappy.wav");
		scoreSound = new Sound("score.wav");
		startSound = new Sound("start.wav");
	//直接调用
	startSound.play();
	
	*
	*
	*
	*
	*/
}
