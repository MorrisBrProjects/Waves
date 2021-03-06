package de.morrisbr.waves.world.worlds;

import java.awt.Graphics2D;
import java.awt.Image;

import de.morrisbr.waves.client.main.Waves;
import de.morrisbr.waves.entity.entitys.EntityPlayer;
import de.morrisbr.waves.gameobjects.GameObject;
import de.morrisbr.waves.gameobjects.Location;
import de.morrisbr.waves.gameobjects.objects.House;
import de.morrisbr.waves.world.World;

public class TestWorld extends World {
	
	private Image background;
	private EntityPlayer player;
	

	
	public TestWorld() {
		
		this.setName("TestWorld");
		
		background =  Waves.getWaves().getAssetsLoader().getAssetByName("inGameBackground").getImage();
		
		player = Waves.getWaves().player;
		player.setLocation(new Location(0, (Waves.getWaves().displayHeight - player.getHeight()) - player.getHeight()/2, this));
	}
	
	@Override
	public void update(double delta) {
		super.update(delta);
		//player.update(delta);
	}
	
	@Override
	public void draw(Graphics2D graphics) {
		super.draw(graphics);
		
		graphics.drawImage(background, 0, 0, Waves.getWaves().displayWidth, Waves.getWaves().displayHeight, null, null);
		
		drawObjects(graphics);
		//player.draw(graphics);
		Waves.getWaves().hud.draw(graphics);
	}
	
	
	
	@Override
	public void onLoad() {
		super.onLoad();
		
		House house = new House(new Location(400, 400, this), 300, 600);
		House house2 = new House(new Location(740, 400, this), 300, 600);
		
		house.setCollisionEnabled(true);
		house2.setCollisionEnabled(true);
		
		getGameObjects().add(house);
		getGameObjects().add(player);
		getGameObjects().add(house2);
		
	}
	
	@Override
	public void onUnload() {
		super.onUnload();
	}
	
	@Override
	public void onCollision(GameObject perpetrator, GameObject victim) {
		super.onCollision(perpetrator, victim);
		
		System.out.println(victim + " hat das " + perpetrator + " angerannt!");
		
		deleteGameObject(victim);
	}

}
