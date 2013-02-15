package org.uva.sea.ql.tests;

import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.base.SyntaxPosition;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;

/**
 * Base class to support the tests.
 * 
 * @author J. Dijkstra
 */
abstract class TestBase {
	/**
	 * Randomizer used for generating a syntax position.
	 */
	private final Random random = new Random(Calendar.getInstance().getTimeInMillis());
	
	/**
	 * Generate a random syntax position to use in the tests.
	 * 
	 * @return syntax position
	 */
	protected SyntaxPosition generateSyntaxPosition() {
		return new SyntaxPosition(random.nextInt(500), random.nextInt(1000));
	}
	
	/**
	 * Parse a QL string.
	 * 
	 * @param source sourcetext to parse
	 * @return QL parser instance
	 */
	protected QLParser parse(final String source) {
		final ANTLRStringStream stream = new ANTLRStringStream(source);
		final CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		return new QLParser(tokens);
	}

	/**
	 * Parse a QL form from a resource.
	 * 
	 * @param path path to the file that contains the form
	 * @return parsed form instance
	 * @throws IOException
	 * @throws RecognitionException
	 */
	protected Form parseFormFromResource(final String path) throws IOException,
			RecognitionException {
		final ANTLRInputStream stream = new ANTLRInputStream(getClass()
				.getClassLoader().getResourceAsStream(path));
		final CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		return (new QLParser(tokens)).form();
	}
}
