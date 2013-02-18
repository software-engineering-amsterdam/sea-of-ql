package org.uva.sea.ql.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.base.*;

public class TestBrowserController extends TestBase {
	private final BrowserController controller = new BrowserController();
	
	@Test
	public void testOpenBrowserInvalidURL() {
		
		boolean exceptionThrown = false;
		try {
			controller.openURL("invalidURL");
		}
		catch (BrowserException e) {
			exceptionThrown = true;
		}
		assertTrue(exceptionThrown);
	}
	
	@Test
	public void testOpenBrowserValidURL() {
		try {
			controller.openURL("http://www.google.nl");
		}
		catch (BrowserException e) {
			fail();
		}
	}
}
