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
	
	// Property names that are stored in the properties file
	private static final String SERVER_PORT_PROPERTY = "server.port";
	private static final String SERVER_BASE_URL_PROPERTY = "server.base.url";
	private static final String FORMS_SAVE_PATH_PROPERTY = "forms.save.target.dir";
	private static final String TEMPLATE_PATH_PROPERTY = "template.deploy.dir";
	private static final String WEB_PATH_PROPERTY = "web.deploy.dir";
	
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
		return properties.getProperty(WEB_PATH_PROPERTY);
	}

	/**
	 * Retrieve the templates path.
	 * @return templates path
	 */
	public String getTemplatesPath() {
		return properties.getProperty(TEMPLATE_PATH_PROPERTY);
	}
	
	/**
	 * Retrieve the path to save forms at.
	 * @return save path
	 */
	public String getSaveFormPath() {
		return properties.getProperty(FORMS_SAVE_PATH_PROPERTY);
	}
	
	/**
	 * Retrieve the server base URL.
	 * @return base URL
	 */
	public String getServerBaseURL() {
		return String.format("%s:%d/", properties.getProperty(SERVER_BASE_URL_PROPERTY), getServerPort());
	}
	
	/**
	 * Retrieve the server port.
	 * @return server port
	 */
	public int getServerPort() {
		return Integer.parseInt(properties.getProperty(SERVER_PORT_PROPERTY));
	}
}
