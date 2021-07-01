package de.morrisbr.waves.client.gui.ingame;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;

import de.morrisbr.waves.client.audio.AudioPlayer;
import de.morrisbr.waves.client.gui.GuiScreen;
import de.morrisbr.waves.client.main.Waves;
import de.morrisbr.waves.world.World;

public class InGameGui extends GuiScreen {
	
	@SuppressWarnings("unused")
	private final GuiScreen lastScreen;
	private AudioPlayer audioPlayer;
	private World world;

	
	public InGameGui(GuiScreen lastScreen) {
		this.lastScreen = lastScreen;
		this.audioPlayer = Waves.getWaves().getAssetsLoader().getAssetByName("ingameMusic").getAudioPlayer();
		this.world = Waves.getWaves().player.getLocation().getWorld(); //player.getWorld();
		
		world.onLoad();
	}
	
	
	@Override
	public void onOpenGui() {
		super.onOpenGui();
		
		Waves.getWaves().player.setIngame(true);
		audioPlayer.loop();
	}
	
	
	@Override
	public void drawScreen(int mouseX, int mouseY, Graphics2D graphics) {
		super.drawScreen(mouseX, mouseY, graphics);
		
		world.draw(graphics);
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent keyEvent) {
		super.keyTyped(keyEvent);
		
		int keyCode = keyEvent.getKeyCode();
		
		
		if(keyCode == KeyEvent.VK_ESCAPE) 
		{
			this.audioPlayer.stop();
			Waves.getWaves().displayGui(new PauseMenuGui(this), false);
		}
		
		if(keyEvent.getKeyCode() == KeyEvent.VK_E) 
		{
			Waves.getWaves().displayGui(new InventoryGui(this), false);
		}
		
		if(keyEvent.getKeyCode() == KeyEvent.VK_T) 
		{
			Waves.getWaves().displayGui(new CheatGui(this), false);
		}
		
		
	}
	
	@Override
	public void mouseWeelScroll(MouseWheelEvent event) {
		super.mouseWeelScroll(event);
		Waves.getWaves().player.mouseWeelScroll(event);
	}
	
	
	@Override
	public void updateScreen(double delta) {
		super.updateScreen(delta);
		
//		if(Waves.getWaves().player.isIngame() && Option.getOptionByName("music").isAktive()) {
//		}
		
		world.update(delta);
	}
	
	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
		
		world.onUnload();
		
		this.audioPlayer.stop();
		
		Waves.getWaves().player.setIngame(false);
		Waves.getWaves().player.setHeal(100);
		
		this.audioPlayer.rewind();
		this.audioPlayer.stop();
	}

}
