package org.uva.sea.ql.lead;

import static julius.validation.Assertions.state;
import julius.utilities.FileHelper;

import org.uva.sea.ql.ast.stm.Form;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.JACCParser;
import org.uva.sea.ql.visitor.ExpressionTypeChecker;
import org.uva.sea.ql.visitor.StatementTypeChecker;
import org.uva.sea.ql.visitor.TypeCheckException;

/**
 * Main class starting up and initializing.
 */
public final class Startup {

	private final String[] args;
	private final IParse parser;

	public Startup(final String[] args) {
		this.args = args;
		parser = new JACCParser();
	}

	public void process() {
		Form form = parseForm(readSourceFileFromArgs());

		if (form != null && checkTypes(form)) {

			LogPrinter.debugInfo(form);
		}
	}

	/**
	 * 
	 * @param form
	 * @return true if no errors are detected
	 */
	private boolean checkTypes(final Form form) {
		StatementTypeChecker statementChecker = new StatementTypeChecker(
				new ExpressionTypeChecker());
		statementChecker.visit(form);

		for (TypeCheckException e : statementChecker.getAllTypeErrors()) {
			System.out.println(e);
		}
		return statementChecker.isValid();
	}

	/**
	 * 
	 * @return null if any error occurs reading or parsing the file
	 */
	private Form parseForm(final String source) {
		try {
			return parser.parseForm(source);
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

	public static void main(final String[] args) {
		new Startup(args).process();
	}

}
