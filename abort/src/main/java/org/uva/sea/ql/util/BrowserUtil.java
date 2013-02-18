package org.uva.sea.ql.util;

import java.awt.Desktop;
import java.io.IOException;
import java.net.*;

import org.uva.sea.ql.base.BrowserException;

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
	public static void openURL(final String URL) throws BrowserException {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(new URI(URL));
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