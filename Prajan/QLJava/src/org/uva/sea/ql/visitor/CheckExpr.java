package org.uva.sea.ql.visitor;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Primary;
import org.uva.sea.ql.ast.alg.Add;
import org.uva.sea.ql.ast.alg.And;
import org.uva.sea.ql.ast.alg.Bool;
import org.uva.sea.ql.ast.alg.Div;
import org.uva.sea.ql.ast.alg.Eq;
import org.uva.sea.ql.ast.alg.GEq;
import org.uva.sea.ql.ast.alg.GT;
import org.uva.sea.ql.ast.alg.Int;
import org.uva.sea.ql.ast.alg.LEq;
import org.uva.sea.ql.ast.alg.LT;
import org.uva.sea.ql.ast.alg.Money;
import org.uva.sea.ql.ast.alg.Mul;
import org.uva.sea.ql.ast.alg.NEq;
import org.uva.sea.ql.ast.alg.Neg;
import org.uva.sea.ql.ast.alg.Not;
import org.uva.sea.ql.ast.alg.Or;
import org.uva.sea.ql.ast.alg.Pos;
import org.uva.sea.ql.ast.alg.Str;
import org.uva.sea.ql.ast.alg.Sub;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.gen.TypeError;

public class CheckExpr implements AlgebricElementVisitor<Boolean> {

	private final Map<Ident, Type> typeEnv;
	private final List<TypeError> messages;

	public CheckExpr(Map<Ident, Type> tenv, List<TypeError> messages) {
		this.typeEnv = tenv;
		this.messages = messages;
	}

	public static boolean check(Expr expr, Map<Ident, Type> typeEnv, List<TypeError> errs) {
		CheckExpr check = new CheckExpr(typeEnv, errs);
		return expr.accept(check);
	}

	@Override
	public Boolean visit(Add add) {

		boolean checkLhs = add.getLhs().accept(this);
		boolean checkRhs = add.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			messages.add(new TypeError("Error from +"));
			return false;
		}
		Type lhsType = add.getLhs().typeOf(typeEnv);
		Type rhsType = add.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			messages.add(new TypeError("invalid type for +"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(And and) {

		boolean checkLhs = and.getLhs().accept(this);
		boolean checkRhs = and.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			messages.add(new TypeError("Error from &"));
			return false;
		}
		Type lhsType = and.getLhs().typeOf(typeEnv);
		Type rhsType = and.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			messages.add(new TypeError("invalid type for &"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Div div) {

		boolean checkLhs = div.getLhs().accept(this);
		boolean checkRhs = div.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			messages.add(new TypeError("Error from /"));
			return false;
		}
		Type lhsType = div.getLhs().typeOf(typeEnv);
		Type rhsType = div.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			messages.add(new TypeError("invalid type for /"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Eq eq) {

		boolean checkLhs = eq.getLhs().accept(this);
		boolean checkRhs = eq.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			messages.add(new TypeError("Error from  =="));
			return false;
		}
		Type lhsType = eq.getLhs().typeOf(typeEnv);
		Type rhsType = eq.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			messages.add(new TypeError("invalid type for =="));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(GEq geq) {

		boolean checkLhs = geq.getLhs().accept(this);
		boolean checkRhs = geq.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			messages.add(new TypeError("Error from >="));
			return false;
		}
		Type lhsType = geq.getLhs().typeOf(typeEnv);
		Type rhsType = geq.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			messages.add(new TypeError("invalid type for >="));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(GT gt) {

		boolean checkLhs = gt.getLhs().accept(this);
		boolean checkRhs = gt.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			messages.add(new TypeError("Error from >"));
			return false;
		}
		Type lhsType = gt.getLhs().typeOf(typeEnv);
		Type rhsType = gt.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			messages.add(new TypeError("invalid type for >"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Int val) {

		return true;
	}

	@Override
	public Boolean visit(LEq leq) {

		boolean checkLhs = leq.getLhs().accept(this);
		boolean checkRhs = leq.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			messages.add(new TypeError("Error from <="));
			return false;
		}
		Type lhsType = leq.getLhs().typeOf(typeEnv);
		Type rhsType = leq.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			messages.add(new TypeError("invalid type for <="));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(LT lt) {

		boolean checkLhs = lt.getLhs().accept(this);
		boolean checkRhs = lt.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			messages.add(new TypeError("Error from <"));
			return false;
		}
		Type lhsType = lt.getLhs().typeOf(typeEnv);
		Type rhsType = lt.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			messages.add(new TypeError("invalid type for <"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Mul mul) {

		boolean checkLhs = mul.getLhs().accept(this);
		boolean checkRhs = mul.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			messages.add(new TypeError("Error from *"));
			return false;
		}
		Type lhsType = mul.getLhs().typeOf(typeEnv);
		Type rhsType = mul.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			messages.add(new TypeError("invalid type for *"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Neg neg) {

		boolean acceptResult = neg.getValue().accept(this);
		Type type = neg.getValue().typeOf(typeEnv);
		if (!(acceptResult && type.isCompatibleToNumeric())) {
			messages.add(new TypeError("invalid type for Neg "));
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit(NEq neq) {

		boolean checkLhs = neq.getLhs().accept(this);
		boolean checkRhs = neq.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			messages.add(new TypeError("Error from !="));
			return false;
		}
		Type lhsType = neq.getLhs().typeOf(typeEnv);
		Type rhsType = neq.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			messages.add(new TypeError("invalid type for !="));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Not not) {

		boolean acceptResult = not.getValue().accept(this);
		Type type = not.getValue().typeOf(typeEnv);

		if (!(acceptResult && type.isCompatibleToBool())) {
			messages.add(new TypeError("invalid type for Not "));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Or or) {

		boolean checkLhs = or.getLhs().accept(this);
		boolean checkRhs = or.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			messages.add(new TypeError("Error from ||"));
			return false;
		}
		Type lhsType = or.getLhs().typeOf(typeEnv);
		Type rhsType = or.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			messages.add(new TypeError("invalid type for ||"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Pos pos) {

		boolean acceptResult = pos.getValue().accept(this);
		Type type = pos.getValue().typeOf(typeEnv);
		if (!(acceptResult && type.isCompatibleToNumeric())) {
			messages.add(new TypeError("invalid type for Pos "));
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit(Sub sub) {

		boolean checkLhs = sub.getLhs().accept(this);
		boolean checkRhs = sub.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			messages.add(new TypeError("Error from -"));
			return false;
		}
		Type lhsType = sub.getLhs().typeOf(typeEnv);
		Type rhsType = sub.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			messages.add(new TypeError("invalid type for -"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Ident ast) {
		return true;
	}

	@Override
	public Boolean visit(Primary ast) {
		return null;
	}

	@Override
	public Boolean visit(Bool bool) {

		Type t = bool.typeOf(typeEnv);
		return t.isCompatibleToBool();
	}

	@Override
	public Boolean visit(Str str) {

		Type t = str.typeOf(typeEnv);
		return t.isCompatibleToStr();
	}

	@Override
	public Boolean visit(Money money) {
		Type t = money.typeOf(typeEnv);
		return t.isCompatibleToMoney();

	}

}