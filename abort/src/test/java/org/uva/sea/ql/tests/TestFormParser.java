package org.uva.sea.ql.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.net.*;

import org.junit.Test;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.antlr.FormParser;
import org.uva.sea.ql.parser.base.*;

// Test the form parser used in the main code (wraps ANTLRParser)
public class TestFormParser extends TestBase {
	private final IFormParser formParser = new FormParser();

	@Test
	public void testFormParserValid() throws Exception {
		try {
			final Form form = formParser.parseForm(getFileResource("forms/form_valid.ql"));
			assertTrue(form.getStatements() != null);
			assertTrue(form.getStatements().size() > 0);
			assertFalse(formParser.hasParsingErrors());
		}
		catch (ParsingException e) {
			fail();
		}
	}

	@Test
	public void testFormParserInvalid() throws Exception {
		boolean exceptionThrown = false;
		Form form = null;
		try {
			form = formParser.parseForm(getFileResource("forms/form_syntax_errors.ql"));
		}
		catch (ParsingException e) {
			exceptionThrown = true;
		}
		assertTrue(exceptionThrown);
		assertTrue(formParser.hasParsingErrors());
		assertNull(form);
		formParser.writeErrorLog(System.out);
	}
	
	private File getFileResource(final String path) throws URISyntaxException {
		return new File(getClass().getClassLoader().getResource(path).toURI());
	}
}
