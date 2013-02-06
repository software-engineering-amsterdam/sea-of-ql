package org.uva.sea.ql.lead;

import static julius.validation.Assertions.state;
import julius.utilities.FileHelper;

import org.uva.sea.ql.ast.stm.Form;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.JACCParser;
import org.uva.sea.ql.visitor.ExpressionTypeChecker;
import org.uva.sea.ql.visitor.StatementTypeChecker;

/**
 * Main class starting up and initializing.
 */
public final class Startup {

	private final String[] args;
	private final IParse parser;
	private final ExpressionTypeChecker expressionChecker;
	private final StatementTypeChecker statementChecker;

	public Startup(final String[] args) {
		this.args = args;

		expressionChecker = new ExpressionTypeChecker();
		statementChecker = new StatementTypeChecker(expressionChecker);
		parser = new JACCParser();
	}

	public void process() {

		Form form = parseForm();

		if (form != null) {
			statementChecker.visit(form);
			state.assertTrue(statementChecker.isValid(), "Type errors: "
					+ statementChecker.getAllTypeErrors().toString());
		}
	}

	/**
	 * 
	 * @return null if any error occurs reading or parsing the file
	 */
	private Form parseForm() {
		try {
			return parser.parseForm(readSourceFileFromArgs());
		} catch (ParseError e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private String readSourceFileFromArgs() {
		state.assertFalse(args.length < 1,
				"The first argument should be the filepath to the source");
		return FileHelper.readFileAsString(args[0]);
	}

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		new Startup(args).process();
	}

}
