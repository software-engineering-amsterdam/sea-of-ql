package org.uva.sea.ql.ast.visitor;

import java.util.List;
import java.util.Map;

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
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.BoolValue;
import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.StringValue;

public class CheckExpr implements VisitorExpressions<Boolean> {

	private final Map<Ident, Type> typeEnv;
	private final List<String> messages;

	private CheckExpr(Map<Ident, Type> tenv, List<String> messages) {
		this.typeEnv = tenv;
		this.messages = messages;
	}

	public static boolean check(Expr expr, Map<Ident, Type> typeEnv, List<String> errs) {
		CheckExpr check = new CheckExpr(typeEnv, errs);
		return expr.accept(check);
	}
	
	public void addError(String errors) {
		this.messages.add(errors);
	}

	@Override
	public Boolean visit(Add add) {
		
		boolean checkLeft = add.getLeft().accept(this);
		boolean checkRight = add.getRight().accept(this);
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = add.getLeft().typeOf(typeEnv);
		Type rightType = add.getRight().typeOf(typeEnv);
		if (!(leftType.isCompatibleToTypeInt() && rightType.isCompatibleToTypeInt())) {
			addError("Invalid type for +");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(And and) {
		
		boolean checkLeft = and.getLeft().accept(this);
		boolean checkRight = and.getRight().accept(this);
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = and.getLeft().typeOf(typeEnv);
		Type rightType = and.getRight().typeOf(typeEnv);
		if (!(leftType.isCompatibleToTypeBool() && rightType.isCompatibleToTypeBool())) {
			addError("Invalid type for &");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Div div) {
		
		boolean checkLeft = div.getLeft().accept(this);
		boolean checkRight = div.getRight().accept(this);
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = div.getLeft().typeOf(typeEnv);
		Type rightType = div.getRight().typeOf(typeEnv);
		if (!(leftType.isCompatibleToTypeInt() && rightType.isCompatibleToTypeInt())) {
			addError("Invalid type for /");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Eq eq) {
		
		boolean checkLeft = eq.getLeft().accept(this);
		boolean checkRight = eq.getRight().accept(this);
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = eq.getLeft().typeOf(typeEnv);
		Type rightType = eq.getRight().typeOf(typeEnv);
		if (!(leftType.isCompatibleTo(rightType))) {
			addError("Invalid type for ==");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(GEq geq) {
		
		boolean checkLeft = geq.getLeft().accept(this);
		boolean checkRight = geq.getRight().accept(this);
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = geq.getLeft().typeOf(typeEnv);
		Type rightType = geq.getRight().typeOf(typeEnv);
		if (!(leftType.isCompatibleToTypeInt() && rightType.isCompatibleToTypeInt())) {
			addError("Invalid type for >=");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(GT gt) {
		
		boolean checkLeft = gt.getLeft().accept(this);
		boolean checkRight = gt.getRight().accept(this);
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = gt.getLeft().typeOf(typeEnv);
		Type rightType = gt.getRight().typeOf(typeEnv);
		if (!(leftType.isCompatibleToTypeInt() && rightType.isCompatibleToTypeInt())) {
			addError("Invalid type for >");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(LEq leq) {
		
		boolean checkLeft = leq.getLeft().accept(this);
		boolean checkRight = leq.getRight().accept(this);
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = leq.getLeft().typeOf(typeEnv);
		Type rightType = leq.getRight().typeOf(typeEnv);
		if (!(leftType.isCompatibleToTypeInt() && rightType.isCompatibleToTypeInt())) {
			addError("Invalid type for <=");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(LT lt) {
		
		boolean checkLeft = lt.getLeft().accept(this);
		boolean checkRight = lt.getRight().accept(this);
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = lt.getLeft().typeOf(typeEnv);
		Type rightType = lt.getRight().typeOf(typeEnv);
		if (!(leftType.isCompatibleToTypeInt() && rightType.isCompatibleToTypeInt())) {
			addError("Invalid type for <");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Mul mul) {
		
		boolean checkLeft = mul.getLeft().accept(this);
		boolean checkRight = mul.getRight().accept(this);
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = mul.getLeft().typeOf(typeEnv);
		Type rightType = mul.getRight().typeOf(typeEnv);
		if (!(leftType.isCompatibleToTypeInt() && rightType.isCompatibleToTypeInt())) {
			addError("Invalid type for *");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Neg neg) {
		
		boolean checkExpression = neg.getExpression().accept(this);
		if (!(checkExpression)) {
			return false;
		}
		
		Type expressionType = neg.getExpression().typeOf(typeEnv);
		if (!(expressionType.isCompatibleToTypeInt())) {
			addError("Invalid type for -");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(NEq neq) {
		
		boolean checkLeft = neq.getLeft().accept(this);
		boolean checkRight = neq.getRight().accept(this);
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = neq.getLeft().typeOf(typeEnv);
		Type rightType = neq.getRight().typeOf(typeEnv);
		if (!(leftType.isCompatibleToTypeInt() && rightType.isCompatibleToTypeInt())) {
			addError("Invalid type for !=");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Not not) {
		
		boolean checkExpression = not.getExpression().accept(this);
		if (!(checkExpression)) {
			return false;
		}
		
		Type expressionType = not.getExpression().typeOf(typeEnv);
		if (!(expressionType.isCompatibleToTypeBool())) {
			addError("Invalid type for !");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Or or) {
		
		boolean checkLeft = or.getLeft().accept(this);
		boolean checkRight = or.getRight().accept(this);
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = or.getLeft().typeOf(typeEnv);
		Type rightType = or.getRight().typeOf(typeEnv);
		if (!(leftType.isCompatibleToTypeBool() && rightType.isCompatibleToTypeBool())) {
			addError("Invalid type for |");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Pos pos) {
		
		boolean checkExpression = pos.getExpression().accept(this);
		if (!(checkExpression)) {
			return false;
		}
		
		Type expressionType = pos.getExpression().typeOf(typeEnv);
		if (!(expressionType.isCompatibleToTypeInt())) {
			addError("Invalid type for +");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Sub sub) {
		
		boolean checkLeft = sub.getLeft().accept(this);
		boolean checkRight = sub.getRight().accept(this);
		if (!(checkLeft && checkRight)) {
			return false;
		}
		
		Type leftType = sub.getLeft().typeOf(typeEnv);
		Type rightType = sub.getRight().typeOf(typeEnv);
		if (!(leftType.isCompatibleToTypeInt() && rightType.isCompatibleToTypeInt())) {
			addError("Invalid type for -");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Ident ident) {
		return true;
	}

	@Override
	public Boolean visit(BoolValue bool) {
		return true;
	}

	@Override
	public Boolean visit(Int integer) {
		return true;
	}

	@Override
	public Boolean visit(StringValue stringValue) {
		return true;
	}

}