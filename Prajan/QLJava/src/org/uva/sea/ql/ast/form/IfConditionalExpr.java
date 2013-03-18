package org.uva.sea.ql.ast.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.FormElementVisitor;

public class IfConditionalExpr extends ObservableStatement {

	private final Expr orexpr;
	private Statements statements;
	private List<Question> elseStatements;

	public Statements getStatements() {
		return statements;
	}

	public void setStatements(Statements statements) {
		this.statements = statements;
	}

	public List<Question> getElseStatements() {
		return elseStatements;
	}

	public void setElseStatements(List<Question> elseStatements) {
		this.elseStatements = elseStatements;
	}

	public IfConditionalExpr(Expr or) {
		this.orexpr = or;
		elseStatements = new ArrayList<Question>();
	}

	public void addAllQuestion(Statements q) {
		statements = q;
	}

	public void addElse(Question q) {
		elseStatements.add(q);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return null;
	}

	@Override
	public <T> T accept(FormElementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Expr getOrexpr() {
		return orexpr;
	}
}
