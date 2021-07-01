package de.morrisbr.waves.client.input;

public class Mouse {
	
	private static int xPosition, yPosition;
	private static boolean pressed;

	public static int getxPosition() {
		return xPosition;
	}

	public static void setxPosition(int xPosition) {
		Mouse.xPosition = xPosition;
	}

	public static int getyPosition() {
		return yPosition;
	}

	public static void setyPosition(int yPosition) {
		Mouse.yPosition = yPosition;
	}

	public static boolean isPressed() {
		return pressed;
	}

	public static void setPressed(boolean pressed) {
		Mouse.pressed = pressed;
	}

}
