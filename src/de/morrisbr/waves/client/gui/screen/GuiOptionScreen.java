package de.morrisbr.waves.client.gui.screen;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import de.morrisbr.waves.client.gui.GuiScreen;
import de.morrisbr.waves.client.gui.elements.GuiButton;
import de.morrisbr.waves.client.main.Waves;
import de.morrisbr.waves.client.settings.Option;

public class GuiOptionScreen extends GuiScreen {
	
	private final GuiScreen lastScreen;
	private GuiButton muteMusic;
	
	public GuiOptionScreen(GuiScreen lastScreen) {
		this.lastScreen = lastScreen;
		
		this.muteMusic = new GuiButton(0, (Waves.getWaves().displayWidth/2) - 180/2, 100, 380, 75, "Toggle Music Off");
		this.buttonList.add(muteMusic);
	}
	
	
	@Override
	public void updateScreen(double delta) {
		super.updateScreen(delta);
		
		muteMusic.setxPosition((Waves.getWaves().displayWidth/2) - muteMusic.getButtonWidth()/2);
		muteMusic.setyPosition((Waves.getWaves().displayHeight/2) - muteMusic.getButtonHeight()/2);
		
		if(!Option.getOptionByName("music").isAktive())
		{
			muteMusic.setDisplayString("Toggle Music On");
		} else muteMusic.setDisplayString("Toggle Music Off");
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, Graphics2D graphics) {
		super.drawScreen(mouseX, mouseY, graphics);
		
		//Graphics2D grafic = Waves.getWaves().graphics;
		
		graphics.setColor(new Color(0f,0f,0f,.9f));
		graphics.setFont(new Font("", Font.BOLD, 180));
		graphics.fillRect(50, 50, width - 120, height - 140);
		
		graphics.setColor(Color.GRAY);
		graphics.drawString("Option", (Waves.getWaves().displayWidth/2) - 300, 220);
		
		muteMusic.draw(mouseX, mouseY, graphics);
		 
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent keyEvent) {
		super.keyTyped(keyEvent);
		
		int keyCode = keyEvent.getKeyCode();
		
		
		if(keyCode == KeyEvent.VK_T) {
			Waves.getWaves().displayGuiScreen(new GuiMainMenuScreen(), true);
			System.out.println("fdg");
		}
		
		if(keyCode == KeyEvent.VK_ESCAPE) {
			Waves.getWaves().displayGui(lastScreen, false);
		}
		
		
	}
	
	@Override
	public void actionPerformed(GuiButton button) {
		super.actionPerformed(button);
		
		if(button.id == 0) {
			Option.getOptionByName("music").setAktive(!Option.getOptionByName("music").isAktive());
			//Waves.getWaves().getOptions().setOption("music", musicOption);
		}
	}
	
	@Override
	public void updateButtonPosition() {
		super.updateButtonPosition();
		
		muteMusic.setxPosition((Waves.getWaves().displayWidth/2) - muteMusic.getButtonWidth()/2);
		muteMusic.setyPosition((Waves.getWaves().displayHeight/2) - muteMusic.getButtonHeight()/2);
	}

}
