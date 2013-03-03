package org.uva.sea.ql.checker;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.binary.Arithmetic;
import org.uva.sea.ql.ast.expression.binary.Comparison;
import org.uva.sea.ql.ast.expression.binary.Logic;
import org.uva.sea.ql.ast.expression.binary.arithmetic.*;
import org.uva.sea.ql.ast.expression.binary.comparison.*;
import org.uva.sea.ql.ast.expression.binary.logic.*;
import org.uva.sea.ql.ast.expression.unary.*;
import org.uva.sea.ql.ast.expression.value.Bool;
import org.uva.sea.ql.ast.expression.value.Int;
import org.uva.sea.ql.ast.expression.value.Str;

public class ExpressionChecker implements org.uva.sea.ql.ast.expression.Visitor<Void> {

	private Environment environment;

	public ExpressionChecker(Environment environment) {
		this.environment = environment;
	}

	private Void checkUnary(Unary ast, Type type) {
		Expression expr = ast.getExpression();
		Type exprType = expr.typeOf(environment.getTypeEnv());

		if (!type.isCompatibleTo(exprType))
			addError(ast.getOperatorSymbol() + " Incompatible type (required: " + type + "; got: " + exprType + ")");
		return null;
	}

	private Void checkUnaryInt(Unary ast) {
		return checkUnary(ast, new org.uva.sea.ql.ast.type.Int());
	}

	private Void checkUnaryBool(Unary ast) {
		return checkUnary(ast, new org.uva.sea.ql.ast.type.Bool());
	}

	private Void checkArithmetic(Arithmetic expr) {
		Type exprType = new org.uva.sea.ql.ast.type.Int();
		checkBinary(expr, exprType);
		return null;
	}

	private Void checkComparison(Comparison expr) {
		Type exprType = new org.uva.sea.ql.ast.type.Int();
		checkBinary(expr, exprType);
		return null;
	}

	private Void checkLogic(Logic expr) {
		Type exprType = new org.uva.sea.ql.ast.type.Bool();
		checkBinary(expr, exprType);
		return null;
	}

	private Void checkBinary(Binary expr, Type exprType) {
		Expression lhs = expr.getLhs();
		Expression rhs = expr.getRhs();
		Type lhsType = lhs.typeOf(environment.getTypeEnv());
		Type rhsType = rhs.typeOf(environment.getTypeEnv());
		if (!(exprType.isCompatibleTo(lhsType) && exprType.isCompatibleTo(rhsType)))
			addError(expr.getOperatorSymbol() + " Incompatible types (required: " + exprType + "; got: " + lhsType + " and " + rhsType + ")");
		return null;
	}

	@Override
	public Void visit(Add ast) {
		return checkArithmetic(ast);
	}

	@Override
	public Void visit(And ast) {
		return checkLogic(ast);
	}

	@Override
	public Void visit(Div ast) {
		return checkArithmetic(ast);
	}

	@Override
	public Void visit(Eq ast) {
		return checkComparison(ast);
	}

	@Override
	public Void visit(GEq ast) {
		return checkComparison(ast);
	}

	@Override
	public Void visit(GT ast) {
		return checkComparison(ast);
	}

	@Override
	public Void visit(LEq ast) {
		return checkComparison(ast);
	}

	@Override
	public Void visit(LT ast) {
		return checkComparison(ast);
	}

	@Override
	public Void visit(Mul ast) {
		return checkArithmetic(ast);
	}

	@Override
	public Void visit(Neg ast) {
		return checkUnaryInt(ast);
	}

	@Override
	public Void visit(NEq ast) {
		return checkComparison(ast);
	}

	@Override
	public Void visit(Not ast) {
		return checkUnaryBool(ast);
	}

	@Override
	public Void visit(Or ast) {
		return checkLogic(ast);
	}

	@Override
	public Void visit(Pos ast) {
		return checkUnaryInt(ast);
	}

	@Override
	public Void visit(Sub ast) {
		return checkArithmetic(ast);
	}

	@Override
	public Void visit(Bool ast) {
		return null;
	}

	@Override
	public Void visit(Str ast) {
		return null;
	}

	@Override
	public Void visit(Int ast) {
		return null;
	}

	@Override
	public Void visit(Ident ast) {
		return null;
	}

	private void addError(String message) {
		environment.addError(message);
	}

}
