package com.company.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ReadIdentifier implements ILogger {
    Properties p = new Properties();

    /**
     * read all the xpaths defined for a project
     *
     * @return
     * @throws IOException
     */
    public Properties getXPathRepository() throws IOException {
        InputStream stream = new FileInputStream(new File(System.getProperty("user.dir")
                + "/src/main/resources/Xpaths/object.properties"));
        p.load(stream);
        return p;
    }

    public Properties getXPathRepository(String path) throws IOException {
        InputStream stream = new FileInputStream(new File(System.getProperty("user.dir") + path));
        p.load(stream);
        return p;
    }
}
