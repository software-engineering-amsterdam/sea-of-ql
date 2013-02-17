package org.uva.sea.ql.parser.antlr;

import java.io.*;

import org.antlr.runtime.*;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.*;

public class FormParser implements IFormParser {
	public FormParser() { }

	@Override
	public Form parseForm(final File inputFile) throws ParsingException {
		try {
			final ANTLRInputStream stream = new ANTLRInputStream(new FileInputStream(inputFile));
			final CommonTokenStream tokens = new CommonTokenStream();
			tokens.setTokenSource(new QLLexer(stream));
			final QLParser parser = new QLParser(tokens);

			return parser.form();
		}
		catch (FileNotFoundException e) {
			throw new ParsingException(e);
		}
		catch (RecognitionException e) {
			throw new ParsingException(e);
		}
		catch (IOException e) {
			throw new ParsingException(e);
		}
	}
}
