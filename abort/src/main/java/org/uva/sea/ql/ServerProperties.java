package org.uva.sea.ql;

import java.io.*;
import java.util.Properties;

/**
 * Properties as used for server configuration (also used by ANT build).
 * 
 * @author J. Dijkstra
 */
public class ServerProperties {
	/**
	 * Properties file name.
	 */
	public static final String PROPERTIES_FILE_NAME = "codegenerator.properties";
	
	/**
	 * Properties instance.
	 */
	private final Properties properties = new Properties();

	/**
	 * Read the properties file.
	 * @throws IOException
	 */
	public void readProperties() throws IOException {
		properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
	}
	
	/**
	 * Retrieve the web path.
	 * @return web path
	 */
	public String getWebPath() {
		return properties.getProperty("web.deploy.dir");
	}

	/**
	 * Retrieve the templates path.
	 * @return templates path
	 */
	public String getTemplatesPath() {
		return properties.getProperty("template.deploy.dir");
	}
	
	/**
	 * Retrieve the path to save forms at.
	 * @return save path
	 */
	public String getSaveFormPath() {
		return properties.getProperty("forms.save.target.dir");
	}
	
	/**
	 * Retrieve the server base URL.
	 * @return base URL
	 */
	public String getServerBaseURL() {
		return String.format("%s:%d/", properties.getProperty("server.base.url"), getServerPort());
	}
	
	/**
	 * Retrieve the server port.
	 * @return server port
	 */
	public int getServerPort() {
		return Integer.parseInt(properties.getProperty("server.port"));
	}
}
