package org.uva.sea.ql.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.util.*;

public class TestBrowserUtils extends TestBase {
	@Test
	public void testOpenBrowserInvalidURL() {

		boolean exceptionThrown = false;
		try {
			BrowserUtil.openURL("invalidURL");
		} catch (final BrowserException e) {
			exceptionThrown = true;
		}
		assertTrue(exceptionThrown);
	}

	@Test
	public void testOpenBrowserValidURL() {
		try {
			BrowserUtil.openURL("http://www.google.nl");
		} catch (final BrowserException e) {
			fail();
		}
	}
}
