package de.morrisbr.waves.client.audio;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class AudioPlayer {
	
//	private Clip clip;
//	private long pisitionTime;
//	@SuppressWarnings("unused")
//	private boolean isPaused;
//	@SuppressWarnings("unused")
//	private float volume;
//	
//	public AudioPlayer(String s, float volume) {
//		
//		this.volume = volume;
//		
//		new Thread(() ->{
//			try {
//				
//				AudioInputStream ais =
//					AudioSystem.getAudioInputStream(
//						getClass().getResourceAsStream(
//							s
//						)
//					);
//				AudioFormat baseFormat = ais.getFormat();
//				AudioFormat decodeFormat = new AudioFormat(
//					AudioFormat.Encoding.PCM_SIGNED,
//					baseFormat.getSampleRate(),
//					16,
//					baseFormat.getChannels(),
//					baseFormat.getChannels() * 2,
//					baseFormat.getSampleRate(),
//					false
//				);
//				AudioInputStream dais =
//					AudioSystem.getAudioInputStream(
//						decodeFormat, ais);
//				clip = AudioSystem.getClip();
//				clip.open(dais);
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//			
//		}).start();
//		
//		
//		
//	}
//	
//	public void play() {
//		if(clip == null) return;
//		clip.setFramePosition(0);
//		clip.start();
//	}
//	
//	public void pause() {
//		if(clip.isRunning()) {
//			this.pisitionTime = clip.getMicrosecondPosition();
//			isPaused = true;
//			stop();
//		} else {
//			clip.setMicrosecondPosition(pisitionTime);
//			isPaused = false;
//		}
//	}
//	
//	public void overridePlay() {
//		if(clip == null || !Option.getOptionByName("music").isAktive()) return;
//		
//		if(!clip.isRunning()) {
//			play();
//		}
//	}
//	
//	public void stop() {
//		if(clip == null) return;
//		if(clip.isRunning()) clip.stop();
//	}
//	
//	public void close() {
//		stop();
//		clip.close();
//	}
//	
//	public void loopAudio(int loopCount) {
//		if(clip == null) return;
//		clip.loop(loopCount);
//		play();
//	}
	


	  private Clip clip;
	  
	  private FloatControl volumen;
	  
	  //private AudioInputStream ais;
	  
	  private long ende = 0L;
	  
	  private long start = 0L;
	  
	  public AudioPlayer(String path, float volumen) {
	    try {
			AudioInputStream ais =
			AudioSystem.getAudioInputStream(
				getClass().getResourceAsStream(
					path
				)
			);
		AudioFormat baseFormat = ais.getFormat();
		AudioFormat decodeFormat = new AudioFormat(
			AudioFormat.Encoding.PCM_SIGNED,
			baseFormat.getSampleRate(),
			16,
			baseFormat.getChannels(),
			baseFormat.getChannels() * 2,
			baseFormat.getSampleRate(),
			false
		);
		AudioInputStream dais =
			AudioSystem.getAudioInputStream(
				decodeFormat, ais);
		clip = AudioSystem.getClip();
		clip.open(dais);
	      //this.volumen = (FloatControl)this.clip.getControl(FloatControl.Type.MASTER_GAIN);
	      //this.volumen.setValue(volumen);
	    } catch (Exception e) {
	      e.printStackTrace();
	      System.out.println("Arschloch exeption");
	      System.err.println("SOUND DATEI KONNTE NICHT GELADEN WERDEN");
	    } 
	  }
	  
	  public void sample(long start, long ende) {
	    this.ende = ende;
	    this.start = start;
	    if (!this.clip.isActive()) {
	      this.clip.stop();
	      this.clip.setMicrosecondPosition(start);
	      this.clip.start();
	    } 
	  }
	  
	  public void play() {
	    this.clip.stop();
	    this.clip.setMicrosecondPosition(0L);
	    this.clip.start();
	  }
	  
	  public void rewind() {
	    this.clip.setMicrosecondPosition(0L);
	  }
	  
	  public void stop() {
	    this.clip.stop();
	  }
	  
	  public void stopWhenRunning() {
	    this.clip.stop();
	    this.clip.close();
	    if (this.clip.isActive())
	      this.clip.close(); 
	  }
	  
	  public void loop() {
	    this.clip.loop(-1);
	    this.clip.start();
	  }
	  
	  public boolean issoundactive() {
	    return this.clip.isActive();
	  }
	  
	  public void setVolumen(float value) {
	    try {
	      this.volumen.setValue(value);
	    } catch (Exception e) {
	      e.printStackTrace();
	      System.out.println("Hurensohn exaption");
	    } 
	  }
	  
	  public void update() {
	    if (this.clip.getMicrosecondPosition() >= this.ende) {
	      this.clip.stop();
	      this.clip.setMicrosecondPosition(this.start);
	    } 
	  }
	}














