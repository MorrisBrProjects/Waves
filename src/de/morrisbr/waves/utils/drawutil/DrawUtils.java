package de.morrisbr.waves.utils.drawutil;

import java.awt.Graphics2D;


public class DrawUtils {
	

	public Drawer getDrawFromObject(Object object) {
		return DrawerStorage.getObjectDrawers().get(object);
	}

	public Drawer getDrawFromName(String name) {
		return DrawerStorage.getNamedDrawers().get(name);
	}

	public void setDrawerObject(Object object, Drawer drawer) {
		DrawerStorage.getObjectDrawers().put(object, drawer);
	}

	public void setDrawerName(String name, Drawer drawer) {
		DrawerStorage.getNamedDrawers().put(name, drawer);
	}

	public Object getClassDrawFromObject(Object object) {
		return DrawerStorage.getObjectDrawersClass().get(object);
	}

	public Object getClassDrawFromName(String name) {
		return DrawerStorage.getNamedDrawersClass().get(name);
	}

	public void setClassDrawerObject(Object object, Graphics2D g2d) {
		DrawerStorage.getObjectDrawersClass().put(object, g2d);
	}

	public void setClassDrawerName(String name, Object object) {
		DrawerStorage.getNamedDrawersClass().put(name, object);
	}
	
	public Drawer getDrawer() {
		return new Drawer();
	}


}




