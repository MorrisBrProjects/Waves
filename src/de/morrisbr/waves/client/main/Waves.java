package de.morrisbr.waves.client.main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import de.morrisbr.waves.client.gui.GuiScreen;
import de.morrisbr.waves.client.gui.ingame.HUD;
import de.morrisbr.waves.client.gui.screen.GuiStartAdvert;
import de.morrisbr.waves.client.input.Mouse;
import de.morrisbr.waves.client.settings.MusicOption;
import de.morrisbr.waves.client.settings.Option;
import de.morrisbr.waves.entity.entitys.EntityPlayer;
import de.morrisbr.waves.utils.AssetsLoader.Type;
import de.morrisbr.waves.utils.aplication.Application;
import de.morrisbr.waves.utils.drawutil.Drawer;

public class Waves extends Application {
	//am tag materialen Sammeln, und in der Nacht Kommen Zombies, zerst?ren dein geb?ude, wenn du ?berlebst bekommst du punkte zum upgrade.
	//kannst auch geisterst?de finden, leute retten und die als Helfer/freunde bekommen, es gibt auch leute die nur an sich denken, und dir nicht helfen oder hintergehen!
	//gewonnnen hat man wen ?ber die helfe der menscheit nicht mehr infiziert ist!

	private static Waves waves;
	
	public EntityPlayer player;

	private Option options;
	
	public HUD hud;

	public int displayWidth;
	public int displayHeight;
	
	public int displayWidthDiffirenz;
	public int displayHeightDiffirenz;

	private GameConfiguration gameconfiguration;
	
	private int debugFPS;

	private boolean running = false;

	public GuiScreen currentScreen;
	public GuiScreen gui;


	@Override
	public void onApplicationInit() {
		super.onApplicationInit();

		this.options = new Option();
		this.setSettings();

		this.hud = new HUD();

		waves = this;
	}


	@Override
	public void onRender(Graphics2D graphics) {
		super.onRender(graphics);

		if(graphics == null) return;

		if (currentScreen != null) {
			currentScreen.drawScreen(Mouse.getxPosition(), Mouse.getyPosition(), graphics);
		}

		if (gui != null) {
			gui.drawScreen(Mouse.getxPosition(), Mouse.getyPosition(), graphics);
		}
		
	}
	

	@Override
	public void onStart() {
		super.onStart();

		this.displayGuiScreen(new GuiStartAdvert(), true);
	}

	private void setSettings() {
		MusicOption musicOption = new MusicOption("music", true);
		Option.addOption("music", musicOption);
	}
	
	
	/**
	 * 
	 * THis is the first called Methode in this Game by Start
	 * 
	 * @param gameconfiguration
	 */
	public void run(GameConfiguration gameconfiguration) {

		this.gameconfiguration = gameconfiguration;

		this.displayWidth = gameconfiguration.displayInfo.width;
		this.displayHeight = gameconfiguration.displayInfo.height;

		this.createDisplay();
		setFrame(Display.getDisplay());

		start();
	}


	@Override
	public void onUpdate(float delta) {

		displayHeight = Display.getDisplay().getHeight();
		displayWidth = Display.getDisplay().getWidth() - 14;

		if (currentScreen != null) {
			currentScreen.updateScreen(getDelta());
		}

		if (gui != null) {
			gui.updateScreen(getDelta());
		}

	}

	
	private void createDisplay() {
        Display.setResizable(true);
        Display.setTitle("Waves");
        Display.setHeight(displayHeight);
        Display.setWidth(displayWidth);
        Display.create();
	}
	
	public void displayGuiScreen(GuiScreen guiScreen, boolean closeCurrentScreen) {
        if (this.currentScreen != null && closeCurrentScreen)
        {
            this.currentScreen.onGuiClosed();
        }
        this.gui = null;
        this.currentScreen = guiScreen;
        this.currentScreen.onOpenGui();
	}
	
	public void displayGui(GuiScreen gui, boolean closeCurrentGui) {
        if (this.gui != null && closeCurrentGui)
        {
            this.gui.onGuiClosed();
        }
        this.gui = gui;
        this.gui.onOpenGui();
	}
	
	
	public boolean isInGui() {
		return this.gui != null;
	}

	public static Waves getWaves() {
		return waves;
	}

	public int getDebugFPS() {
		return debugFPS;
	}

	public Option getOptions() {
		return options;
	}
	
}
