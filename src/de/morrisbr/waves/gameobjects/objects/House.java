package de.morrisbr.waves.gameobjects.objects;

import java.awt.Color;
import java.awt.Graphics2D;

import de.morrisbr.waves.gameobjects.GameObject;
import de.morrisbr.waves.gameobjects.Location;

public class House extends GameObject {

	
	public House(Location location, int widht, int height) {
		setLocation(location);
		setHeight(height);
		setWidht(widht);
		//setWorld(location.getWorld()); // entfernen, mach über location
	}
	
	@Override
	public void update(double delta) {
		super.update(delta);
		
	}
	
	@Override
	public void draw(Graphics2D graphics) {
		super.draw(graphics);
		graphics.setColor(Color.BLACK);
		graphics.fillRect(getLocation().getxPosition(), getLocation().getyPosition(), getWidht(), getHeight());
	}
	
	@Override
	public void onCollision(GameObject other) {
		super.onCollision(other);
		System.out.println(other + "54645678678");
	}
	
}
