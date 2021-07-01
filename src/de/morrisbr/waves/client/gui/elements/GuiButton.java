package de.morrisbr.waves.client.gui.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import de.morrisbr.waves.client.audio.AudioPlayer;
import de.morrisbr.waves.client.gui.Gui;
import de.morrisbr.waves.client.main.Waves;
import de.morrisbr.waves.utils.Size;

public class GuiButton extends Gui {
	
	
    /** Button width in pixels */
    protected int width;

    /** Button height in pixels */
    protected int height;

    /** The x position of this control. */
    public int xPosition;

    /** The y position of this control. */
    public int yPosition;

    /** The string displayed on this control. */
    public String displayString;
    public int id;

    /** True if this control is enabled, false to disable. */
    public boolean enabled;

    /** Hides the button completely if false. */
    public boolean visible;
    protected boolean hovered;
    
	private AudioPlayer buttonClickPlayer;
    
    
    public GuiButton(int buttonId, int x, int y, String buttonText)
    {
        this(buttonId, x, y, 200, 20, buttonText);
    }
    
    public GuiButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText)
    {
        this.width = 200;
        this.height = 20;
        this.enabled = true;
        this.visible = true;
        this.id = buttonId;
        this.xPosition = x;
        this.yPosition = y;
        this.width = widthIn;
        this.height = heightIn;
        this.displayString = buttonText;
        
        this.buttonClickPlayer = Waves.getWaves().getAssetsLoader().getAssetByName("buttonClick").getAudioPlayer();
    }
	

		 public String getDisplayString() {
		return displayString;
	}

	public void setDisplayString(String displayString) {
		this.displayString = displayString;
	}

		public void draw(int mouseX, int mouseY, Graphics2D graphics) {
			 updateButton();

			    this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			    this.mouseDragged(mouseX, mouseY);
			    Size dimension = GetFontDimension(graphics, displayString);
			    
			 	@SuppressWarnings("unused")
				int j = 14737632;
			 	
	            if (!this.enabled)
	            {
	                j = 10526880;
	            }
	            else if (this.hovered)
	            {
	                j = 16777120;
	                
	               graphics.setColor(Color.YELLOW);
		           graphics.fillRoundRect(xPosition, yPosition, width, height, 90, 90);
		           drawString(graphics, displayString, new Font("", Font.BOLD, 18), 
	            			  xPosition + width/2 - dimension.width/2, yPosition + height/2 + dimension.heigth/3 , Color.BLACK);
	            }
	            
	            if (!this.hovered) {
	            	  graphics.setColor(new Color(0f, 0f, 0f, 0.9f));
	            	  graphics.fillRoundRect(xPosition, yPosition, width, height, 90, 90);
	            	  
	            	 
	   
	            	  
	            	  drawString(graphics, displayString, new Font("", Font.BOLD, 18), 
	            			  xPosition + width/2 - dimension.width/2, yPosition + height/2 + dimension.heigth/3 , Color.WHITE);
	            }
	            
		 }
		 
		 public void updateButton() {

		 }
		 
		 
	 
	 
	    /**
	     * Returns true if the mouse has been pressed on this control. Equivalent of MouseListener.mousePressed(MouseEvent
	     * e).
	     */
	    public boolean mousePressed(int mouseX, int mouseY)
	    {
	    	if(this.enabled && this.visible && mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height) {
	    		
		    	buttonClickPlayer.play();
	    		
	    		return true;
	    	} else return false;

	    }
	    
	    public boolean isMouseOver()
	    {
	        return this.hovered;
	    }
	    
	    /**
	     * Returns 0 if the button is disabled, 1 if the mouse is NOT hovering over this button and 2 if it IS hovering over
	     * this button.
	     */
	    public int getHoverState(boolean mouseOver)
	    {
	        int i = 1;

	        if (!this.enabled)
	        {
	            i = 0;
	        }
	        else if (mouseOver)
	        {
	            i = 2;
	        }

	        return i;
	    }
	    
	    public int getButtonWidth()
	    {
	        return this.width;
	    }

	    public void setWidth(int width)
	    {
	        this.width = width;
	    }
	    
	    public int getButtonHeight()
	    {
	        return this.height;
	    }

	    public int getxPosition() {
			return xPosition;
		}

		public void setxPosition(int xPosition) {
			this.xPosition = xPosition;
		}

		public int getyPosition() {
			return yPosition;
		}

		public void setyPosition(int yPosition) {
			this.yPosition = yPosition;
		}

		public void setHeight(int height)
	    {
	        this.height = height;
	    }
	    
	    /**
	     * Fired when the mouse button is dragged. Equivalent of MouseListener.mouseDragged(MouseEvent e).
	     */
	    public void mouseDragged(int mouseX, int mouseY)
	    {
	    }
	    
	    /**
	     * Fired when the mouse button is released. Equivalent of MouseListener.mouseReleased(MouseEvent e).
	     */
	    public void mouseReleased(int mouseX, int mouseY)
	    {
	    }
	
}
