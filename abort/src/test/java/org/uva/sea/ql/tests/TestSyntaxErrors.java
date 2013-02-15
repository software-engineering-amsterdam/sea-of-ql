package org.uva.sea.ql.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.junit.After;
import org.junit.Test;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;
import org.uva.sea.ql.parser.errors.SyntaxErrorReporter;
import org.uva.sea.ql.parser.errors.base.ISyntaxErrorReporter;

// Test syntax error reporting and logging
public class TestSyntaxErrors extends TestBase {
	private static final String RESOURCE_FORM_SYNTAX_ERRORS = "tests/form_syntax_errors.ql";
	private static final String RESOURCE_FORM_VALID = "tests/form_valid.ql";
	private final ISyntaxErrorReporter errorReporter = new SyntaxErrorReporter();
	
	@Override
	protected Form parseFormFromResource(final String path) throws IOException, RecognitionException {
		final ANTLRInputStream stream = new ANTLRInputStream(getClass()
				.getClassLoader().getResourceAsStream(path));
		final CommonTokenStream tokens = new CommonTokenStream();
		final QLLexer lexer = new QLLexer(stream);
		final QLParser parser = new QLParser(tokens);
		lexer.setErrorReporter(errorReporter);
		tokens.setTokenSource(lexer);
		
		parser.setErrorReporter(errorReporter);
		return parser.form();
	}
	
	@Test
	public void testSyntaxErrors() throws IOException, RecognitionException {
		parseFormFromResource(RESOURCE_FORM_SYNTAX_ERRORS);
		assertTrue(errorReporter.getErrors().size() > 0);
		assertTrue(errorReporter.hasSyntaxErrors());
		assertTrue(errorReporter.toString().length() > 0);
	}

	@Test
	public void testGoodSyntax() throws IOException, RecognitionException {
		parseFormFromResource(RESOURCE_FORM_VALID);
		assertTrue(errorReporter.getErrors().size() == 0);
		assertFalse(errorReporter.hasSyntaxErrors());
		assertTrue(errorReporter.toString().length() == 0);
	}
	
	@After
	public void afterTest() {
		System.out.println(errorReporter.toString());
	}
}