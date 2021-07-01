package de.morrisbr.waves.client.gui.screen;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import de.morrisbr.waves.client.gui.GuiScreen;
import de.morrisbr.waves.client.main.Waves;

public class GuiStartAdvert extends GuiScreen {
	
	
	
	@Override
	public void onOpenGui() {
		super.onOpenGui();
		
		new Thread(() ->{
			try {
				Thread.sleep(1000*5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Waves.getWaves().displayGuiScreen(new GuiLoadingScreen(), true);
		}).start();
	}
	
	
	@Override
	public void drawScreen(int mouseX, int mouseY, Graphics2D graphics) {
		super.drawScreen(mouseX, mouseY, graphics);
		
		 this.fillRect(graphics, 0, 0, width, height, Color.BLACK);
		 	graphics.setColor(Color.ORANGE);
		 	graphics.setFont(new Font("", Font.BOLD, 90));
		 	graphics.drawString("Brandt Studios", (this.width/2) - 330, this.height/2 - 120);
		 	graphics.setColor(Color.LIGHT_GRAY);
		 	graphics.setFont(new Font("", Font.BOLD, 60));
		 	graphics.drawString("Das erste Spiel", (this.width/2) - 230, this.height/2);
	}
	
	
	@Override
	public void keyTyped(KeyEvent keyEvent) {
		super.keyTyped(keyEvent);
		
		//int keyCode = keyEvent.getKeyCode();
		
	}

}
