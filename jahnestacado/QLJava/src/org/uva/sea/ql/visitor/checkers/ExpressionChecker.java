package org.uva.sea.ql.visitor.checkers;

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
import org.uva.sea.ql.ast.values.BoolLit;
import org.uva.sea.ql.ast.values.Decimal;
import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.StringLit;
import org.uva.sea.ql.visitor.Visitor;



public class ExpressionChecker implements Visitor {
	private final Map<Ident, Type> declaredVar;
	private final List<String> errorReport;
	static int i = 0;

	public ExpressionChecker(Map<Ident, Type> declaredVar, List<String> errorReport) {
		this.declaredVar = declaredVar;
		this.errorReport = errorReport;
	}

	public static boolean check(Expr expr, Map<Ident, Type> typeEnv,
			List<String> errs) {
		ExpressionChecker check = new ExpressionChecker(typeEnv, errs);
		return expr.accept(check);
	}

	@Override
	public boolean visit(Add node) {

		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToNumericType() && rightExprType.isCompatibleToNumericType())) {
		errorReport.add("Invalid type for '+'. Both operands must be of the Numeric type");
			return false;
		}

		return true;
	}

	@Override
	public boolean visit(And node) {

		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToBoolType() && rightExprType.isCompatibleToBoolType())) {
			errorReport.add("Invalid type for '&&'. Both operands must be of the Boolean type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(Div node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToNumericType() && rightExprType
				.isCompatibleToNumericType())) {
			errorReport.add("Invalid type for '/'. Both operands must be of the Numeric type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(Eq node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.getClass() == rightExprType.getClass())) {
			errorReport.add("Invalid type for '=='. Both operands must be of the same type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(GEq node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToNumericType() && rightExprType
				.isCompatibleToNumericType())) {
			errorReport.add("Invalid type for '>='. Both operands must be of the Numeric type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(GT node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToNumericType() && rightExprType
				.isCompatibleToNumericType())) {
			errorReport.add("Invalid type for '>'. Both operands must be of the Numeric type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(Ident node) {

		return true;
	}

	@Override
	public boolean visit(LEq node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToNumericType() && rightExprType
				.isCompatibleToNumericType())) {
			errorReport.add("Invalid type for '<='. Both operands must be of the Numeric type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(LT node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToNumericType() && rightExprType
				.isCompatibleToNumericType())) {
			errorReport.add("Invalid type for '>'. Both operands must be of the Numeric type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(Mul node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToNumericType() && rightExprType
				.isCompatibleToNumericType())) {
			errorReport.add("Invalid type for '*'. Both operands must be of the Numeric type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(Neg node) {
		boolean leftExpr = node.getLeftExpr().accept(this);

		if (!leftExpr) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);

		if (!leftExprType.isCompatibleToNumericType()) {
			errorReport.add("Invalid type for '-'. Right operand must be of the Numeric type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(NEq node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.getClass() == rightExprType.getClass())) {
			errorReport.add("Invalid type for '!='. Both operands must be of the same type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(Not node) {
		boolean leftExpr = node.getLeftExpr().accept(this);

		if (!leftExpr) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);

		if (!leftExprType.isCompatibleToBoolType()) {
			errorReport.add("Invalid type for '!'. Right operand must be of the Boolean type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(Or node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToBoolType() && rightExprType.isCompatibleToBoolType())) {
			errorReport.add("Invalid type for '||'. Both operands must be of the Boolean type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(Pos node) {
		boolean leftExpr = node.getLeftExpr().accept(this);

		if (!leftExpr) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);

		if (!leftExprType.isCompatibleToNumericType()) {
			errorReport.add("Invalid type for '+'. Right operand must be of the Numeric type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(Sub node) {
		boolean leftExpr = node.getLeftExpr().accept(this);
		boolean rightExpr = node.getRightExpr().accept(this);

		if (!(leftExpr && rightExpr)) {
			return false;
		}

		Type leftExprType = node.getLeftExpr().isOfType(declaredVar);
		Type rightExprType = node.getRightExpr().isOfType(declaredVar);

		if (!(leftExprType.isCompatibleToNumericType() && rightExprType.isCompatibleToNumericType())) {
			errorReport.add("Invalid type for '-'. Both operands must be of the Numeric type");
			return false;
		}

		return true;

	}

	@Override
	public boolean visit(Int node) {
		return true;

	}

	@Override
	public boolean visit(BoolLit node) {
		return true;
	}

	@Override
	public boolean visit(Decimal node) {
		return true;

	}

	@Override
	public boolean visit(StringLit node) {
		return true;

	}

	

	public List<String> getErrors() {
		return errorReport;
	}

}
