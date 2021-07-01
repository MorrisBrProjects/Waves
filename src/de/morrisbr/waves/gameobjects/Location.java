package de.morrisbr.waves.gameobjects;

import de.morrisbr.waves.world.World;

public class Location {
	
	private int xPosition;
	private int yPosition;
	private int zPosition;
	
	private World world;
	
	
	public Location(int xPosition, int yPosition, World world) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.setWorld(world);
	}
	
	public Location(int xPosition, int yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	
	public Location(int xPosition, int yPosition, int zPosition, World world) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.zPosition = zPosition;
		this.setWorld(world);
	}
	
	public Location(int xPosition, int yPosition, int zPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.zPosition = zPosition;
	}
	
	
	public int getxPosition() {
		return xPosition;
	}
	
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	
	public int getyPosition() {
		return yPosition;
	}
	
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public int getzPosition() {
		return zPosition;
	}

	public void setzPosition(int zPosition) {
		this.zPosition = zPosition;
	}

}
