package de.morrisbr.waves.client.gui;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;

import de.morrisbr.waves.client.gui.elements.GuiButton;
import de.morrisbr.waves.client.main.Waves;

public class GuiScreen extends Gui {
	
	public int height;
	public int width;
	
	public List<GuiButton> buttonList = new ArrayList<GuiButton>();
	private GuiButton selectedButton;
	
    
    
	public void drawScreen(int mouseX, int mouseY, Graphics2D graphics) {
        for (int i = 0; i < this.buttonList.size(); ++i)
        {
            ((GuiButton)this.buttonList.get(i)).draw(mouseX, mouseY, graphics);
        }

	}
	

	public void keyTyped(KeyEvent keyEvent) {}
	
    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen(double delta) {
    	height = Waves.getWaves().displayHeight;
    	width = Waves.getWaves().displayWidth;
    	updateButtonPosition();
    }
    
    
    /**
     * Called when the mouse is clicked. Args : mouseX, mouseY, clickedButton
     */
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) 
    {
    	
    	//System.out.println("d" + mouseButton);
        if (mouseButton == 1) // default 0
        {
            for (int i = 0; i < this.buttonList.size(); ++i)
            {
                GuiButton guibutton = this.buttonList.get(i);

                if (guibutton.mousePressed(mouseX, mouseY))
                {
                	
                    this.selectedButton = guibutton;
                    
                    //guibutton.playPressSound(this.mc.getSoundHandler());
                    
                    if(guibutton.enabled) {
                    	//System.out.println("fg");
                    	this.actionPerformed(guibutton);
                    }
                }
            }
        }
    }

    /**
     * Called when a mouse button is released.
     */
    public void mouseReleased(int mouseX, int mouseY, int state)
    {
        if (this.selectedButton != null && state == 0)
        {
            this.selectedButton.mouseReleased(mouseX, mouseY);
            this.selectedButton = null;
        }
    }
    
    /**
     * Called when a mouse Weel is scroll.
     * @param event 
     */
    public void mouseWeelScroll(MouseWheelEvent event) {}
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
    public void actionPerformed(GuiButton button)
    {
     //   audioPlayer.play();
    }
    
    
    public GuiButton getButton(int id) {
    	for (GuiButton guiButton : buttonList) {
			if(guiButton.id == id) {
				return guiButton;
			}
		}
		return null;
    }
    
    
    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    public void onGuiClosed() {}

	public void onOpenGui() {
		updateButtonPosition();
	}
	
	public void updateButtonPosition() {}
}
