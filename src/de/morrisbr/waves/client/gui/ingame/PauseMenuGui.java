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

public class PauseMenuGui extends GuiScreen {
	
	private final GuiScreen lastScreen;
	
	private GuiButton mainmenu;
	private GuiButton options;
	
	public PauseMenuGui(GuiScreen lastScreen) {
		this.lastScreen = lastScreen;
		this.mainmenu = new GuiButton(0, (Waves.getWaves().displayWidth/2) - 180/2, 100, 380, 75, "Hauptmenü");
		this.options = new GuiButton(1, (Waves.getWaves().displayWidth/2) - 180/2, (100*2) + 20, 380, 75, "Options");
		
		this.buttonList.add(mainmenu);
		this.buttonList.add(options);
		
		Waves.getWaves().player.setIngame(false);
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, Graphics2D graphics) {
		super.drawScreen(mouseX, mouseY, graphics);

		//Graphics2D grafic = Waves.getWaves().graphics;
		
		graphics.setColor(new Color(0f,0f,0f,.9f));
		graphics.setFont(new Font("", Font.BOLD, 180));
		graphics.fillRect(50, 50, width - 120, height - 140);
		
		this.mainmenu.draw(mouseX, mouseY, graphics);
		this.options.draw(mouseX, mouseY, graphics);
		
		graphics.setColor(Color.GRAY);
		graphics.drawString("Pause", (Waves.getWaves().displayWidth/2) - 300, 220);
		
	}
	
	
	@Override
	public void updateScreen(double delta) {
		super.updateScreen(delta);
	}
	
	
	@Override
	public void keyTyped(KeyEvent keyEvent) {
		super.keyTyped(keyEvent);
		
		int keyCode = keyEvent.getKeyCode();
		
		if(keyCode == KeyEvent.VK_ESCAPE) {
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
	
	// UIPanel:
	// ArrayList<GUIElement>
	
	// OnDraw -> foreach all guielements and update position
	
	
	@Override
	public void updateButtonPosition() {
		super.updateButtonPosition();
		
		mainmenu.setxPosition((Waves.getWaves().displayWidth/2) - mainmenu.getButtonWidth()/2);
		mainmenu.setyPosition((Waves.getWaves().displayHeight/2) - mainmenu.getButtonHeight()/2);
		
		options.setxPosition((Waves.getWaves().displayWidth/2) - options.getButtonWidth()/2);
		options.setyPosition((Waves.getWaves().displayHeight/2) - options.getButtonHeight()/2 + 20 + 75);
	}

}
