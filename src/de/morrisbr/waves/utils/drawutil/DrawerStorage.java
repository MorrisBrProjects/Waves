package de.morrisbr.waves.utils.drawutil;

import java.util.HashMap;

public class DrawerStorage {
	
	private static HashMap<String, Drawer> namedDrawers = new HashMap<String, Drawer>();
	private static HashMap<Object, Drawer> objectDrawers = new HashMap<Object, Drawer>();

	private static HashMap<String, Object> namedDrawersClass = new HashMap<String, Object>();
	private static HashMap<Object, Object> objectDrawersClass = new HashMap<Object, Object>();

	public static HashMap<String, Drawer> getNamedDrawers() {
		return namedDrawers;
	}

	public static HashMap<Object, Drawer> getObjectDrawers() {
		return objectDrawers;
	}

	public static HashMap<String, Object> getNamedDrawersClass() {
		return namedDrawersClass;
	}

	public static HashMap<Object, Object> getObjectDrawersClass() {
		return objectDrawersClass;
	}

}
