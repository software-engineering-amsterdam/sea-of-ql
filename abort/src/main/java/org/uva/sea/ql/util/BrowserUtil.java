package org.uva.sea.ql.util;

import java.awt.Desktop;
import java.io.IOException;
import java.net.*;


/**
 * Browser Utility class to open the browser.
 * 
 * @author J. Dijkstra
 */
public final class BrowserUtil {
	/**
	 * No instance can be made from the outside
	 */
	private BrowserUtil() { }
	
	/**
	 * Open the default browser with a specific URL.
	 * 
	 * @param URL URL to open
	 * @throws BrowserException
	 */
	public static void openURL(final String url) throws BrowserException {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(new URI(url));
			}
			catch (IOException e) {
				throw new BrowserException(e);
			}
			catch (URISyntaxException e) {
				throw new BrowserException(e);
			}
		}
	}
}