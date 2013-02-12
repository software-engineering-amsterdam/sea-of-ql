package org.uva.sea.ql.lead;

import static julius.validation.Assertions.state;
import javafx.application.Application;
import javafx.stage.Stage;
import julius.utilities.FileHelper;

import org.uva.sea.ql.ast.stm.Form;
import org.uva.sea.ql.gui.VisibleForm;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.JACCParser;
import org.uva.sea.ql.visitor.ExpressionEvaluator;
import org.uva.sea.ql.visitor.ExpressionTypeChecker;
import org.uva.sea.ql.visitor.StatementEvaluator;
import org.uva.sea.ql.visitor.StatementTypeChecker;
import org.uva.sea.ql.visitor.TypeCheckException;

/**
 * Main class starting up and initializing. It uses {@value #PATH_PROPERTY} to read the source path
 * from the vm arguments.
 * 
 */
public final class Startup extends Application {

	private static final String PATH_PROPERTY = "QL.formPath";

	private final IParse parser;
	private final Model model;

	public Startup() {
		parser = new JACCParser();
		model = new Model();
	}

	private void evaluate(final Form form) {
		ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(model);

		StatementEvaluator statementEvaluator = new StatementEvaluator(model,
				expressionEvaluator);

		form.accept(statementEvaluator);
	}

	/**
	 * 
	 * @param form
	 * @return true if no errors detected
	 */
	private boolean checkTypes(final Form form) {
		StatementTypeChecker statementChecker = new StatementTypeChecker(
				new ExpressionTypeChecker());
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
			new VisibleForm(model, form).start(stage);
		}

		else {

		}

	}

	@SuppressWarnings("static-access")
	public static void main(final String[] args) {
		new Startup().launch();
	}
}
