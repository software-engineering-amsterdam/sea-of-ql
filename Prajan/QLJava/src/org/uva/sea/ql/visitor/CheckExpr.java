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
import org.uva.sea.ql.ast.alg.Mul;
import org.uva.sea.ql.ast.alg.NEq;
import org.uva.sea.ql.ast.alg.Neg;
import org.uva.sea.ql.ast.alg.Not;
import org.uva.sea.ql.ast.alg.Or;
import org.uva.sea.ql.ast.alg.Pos;
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

	private void addError(Add add, String str) {

	}

	private void divError(Div div, String string) {

	}

	private void andError(And div, String string) {

	}

	private void eqError(Eq div, String string) {

	}

	private void geqError(GEq div, String string) {

	}

	private void gtError(GT div, String string) {

	}

	private void leqError(LEq div, String string) {

	}

	private void ltError(LT div, String string) {

	}

	private void mulError(Mul div, String string) {

	}

	private void orError(Or div, String string) {

	}

	private void subError(Sub div, String string) {

	}

	@Override
	public Boolean visit(Add add) {
		boolean checkLhs = add.getLhs().accept(this);
		boolean checkRhs = add.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			System.out.println("Error from Add ");
			return false;
		}
		Type lhsType = add.getLhs().typeOf(typeEnv);
		Type rhsType = add.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			// addError(add, "invalid type for +");
			messages.add(new TypeError("invalid type for +"));
			System.out.println("Error from Add 2");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(And and) {
		boolean checkLhs = and.getLhs().accept(this);
		boolean checkRhs = and.getRhs().accept(this);
		System.out.println("from left" + checkLhs);
		System.out.println("from Right" + checkRhs);
		if (!(checkLhs && checkRhs)) {
			System.out.println("Error from And");
			return false;
		}
		Type lhsType = and.getLhs().typeOf(typeEnv);
		Type rhsType = and.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			andError(and, "invalid type for & ");
			System.out.println("Error from And2");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Div div) {
		boolean checkLhs = div.getLhs().accept(this);
		boolean checkRhs = div.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			System.out.println("Error in Div 1");
			return false;
		}
		Type lhsType = div.getLhs().typeOf(typeEnv);
		Type rhsType = div.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			divError(div, "invalid type for / ");
			System.out.println("Error in Div 2");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Eq eq) {
		boolean checkLhs = eq.getLhs().accept(this);
		boolean checkRhs = eq.getRhs().accept(this);
		System.out.println("from left" + checkLhs);
		System.out.println("from Right" + checkRhs);
		if (!(checkLhs && checkRhs)) {
			System.out.println("Error from Eq");
			return false;
		}
		Type lhsType = eq.getLhs().typeOf(typeEnv);
		Type rhsType = eq.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			eqError(eq, "invalid type for == ");
			System.out.println("Error from Eq2");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(GEq geq) {
		boolean checkLhs = geq.getLhs().accept(this);
		boolean checkRhs = geq.getRhs().accept(this);
		System.out.println("from left" + checkLhs);
		System.out.println("from Right" + checkRhs);
		if (!(checkLhs && checkRhs)) {
			System.out.println("Error from Geq");
			return false;
		}
		Type lhsType = geq.getLhs().typeOf(typeEnv);
		Type rhsType = geq.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			geqError(geq, "invalid type for >= ");
			System.out.println("Error from Geq2");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(GT gt) {
		boolean checkLhs = gt.getLhs().accept(this);
		boolean checkRhs = gt.getRhs().accept(this);
		System.out.println("from left" + checkLhs);
		System.out.println("from Right" + checkRhs);
		if (!(checkLhs && checkRhs)) {
			System.out.println("Error from Gt");
			return false;
		}
		Type lhsType = gt.getLhs().typeOf(typeEnv);
		Type rhsType = gt.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			gtError(gt, "invalid type for > ");
			System.out.println("Error from Gt2");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Int val) {

		// Type valueType = val.typeOf(typeEnv);
		// System.out.println(val.typeOf(typeEnv).toString());
		// if (!(valueType.equals(new org.uva.sea.ql.ast.types.Int() ))) {
		// //addError("invalid type for " + val );
		// System.out.println("In CheckExpr Int part 5" + val);
		// return false;
		//
		// }
		return true;
	}

	@Override
	public Boolean visit(LEq leq) {
		boolean checkLhs = leq.getLhs().accept(this);
		boolean checkRhs = leq.getRhs().accept(this);
		System.out.println("from left" + checkLhs);
		System.out.println("from Right" + checkRhs);
		if (!(checkLhs && checkRhs)) {
			System.out.println("Error from LRq");
			return false;
		}
		Type lhsType = leq.getLhs().typeOf(typeEnv);
		Type rhsType = leq.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			leqError(leq, "invalid type for <= ");
			System.out.println("Error from LEq2");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(LT lt) {
		boolean checkLhs = lt.getLhs().accept(this);
		boolean checkRhs = lt.getRhs().accept(this);
		System.out.println("from left" + checkLhs);
		System.out.println("from Right" + checkRhs);
		if (!(checkLhs && checkRhs)) {
			System.out.println("Error from LT");
			return false;
		}
		Type lhsType = lt.getLhs().typeOf(typeEnv);
		Type rhsType = lt.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			ltError(lt, "invalid type for < ");
			System.out.println("Error from LT 2");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Mul mul) {
		boolean checkLhs = mul.getLhs().accept(this);
		boolean checkRhs = mul.getRhs().accept(this);
		System.out.println("from left" + checkLhs);
		System.out.println("from Right" + checkRhs);
		if (!(checkLhs && checkRhs)) {
			System.out.println("Error from Mul");
			return false;
		}
		Type lhsType = mul.getLhs().typeOf(typeEnv);
		Type rhsType = mul.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			mulError(mul, "invalid type for * ");
			System.out.println("Error from Mul 2");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Neg neg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(NEq neq) {
		// TODO Auto-generated method stub
		return null;
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
		System.out.println("from left" + checkLhs);
		System.out.println("from Right" + checkRhs);
		if (!(checkLhs && checkRhs)) {
			System.out.println("Error from Or");
			return false;
		}
		Type lhsType = or.getLhs().typeOf(typeEnv);
		Type rhsType = or.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			orError(or, "invalid type for || ");
			System.out.println("Error from Or 2");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Pos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Sub sub) {
		boolean checkLhs = sub.getLhs().accept(this);
		boolean checkRhs = sub.getRhs().accept(this);
		System.out.println("from left" + checkLhs);
		System.out.println("from Right" + checkRhs);
		if (!(checkLhs && checkRhs)) {
			System.out.println("Error from Sub");
			return false;
		}
		Type lhsType = sub.getLhs().typeOf(typeEnv);
		Type rhsType = sub.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			subError(sub, "invalid type for - ");
			System.out.println("Error from Sub");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Ident ast) {
		// yaha k garney sochnu parcha
		return true;
	}

	@Override
	public Boolean visit(Primary ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Bool bool) {
		// TODO Auto-generated method stub
		return null;
	}

}