package de.morrisbr.waves.utils;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import de.morrisbr.waves.client.audio.AudioPlayer;
import de.morrisbr.waves.client.main.Waves;

public class AssetsLoader {
	
	private ArrayList<AssetsObject> assets;
	private int prozess = 0;
	private int filesToLoadCount = 0;
	private int filesHasLoadedCount = 0;
	private String currentFileName;
	
	public AssetsLoader() {
		this.assets = new ArrayList<AssetsObject>();
	}

	
	
	public ArrayList<AssetsObject> getAssets() {
		return assets;
	}

	public AssetsObject getAssetByName(String name) {
		for (AssetsObject assetsObject : assets) {
			if(assetsObject.getName().equals(name)) {
				return assetsObject;
			}
		}
		return null;
	}
	
	public String getFileNameFromPath(String filePath) {
		String[] tmp = filePath.split("/");
		
		return tmp[tmp.length-1];
	}
	
	public void addAsset(String filePath, String name, Type assetsType) {

		AssetsObject objectAudio = new AssetsObject(name, filePath, assetsType);
		//objectAudio.fileName = getFileNameFromPath(filePath);
		getAssets().add(objectAudio);
		
		System.out.println("Add Asset: " + "" + objectAudio.getName() + " | Path: " + objectAudio.getFileName() + " | Type: " + objectAudio.type);

	}
	
	
	public void loadAssets() {
		
		System.out.println("");
		
		for (AssetsObject assetsObject : assets) {
			currentFileName = assetsObject.getName();
			assetsObject.load();
			System.out.println("Load Asset: " + "" + assetsObject.getName() + " | Path: " + assetsObject.getFileName() + " | Type: " + assetsObject.type);
		}
		
		System.out.println("_____________________________");
		System.out.println("Assets loading completed!");
		
		
	}
	
	public void removeImage(String name) {
		getAssets().remove(getAssetByName(name));
	}
	
	
	


	public int getProzess() {
		return prozess;
	}



	public void setProzess(int prozess) {
		this.prozess = prozess;
	}
	
	public int getFilesToLoadCount() {
		return filesToLoadCount;
	}



	public void setFilesToLoadCount(int filesToLoadCount) {
		this.filesToLoadCount = filesToLoadCount;
	}

	public int getFilesHasLoadedCount() {
		return filesHasLoadedCount;
	}



	public void setFilesHasLoadedCount(int filesHasLoadedCount) {
		this.filesHasLoadedCount = filesHasLoadedCount;
	}

	public String getCurrentFileName() {
		if(currentFileName == null) {
			return "";
		}
		return currentFileName;
	}



	public void setCurrentFileName(String currentFileName) {
		this.currentFileName = currentFileName;
	}

	public static enum Type {
		IMAGE, AUDIO;
	}
	
	
	public class AssetsObject {
		private String name;
		private String fileName;
		private int id;
		private Image image;
		private AudioPlayer audioPlayer;
		private Type type;
		
		public AssetsObject() {}
		
		public void load() {
			try {
				switch (type) {
				case AUDIO:
					this.audioPlayer = new AudioPlayer(fileName, 1.0F);
					break;
				case IMAGE:
					this.image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(fileName));
					break;
				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("______CRASH______");
				System.out.println("");
				System.out.println("Crash: Das Spiel musste beendet werden.");
				System.out.println("Grund: F?r den Asset namens: " + name + " konnte keine Datei gefunden werden!");
				System.out.println("");
				System.out.println("Name: " + name);
				System.out.println("Path: " + fileName);
				System.out.println("");
				System.out.println("");
				System.out.println("______CRASH______");
				
				Waves.getWaves().stop();
			}
		}
		
		public AssetsObject(String name, String filename, Type type) {
			this.name = name;
			this.fileName = filename;
			this.type = type;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Image getImage() {
			return image;
		}
		public void setImage(Image image) {
			this.image = image;
		}

		public AudioPlayer getAudioPlayer() {
			return audioPlayer;
		}

		public void setAudioPlayer(AudioPlayer audioPlayer) {
			this.audioPlayer = audioPlayer;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

}


}



