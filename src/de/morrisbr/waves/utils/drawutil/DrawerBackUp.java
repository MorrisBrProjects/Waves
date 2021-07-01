package de.morrisbr.waves.utils.drawutil;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class DrawerBackUp extends JPanel {

	private JFrame frame;
	private Graphics2D graphics;
	private Boolean paused;

	public DrawerBackUp(JFrame frame) {
		this.frame = frame;
		this.frame.add(this);
	}

	public DrawerBackUp() {}

	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g2d = (Graphics2D) graphics.create();

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.fillRect(0, 0, 0, 0);

		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, frame.getWidth(), frame.getHeight());

		this.graphics = g2d;
		
		g2d.dispose();
		repaint();
	}

	public void render(Graphics2D g2d) 
	{
		//System.out.println("renders");
	}
	public void update(float delta) 
	{
		
	}
	
	
	public Graphics2D getGraphics() {
		return graphics;
	}
	
	public void setGraphics(Graphics2D graphics) {
		this.graphics = graphics;
	}
	
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Boolean isPaused() {
		return paused;
	}

	public void setPaused(Boolean paused) {
		this.paused = paused;
	}


	
}
