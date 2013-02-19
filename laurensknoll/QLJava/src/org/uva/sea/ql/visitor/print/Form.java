package org.uva.sea.ql.visitor.print;

import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.visitor.IExpression;
import org.uva.sea.ql.visitor.IForm;
import org.uva.sea.ql.visitor.IStatement;

public class Form implements IForm<String> {

	private final Environment environment;

	public Form() {
		this.environment = new Environment();
	}

	@Override
	public String visit(Question questionForm) {
		IExpression<String> expressionVisitor = new Expression();
		String ident = questionForm.getIdent().accept(expressionVisitor);

		IStatement<String> statementVisitor = new Statement(this.environment);
		String statements = questionForm.getStatements().accept(
				statementVisitor);

		return String.format("Questionform %s%s%s", ident,
				System.getProperty("line.separator"), statements);
	}

}
