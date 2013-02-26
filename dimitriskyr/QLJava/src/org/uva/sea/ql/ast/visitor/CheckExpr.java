package org.uva.sea.ql.ast.visitor;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.Add;
import org.uva.sea.ql.ast.expressions.And;
import org.uva.sea.ql.ast.expressions.Div;
import org.uva.sea.ql.ast.expressions.Eq;
import org.uva.sea.ql.ast.expressions.GEq;
import org.uva.sea.ql.ast.expressions.GT;
import org.uva.sea.ql.ast.expressions.LEq;
import org.uva.sea.ql.ast.expressions.LT;
import org.uva.sea.ql.ast.expressions.Mul;
import org.uva.sea.ql.ast.expressions.NEq;
import org.uva.sea.ql.ast.expressions.Neg;
import org.uva.sea.ql.ast.expressions.Not;
import org.uva.sea.ql.ast.expressions.Or;
import org.uva.sea.ql.ast.expressions.Pos;
import org.uva.sea.ql.ast.expressions.Sub;
import org.uva.sea.ql.ast.values.Bool;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.Money;
import org.uva.sea.ql.ast.values.String_lit;

public class CheckExpr implements ICheckExprVisitor<Boolean> {

	private final Map<String, Type> typeEnv;
	private final List<String> errormessages;

	public CheckExpr(Map<String, Type> tenv, List<String> messages) {
		this.typeEnv = tenv;
		this.errormessages = messages;
	}

	public static boolean check(Expr expr, Map<String, Type> typeEnv,
			List<String> errors) {
		CheckExpr check = new CheckExpr(typeEnv, errors);
		return expr.accept(check);
	}

	public void getErrormessages(String errors) {
		this.errormessages.add(errors);
	}

	@Override
	public Boolean visit(Add add) {
		boolean checkLhs = add.getLhs().accept(this);
		boolean checkRhs = add.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = add.getLhs().typeOf(typeEnv);
		Type rhsType = add.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType
				.isCompatibleToNumeric())) {
			getErrormessages("invalid type for '+' . The operands of the two sides should both be of type Numeric");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(And and) {
		boolean checkLhs = and.getLhs().accept(this);
		boolean checkRhs = and.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = and.getLhs().typeOf(typeEnv);
		Type rhsType = and.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBoolean() && rhsType
				.isCompatibleToBoolean())) {
			errormessages
					.add("invalid type for '&&' . The operands of the two sides should both be of type Boolean.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Div div) {
		boolean checkLhs = div.getLhs().accept(this);
		boolean checkRhs = div.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = div.getLhs().typeOf(typeEnv);
		Type rhsType = div.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType
				.isCompatibleToNumeric())) {
			errormessages
					.add("invalid type for '/' . The operands of the two sides should both be of type Numeric.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Eq eq) {
		boolean checkLhs = eq.getLhs().accept(this);
		boolean checkRhs = eq.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = eq.getLhs().typeOf(typeEnv);
		Type rhsType = eq.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleTo(rhsType))) {
			errormessages
					.add("invalid type for '=='. The operands of the two sides should both be of the same type.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(GEq geq) {
		boolean checkLhs = geq.getLhs().accept(this);
		boolean checkRhs = geq.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = geq.getLhs().typeOf(typeEnv);
		Type rhsType = geq.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType
				.isCompatibleToNumeric())) {
			errormessages
					.add("invalid type for '>='. The operands of the two sides should both be of type Numeric.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(GT gt) {
		boolean checkLhs = gt.getLhs().accept(this);
		boolean checkRhs = gt.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = gt.getLhs().typeOf(typeEnv);
		Type rhsType = gt.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType
				.isCompatibleToNumeric())) {
			errormessages
					.add("invalid type for '>'. The operands of the two sides should both be of type Numeric.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(LEq leq) {
		boolean checkLhs = leq.getLhs().accept(this);
		boolean checkRhs = leq.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = leq.getLhs().typeOf(typeEnv);
		Type rhsType = leq.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType
				.isCompatibleToNumeric())) {
			errormessages
					.add("invalid type for '<='. The operands of the two sides should both be of type Numeric.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(LT lt) {
		boolean checkLhs = lt.getLhs().accept(this);
		boolean checkRhs = lt.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = lt.getLhs().typeOf(typeEnv);
		Type rhsType = lt.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType
				.isCompatibleToNumeric())) {
			errormessages
					.add("invalid type for '<'. The operands of the two sides should both be of type Numeric.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Mul mul) {
		boolean checkLhs = mul.getLhs().accept(this);
		boolean checkRhs = mul.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = mul.getLhs().typeOf(typeEnv);
		Type rhsType = mul.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType
				.isCompatibleToNumeric())) {
			errormessages
					.add("invalid type for '*' . The operands of the two sides should both be of type Numeric");
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit(Neg neg) {
		boolean checkValue = neg.getValue().accept(this);
		if (!(checkValue)) {
			return false;
		}
		Type valueType = neg.getValue().typeOf(typeEnv);
		if (!(valueType.isCompatibleToNumeric())) {
			errormessages
					.add("invalid type for '-' . The operand should be of type Numeric");
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit(NEq neq) {
		boolean checkLhs = neq.getLhs().accept(this);
		boolean checkRhs = neq.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = neq.getLhs().typeOf(typeEnv);
		Type rhsType = neq.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleTo(rhsType))) {
			errormessages
					.add("invalid type for '!='. The operands of the two sides should both be of the same type.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Not not) {
		boolean checkValue = not.getValue().accept(this);
		if (!(checkValue)) {
			return false;
		}
		Type valueType = not.getValue().typeOf(typeEnv);
		if (!(valueType.isCompatibleToBoolean())) {
			errormessages
					.add("invalid type for '!' . The operand should be of type Boolean");
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit(Or or) {
		boolean checkLhs = or.getLhs().accept(this);
		boolean checkRhs = or.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = or.getLhs().typeOf(typeEnv);
		Type rhsType = or.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBoolean() && rhsType
				.isCompatibleToBoolean())) {
			errormessages
					.add("invalid type for '||' . The operands of the two sides should both be of type Boolean.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Pos pos) {
		boolean checkValue = pos.getValue().accept(this);
		if (!(checkValue)) {
			return false;
		}
		Type valueType = pos.getValue().typeOf(typeEnv);
		if (!(valueType.isCompatibleToNumeric())) {
			errormessages
					.add("invalid type for '+' . The operand should be of type Numeric.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Sub sub) {
		boolean checkLhs = sub.getLhs().accept(this);
		boolean checkRhs = sub.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		Type lhsType = sub.getLhs().typeOf(typeEnv);
		Type rhsType = sub.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType
				.isCompatibleToNumeric())) {
			errormessages
					.add("invalid type for '-' . The operands of the two sides should both be of type Numeric.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Bool bool) {
		return true;
	}

	@Override
	public Boolean visit(String_lit string_lit) {
		return true;
	}

	@Override
	public Boolean visit(Money money) {
		return true;
	}

	@Override
	public Boolean visit(Ident ident) {
		if (typeEnv.get(ident.getValue()) == null) {
			getErrormessages("Ident " + ident.getValue() + " is not declared.");
		}
		return true;
	}

	@Override
	public Boolean visit(Int integer) {
		return true;
	}

}
