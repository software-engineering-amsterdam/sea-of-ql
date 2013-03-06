package org.uva.sea.ql.checkers;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.IExprVisitor;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.BinaryExpr;
import org.uva.sea.ql.ast.expr.BoolLiteral;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.IntLiteral;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.StringLiteral;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.errors.QLError;

public class ExprTypeChecker implements IExprVisitor<Boolean> {

	private final Map<String, Type> typeEnvironment;
	// private final List<String> errors;
	private final List<QLError> errors;

	public ExprTypeChecker(Map<String, Type> typeEnvironment,
			List<QLError> errors) {

		this.typeEnvironment = typeEnvironment;
		this.errors = errors;
	}

	public List<QLError> getErrors() {
		return errors;
	}

	public static boolean check(Expr expr, Map<String, Type> typeEnvironment,
			List<QLError> errors) {

		ExprTypeChecker typeChecker = new ExprTypeChecker(typeEnvironment,
				errors);
		return expr.accept(typeChecker);

	}

	private void addError(String operator) {

		errors.add(new QLError("The operands of \"" + operator
				+ "\" are not compatible"));
	}

	private boolean checkSubTrees(BinaryExpr node) {

		boolean checkLeft = node.getLeft().accept(this);
		boolean checkRight = node.getRight().accept(this);

		if (!(checkLeft && checkRight)) {
			return false;
		}
		return true;
	}

	private boolean numericTypeCheck(BinaryExpr node, String operator) {

		Type leftType = node.getLeft().isOfType(typeEnvironment);
		Type rightType = node.getRight().isOfType(typeEnvironment);

		if (!(leftType.isCompatibleToNumeric() && rightType
				.isCompatibleToNumeric())) {
			addError(operator);
			return false;
		}
		return true;
	}

	private boolean boolTypeCheck(BinaryExpr node, String operator) {

		Type leftType = node.getLeft().isOfType(typeEnvironment);
		Type rightType = node.getRight().isOfType(typeEnvironment);

		if (!(leftType.isCompatibleToBool() && rightType.isCompatibleToBool())) {
			addError(operator);
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Add node) {

		// check sub-trees
		if (!checkSubTrees(node)) {
			return false;
		}
		// check required types for "+"
		if (!numericTypeCheck(node, "+")) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(And node) {

		// check sub-trees
		if (!checkSubTrees(node)) {
			return false;
		}
		// check required types for "&&"
		if (!boolTypeCheck(node, "&&")) {
			return false;
		}
		return true;

	}

	@Override
	public Boolean visit(Div node) {

		// check sub-trees
		if (!checkSubTrees(node)) {
			return false;
		}
		// check required types for "/"
		if (!numericTypeCheck(node, "/")) {
			return false;
		}
		return true;

	}

	@Override
	public Boolean visit(Eq node) {

		// check sub-trees
		if (!checkSubTrees(node)) {
			return false;
		}
		// check required types for "=="
		if (!numericTypeCheck(node, "==")) {
			return false;
		}
		return true;

	}

	@Override
	public Boolean visit(GEq node) {

		// check sub-trees
		if (!checkSubTrees(node)) {
			return false;
		}
		// check required types for ">="
		if (!numericTypeCheck(node, ">=")) {
			return false;
		}
		return true;

	}

	@Override
	public Boolean visit(GT node) {

		// check sub-trees
		if (!checkSubTrees(node)) {
			return false;
		}
		// check required types for ">"
		if (!numericTypeCheck(node, ">")) {
			return false;
		}
		return true;

	}

	@Override
	public Boolean visit(Ident node) {

		if (node.isOfType(typeEnvironment).isCompatibleToUndefined()) {
			errors.add(new QLError("Variable " + node.getName()
					+ " is undefined "));
			return false;
		}

		return true;

	}

	@Override
	public Boolean visit(IntLiteral node) {
		return true;

	}

	@Override
	public Boolean visit(LEq node) {

		// check sub-trees
		if (!checkSubTrees(node)) {
			return false;
		}
		// check required types for "<="
		if (!numericTypeCheck(node, "<=")) {
			return false;
		}
		return true;

	}

	@Override
	public Boolean visit(LT node) {

		// check sub-trees
		if (!checkSubTrees(node)) {
			return false;
		}
		// check required types for "<"
		if (!numericTypeCheck(node, "<")) {
			return false;
		}
		return true;

	}

	@Override
	public Boolean visit(Mul node) {

		// check sub-trees
		if (!checkSubTrees(node)) {
			return false;
		}
		// check required types for "*"
		if (!numericTypeCheck(node, "*")) {
			return false;
		}
		return true;

	}

	@Override
	public Boolean visit(Neg node) {

		Type arg = node.getArg().isOfType(typeEnvironment);

		if (!(arg.isCompatibleToNumeric())) {

			addError("-");
			return false;
		}

		return true;

	}

	@Override
	public Boolean visit(NEq node) {

		// check sub-trees
		if (!checkSubTrees(node)) {
			return false;
		}
		// check required types for "!="
		if (!numericTypeCheck(node, "!=")) {
			return false;
		}
		return true;

	}

	@Override
	public Boolean visit(Not node) {

		Type arg = node.getArg().isOfType(typeEnvironment);

		if (!(arg.isCompatibleToBool())) {

			addError("!");
			return false;
		}

		return true;

	}

	@Override
	public Boolean visit(Or node) {

		// check sub-trees
		if (!checkSubTrees(node)) {
			return false;
		}
		// check required types for "||"
		if (!boolTypeCheck(node, "||")) {
			return false;
		}
		return true;

	}

	@Override
	public Boolean visit(Pos node) {

		Type arg = node.getArg().isOfType(typeEnvironment);

		if (!(arg.isCompatibleToNumeric())) {

			addError("+");
			return false;
		}

		return true;

	}

	@Override
	public Boolean visit(Sub node) {

		// check sub-trees
		if (!checkSubTrees(node)) {
			return false;
		}
		// check required types for "-"
		if (!numericTypeCheck(node, "-")) {
			return false;
		}
		return true;

	}

	@Override
	public Boolean visit(BoolLiteral node) {
		return true;

	}

	@Override
	public Boolean visit(StringLiteral node) {
		return true;

	}

}