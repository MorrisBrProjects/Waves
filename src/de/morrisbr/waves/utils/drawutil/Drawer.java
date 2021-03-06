package de.morrisbr.waves.utils.drawutil;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Drawer extends JPanel {
	
	private JFrame frame;
	private Graphics2D grapic;
	private Boolean paused;

	public Drawer(JFrame frame) {
		this.frame = frame;
		this.frame.add(this);
	}

	public Drawer() {}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, frame.getWidth(), frame.getHeight());

		this.grapic = g2d;

		this.update();
		this.render(grapic);
		g2d.dispose();
		//repaint();
	}

	public void render(Graphics2D g2d) {}
	public void update() {}
	
	
	public Graphics2D getGrapic() {
		return (Graphics2D) grapic.create();
	}
	
	public void setGrapic(Graphics2D grapic) {
		this.grapic = grapic;
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
