package de.morrisbr.waves.client.gui.screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import de.morrisbr.waves.client.audio.AudioPlayer;
import de.morrisbr.waves.client.gui.GuiScreen;
import de.morrisbr.waves.client.gui.elements.GuiButton;
import de.morrisbr.waves.client.gui.ingame.CheatGui;
import de.morrisbr.waves.client.gui.ingame.InGameGui;
import de.morrisbr.waves.client.main.Waves;
import de.morrisbr.waves.client.settings.Option;

public class GuiMainMenuScreen extends GuiScreen {
	
	private GuiButton start;
	private AudioPlayer audioPlayer;
	private Image image;
	
	
	public GuiMainMenuScreen() {
		this.audioPlayer = Waves.getWaves().getAssetsLoader().getAssetByName("mainMusic").getAudioPlayer();
		image = Waves.getWaves().getAssetsLoader().getAssetByName("mainBackground").getImage();
		
		this.start = new GuiButton(0, (Waves.getWaves().displayWidth/2) - 380/2, (Waves.getWaves().displayHeight/2) - 75/2, 380, 75, "Einzelspieler");
		this.buttonList.add(start);
		
		this.audioPlayer.loop();
	}
	
	
	@Override
	public void onOpenGui() {
		super.onOpenGui();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, Graphics2D graphics) {
		super.drawScreen(mouseX, mouseY, graphics);
		
		
		drawTexture(graphics, image, 0, 0, width, height, Color.WHITE, null);
		//drawTexture(Waves.getWaves().graphics, new ResourceLocation("Waves/background.png").getImageResource(), 0, 0, width, height, Color.WHITE, null);
		
		
		fillRect(graphics, 40, 34, width - 100, height - 105, new Color(0f,0f,0f,0.8f));
		drawArrow(graphics, mouseX - 15, mouseY - 15, Color.WHITE);
		
		
		drawString(graphics, "Waves 1.0", new Font("", Font.BOLD, 100), (width/2) - 250, 150, Color.WHITE);
		
		start.draw(mouseX, mouseY, graphics);
		 
	}
	
	@Override
	public void keyTyped(KeyEvent keyEvent) {
		super.keyTyped(keyEvent);
		
		int keyCode = keyEvent.getKeyCode();
		
		if(keyCode == KeyEvent.VK_T) {
			Waves.getWaves().displayGuiScreen(new CheatGui(this), true);
		}
		
		if(keyCode == KeyEvent.VK_ESCAPE) {
			this.audioPlayer.stop();
			Waves.getWaves().stop();
		}
		
		if(keyCode == KeyEvent.VK_SPACE) {
			Waves.getWaves().displayGui(new InGameGui(this), true);
		}
	}
	
	@Override
	public void actionPerformed(GuiButton button) {
		super.actionPerformed(button);
		if(button.id == 0) {
			Waves.getWaves().displayGuiScreen(new InGameGui(this), true);
		}
	}

	
	@Override
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	
	@Override
	public void updateScreen(double delta) {
		super.updateScreen(delta);
		
		if(!Option.getOptionByName("music").isAktive()) {
			this.audioPlayer.stop();
			return;
		}
	}
	
	
	@Override
	public void updateButtonPosition() {
		super.updateButtonPosition();
		
		GuiButton start = getButton(this.start.id);
		
		start.setxPosition((Waves.getWaves().displayWidth/2) - start.getButtonWidth()/2);
		start.setyPosition((Waves.getWaves().displayHeight/2) - start.getButtonHeight()/2);
	}
	
	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
		this.audioPlayer.rewind();
		this.audioPlayer.stop();
	}
	
}
