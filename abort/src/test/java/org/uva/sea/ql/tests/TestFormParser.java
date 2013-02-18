package org.uva.sea.ql.tests;

import static org.junit.Assert.*;

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
		} catch (final ParsingException e) {
			fail();
		}
	}

	@Test
	public void testFormParserInvalid() throws Exception {
		try {
			formParser.parseForm(getFileResource("forms/form_syntax_errors.ql"));
		} catch (final ParsingException e) {
			// There should be no exceptions, just errors
			fail();
		}

		assertTrue(formParser.hasParsingErrors());
		formParser.writeErrorLog(System.out);
	}
}
