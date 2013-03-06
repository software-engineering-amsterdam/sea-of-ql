package org.uva.sea.ql.visitors.typechecking;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.And;
import org.uva.sea.ql.ast.expr.binary.BinaryExpr;
import org.uva.sea.ql.ast.expr.binary.Div;
import org.uva.sea.ql.ast.expr.binary.Eq;
import org.uva.sea.ql.ast.expr.binary.GEq;
import org.uva.sea.ql.ast.expr.binary.GT;
import org.uva.sea.ql.ast.expr.binary.LEq;
import org.uva.sea.ql.ast.expr.binary.LT;
import org.uva.sea.ql.ast.expr.binary.Mul;
import org.uva.sea.ql.ast.expr.binary.NEq;
import org.uva.sea.ql.ast.expr.binary.Or;
import org.uva.sea.ql.ast.expr.binary.Sub;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.ast.expr.unary.UnaryExpr;
import org.uva.sea.ql.ast.expr.value.BoolLiteral;
import org.uva.sea.ql.ast.expr.value.IntLiteral;
import org.uva.sea.ql.ast.expr.value.MoneyLiteral;
import org.uva.sea.ql.ast.expr.value.StringLiteral;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitors.IExprVisitor;
import org.uva.sea.ql.visitors.utils.Errors;
import org.uva.sea.ql.visitors.utils.State;

public class ExprChecker implements IExprVisitor<Boolean> {

	private final State state;
	private final Errors errors;

	private ExprChecker(State state, Errors errors) {
		this.state = state;
		this.errors = errors;
	}

	public static boolean check(Expr expr, State state, Errors errors) {
		ExprChecker check = new ExprChecker(state, errors);
		return expr.accept(check);
	}

	@Override
	public Boolean visit(Ident node) {
		if (!state.hasRegisteredType(node.getStringName())) {
			errors.addError("Ident " + node.getStringName() + " is not declared.");
		}
		return true;
	}

	@Override
	public Boolean visit(Add node) {
		checkSubtrees(node);
		areBothSidesCompatible(node, "+");
		areBothSidesCompatibleToNumeric(node, "+");
		return true;
	}

	@Override
	public Boolean visit(And node) {
		checkSubtrees(node);
		areBothSidesCompatibleToBoolean(node, "&&");
		return true;
	}

	@Override
	public Boolean visit(Div node) {
		checkSubtrees(node);
		areBothSidesCompatible(node, "/");
		areBothSidesCompatibleToNumeric(node, "/");
		return true;
	}

	@Override
	public Boolean visit(Eq node) {
		checkSubtrees(node);
		areBothSidesCompatible(node, "==");
		return true;
	}

	@Override
	public Boolean visit(GEq node) {
		checkSubtrees(node);
		areBothSidesCompatible(node, ">=");
		areBothSidesCompatibleToNumeric(node, ">=");
		return true;
	}

	@Override
	public Boolean visit(GT node) {
		checkSubtrees(node);
		areBothSidesCompatible(node, ">");
		areBothSidesCompatibleToNumeric(node, ">");
		return true;
	}

	@Override
	public Boolean visit(LEq node) {
		checkSubtrees(node);
		areBothSidesCompatible(node, "<=");
		areBothSidesCompatibleToNumeric(node, "<=");
		return true;
	}

	@Override
	public Boolean visit(LT node) {
		checkSubtrees(node);
		areBothSidesCompatible(node, "<");
		areBothSidesCompatibleToNumeric(node, "<");
		return true;
	}

	@Override
	public Boolean visit(Mul node) {
		checkSubtrees(node);
		areBothSidesCompatible(node, "*");
		areBothSidesCompatibleToNumeric(node, "*");
		return true;
	}

	@Override
	public Boolean visit(Neg node) {
		checkArgument(node);
		isArgumentNumeric(node, "-");
		return true;
	}

	@Override
	public Boolean visit(NEq node) {
		checkSubtrees(node);
		areBothSidesCompatible(node, "!=");
		return true;
	}

	@Override
	public Boolean visit(Not node) {
		checkArgument(node);
		isArgumentBoolean(node, "!");
		return true;
	}

	@Override
	public Boolean visit(Or node) {
		checkSubtrees(node);
		areBothSidesCompatibleToBoolean(node, "||");
		return true;
	}

	@Override
	public Boolean visit(Pos node) {
		checkArgument(node);
		isArgumentNumeric(node, "+");
		return true;
	}

	@Override
	public Boolean visit(Sub node) {
		checkSubtrees(node);
		areBothSidesCompatible(node, "-");
		areBothSidesCompatibleToNumeric(node, "-");
		return true;
	}

	@Override
	public Boolean visit(BoolLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(MoneyLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(StringLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(IntLiteral node) {
		return true;
	}

	private boolean checkSubtrees(BinaryExpr node) {
		if (!(node.getLhs().accept(this) && node.getRhs().accept(this))) {
			return false;
		}
		return true;
	}

	private boolean checkArgument(UnaryExpr node) {
		if (!node.getArg().accept(this)) {
			return false;
		}
		return true;
	}

	private boolean isArgumentNumeric(UnaryExpr node, String operator) {
		Type argumentType = node.getArg().typeOf(state.getTypeEnv());
		if (!argumentType.isCompatibleToNumeric()) {
			errors.addError("Invalid type for unary " + operator + ". Expected NumericType but got " + argumentType.getClass().getSimpleName() + ".");
			return false;
		}
		return true;
	}

	private boolean isArgumentBoolean(UnaryExpr node, String operator) {
		Type argumentType = node.getArg().typeOf(state.getTypeEnv());
		if (!argumentType.isCompatibleToBoolType()) {
			errors.addError("Invalid type for unary " + operator + ". Expected BoolType but got " + argumentType.getClass().getSimpleName() + ".");
			return false;
		}
		return true;
	}
	
	/*
	 * In some cases both areBothSidesCompatible(BinaryExpr node, String operator)
	 * and areBothSidesCompatibleToNumeric(BinaryExpr node, String operator) are used.
	 * This is due to the fact that int and money are not compatible. The first method 
	 * is used to ensure that the expression's arguments will be either both ints or both money
	 * and the second check ensures that we dont have bools and strings
	 */

	private boolean areBothSidesCompatible(BinaryExpr node, String operator) {
		Type lhsType = node.getLhs().typeOf(state.getTypeEnv());
		Type rhsType = node.getRhs().typeOf(state.getTypeEnv()); 
		if (!(lhsType.isCompatibleTo(rhsType))) {
			errors.addError("Both arguments must have the same type for binary " + operator + ". Got " + lhsType.getClass().getSimpleName() + " " + operator + " " + rhsType.getClass().getSimpleName() + ".");
			return false;
		}
		return true;
	}

	private boolean areBothSidesCompatibleToNumeric(BinaryExpr node, String operator) {
		Type lhsType = node.getLhs().typeOf(state.getTypeEnv());
		Type rhsType = node.getRhs().typeOf(state.getTypeEnv());
		if (!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) { 
			errors.addError("Invalid types for binary " + operator + ". BoolTypes are not allowed for this operator.");
			return false;
		}
		return true;
	}

	private boolean areBothSidesCompatibleToBoolean(BinaryExpr node, String operator) {
		Type lhsType = node.getLhs().typeOf(state.getTypeEnv());
		Type rhsType = node.getRhs().typeOf(state.getTypeEnv());
		if (!(lhsType.isCompatibleToBoolType() && rhsType.isCompatibleToBoolType())) {
			errors.addError("Invalid types for binary " + operator + ". Numeric Types are not allowed for this operator.");
			return false;
		}
		return true;
	}

}
