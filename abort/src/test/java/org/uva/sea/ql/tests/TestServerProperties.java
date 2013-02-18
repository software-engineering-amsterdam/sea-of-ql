package org.uva.sea.ql.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.ServerProperties;

// Test server properties file
public class TestServerProperties extends TestBase {
	@Test
	public void testProperties() throws Exception {
		ServerProperties p = new ServerProperties();
		p.readProperties();
		
		assertTrue(p.getServerPort() > 0);
		assertNotNull(p.getSaveFormPath());
		assertNotNull(p.getServerBaseURL());
		assertNotNull(p.getTemplatesPath());
	}
}
