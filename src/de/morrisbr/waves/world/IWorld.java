package de.morrisbr.waves.world;

import java.awt.Graphics2D;

import de.morrisbr.waves.gameobjects.GameObject;


public interface IWorld {
	
	public void update(double delta);
	
	public void draw(Graphics2D graphics);
	
	public void onLoad();
	
	public void onUnload();
	
	public void onCollision(GameObject perpetrator, GameObject victim);

}
