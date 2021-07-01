package de.morrisbr.waves.client.gui.ingame;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import de.morrisbr.waves.client.gui.GuiScreen;
import de.morrisbr.waves.client.main.Waves;

public class TestChatGui extends GuiScreen {
	
	private final GuiScreen lastScreen;
	
	private ArrayList<String> text = new ArrayList<String>();
	
	public TestChatGui(GuiScreen lastScreen) {
		this.lastScreen = lastScreen;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, Graphics2D graphics) {
		super.drawScreen(mouseX, mouseY, graphics);

		graphics.setColor(Color.ORANGE);
		graphics.setFont(new Font("", Font.BOLD, 180));
		graphics.drawString(text.toString().replace("[", "").replace("]", "").replaceAll(", ", ""), (this.width / 2) - 660, this.height / 2);
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent keyEvent) {
		super.keyTyped(keyEvent);
		
		int keyCode = keyEvent.getKeyCode();
		
		if(keyCode == KeyEvent.VK_T) {
			Waves.getWaves().displayGui(null, true);
			System.out.println("fdg");
		}
		
		if(keyCode == KeyEvent.VK_ESCAPE) {
			Waves.getWaves().displayGuiScreen(lastScreen, false);
		}
		
		if(keyCode == KeyEvent.VK_BACK_SPACE) {
			this.text.remove(text.size()-1);
		} else {
			this.text.add(KeyEvent.getKeyText(keyCode));
		}
		
		System.out.println(text);
		
		
		
	}

}
