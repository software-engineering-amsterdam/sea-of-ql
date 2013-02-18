package org.uva.sea.ql.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.CommandLineParameters;

import com.beust.jcommander.*;

// Test command line parsing
public class TestCommandLine extends TestBase {
	private final static String FORM_PARAMETER = "form_valid.ql";

	@Test
	public void testParse() {
		final CommandLineParameters parameters = new CommandLineParameters();
		final JCommander jCommander = new JCommander(parameters);
		jCommander.setProgramName("testprogram");
		try {
			jCommander.parse("-i", getQuotedArgument(FORM_PARAMETER));
			assertNotNull(parameters.getInputFile());
			assertEquals(FORM_PARAMETER, parameters.getInputFile().getName());
		} catch (final ParameterException exception) {
			fail();
		}
	}

	private String getQuotedArgument(final String argument) {
		return String.format("\"%s\"", argument);
	}
}
