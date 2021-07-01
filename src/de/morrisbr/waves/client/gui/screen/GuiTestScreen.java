package de.morrisbr.waves.client.gui.screen;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import de.morrisbr.waves.client.gui.GuiScreen;
import de.morrisbr.waves.client.main.Waves;

public class GuiTestScreen extends GuiScreen {
	
	private final GuiScreen lastScreen;
	
	public GuiTestScreen(GuiScreen lastScreen) {
		this.lastScreen = lastScreen;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, Graphics2D graphics) {
		super.drawScreen(mouseX, mouseY, graphics);
		
		 this.fillRect(graphics, 0, 0, width, height, Color.BLACK);
		    graphics.setColor(Color.ORANGE);
			graphics.setFont(new Font("", Font.BOLD, 180));
			graphics.drawString("SKYENTON.DE", (this.width/2) - 660, this.height/2);
		 
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
			Waves.getWaves().displayGuiScreen(lastScreen, true);
		}
		
		
	}

}
