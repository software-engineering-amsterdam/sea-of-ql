package org.uva.sea.ql.visitor;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.form.Calculation;
import org.uva.sea.ql.ast.form.Declaration;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.IfConditionalExpr;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.form.Statements;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.gen.TypeError;
import org.uva.sea.ql.gui.State;

public class CheckForm implements FormElementVisitor<Boolean> {

	private final Map<Ident, Type> typeEnv;
	private final State state;
	private final List<TypeError> messages;

	public CheckForm(Map<Ident, Type> tenv, State state, List<TypeError> messages) {

		this.typeEnv = tenv;
		this.messages = messages;
		this.state = state;
	}

	private boolean checkName(String ident) {

		if (typeEnv.containsKey(ident)) {
			// add error message saying that variable is already defined
			messages.add(new TypeError("variable is already defined: " + ident));
			return false;
		}
		return true;
	}

	// get into the form and visits all the allquestion
	@Override
	public Boolean visit(Form form) {
		form.getStatements().accept(this);
		return null;
	}

	// get all the questions and all ifconditonal expressions
	@Override
	public Boolean visit(Statements allquestion) {

		for (Question question : allquestion.getQuestion()) {
			question.accept(this);
		}

		for (IfConditionalExpr ifExpr : allquestion.getIfconditionalexpr()) {
			ifExpr.accept(this);
		}
		return null;
	}

	// get declarations and calculations
	@Override
	public Boolean visit(Question question) {

		if (question.isDeclaration())
			question.getDeclaration().accept(this);
		else
			question.getCalculation().accept(this);

		return null;
	}

	// get the expression to be evaluated and calls expression dependency
	// checker to get the type and uses observer pattern
	@Override
	public Boolean visit(Calculation calculation) {

		boolean checkName = checkName(calculation.getIdent().getName());
		boolean checkExpr = CheckExpr.check(calculation.getOrexpr(), typeEnv, messages);

		ExprDependencyAnalyzer analyzer = new ExprDependencyAnalyzer(state, calculation);
		calculation.getOrexpr().accept(analyzer);

		return checkName && checkExpr;
	}

	@Override
	public Boolean visit(IfConditionalExpr ifconditionalexpr) {

		boolean checkExpr = CheckExpr.check(ifconditionalexpr.getOrexpr(), typeEnv, messages);

		ExprDependencyAnalyzer analyzer = new ExprDependencyAnalyzer(state, ifconditionalexpr);
		ifconditionalexpr.getOrexpr().accept(analyzer);

		ifconditionalexpr.getStatements().accept(this);

		for (Question elseQuestion : ifconditionalexpr.getElseStatements()) {
			elseQuestion.accept(this);
		}

		return null;
	}

	@Override
	public Boolean visit(Declaration declaration) {

		if (typeEnv.containsKey(declaration.getIdent())) {
			// add error message saying that variable is already defined
			messages.add(new TypeError("variable is already defined: " + declaration.getIdent()));
		} else {
			Value defaultValue = declaration.getIdenttype().accept(new TypeDefaultValue());
			this.state.getEnv().put(declaration.getIdent(), defaultValue);
			this.typeEnv.put(declaration.getIdent(), declaration.getIdenttype());
		}

		return null;
	}

}