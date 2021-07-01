package de.morrisbr.waves.client.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import de.morrisbr.waves.client.main.Waves;

public class KeyBoardAndMouseInput implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

	private Waves waves = Waves.getWaves();
	
	//keyboard listener
	@Override
	public void keyPressed(KeyEvent event) {
		Waves.getWaves().player.updateMovement(event, false);
	}

	@Override
	public void keyReleased(KeyEvent event) {

		if(Waves.getWaves().isInGui()) {
			if(waves.gui != null) {
				waves.gui.keyTyped(event);
//				System.out.println(event);
			}
		} else {
			if(waves.currentScreen != null) {
				waves.currentScreen.keyTyped(event);
//				System.out.println(event);
			}
		}
		
		Waves.getWaves().player.updateMovement(event, true);
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
	}

	
	
	
	//input listener
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(Waves.getWaves().isInGui()) {
			if(waves.gui != null) {
				waves.gui.mouseClicked(e.getX() - 7, e.getY()  - 27, e.getButton());
			}
		} else {
			if(waves.currentScreen != null) {
				waves.currentScreen.mouseClicked(e.getX() - 7, e.getY()  - 27, e.getButton());
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Mouse.setPressed(true);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Mouse.setPressed(false);
		
		if(Waves.getWaves().isInGui()) {
			if(waves.gui != null) {
				waves.gui.mouseReleased(e.getX() - 7, e.getY() - 27, e.getID());
				//System.out.println(e.getID());
			}
		} else {
			if(waves.currentScreen != null) {
				waves.currentScreen.mouseReleased(e.getX() - 7, e.getY()  - 27, e.getButton());
			}
		}
		
	}
	
	
	
	
	//move listener

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Mouse.setxPosition(e.getX() - 7);
		Mouse.setyPosition(e.getY() - 27);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent event) {
		if(Waves.getWaves().isInGui()) {
			if(waves.gui != null) {
				waves.gui.mouseWeelScroll(event);
				System.out.println(event.getID());
			}
		} else {
			if(waves.currentScreen != null) {
				waves.currentScreen.mouseWeelScroll(event);
			}
		}
	}


}
