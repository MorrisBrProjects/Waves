package de.morrisbr.waves.client.settings;

import java.util.HashMap;

public class Option {

	private static HashMap<String, Option> options;
	
	private boolean aktive;
	private String name;



	public Option() {
		options = new HashMap<String, Option>();
	}
	
	

	public boolean isAktive() {
		return aktive;
	}

	public void setAktive(boolean aktive) {
		this.aktive = aktive;
	}


	public static HashMap<String, Option> getOptions() {
		return options;
	}
	
	public void setOptions(HashMap<String, Option> options) {
		Option.options = options;
	}
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	
	
//////////////////////////////////[MUSS IN EIN OptionHandler!]///////////////////////////////////////
	public static void addOption(String name, Option option) {                                     //
		if(Option.getOptions().containsKey(name)) Option.getOptions().remove(name);                //
		Option.getOptions().put(name, option);                                                     //
	}                                                                                              //
                                                                                                   //
	public static void setOption(String name, Option option) {                                     //
		if(Option.getOptions().containsKey(name)) {                                                // 
			Option.getOptions().remove(name);                                                      //
		} else {                                                                                   //
			System.out.println("Option: " + name + " nicht gefunden!");                            //
			return;                                                                                //
		}                                                                                          //
		Option.getOptions().put(name, option);                                                     //
	}                                                                                              //
                                                                                                   //
	public static Option getOptionByName(String name) {                                            //
		if(getOptions().containsKey(name)) {                                                       //
			return getOptions().get(name);                                                         //
		}                                                                                          //
		return null;                                                                               //
	}                                                                                              //
                                                                                                   //
//////////////////////////////////[MUSS IN EIN OptionHandler!]///////////////////////////////////////
	
}
