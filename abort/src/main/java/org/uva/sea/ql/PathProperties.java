package org.uva.sea.ql;

import java.io.*;
import java.util.Properties;

public class PathProperties {
	public static final String PROPERTIES_FILE_NAME = "codegenerator.properties";
	private final Properties properties = new Properties();

	public void readProperties() throws IOException {
		properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
	}
	
	public String getWebPath() {
		return properties.getProperty("web.deploy.dir");
	}
	
	public String getTemplatesPath() {
		return properties.getProperty("template.deploy.dir");
	}
}
