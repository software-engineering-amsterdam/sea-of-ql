package org.uva.sea.ql.visitors.typechecking;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.formelements.Block;
import org.uva.sea.ql.ast.formelements.CompQuestion;
import org.uva.sea.ql.ast.formelements.Form;
import org.uva.sea.ql.ast.formelements.FormElement;
import org.uva.sea.ql.ast.formelements.IfThen;
import org.uva.sea.ql.ast.formelements.IfThenElse;
import org.uva.sea.ql.ast.formelements.Question;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitors.IElementVisitor;
import org.uva.sea.ql.visitors.utils.Errors;
import org.uva.sea.ql.visitors.utils.State;

public class ElementChecker implements IElementVisitor {

	private final State state;
	private final Errors errors;

	private ElementChecker(State state, Errors errors) {
		this.state = state;
		this.errors = errors;
	}

	public static void check(Form form, State state, Errors errors) {
		ElementChecker check = new ElementChecker(state, errors);
		form.accept(check);
	}

	public void visit(Form form) {
		form.getBody().accept(this);
	}

	public void visit(Block block) {
		for (FormElement element : block.getBlock()) {
			element.accept(this);
		}
	}

	public void visit(IfThen ifBody) {
		isConditionBoolean(ifBody);
		ifBody.getThenBody().accept(this);
	}

	public void visit(IfThenElse ifBody) {
		isConditionBoolean(ifBody);
		ifBody.getThenBody().accept(this);
		ifBody.getElseBody().accept(this);
	}

	public void visit(Question question) {
		isIdentDeclared(question);
	}

	public void visit(CompQuestion compQuestion) {
		Expr expression = compQuestion.getExpr();
		Type type = compQuestion.getType();
		String name = compQuestion.getName().getStringName();
		isIdentDeclared(compQuestion);
		ExprChecker.check(expression, state, errors);
		if (!expression.typeOf(state.getTypeEnv()).isCompatibleTo(type)) {
			errors.addError("Incompatible type and expression at " + name + ". Expected " + type.getClass().getSimpleName() + " but got " + expression.typeOf(state.getTypeEnv()).getClass().getSimpleName() + ".");
		}
	}

	public void isIdentDeclared(Question question) {
		String name = question.getName().getStringName();
		Type type = question.getType();
		if (state.hasRegisteredType(name)) {
			errors.addError("Question Ident: " + name + " is already declared.");
		} else {
			state.setType(name, type);
		}
	}

	public void isConditionBoolean(IfThen ifBody) {
		Expr condition = ifBody.getCondition();
		ExprChecker.check(condition, state, errors);
		if (!condition.typeOf(state.getTypeEnv()).isCompatibleToBoolType()) {
			errors.addError("If condition must be Boolean.");
		}
	}

}
