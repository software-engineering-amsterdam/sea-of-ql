package org.uva.sea.ql.ast.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.FormElementVisitor;
import org.uva.sea.ql.visitor.IForm;

public class IfConditionalExpr extends IForm {

	private final Expr orexpr;
	private List<Question> thenStatements;
	private List<Question> elseStatements;

	public List<Question> getThenStatements() {
		return thenStatements;
	}

	public void setThenStatements(List<Question> thenStatements) {
		this.thenStatements = thenStatements;
	}

	public List<Question> getElseStatements() {
		return elseStatements;
	}

	public void setElseStatements(List<Question> elseStatements) {
		this.elseStatements = elseStatements;
	}

	public IfConditionalExpr(Expr or) {
		this.orexpr = or;
		thenStatements = new ArrayList<Question>();
		elseStatements = new ArrayList<Question>();
		System.out.println("printed or expr CondtionalExpr");
	}

	public void addThen(Question q) {
		thenStatements.add(q);
		System.out.println(q.questionText + "     ThenCondtionalExpr");
	}

	public void addElse(Question q) {
		elseStatements.add(q);
		System.out.println(q.questionText + "      ElseCondtionalExpr");
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T accept(FormElementVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}

	public Expr getOrexpr() {
		return orexpr;
	}
}
