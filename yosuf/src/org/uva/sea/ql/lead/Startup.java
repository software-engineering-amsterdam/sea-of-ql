package org.uva.sea.ql.lead;

import static julius.validation.Assertions.state;
import javafx.application.Application;
import javafx.stage.Stage;
import julius.utilities.FileHelper;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.checker.StatementTypeChecker;
import org.uva.sea.ql.checker.TypeCheckException;
import org.uva.sea.ql.evaluator.ExpressionEvaluator;
import org.uva.sea.ql.evaluator.StatementEvaluator;
import org.uva.sea.ql.gui.QLForm;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.JACCParser;

/**
 * Main class starting up and initializing. It uses {@value #PATH_PROPERTY} to read the source path
 * from the vm arguments.
 * 
 */
public final class Startup extends Application {

	private static final String DEBUG = "-debug";
	private static final String PATH_PROPERTY = "QL.formPath";

	private static final String HELP = "help";
	private static final String HELP_TEXT = DEBUG + " arg enables printing debug messages."
			+ "\nUse " + PATH_PROPERTY + " system property to provide the file path. Example: -D"
			+ PATH_PROPERTY + "=/forms/taxes.txt";

	private final IParse parser;
	private final Model model;

	public Startup() {
		parser = new JACCParser();
		model = new Model();
	}

	private void evaluate(final Form form) {
		ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(model);

		StatementEvaluator statementEvaluator = new StatementEvaluator(model, expressionEvaluator);

		statementEvaluator.visit(form);
	}

	/**
	 * 
	 * @param form
	 * @return true if no errors detected
	 */
	private boolean checkTypes(final Form form) {
		StatementTypeChecker statementChecker = new StatementTypeChecker();
		statementChecker.visit(form);

		for (TypeCheckException e : statementChecker.getAllTypeErrors()) {
			LogPrinter.debugInfo(e.toString());
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

	private String getPathFromEnvironment(final String propertyName) {
		return System.getProperty(propertyName);
	}

	private String readSourceFile(final String path) {
		state.assertNotNull(path, "Startup.path");
		return FileHelper.readFileAsString(path);
	}

	@Override
	public void start(final Stage stage) throws Exception {
		String sourceFile = readSourceFile(getPathFromEnvironment(PATH_PROPERTY));
		Form form = parseForm(sourceFile);

		if (form != null && checkTypes(form)) {
			evaluate(form);
			new QLForm(model, form).start(stage);
		} else {
			System.exit(0);
		}
	}

	@SuppressWarnings("static-access")
	public static void main(final String[] args) {
		if (args.length > 0 && args[0].contains(HELP)) {
			// Since debug messages printing option is disable by default, System.println is used.
			System.out.println(HELP_TEXT);
			System.exit(0);
		}
		initDebugPrinter(args);
		new Startup().launch();
	}

	private static void initDebugPrinter(final String[] args) {
		for (String string : args) {
			if (string.contains(DEBUG)) {
				LogPrinter.setDebugOn(true);
			}
		}
	}

}
