package de.morrisbr.waves.inventory;

import java.awt.Color;
import java.awt.Graphics2D;

public class Hotbar {
	
	private int slot = 0;
	
	private int hotbarWidht = 700;
	private int hotbarHeight = 100;
	
	private int hotbarScrollElement = 100;
	
	private int xPosition = 0;
	private int yPosition = 0;

	
	public Hotbar(int xPosition, int yPosition, int hotbarWidht, int hotbarHeight, int hotbarScrollElement, int defaultSlot) {
		this.hotbarHeight = hotbarHeight;
		this.hotbarWidht = hotbarWidht;
		this.hotbarScrollElement = hotbarScrollElement;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.slot = defaultSlot;
	}
	
	public Hotbar() {}
	
	
	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}
	
	public void draw(Graphics2D graphics) {
		
		//hotbar rect
		graphics.setColor(new Color(0f,0f,0f,.9f));
		graphics.fillRect(xPosition, yPosition, hotbarWidht, hotbarHeight);
		
		//scroll element rect
		graphics.setColor(new Color(1f,1f,1f,.2f));
		graphics.fillRect(xPosition + (slot * hotbarScrollElement), yPosition, hotbarScrollElement, hotbarScrollElement);
	}
	
	public void scrollUp() {
		if(slot > (hotbarWidht/hotbarScrollElement) - 2) {
			slot = 0;
		} else slot = slot + 1;
	}
	
	public void scrollDown() {
		if(slot < 1) {
			slot = (hotbarWidht/hotbarScrollElement) - 1;
		} else slot = slot - 1;
	}

	
	
	
	
	public int getHotbarWidht() {
		return hotbarWidht;
	}

	public void setHotbarWidht(int hotbarWidht) {
		this.hotbarWidht = hotbarWidht;
	}

	public int getHotbarHeight() {
		return hotbarHeight;
	}

	public void setHotbarHeight(int hotbarHeight) {
		this.hotbarHeight = hotbarHeight;
	}

	public int getHotbarScrollElement() {
		return hotbarScrollElement;
	}

	public void setHotbarScrollElement(int hotbarScrollElement) {
		this.hotbarScrollElement = hotbarScrollElement;
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


}
