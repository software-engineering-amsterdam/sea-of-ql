package org.uva.sea.ql.visitor.printer;

import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.And;
import org.uva.sea.ql.ast.expr.binary.Binary;
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
import org.uva.sea.ql.ast.expr.primary.Bool;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.expr.primary.Int;
import org.uva.sea.ql.ast.expr.primary.Primary;
import org.uva.sea.ql.ast.expr.primary.StringLiteral;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.ast.expr.unary.Unary;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class ExpressionVisitorPrinter implements IExpressionVisitor<Boolean> {

	@Override
	public Boolean visit(Add ast) {
		runBinaryExpr(ast);
		return true;
	}

	@Override
	public Boolean visit(And ast) {
		runBinaryExpr(ast);
		return true;
	}

	@Override
	public Boolean visit(Div ast) {
		runBinaryExpr(ast);
		return true;
	}

	@Override
	public Boolean visit(Eq ast) {
		runBinaryExpr(ast);
		return true;
	}

	@Override
	public Boolean visit(GEq ast) {
		runBinaryExpr(ast);
		return true;
	}

	@Override
	public Boolean visit(GT ast) {
		runBinaryExpr(ast);
		return true;
	}

	@Override
	public Boolean visit(LEq ast) {
		runBinaryExpr(ast);
		return true;
	}

	@Override
	public Boolean visit(LT ast) {
		runBinaryExpr(ast);
		return true;
	}

	@Override
	public Boolean visit(Mul ast) {
		runBinaryExpr(ast);
		return true;
	}

	@Override
	public Boolean visit(NEq ast) {
		runBinaryExpr(ast);
		return true;
	}

	@Override
	public Boolean visit(Or ast) {
		runBinaryExpr(ast);
		return true;
	}

	@Override
	public Boolean visit(Sub ast) {
		runBinaryExpr(ast);
		return true;
	}

	@Override
	public Boolean visit(Neg ast) {
		runUnaryExpr(ast);
		return true;
	}

	@Override
	public Boolean visit(Not ast) {
		runUnaryExpr(ast);
		return true;
	}

	@Override
	public Boolean visit(Pos ast) {
		runUnaryExpr(ast);
		return true;
	}

	@Override
	public Boolean visit(Bool ast) {
		printPrimaryValue(ast);
		return true;
	}

	@Override
	public Boolean visit(Ident ast) {
		System.out.println(ast.toString() + ": " + ast.getName());
		return true;
	}

	@Override
	public Boolean visit(Int ast) {
		printPrimaryValue(ast);
		return true;
	}

	@Override
	public Boolean visit(StringLiteral ast) {
		printPrimaryValue(ast);
		return true;
	}
	
	private void runBinaryExpr(Binary ast) {
		System.out.println(ast.toString());
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
	}
	
	private void runUnaryExpr(Unary ast) {
		System.out.println(ast.toString());
		ast.getArg().accept(this);
	}
	
	private void printPrimaryValue(Primary<?> ast) {
		System.out.println(ast.toString() + ": " + ast.getValue());
	}

}