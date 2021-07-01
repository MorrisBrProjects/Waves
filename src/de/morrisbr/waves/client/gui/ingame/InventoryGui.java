package de.morrisbr.waves.client.gui.ingame;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import de.morrisbr.waves.client.gui.GuiScreen;
import de.morrisbr.waves.client.gui.elements.GuiButton;
import de.morrisbr.waves.client.gui.screen.GuiMainMenuScreen;
import de.morrisbr.waves.client.gui.screen.GuiOptionScreen;
import de.morrisbr.waves.client.main.Waves;

public class InventoryGui extends GuiScreen {
	
	private final GuiScreen lastScreen;
	
	public InventoryGui(GuiScreen lastScreen) {
		this.lastScreen = lastScreen;
		
		Waves.getWaves().player.setIngame(false);
	}
	
	public void drawScreen(int mouseX, int mouseY, Graphics2D graphics) {
		super.drawScreen(mouseX, mouseY, graphics);

		//Graphics2D grafic = Waves.getWaves().graphics;
		
		graphics.setColor(new Color(0.1f,0.8f,0.1f,.4f));
		graphics.setFont(new Font("", Font.BOLD, 180));
		graphics.fillRect((width/2) - (width/2/2) - 8, (height/2) - (height/2/2) - 17, (width/2), (height/2));
		graphics.setColor(Color.WHITE);
		graphics.drawRect((width/2) - (width/2/2) - 8, (height/2) - (height/2/2) - 17, (width/2), (height/2));
		
	}
	
	
	@Override
	public void updateScreen(double delta) {
		super.updateScreen(delta);
	}
	
	
	@Override
	public void keyTyped(KeyEvent keyEvent) {
		super.keyTyped(keyEvent);
		
		int keyCode = keyEvent.getKeyCode();
		
		if(keyCode == KeyEvent.VK_ESCAPE || keyCode == KeyEvent.VK_E) {
			Waves.getWaves().displayGuiScreen(lastScreen, false);
		}
		
	}
	
	@Override
	public void actionPerformed(GuiButton button) {
		super.actionPerformed(button);
		
		if(button.id == 0) {
			Waves.getWaves().displayGuiScreen(new GuiMainMenuScreen(), true);
		}
		
		if(button.id == 1) {
			Waves.getWaves().displayGui(new GuiOptionScreen(this), false);
		}
	}
	
	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
		Waves.getWaves().player.setIngame(true);
	}
	

}
