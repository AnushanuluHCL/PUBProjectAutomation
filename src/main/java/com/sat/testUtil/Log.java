package com.sat.testUtil;

import org.apache.log4j.Logger;

public class Log {

    private static final Logger Log = Logger.getLogger(com.sat.testUtil.Log.class.getName());

    public static void startLog(String featureName) {
        Log.info("---------------------------------------------------------------");
        Log.info("          Feature Execution Started For " + featureName);
        Log.info("---------------------------------------------------------------");
    }

    public static void endLog(String featureName) {
        Log.info("---------------------------------------------------------------");
        Log.info("          Feature Execution Started For " + featureName);
        Log.info("---------------------------------------------------------------");
    }

    public static void info(String message) {
        Log.info(message);
    }

    public static void warn(String message) {
        Log.warn(message);
    }

    public static void error(String message) {
        Log.error(message);
    }

    public static void fatal(String message) {
        Log.fatal(message);
    }

    public static void debug(String message) {
        Log.debug(message);
    }
}
