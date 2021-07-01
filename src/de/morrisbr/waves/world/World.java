package de.morrisbr.waves.world;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import de.morrisbr.waves.gameobjects.GameObject;
import de.morrisbr.waves.gameobjects.Location;

public class World implements IWorld {

	private String name;
	private CopyOnWriteArrayList<GameObject> gameObjects;
	private Iterator<GameObject> gameObjectIterator;
	
	public World(String name) {
		gameObjects = new CopyOnWriteArrayList<GameObject>();
		this.name = name;
	}
	


	public World() {
		gameObjects = new CopyOnWriteArrayList<GameObject>();
	}
	
	
	@Override
	public void update(double delta) {
		
		for (int i = 0; i < gameObjects.size(); i++) 
		{
			GameObject gameObject = gameObjects.get(i);
			gameObject.update(delta);
			checkCollision(gameObject);
		}
		
	}

	@Override
	public void draw(Graphics2D graphics) {
	}

	@Override
	public void onLoad() {
		System.out.println("World: " + getName() + " loaded...");
	}

	@Override
	public void onUnload() {
		gameObjects.clear();
		System.out.println("World: " + getName() + " unloaded...");
	}
	
	
	public void drawObjects(Graphics2D graphics) 
	{
		for (int i = 0; i < gameObjects.size(); i++) {
			GameObject gameObject = gameObjects.get(i);
//			Location location = gameObject.getLocation();
//			
//			location.setzPosition(location.getzPosition() + (Waves.getWaves().displayHeight - gameObject.getLocation().getyPosition()));
//			gameObject.setLocation(location);
//			
//
//			gameObject.setWidht(gameObject.getWidht() - location.getzPosition());
//
//			
//			System.out.println(gameObject.getWidht() - location.getzPosition());
			
			gameObject.draw(graphics);
		}
	}
	
	
	
	
	@SuppressWarnings("unused")
	private void checkCollision(GameObject gameObject) {
		
		
		
		  for (GameObject other : getGameObjects()) {
		    if (!other.equals(gameObject)) {
		    	Location currentObjlocation = gameObject.getLocation();
		    	Location otherObjLocation = other.getLocation();
				
				if (gameObject.isCollisionEnabled() 
				&& currentObjlocation.getxPosition()  +  gameObject.getWidht() >= other.getLocation().getxPosition() 
				&& other.getLocation().getxPosition() +       other.getWidht() >=  currentObjlocation.getxPosition() 
				&& currentObjlocation.getyPosition()  + gameObject.getHeight() >= other.getLocation().getyPosition() 
				&& other.getLocation().getyPosition() +      other.getHeight() >=  currentObjlocation.getyPosition()) {
					
					
					onCollision(gameObject, other);
					other.onCollision(gameObject);
					gameObject.onCollision(other);
				}
		    }
		  }
		
		
		}
	//Collisionsobject machen, mit COlision type , und richtung

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public CopyOnWriteArrayList<GameObject> getGameObjects() {
		return gameObjects;
	}
	


	 @Override
	public void onCollision(GameObject perpetrator, GameObject victim) {}


	public void deleteGameObject(GameObject gameObject) {
		getGameObjects().remove(gameObject);
	}
	
}
