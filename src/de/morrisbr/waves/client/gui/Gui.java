package de.morrisbr.waves.client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

import de.morrisbr.waves.client.main.Waves;
import de.morrisbr.waves.utils.Size;



public class Gui {
	
	//private Waves waves = Waves.getWaves();
	
	public void drawRect(Graphics2D g2d, int xPosition, int yPosition, int width, int height, Color color) {
		
		Graphics2D graphics = (Graphics2D) g2d.create();
		
		graphics.setColor(color);
		graphics.drawRect(xPosition, yPosition, width, height);
	}
	
	public void fillRect(Graphics2D g2d, int xPosition, int yPosition, int width, int height, Color color) {
		
		Graphics2D graphics = (Graphics2D) g2d.create();
		
		graphics.setColor(color);
		graphics.fillRect(xPosition, yPosition, width, height);
	}
	
	public void drawString(Graphics2D g2d, String text, Font font, int xPosition, int yPosition, Color color) {
		
		Graphics2D graphics = (Graphics2D) g2d.create();
		
		graphics.setColor(color);
		graphics.setFont(font);
		graphics.drawString(text, xPosition, yPosition);
	}
	
	public Size GetFontDimension(Graphics2D graphics, String text) {
	
		 FontMetrics metrics = graphics.getFontMetrics(new Font("", Font.BOLD, 18));
		
		 int heigth = metrics.getHeight();
		
		 int width = metrics.stringWidth(text);
	
		 return new Size(width, heigth);
	 }
	
	public void drawArrow(Graphics2D g2d, int xPosition, int yPosition, Color color) {
		
		Graphics2D graphics = (Graphics2D) g2d.create();
		
		graphics.setColor(color);
		graphics.drawLine(10, 10, xPosition, yPosition);
		
	    double angle = Math.atan2(yPosition - 10, xPosition - 10);
	    AffineTransform tx = graphics.getTransform();
	    tx.translate(xPosition, yPosition);
	    tx.rotate(angle - Math.PI / 2d);
	    graphics.setTransform(tx);

	    Polygon arrowHead = new Polygon();
	    arrowHead.addPoint(0, 5);
	    arrowHead.addPoint(-5, -5);
	    arrowHead.addPoint(5, -5);
	    graphics.fill(arrowHead);
	    graphics.setTransform(tx);
	}
	
	public void drawTexture(Graphics2D g2d, Image img, int xPosition, int yPosition, int width, int height, Color color, ImageObserver observer) {
		Graphics2D graphics = (Graphics2D) g2d.create();
		graphics.drawImage(img, xPosition, yPosition, width, height, color, observer);
	}
	
	public int xCenter(int xPosition, int widht) {
		return (Waves.getWaves().displayWidth/2) - (widht/2);
	}
	
	public int yCenter(int yPosition, int height) {
		return (Waves.getWaves().displayHeight/2) - (height/2);
	}

}
