package org.uva.sea.ql.parser.antlr;

import java.io.*;

import org.antlr.runtime.*;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.base.*;
import org.uva.sea.ql.parser.errors.*;

/**
 * Parses a form using input.
 * 
 * @author J. Dijkstra
 */
public class FormParser implements IFormParser {
	private final ISyntaxErrorReporter errorReporter = new SyntaxErrorReporter();

	@Override
	public Form parseForm(final File inputFile) throws ParsingException {
		try {
			final ANTLRInputStream stream = new ANTLRInputStream(new FileInputStream(inputFile));
			final CommonTokenStream tokens = new CommonTokenStream();
			tokens.setTokenSource(new QLLexer(stream));
			final QLParser parser = new QLParser(tokens);
			parser.setErrorReporter(errorReporter);

			return parser.form();
		} catch (final FileNotFoundException e) {
			throw new ParsingException(e);
		} catch (final RecognitionException e) {
			throw new ParsingException(e);
		} catch (final IOException e) {
			throw new ParsingException(e);
		}
	}

	@Override
	public boolean hasParsingErrors() {
		return errorReporter.hasSyntaxErrors();
	}

	@Override
	public void writeErrorLog(final PrintStream stream) {
		for (final SyntaxErrorMessage message : errorReporter.getErrors()) {
			stream.println(message);
		}
	}
}
