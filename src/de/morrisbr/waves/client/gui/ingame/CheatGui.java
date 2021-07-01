package de.morrisbr.waves.client.gui.ingame;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import de.morrisbr.waves.client.gui.GuiScreen;
import de.morrisbr.waves.client.main.Waves;

public class CheatGui extends GuiScreen {
	
	private final GuiScreen lastScreen;
	
	private ArrayList<String> text = new ArrayList<String>();
	
	private String message = "";
	
	public CheatGui(GuiScreen lastScreen) {
		this.lastScreen = lastScreen;
		Waves.getWaves().player.setIngame(false);
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, Graphics2D graphics) {
		super.drawScreen(mouseX, mouseY, graphics);

		graphics.setColor(new Color(0f, 0f, 0f, .9f));
		graphics.setFont(new Font("", Font.BOLD, 18));
		
		graphics.fillRect((this.width / 2) - 200, (this.height / 2) - 25, 400, 50);
		graphics.setColor(Color.WHITE);
		graphics.drawRect((this.width / 2) - 200, (this.height / 2) - 25, 400, 50);
		graphics.setColor(Color.GRAY);
		graphics.drawString(message, (this.width / 2) - 190, (this.height / 2) + 7);
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent keyEvent) {
		super.keyTyped(keyEvent);
		
		int keyCode = keyEvent.getKeyCode();
		
		
		if(keyCode == KeyEvent.VK_ESCAPE) {
			Waves.getWaves().displayGuiScreen(lastScreen, false);
		}
		
		if(keyCode == KeyEvent.VK_BACK_SPACE) {
			
			if(text.isEmpty()) return;
			
			this.text.remove(text.size()-1);
			message = text.toString().replace("[", "").replace("]", "").replaceAll(", ", "");
		} else {
			if(text.size() >= 27) return;
			this.text.add(KeyEvent.getKeyText(keyCode));
			message = text.toString().replace("[", "").replace("]", "").replaceAll(", ", "");
		}
		
		System.out.println(text);
		
		if(keyCode == KeyEvent.VK_ENTER)
		{
			this.text.remove(text.size()-1);
			message = text.toString().replace("[", "").replace("]", "").replaceAll(", ", "");
			
			if(message.equalsIgnoreCase("kill")) 
			{
				Waves.getWaves().player.kill();
			} 
		}
		
		
		
	}
	
	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
		Waves.getWaves().player.setIngame(true);
	}


}
