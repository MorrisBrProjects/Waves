package de.morrisbr.waves.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceLocation 
{
	
	private String domain;
	
	public ResourceLocation(String domain) {
		this.domain = domain;
	}
	
	
	public BufferedImage getImageResource() {
		try {
			return ImageIO.read(new File("strawberry.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getPfad() {
		return domain;
	}
	
	

}

