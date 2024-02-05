package com.company.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * get the env env details based on the env defined in config.properties
 */
public class ReadEnvDetails implements ILogger {
    private final Logger LOG = LogManager.getLogger(ILogger.class);
    Properties p = new Properties();
    Properties getEnv = new Properties();

    public Properties getEnvDetails() throws IOException {
        InputStream stream = new FileInputStream(new File(System.getProperty("user.dir")
                + "/src/main/resources/config.properties"));
        p.load(stream);
        InputStream envDetails = null;
        String EnvName = p.get("EnvName").toString();
        switch (EnvName) {
            case "production":
                envDetails = new FileInputStream(new File(System.getProperty("user.dir")
                        + "/src/main/resources/EnvUrls/prod_url.properties"));
                getEnv.load(envDetails);
                break;
            case "uat":
                envDetails = new FileInputStream(new File(System.getProperty("user.dir")
                        + "/src/main/resources/EnvUrls/uat_url.properties"));
                getEnv.load(envDetails);
            default:
                LOG.error("No env is present in config");
                break;
        }
        return getEnv;
    }

}
