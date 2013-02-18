package org.uva.sea.ql;

import java.io.*;
import java.util.Properties;

public class ServerProperties {
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
	
	public String getSaveFormPath() {
		return properties.getProperty("forms.save.target.dir");
	}
	
	public String getServerBaseURL() {
		return String.format("%s:%d/", properties.getProperty("server.base.url"), getServerPort());
	}
	
	public int getServerPort() {
		return Integer.parseInt(properties.getProperty("server.port"));
	}
}
