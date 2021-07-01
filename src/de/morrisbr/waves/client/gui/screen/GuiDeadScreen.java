package de.morrisbr.waves.client.gui.screen;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import de.morrisbr.waves.client.gui.GuiScreen;
import de.morrisbr.waves.client.main.Waves;

public class GuiDeadScreen extends GuiScreen {
	
	//private final GuiScreen lastScreen;
	
	public GuiDeadScreen(GuiScreen lastScreen) {
		//this.lastScreen = lastScreen;
		Waves.getWaves().player.setIngame(false);
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, Graphics2D graphics) {
		super.drawScreen(mouseX, mouseY, graphics);
		
		//Graphics2D grafic = Waves.getWaves().graphics;
		
		graphics.setColor(new Color(0f,0f,0f,.9f));
		graphics.setFont(new Font("", Font.BOLD, 180));
		graphics.fillRect(50, 50, width - 120, height - 140);
		
		graphics.setColor(Color.RED);
		graphics.drawString("Dead", (Waves.getWaves().displayWidth/2) - 300, 220);
		 
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent keyEvent) {
		super.keyTyped(keyEvent);
		
		int keyCode = keyEvent.getKeyCode();
		
		
		if(keyCode == KeyEvent.VK_ESCAPE) {
			Waves.getWaves().displayGuiScreen(new GuiMainMenuScreen(), true);
		}
		
		
	}
	
	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
		Waves.getWaves().player.setIngame(true);
	}

}
