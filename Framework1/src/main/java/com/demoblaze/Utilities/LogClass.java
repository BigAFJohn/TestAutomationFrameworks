package com.demoblaze.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogClass {
	
	// Initialize logs
	public static final Logger logger = LoggerFactory.getLogger(LogClass.class);

    
    public static void startTestCase(String sTestCaseName){		  
		 logger.info("====================================="+sTestCaseName+" TEST START=========================================");
		 }
    
    public static void endTestCase(String sTestCaseName){
		logger.info("====================================="+sTestCaseName+" TEST END=========================================");
		 }
    public static void info(String message) {

		logger.info(message);

		}

    public static void warn(String message) {

	    logger.warn(message);

		}

	 public static void error(String message) {

	    logger.error(message);

		}

	

	 public static void debug(String message) {

	    logger.debug(message);

		}
}
