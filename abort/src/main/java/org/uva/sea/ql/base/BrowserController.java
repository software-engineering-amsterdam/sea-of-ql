package org.uva.sea.ql.base;

import java.awt.Desktop;
import java.io.IOException;
import java.net.*;

public class BrowserController {
	public void openURL(final String URL) throws BrowserException {
		if(Desktop.isDesktopSupported())
		{
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