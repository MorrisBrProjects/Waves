package de.morrisbr.waves.client.main;

public class Main {
	
	private static GameConfiguration gameconfiguration;
	
	private static int height;
	private static int width;

	public static void main(String[] args) {
		
		height = 600;
		width = 900;
		
		gameconfiguration = new GameConfiguration(new GameConfiguration.DisplayInformation(width, height, false));
		
		new Waves().run(gameconfiguration);

	}

}
