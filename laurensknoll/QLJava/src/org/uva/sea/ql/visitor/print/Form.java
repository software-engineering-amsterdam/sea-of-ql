package org.uva.sea.ql.visitor.print;

import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.visitor.IForm;

public class Form implements IForm<String> {

	private final Environment environment;

	public Form() {
		this.environment = new Environment();
	}

	@Override
	public String visit(Question questionForm) {
		Expression expressionVisitor = new Expression();
		String ident = questionForm.getIdent().accept(expressionVisitor);

		Statement statementVisitor = new Statement(this.environment);
		String statements = questionForm.getStatements().accept(
				statementVisitor);

		return String.format("Questionform %s%s%s", ident,
				System.getProperty("line.separator"), statements);
	}

}
