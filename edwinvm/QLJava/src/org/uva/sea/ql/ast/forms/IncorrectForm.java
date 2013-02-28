package org.uva.sea.ql.ast.forms;

import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.statements.StatementBody;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserForms;
import org.uva.sea.ql.parser.errors.ParseError;

public class IncorrectForm extends Form {
	public IncorrectForm(Identifier identifier, StatementBody body) {
		super(identifier, body);
	}

	public static Form InvalidQLForm() {
		try {
			return new ANTLRParserForms().parse(
				"form incorrectForm { \"Het ingevulde QL Formulier is niet correct.\" hasSyntaxErrors: boolean }"
			);
		} catch (ParseError e) { e.printStackTrace(); return null; }
	}
}