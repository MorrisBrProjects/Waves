package de.morrisbr.waves.client.main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import de.morrisbr.waves.client.input.KeyBoardAndMouseInput;

public class Display {
	
	private static JFrame display = new JFrame();
	
	private static Boolean resizable;
	private static String title;
	
	private static int height;
	private static int width;
	
	
	
	public static Boolean isResizable() {
		return resizable;
	}
	public static void setResizable(Boolean resizable) {
		Display.resizable = resizable;
	}
	public static String getTitle() {
		return title;
	}
	public static void setTitle(String title) {
		Display.title = title;
	}
	public static int getWidth() {
		return width;
	}
	public static void setWidth(int width) {
		Display.width = width;
	}
	public static int getHeight() {
		return height;
	}
	public static void setHeight(int height) {
		Display.height = height;
	}
	public static JFrame getDisplay() {
		return display;
	}
	
	public static void create() {
		display.setTitle(title);
		display.setSize(width -14, height);
		display.setResizable(resizable);
		display.setVisible(true);
		display.setLocationRelativeTo(null);
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//display.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		display.requestFocus();		
		
		display.addWindowListener(new WindowAdapter()
	      {
	          @Override
	          public void windowClosing(WindowEvent e)
	          {
	              Waves.getWaves().stop();
	          }
	      });
		
		display.addKeyListener(new KeyBoardAndMouseInput());
		display.addMouseMotionListener(new KeyBoardAndMouseInput());
		display.addMouseListener(new KeyBoardAndMouseInput());
		display.addMouseWheelListener(new KeyBoardAndMouseInput());

		
	}
	
	

}
