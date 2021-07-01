package de.morrisbr.waves.client.gui.elements;

import java.awt.Graphics2D;

import de.morrisbr.waves.client.audio.AudioPlayer;
import de.morrisbr.waves.client.gui.Gui;
import de.morrisbr.waves.client.main.Waves;

public class GuiLoadingBalken extends Gui {

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

	@SuppressWarnings("unused")
	private AudioPlayer buttonClickPlayer;

	public GuiLoadingBalken(int buttonId, int x, int y, String buttonText) {
		this(buttonId, x, y, 200, 20, buttonText);
	}

	public GuiLoadingBalken(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
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

	}

	public void updateButton() {

	}

}
