package org.uva.sea.ql.visitor.semantic;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.visitor.IForm;

public class Form implements IForm<Boolean> {

	private final Environment environment;
	private final List<String> errors;

	public Form() {
		this.environment = new Environment();
		this.errors = new ArrayList<String>();
	}

	@Override
	public Boolean visit(Question questionForm) {
		Ident id = questionForm.getIdent();

		Boolean isIdentDeclared = false;
		if (!this.environment.exists(id)) {
			this.environment.declare(id, new org.uva.sea.ql.ast.type.Form());
			isIdentDeclared = true;
		} else {
			String identNotUnique = String.format(
					"Ident \"%s\" is already defined.", id.getName());
			this.errors.add(identNotUnique);
		}

		Expression expressionVisitor = new Expression(this.environment);
		Boolean isIdentValid = id.accept(expressionVisitor);
		if (!isIdentValid) {
			this.errors.addAll(expressionVisitor.getErrors());
		}

		Statement statementVisitor = new Statement(this.environment);
		Boolean isBlockStatementValid = questionForm.getStatements().accept(
				statementVisitor);
		if (!isBlockStatementValid) {
			this.errors.addAll(statementVisitor.getErrors());
		}

		return isIdentDeclared && isIdentValid && isBlockStatementValid;
	}

	public List<String> getErrors() {
		return this.errors;
	}

}
