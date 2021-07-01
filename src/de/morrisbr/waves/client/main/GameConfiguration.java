package de.morrisbr.waves.client.main;

public class GameConfiguration {
	
	 public final GameConfiguration.DisplayInformation displayInfo;
	
	  public GameConfiguration(GameConfiguration.DisplayInformation displayInfo) {
		  this.displayInfo = displayInfo;
	  }
	
	
	  public static class DisplayInformation
	    {
	        public final int width;
	        public final int height;
	        public final boolean fullscreen;

	        public DisplayInformation(int widthIn, int heightIn, boolean fullscreenIn)
	        {
	            this.width = widthIn;
	            this.height = heightIn;
	            this.fullscreen = fullscreenIn;
	        }
	    }
	  
	  

}
