package org.uva.sea.ql.questionnaire.check;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.error.ErrorMessage;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.nodes.values.Bool;
import org.uva.sea.ql.ast.nodes.values.Doub;
import org.uva.sea.ql.ast.nodes.values.Int;
import org.uva.sea.ql.ast.nodes.values.Money;
import org.uva.sea.ql.ast.nodes.values.Str;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class CheckExpr implements Visitor<Boolean> {

	private final Map<Ident, Type> typeEnv;
	private final List<ErrorMessage> messages;

	private CheckExpr(Map<Ident, Type> tenv, List<ErrorMessage> messages) {
		this.typeEnv = tenv;
		this.messages = messages;
	}

	//check if expression is valid, if not, put error message to error list
	public static Boolean check(Expr expr, Map<Ident, Type> typeEnv,
			List<ErrorMessage> errs) {
		CheckExpr check = new CheckExpr(typeEnv, errs);
		return expr.accept(check);
	}

	private void addError(Expr ex, String message) {
		this.messages.add(new ErrorMessage(ex, message));
	}

	public List<ErrorMessage> getErrorMessages() {
		return this.messages;
	}

	@Override
	public Boolean visit(Bool bool) {
		return true;
	}

	@Override
	public Boolean visit(Str str) {
		return true;
	}

	@Override
	public Boolean visit(Money money) {
		return true;
	}

	@Override
	public Boolean visit(Ident ident) {
		return true;
	}

	@Override
	public Boolean visit(Int i) {
		return true;
	}

	@Override
	public Boolean visit(Doub doub) {
		return true;
	}

	@Override
	public Boolean visit(Add ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);

		if (!(checkLhs && checkRhs)) {
			return false;
		}

		Type typeLhs = ast.getLhs().typeOf(this.typeEnv);
		Type typeRhs = ast.getRhs().typeOf(this.typeEnv);

		if (!(typeLhs.isCompatibleToNumeric() && typeRhs
				.isCompatibleToNumeric())) {
			addError(ast, "invalid type for ADD (+)");
			return false;
		}
		return true;

	}

	@Override
	public Boolean visit(And ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);

		if (!(checkLhs && checkRhs)) {
			return false;
		}

		Type typeLhs = ast.getLhs().typeOf(this.typeEnv);
		Type typeRhs = ast.getRhs().typeOf(this.typeEnv);

		if (!(typeLhs.isCompatibleToBool() && typeRhs.isCompatibleToBool())) {
			addError(ast, "invalid type for AND (&&)");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Div ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);

		if (!(checkLhs && checkRhs)) {
			return false;
		}

		Type typeLhs = ast.getLhs().typeOf(this.typeEnv);
		Type typeRhs = ast.getRhs().typeOf(this.typeEnv);

		if (!(typeLhs.isCompatibleToNumeric() && typeRhs
				.isCompatibleToNumeric())) {
			addError(ast, "invalid type for DIV (/)");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Eq ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);

		if (!(checkLhs && checkRhs)) {
			return false;
		}

		Type typeLhs = ast.getLhs().typeOf(this.typeEnv);
		Type typeRhs = ast.getRhs().typeOf(this.typeEnv);

		if (!((typeLhs.isCompatibleToBool()
				&& typeRhs.isCompatibleToBool()
				|| (typeLhs.isCompatibleToNumeric() && typeRhs
						.isCompatibleToNumeric()) || (typeLhs
				.isCompatibleToStr() && typeRhs.isCompatibleToStr())))) {
			addError(ast, "invalid type for EQUALS (==)");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(GEq ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);

		if (!(checkLhs && checkRhs)) {
			return false;
		}

		Type typeLhs = ast.getLhs().typeOf(typeEnv);
		Type typeRhs = ast.getRhs().typeOf(typeEnv);

		if (!(typeLhs.isCompatibleToNumeric() && typeRhs
				.isCompatibleToNumeric())) {
			addError(ast, "invalid type for GREATER EQUALS (>=)");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(GT ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);

		if (!(checkLhs && checkRhs)) {
			return false;
		}

		Type typeLhs = ast.getLhs().typeOf(this.typeEnv);
		Type typeRhs = ast.getRhs().typeOf(this.typeEnv);

		if (!(typeLhs.isCompatibleToNumeric() && typeRhs
				.isCompatibleToNumeric())) {
			addError(ast, "invalid type for GREATER THEN (>)");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(LEq ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);

		if (!(checkLhs && checkRhs)) {
			return false;
		}

		Type typeLhs = ast.getLhs().typeOf(this.typeEnv);
		Type typeRhs = ast.getRhs().typeOf(this.typeEnv);

		if (!(typeLhs.isCompatibleToNumeric() && typeRhs
				.isCompatibleToNumeric())) {
			addError(ast, "invalid type for LESS THEN EQUALS (<=)");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(LT ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);

		if (!(checkLhs && checkRhs)) {
			return false;
		}

		Type typeLhs = ast.getLhs().typeOf(this.typeEnv);
		Type typeRhs = ast.getRhs().typeOf(this.typeEnv);

		if (!(typeLhs.isCompatibleToNumeric() && typeRhs
				.isCompatibleToNumeric())) {
			addError(ast, "invalid type for LESS THEN (<)");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Mul ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);

		if (!(checkLhs && checkRhs)) {
			return false;
		}

		Type typeLhs = ast.getLhs().typeOf(this.typeEnv);
		Type typeRhs = ast.getRhs().typeOf(this.typeEnv);

		if (!(typeLhs.isCompatibleToNumeric() && typeRhs
				.isCompatibleToNumeric())) {
			addError(ast, "invalid type for MUL (*)");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Neg ast) {
		return ast.accept(this);
	}

	@Override
	public Boolean visit(NEq ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);

		if (!(checkLhs && checkRhs)) {
			return false;
		}

		Type typeLhs = ast.getLhs().typeOf(this.typeEnv);
		Type typeRhs = ast.getRhs().typeOf(this.typeEnv);

		if (!((typeLhs.isCompatibleToBool()
				&& typeRhs.isCompatibleToBool()
				|| (typeLhs.isCompatibleToNumeric() && typeRhs
						.isCompatibleToNumeric()) || (typeLhs
				.isCompatibleToStr() && typeRhs.isCompatibleToStr())))) {
			
			addError(ast, "invalid type for NOT EQUALS (!=)");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Not ast) {
		boolean checkChild = ast.getExpr().accept(this);
		if (!checkChild) {
			return false;
		}
		Type astType = ast.typeOf(this.typeEnv);
		Type childType = ast.getExpr().typeOf(this.typeEnv);
		boolean isCompatible = childType.isCompatibleTo(astType);

		if (!isCompatible) {
			addError(ast, "invalid type for NOT (!)");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Or ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);

		if (!(checkLhs && checkRhs)) {
			return false;
		}

		Type typeLhs = ast.getLhs().typeOf(this.typeEnv);
		Type typeRhs = ast.getRhs().typeOf(this.typeEnv);

		if (!(typeLhs.isCompatibleToBool() && typeRhs.isCompatibleToBool())) {
			addError(ast, "invalid type for OR (||)");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Pos ast) {
		boolean check = ast.accept(this);
		if (!check) {
			addError(ast, "invalid type for POS (+)");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Sub ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);

		if (!(checkLhs && checkRhs)) {
			return false;
		}

		Type typeLhs = ast.getLhs().typeOf(this.typeEnv);
		Type typeRhs = ast.getRhs().typeOf(this.typeEnv);

		if (!(typeLhs.isCompatibleToNumeric() && typeRhs
				.isCompatibleToNumeric())) {
			addError(ast, "invalid type for SUB (-)");
			return false;
		}
		return true;
	}

}
