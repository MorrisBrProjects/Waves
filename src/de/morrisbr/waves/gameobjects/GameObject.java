package de.morrisbr.waves.gameobjects;

import java.awt.Graphics2D;

import de.morrisbr.waves.world.World;

public class GameObject {
	
	private int widht;
	private int height;
	private Location location;
	private boolean collision;
	
	private World world;
	
	public GameObject() {
		setWorld(new World());
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidht() {
		return widht;
	}
	public void setWidht(int widht) {
		this.widht = widht;
	}
//	@SuppressWarnings("unused")
	
	/**
	 * 
	 * This is a debug Methode (Not Use)
	 * This return a World
	 * 
	 * @return world
	 */
	@Deprecated
	@SuppressWarnings("unused")
	private World getWorld() {
		return world;
	}
	
	
	/**
	 * 
	 * This is a debug Methode (Not Use)
	 * 
	 * @param world
	 */
	 @Deprecated
	public void setWorld(World world) {
		if(this.world != null)
		{
			//this.world.onUnload();
		}
		
		this.world = world;
		//world.onLoad();
	}
	
	
	/**
	 * 
	 * Get the Location from this GameObject
	 * 
	 * @return location
	 **/
	
	public Location getLocation() {
		return location;
	}
	
	/**
	 * 
	 * Set the Location for this GameObject
	 * 
	 **/
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	/**
	 * 
	 * Has this GameObject a Collision
	 * 
	 * @return collision
	 **/
	public boolean isCollisionEnabled() {
		return collision;
	}
	
	/**
	 * 
	 * Set the Collision acictive or inactive for this GameObject
	 * 
	 **/
	public void setCollisionEnabled(boolean collision) {
		this.collision = collision;
	}
	
	/**
	 * 
	 * Draw this GameObject
	 * 
	 * @param graphics
	 */
	public void draw(Graphics2D graphics) {}
	
	
	/**
	 * 
	 * Update this GameObject
	 * 
	 * @param delta
	 */
	public void update(double delta) {}

	
	/**
	 * 
	 * Trigger on collision by Other GameObject
	 * 
	 * @param other
	 */
	public void onCollision(GameObject other) {}


}




