package org.uva.sea.ql.visitor;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.form.Calculation;
import org.uva.sea.ql.ast.form.Declaration;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.IfConditionalExpr;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.gen.TypeError;

public class CheckForm implements FormElementVisitor<Boolean> {

	private final Map<Ident, Type> typeEnv;
	private final List<TypeError> messages;

	public CheckForm(Map<Ident, Type> tenv, List<TypeError> messages) {
		this.typeEnv = tenv;
		this.messages = messages;
	}

	private boolean checkName(String ident) {
		// TODO Auto-generated method stub
		if (typeEnv.containsKey(ident)) {
			// add error message saying that variable is already defined
			messages.add(new TypeError("variable is already defined: " + ident));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Form form) {
		// TODO Auto-generated method stub
		for (Question question : form.getQuestion()) {
			question.accept(this);
		}

		for (IfConditionalExpr ifExpr : form.getIfconditionalexpr()) {
			ifExpr.accept(this);
		}

		return null;
	}

	@Override
	public Boolean visit(Question question) {

		for (Declaration declaration : question.getDeclaration()) {
			declaration.accept(this);
		}

		for (Calculation calculation : question.getCalculation()) {
			calculation.accept(this);
		}

		return null;
	}

	@Override
	public Boolean visit(Calculation calculation) {
		boolean checkName = checkName(calculation.getIdent());
		boolean checkExpr = CheckExpr.check(calculation.getOrexpr(), typeEnv, messages);
		return checkName && checkExpr;
	}

	@Override
	public Boolean visit(IfConditionalExpr ifconditionalexpr) {

		boolean checkExpr = CheckExpr.check(ifconditionalexpr.getOrexpr(), typeEnv, messages);
		for (Question thenQuestion : ifconditionalexpr.getThenStatements()) {
			thenQuestion.accept(this);
		}

		for (Question elseQuestion : ifconditionalexpr.getElseStatements()) {
			elseQuestion.accept(this);
		}

		return null;
	}

	@Override
	public Boolean visit(Declaration declaration) {
		// TODO Auto-generated method stub
		if (typeEnv.containsKey(declaration.getIdent())) {
			// add error message saying that variable is already defined
			messages.add(new TypeError("variable is already defined: " + declaration.getIdent()));
		}
		return null;
	}

}