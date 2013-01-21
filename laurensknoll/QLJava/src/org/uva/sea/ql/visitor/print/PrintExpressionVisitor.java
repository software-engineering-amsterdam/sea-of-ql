package org.uva.sea.ql.visitor.print;

import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.And;
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
import org.uva.sea.ql.ast.expr.type.BoolExprType;
import org.uva.sea.ql.ast.expr.type.IdentExprType;
import org.uva.sea.ql.ast.expr.type.IntExprType;
import org.uva.sea.ql.ast.expr.type.MoneyExprType;
import org.uva.sea.ql.ast.expr.type.StringExprType;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class PrintExpressionVisitor implements ExpressionVisitor<Boolean> {

	@Override
	public Boolean visit(Add add) {
		System.out.println("Visiting Add Expression");

		// Visit items
		ExpressionVisitor<Boolean> expressionVisitor = new PrintExpressionVisitor();
		add.getLeftHandSideExpression().accept(expressionVisitor);
		add.getRightHandSideExpression().accept(expressionVisitor);

		return true;
	}

	@Override
	public Boolean visit(And and) {
		System.out.println("Visiting And Expression");

		// Visit items
		ExpressionVisitor<Boolean> expressionVisitor = new PrintExpressionVisitor();
		and.getLeftHandSideExpression().accept(expressionVisitor);
		and.getRightHandSideExpression().accept(expressionVisitor);

		return true;
	}

	@Override
	public Boolean visit(Div div) {
		System.out.println("Visiting Div Expression");

		// Visit items
		ExpressionVisitor<Boolean> expressionVisitor = new PrintExpressionVisitor();
		div.getLeftHandSideExpression().accept(expressionVisitor);
		div.getRightHandSideExpression().accept(expressionVisitor);

		return true;
	}

	@Override
	public Boolean visit(Eq eq) {
		System.out.println("Visiting Eq Expression");

		// Visit items
		ExpressionVisitor<Boolean> expressionVisitor = new PrintExpressionVisitor();
		eq.getLeftHandSideExpression().accept(expressionVisitor);
		eq.getRightHandSideExpression().accept(expressionVisitor);

		return true;
	}

	@Override
	public Boolean visit(GEq geq) {
		System.out.println("Visiting GEq Expression");

		// Visit items
		ExpressionVisitor<Boolean> expressionVisitor = new PrintExpressionVisitor();
		geq.getLeftHandSideExpression().accept(expressionVisitor);
		geq.getRightHandSideExpression().accept(expressionVisitor);

		return true;
	}

	@Override
	public Boolean visit(GT gt) {
		System.out.println("Visiting GT Expression");

		// Visit items
		ExpressionVisitor<Boolean> expressionVisitor = new PrintExpressionVisitor();
		gt.getLeftHandSideExpression().accept(expressionVisitor);
		gt.getRightHandSideExpression().accept(expressionVisitor);

		return true;
	}

	@Override
	public Boolean visit(LEq leq) {
		System.out.println("Visiting LEq Expression");

		// Visit items
		ExpressionVisitor<Boolean> expressionVisitor = new PrintExpressionVisitor();
		leq.getLeftHandSideExpression().accept(expressionVisitor);
		leq.getRightHandSideExpression().accept(expressionVisitor);

		return true;
	}

	@Override
	public Boolean visit(LT lt) {
		System.out.println("Visiting LT Expression");

		// Visit items
		ExpressionVisitor<Boolean> expressionVisitor = new PrintExpressionVisitor();
		lt.getLeftHandSideExpression().accept(expressionVisitor);
		lt.getRightHandSideExpression().accept(expressionVisitor);

		return true;
	}

	@Override
	public Boolean visit(Mul mul) {
		System.out.println("Visiting Mul Expression");

		// Visit items
		ExpressionVisitor<Boolean> expressionVisitor = new PrintExpressionVisitor();
		mul.getLeftHandSideExpression().accept(expressionVisitor);
		mul.getRightHandSideExpression().accept(expressionVisitor);

		return true;
	}

	@Override
	public Boolean visit(Neg neg) {
		System.out.println("Visiting Neg Expression");

		// Visit items
		ExpressionVisitor<Boolean> expressionVisitor = new PrintExpressionVisitor();
		neg.getExpression().accept(expressionVisitor);

		return true;
	}

	@Override
	public Boolean visit(NEq neq) {
		System.out.println("Visiting NEq Expression");

		// Visit items
		ExpressionVisitor<Boolean> expressionVisitor = new PrintExpressionVisitor();
		neq.getLeftHandSideExpression().accept(expressionVisitor);
		neq.getRightHandSideExpression().accept(expressionVisitor);

		return true;
	}

	@Override
	public Boolean visit(Not not) {
		System.out.println("Visiting Not Expression");

		// Visit items
		ExpressionVisitor<Boolean> expressionVisitor = new PrintExpressionVisitor();
		not.getExpression().accept(expressionVisitor);

		return true;
	}

	@Override
	public Boolean visit(Or or) {
		System.out.println("Visiting Or Expression");

		// Visit items
		ExpressionVisitor<Boolean> expressionVisitor = new PrintExpressionVisitor();
		or.getLeftHandSideExpression().accept(expressionVisitor);
		or.getRightHandSideExpression().accept(expressionVisitor);

		return true;
	}

	@Override
	public Boolean visit(Pos pos) {
		System.out.println("Visiting Pos Expression");

		// Visit items
		ExpressionVisitor<Boolean> expressionVisitor = new PrintExpressionVisitor();
		pos.getExpression().accept(expressionVisitor);

		return true;
	}

	@Override
	public Boolean visit(Sub sub) {
		System.out.println("Visiting Sub Expression");

		// Visit items
		ExpressionVisitor<Boolean> expressionVisitor = new PrintExpressionVisitor();
		sub.getLeftHandSideExpression().accept(expressionVisitor);
		sub.getRightHandSideExpression().accept(expressionVisitor);

		return true;
	}

	@Override
	public Boolean visit(BoolExprType bool) {
		System.out.println("Visiting Bool Expression Type");

		return true;
	}

	@Override
	public Boolean visit(IdentExprType ident) {
		System.out.println("Visiting Ident Expression Type");

		return true;
	}

	@Override
	public Boolean visit(IntExprType intType) {
		System.out.println("Visiting Int Expression Type");

		return true;
	}

	@Override
	public Boolean visit(MoneyExprType money) {
		System.out.println("Visiting Money Expression Type");

		return true;
	}

	@Override
	public Boolean visit(StringExprType string) {
		System.out.println("Visiting String Expression Type");

		return true;
	}

}
