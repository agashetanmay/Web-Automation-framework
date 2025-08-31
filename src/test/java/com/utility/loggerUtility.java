package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class loggerUtility {

//	private static Logger logger;    //we are following singleton design pattern, so to create an object at 
	                                      //once we are making this varible as static
	
	private loggerUtility() {    //making private beacuse no one should able to create objectof class
		
	}
	
	public static Logger getLogger(Class<?> clazz) {
		Logger logger = null; 
		if(logger == null) {
		logger = LogManager.getLogger(clazz);
		}
		 return logger;
	}
}
