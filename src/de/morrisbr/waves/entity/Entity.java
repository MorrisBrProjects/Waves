package de.morrisbr.waves.entity;

import de.morrisbr.waves.gameobjects.GameObject;

public class Entity extends GameObject {
	
	private int speed;
	private int heal;
	private EntityType entityType;

	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getHeal() {
		return heal;
	}

	public void setHeal(int heal) {
		this.heal = heal;
	}
	
	
	public EntityType getEntityType() {
		return entityType;
	}

	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}


	public static enum EntityType {
		PLAYER, ZOMBIE;
	}
	

}

