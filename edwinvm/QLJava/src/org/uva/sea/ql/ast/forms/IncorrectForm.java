package org.uva.sea.ql.ast.forms;

import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.statements.StatementBody;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserForms;
import org.uva.sea.ql.parser.errors.ErrorMessages;
import org.uva.sea.ql.parser.errors.Message;
import org.uva.sea.ql.parser.errors.ParseError;

public class IncorrectForm extends Form {
	public IncorrectForm(Identifier identifier, StatementBody body) {
		super(identifier, body);
	}

	public static Form InvalidQLForm(ErrorMessages errorMessages) {
		try {
			return new ANTLRParserForms().parse(
				"form incorrectForm { " + 
					"\"De volgende fouten zijn opgetreden bij het QL formulier: \" hasSyntaxErrors = true " +
					showErrorMessages(errorMessages) +
				"}"
			);
		} catch (ParseError e) { e.printStackTrace(); return null; }
	}
	
	private static String showErrorMessages(ErrorMessages errorMessages) {
		String errorsAsGuiOutput = "";
		for (Message message: errorMessages.getErrorMessages()) {
			errorsAsGuiOutput += "\"" + message.getErrorMessage() + "\" hasSyntaxErrors = true ";
		}
		return errorsAsGuiOutput;
	}
}