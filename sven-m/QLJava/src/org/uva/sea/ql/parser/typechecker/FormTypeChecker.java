package org.uva.sea.ql.parser.typechecker;

import org.uva.sea.ql.ast.visitor.FormVisitor;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.form.AbstractConditional;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.ast.form.IfElseStatement;
import org.uva.sea.ql.ast.form.IfStatement;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.form.Computed;
import org.uva.sea.ql.ast.form.types.Type;
import org.uva.sea.ql.parser.typechecker.error.FormTypeMismatchError;
import org.uva.sea.ql.parser.typechecker.error.VariableRedefinitionError;

public class FormTypeChecker implements FormVisitor<Boolean> {

	private TypeCheckerState state;
	private ExpressionTypeChecker exprTypeChecker;
	private ExpressionTypeEvaluator exprTypeEval;

	public FormTypeChecker(TypeCheckerState state) {
		this.state = state;
		this.exprTypeChecker = new ExpressionTypeChecker(state);
		this.exprTypeEval = new ExpressionTypeEvaluator(state.getTypeState());
	}

	private TypeCheckerState getState() {
		return state;
	}

	private ExpressionTypeChecker getExprTypeChecker() {
		return exprTypeChecker;
	}

	private ExpressionTypeEvaluator getExprTypeEval() {
		return exprTypeEval;
	}

	private boolean checkConditional(AbstractConditional conditional) {
		return conditional.getBody().accept(this)
				&& conditional.getCondition().accept(getExprTypeChecker());
	}

	@Override
	public Boolean visit(Form ast) {
		return ast.getBody().accept(this);
	}

	@Override
	public Boolean visit(Body ast) {
		boolean typeCorrect = true;

		for (FormElement formElement : ast.getElements()) {
			typeCorrect &= formElement.accept(this);
		}

		return typeCorrect;
	}

	@Override
	public Boolean visit(IfStatement ast) {
		return checkConditional(ast);
	}

	@Override
	public Boolean visit(IfElseStatement ast) {
		return checkConditional(ast) && ast.getElse().accept(this);
	}

	@Override
	public Boolean visit(Question ast) {
		boolean typeCorrect = getState().getType(ast.getIdent()) == null;
		Ident ident = ast.getIdent();

		if (typeCorrect) {
			getState().setType(ident, ast.getType());
		} else {
			getState().reportError(
					new VariableRedefinitionError(ident.getName(), ident));
		}

		return typeCorrect;
	}

	@Override
	public Boolean visit(Computed ast) {
		boolean typeCorrect = ast.getExpression().accept(getExprTypeChecker());
		
		Ident ident = ast.getIdent();

		Type exprType = ast.getExpression().accept(getExprTypeEval());

		if (!exprType.equals(ast.getType())) {
			typeCorrect = false;
			getState().reportError(
					new FormTypeMismatchError(ident.getName(),
							ast.getType().toString(), exprType.toString(),
							ast));
		}

		if (getState().getType(ident) == null) {
			getState().setType(ident, ast.getType());
		} else {
			typeCorrect = false;
			getState().reportError(
					new VariableRedefinitionError(ident.getName(), ident));
		}

		return typeCorrect;
	}

}
