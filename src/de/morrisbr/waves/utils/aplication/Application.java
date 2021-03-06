package de.morrisbr.waves.utils.aplication;

import de.morrisbr.waves.client.main.Display;
import de.morrisbr.waves.utils.AssetsLoader;
import de.morrisbr.waves.utils.drawutil.Drawer;

import javax.swing.*;
import java.awt.*;

public class Application {

    private boolean running = false;
    private final double UPDATE_CAP = 1.0 / 60.0;
    private int debugFPS;
    private Drawer drawer;
    private JFrame frame;
    private AssetsLoader assetsLoader;

    public Application() {
        this.onApplicationInit();
    }

    public void start() {
        this.onStart();
        this.running = true;
		this.drawer = new Drawer(frame) {

			private static final long serialVersionUID = 1L;

			@Override
			public void render(Graphics2D g2d) {
				onRender(g2d);
				repaint();
			}
			
			@Override
			public void update() {
				onUpdate(60);
			}
		};
        System.out.println("Waves: Game has Started...");
        startGameLoop();
    }

    public void stop() {
        this.onStop();
        System.out.println("[INFO]: Game is shutting down ... !");
        frame.dispose();
        System.exit(0);
    }

    public void onGameLoopInit(){}
    public void onApplicationInit(){
        this.assetsLoader = new AssetsLoader();
    }
    public void onStart(){}
    public void onStop(){}

    public void onUpdate(float updateCap) {}
    public void onRender(Graphics2D graphics) {}
    


	private void startGameLoop() {
		new Thread(() ->{
			long lastTime = System.nanoTime();
			while(running) {
			  long nowTime = System.nanoTime();
			  double delta = (double) (nowTime - lastTime) / 1000000d;
			  
			  this.tick();

			  lastTime = nowTime;
			}
		}).start();

        //System.out.println(displayHeightDiffirenz);
	}
	
	
	public void tick() {
	}
    
    
    /**
     * 
     * get the Drawer
     * 
     * @return Drawer
     **/
    
    public Drawer getDrawer() {
        return drawer;
    }
    
    
    /**
     * 
     * get delta
     * 
     * @return UPDATE_CAP
     */

    public double getDelta() {
        return UPDATE_CAP;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public AssetsLoader getAssetsLoader() {
        return assetsLoader;
    }


}
