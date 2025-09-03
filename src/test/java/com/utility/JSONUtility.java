package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Environment;
import com.ui.pojo.config;

public class JSONUtility {

	public static Environment readJSON(Env env) {
		
		Gson gson = new Gson();
		File JsonFile = new File(
			    System.getProperty("user.dir") 
			    + File.separator + "config"                 //this file.seperator help in both CI tool and local execution
			    + File.separator + "config.json"
			);
		FileReader filereader = null;
		try {
			filereader = new FileReader(JsonFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		config config = gson.fromJson(filereader, config.class);
		Environment environment = config.getEnvironments().get(env.name());
		 return environment;	
	}
}
