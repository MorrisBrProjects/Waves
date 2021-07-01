package de.morrisbr.waves.client.gui.elements;

public class GuiMainButton extends GuiButton {

    public GuiMainButton(int buttonId, int x, int y, String buttonText)
    {
        this(buttonId, x, y, 200, 20, buttonText);
    }
    
    public GuiMainButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText)
    {
    	super(buttonId, x, y, widthIn, heightIn, buttonText);
    	
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
    }
    

}
