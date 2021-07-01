package de.morrisbr.waves.entity.entitys;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;

import de.morrisbr.waves.client.gui.screen.GuiDeadScreen;
import de.morrisbr.waves.client.main.Display;
import de.morrisbr.waves.client.main.Waves;
import de.morrisbr.waves.entity.Entity;
import de.morrisbr.waves.gameobjects.GameObject;
import de.morrisbr.waves.gameobjects.Location;
import de.morrisbr.waves.inventory.Hotbar;

public class EntityPlayer extends Entity {
	
	private boolean move, ingame;
	public Movement movement;
	private Image player;
	private Hotbar hotbar;
	
	public EntityPlayer() {
		player = Waves.getWaves().getAssetsLoader().getAssetByName("player").getImage();
		this.hotbar = new Hotbar(0, 0, 350, 50, 50, 0);
	}
	
	public EntityPlayer(Location location, int widht, int height, int speed, int heal) {
		this.setLocation(location);
		this.setWidht(widht);
		this.setHeight(height);
		this.setSpeed(speed);
		this.setHeal(heal);
		
		//50 = 1 Slot
		this.hotbar = new Hotbar(0, 0, 350, 50, 50, 0);
		
		player = Waves.getWaves().getAssetsLoader().getAssetByName("player").getImage();
	}


	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}

	public boolean isIngame() {
		return ingame;
	}

	public void setIngame(boolean ingame) {
		this.ingame = ingame;
	}
	
	public void openInventory() {
		//display gui
	}
	
	public void updateMovement(KeyEvent event, boolean stopMoving) {
		if(Waves.getWaves().player.isIngame()) {
			
			if(stopMoving)
			{
				stopMoving();
			} else 
			{
				switch (event.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					walkLeft();
					break;
				case KeyEvent.VK_RIGHT:
					walkRight();
					break;
				case KeyEvent.VK_A:
					walkLeft();
					break;
				case KeyEvent.VK_D:
					walkRight();
					break;
	
				default:
					break;
				}
			}
		}
	}
	
	
	public void walkLeft() {
		this.movement = Movement.LEFT;
		
		//if(!isColision()) 
		//{
			getLocation().setxPosition((int) (getLocation().getxPosition() - (this.getSpeed())));
			isColision();
		//}
	}
	
	public void walkRight() {
		this.movement = Movement.RIGHT;
		
			getLocation().setxPosition(getLocation().getxPosition() + this.getSpeed());
			
			isColision();
	}
	
	public void stopMoving() {
		this.movement = Movement.IDLE;
	}
	
	
	public boolean isColision() {
		
		
		if((getLocation().getxPosition() + getWidht()) >= Waves.getWaves().displayWidth) 
		{
			damage(10);
			getLocation().setxPosition((Waves.getWaves().displayWidth - getWidht()));
			System.out.println(Display.getDisplay().getWidth());
			System.out.println("fdfgfg " + (Waves.getWaves().displayWidth - getWidht()));
			return true;
		} 
		else if(getLocation().getxPosition() < 0) 
		{
			damage(10);
			getLocation().setxPosition(0);
			return true;
		}
		return false;
	}
	
	public void damage(int damage) {
		this.setHeal(getHeal() - damage);
		
		if(getHeal() <= 0) {
			Waves.getWaves().displayGui(new GuiDeadScreen(null), false);
		}
	}
	
	public void kill() {
		this.setHeal(0);

		Waves.getWaves().displayGui(new GuiDeadScreen(null), false);
	}
	
	
	@Override
	public void draw(Graphics2D graphics) {
		super.draw(graphics);
		
		//Graphics2D graphics = (Graphics2D) Waves.getWaves().graphics.create();
		
		graphics.setColor(Color.BLACK);
		graphics.drawImage(player, getLocation().getxPosition(), getLocation().getyPosition(), this.getWidht(), this.getHeight(), Color.BLACK, null);
		//graphics.fillRect(this.getxPosition(), this.getyPosition(), this.getWidht(), this.getHeight());
		//graphics.fillRect(xPosition - Waves.getWaves().displayWidthDiffirenz, yPosition -  Waves.getWaves().displayHeightDiffirenz, widht, height);
		//System.out.println(Waves.getWaves().displayHeightDiffirenz);
		
		hotbar.draw(graphics);
	}
	
	@Override
	public void update(double delta) {
		hotbar.setxPosition((Waves.getWaves().displayWidth/2) - (hotbar.getHotbarWidht()/2));
		hotbar.setyPosition(Waves.getWaves().displayHeight - hotbar.getHotbarHeight() - 60);
		
		getLocation().setyPosition((Waves.getWaves().displayHeight - Waves.getWaves().player.getHeight()) - Waves.getWaves().player.getHeight()/2);
	}
	
	public void mouseWeelScroll(MouseWheelEvent event) {
		if(event.getWheelRotation() < 0) hotbar.scrollDown();
		if(event.getWheelRotation() > 0) hotbar.scrollUp();
	}


	public Hotbar getHotbar() {
		return hotbar;
	}


	public enum Movement {
		UP, DOWN, LEFT, RIGHT, IDLE
	}
	
	@Override
	public void onCollision(GameObject other) {
		super.onCollision(other);
		
		//other.getLocation().getWorld().deleteGameObject(other);
	}


}
