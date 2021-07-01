package de.morrisbr.waves.utils;

import java.util.TimerTask;

public class Timer 
{

	private java.util.Timer timer;
	private Type type;
	
	private int speed;
	
	public Timer(int speed, Type type) {
		timer = new java.util.Timer();
		this.type = type;
		
		this.speed = speed;
	}

	public java.util.Timer getTimer() {
		return timer;
	}
	
	
	public void runTimer() 
	{
		switch (type) {
		case SINGLE:
			timer.scheduleAtFixedRate(new TimerTask() {
				  @Override
				  public void run() {
				    onFinish();
				  }
				}, 2*60*1000, 2*60*1000);
			break;
		case LOOP:
			timer.schedule(new TimerTask() {
				  @Override
				  public void run() {
				    onFinish();
				  }
				}, 0, speed);
			break;

		default:
			break;
		}
	}
	
	
	public void onFinish() 
	{
		
	}
	
	
	public int getSpeed() {
		return speed;
	}



	public static enum Type 
	{
		LOOP, SINGLE;
	}
	
}
