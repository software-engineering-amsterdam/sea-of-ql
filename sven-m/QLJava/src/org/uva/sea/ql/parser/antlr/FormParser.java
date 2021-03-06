package org.uva.sea.ql.parser.antlr;

import java.io.OutputStream;
import java.io.PrintStream;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.ast.form.Form;

public class FormParser implements IParse {

	private QLParser prepareParse(String src) {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));

		return new QLParser(tokens);
	}

	@Override
	public Form parse(String src) throws ParseError {
		return parseForm(src);
	}

	/* Parse a form, but also replace System.err with a PrintStream that
	 * outputs to the given OutputStream
	 */
	public Form parse(String src, OutputStream errorStream)
			throws NullPointerException, ParseError
	{
		/* save current error stream */
		PrintStream oldErr = System.err;

		/* redirect error stream to provided output stream */
		PrintStream ps = new PrintStream(errorStream);
		System.setErr(ps);

		Form form;

		/* parse form! */
		try {
			form = parse(src);
		} catch (ParseError e) {
			throw e;
		} finally {
			/* always flush and reset error stream back to original */
			System.err.flush();
			System.setErr(oldErr);
		}

		return form;
	}

	public Form parseForm(String src) throws ParseError {
		QLParser parser = prepareParse(src);

		try {
			return parser.form();
		} catch (RecognitionException | RuntimeException e) {
			throw new ParseError(e.getMessage());
		}
	}

	public Body parseBody(String src) throws ParseError {
		QLParser parser = prepareParse(src);

		try {
			return parser.topLevelBody();
		} catch (RecognitionException | RuntimeException e) {
			throw new ParseError(e.getMessage());
		}
	}

	public FormElement parseFormElement(String src) throws ParseError {
		QLParser parser = prepareParse(src);

		try {
			return parser.topLevelFormElement();
		} catch (RecognitionException | RuntimeException e) {
			throw new ParseError(e.getMessage());
		}
	}

	public Expr parseExpression(String src) throws ParseError {
		QLParser parser = prepareParse(src);

		try {
			return parser.topLevelExpression();
		} catch (RecognitionException | RuntimeException e) {
			throw new ParseError(e.getMessage());
		}
	}
}
