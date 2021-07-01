package de.morrisbr.waves.client.gui.ingame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import de.morrisbr.waves.client.main.Waves;

public class HUD {
	
	public void draw(Graphics2D graphics) {
		//Graphics2D grafics = Waves.getWaves().graphics;
		
		graphics.setColor(new Color(1f, 1f, 1f, .5f));
		
		graphics.fillRect(Waves.getWaves().displayWidth - Waves.getWaves().displayWidth/1, 0, Waves.getWaves().displayWidth, 80);
		
		graphics.fillRect(0, 0, 200, 80);
		
		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font("", Font.BOLD, 20));
		graphics.drawString("Gesundheit: " + Waves.getWaves().player.getHeal() + "%", 10, 45);
		
		//graphics.setColor(new Color(1f, 1f, 1f, .5f));
		graphics.setColor(Color.BLACK);
		//graphics.drawString("Musik from: (trap nation music: Unicorn Zombie Apocalypse (Mix Edit))", Waves.getWaves().displayWidth - 700, 45);
		graphics.drawString("FPS: " + Waves.getWaves().getDebugFPS() + "RAM: " + Runtime.getRuntime().totalMemory()/1000000 + "MB/" + Runtime.getRuntime().maxMemory()/1000000 + "MB        CPU: COMING SOON!", Waves.getWaves().displayWidth - 700, 45);
	}
	
}
