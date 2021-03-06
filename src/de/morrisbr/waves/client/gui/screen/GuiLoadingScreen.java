package de.morrisbr.waves.client.gui.screen;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import de.morrisbr.waves.client.gui.GuiScreen;
import de.morrisbr.waves.client.main.Display;
import de.morrisbr.waves.client.main.Waves;
import de.morrisbr.waves.entity.entitys.EntityPlayer;
import de.morrisbr.waves.gameobjects.Location;
import de.morrisbr.waves.utils.AssetsLoader;
import de.morrisbr.waves.utils.AssetsLoader.Type;
import de.morrisbr.waves.world.worlds.TestWorld;

public class GuiLoadingScreen extends GuiScreen {
	
	//private boolean loadAssets = false;
	
	private AssetsLoader assetsLoader;
	
	public GuiLoadingScreen() {
		this.assetsLoader = Waves.getWaves().getAssetsLoader();
	}
	
	@Override
	public void onOpenGui() {
		super.onOpenGui();
		
		new Thread(() ->{
			addAssets();
		}).start();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, Graphics2D graphics) {
		super.drawScreen(mouseX, mouseY, graphics);

		this.fillRect(graphics, 0, 0, width, height, Color.BLACK);
		
		this.addLoadingAssets(graphics);
		
		graphics.setColor(Color.ORANGE);
		graphics.setFont(new Font("", Font.BOLD, 90));
		graphics.drawString("LOADING ...", (this.width / 2) - 250, this.height / 2);

		if (!(assetsLoader.getCurrentFileName() == null)) {
			graphics.drawString(assetsLoader.getCurrentFileName() + "", (this.width / 2) - 250, this.height / 2 + 200);
		} 
		
//		else {
//			graphics.drawString(assetsLoader.getCurrentFileName(), (this.width / 2) - 250, this.height / 2 + 200);
//			graphics.clearRect(0, 0, this.width, this.height);
//		}
	}
	
	
	//TODO: adddassets ist langsamer als das zeichen, deshalb kommt null oben, assets muss ferttig sein, dann erst zeichen! will aber direkt was sehen, das es l�d, bein hinzuf�gen h�ngt es aber!
	private void addAssets() {
		//new Thread(() ->{
		
			System.out.println("");
		
			assetsLoader.addAsset("/images/gui/MainMenu/MainScreenBackground.PNG", "mainBackground", Type.IMAGE);
			assetsLoader.addAsset("/Music/gui/MainMenu/MainScreenMusic.mp3", "mainMusic", Type.AUDIO);
			assetsLoader.addAsset("/Music/gui/InGame/InGameMusicNeutral.mp3", "ingameMusic", Type.AUDIO);
			assetsLoader.addAsset("/Sounds/gui/button/ButtonClick.mp3", "buttonClick", Type.AUDIO);
			assetsLoader.addAsset("/images/gui/InGame/InGameScreenBackground.jpg", "inGameBackground", Type.IMAGE);
			assetsLoader.addAsset("/images/entity/player/Player.jpg", "player", Type.IMAGE);
			assetsLoader.addAsset("/images/gui/cursors/cursor.png", "cursor", Type.IMAGE);
			
			System.out.println("_____________________________");
			System.out.println("Assets add sucess!");
			
			//TODO: muss machen das das image nicht in gameobject geladen wird, sondern sp�ter mit loadAssets!
			loadAssets();
		//}).start();
		
	}
	
	@SuppressWarnings("deprecation")
	private void loadAssets() {
		
		new Thread(() ->{
			assetsLoader.loadAssets();
			Waves.getWaves().player = new EntityPlayer(new Location(0, (this.height - 100) - 40), 80, 100, 20, 100);
			Waves.getWaves().player.setWorld(new TestWorld());
			
			Waves.getWaves().displayGuiScreen(new GuiMainMenuScreen(), true);
		}).start();
	}
	
	
	@Override
	public void keyTyped(KeyEvent keyEvent) {
		super.keyTyped(keyEvent);
		
		//int keyCode = keyEvent.getKeyCode();

	}
	
	private void addLoadingAssets(Graphics2D graphics)
	{

	}
	
	@Override
	public void onGuiClosed() {
		Image icon = assetsLoader.getAssetByName("cursor").getImage();
		
		
		Display.getDisplay().getRootPane()
		.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				icon,
				new Point(8,0),"customCursor"));
	}

}
