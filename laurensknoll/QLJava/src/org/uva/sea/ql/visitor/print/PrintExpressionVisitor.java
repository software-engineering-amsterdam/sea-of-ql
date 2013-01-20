package org.uva.sea.ql.visitor.print;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.expr.type.BoolExprType;
import org.uva.sea.ql.ast.expr.type.IdentExprType;
import org.uva.sea.ql.ast.expr.type.IntExprType;
import org.uva.sea.ql.ast.expr.type.MoneyExprType;
import org.uva.sea.ql.ast.expr.type.StringExprType;
import org.uva.sea.ql.visitor.ExpressionVisitor;
import org.uva.sea.ql.visitor.VisitorResult;

public class PrintExpressionVisitor implements ExpressionVisitor {

	@Override
	public VisitorResult visit(Add add) {
		System.out.println("Visiting Add Expression");

		// Visit items
		ExpressionVisitor expressionVisitor = new PrintExpressionVisitor();
		add.getLeftHandSideExpression().accept(expressionVisitor);
		add.getRightHandSideExpression().accept(expressionVisitor);

		return null;
	}

	@Override
	public VisitorResult visit(And and) {
		System.out.println("Visiting And Expression");

		// Visit items
		ExpressionVisitor expressionVisitor = new PrintExpressionVisitor();
		and.getLeftHandSideExpression().accept(expressionVisitor);
		and.getRightHandSideExpression().accept(expressionVisitor);

		return null;
	}

	@Override
	public VisitorResult visit(Div div) {
		System.out.println("Visiting Div Expression");

		// Visit items
		ExpressionVisitor expressionVisitor = new PrintExpressionVisitor();
		div.getLeftHandSideExpression().accept(expressionVisitor);
		div.getRightHandSideExpression().accept(expressionVisitor);

		return null;
	}

	@Override
	public VisitorResult visit(Eq eq) {
		System.out.println("Visiting Eq Expression");

		// Visit items
		ExpressionVisitor expressionVisitor = new PrintExpressionVisitor();
		eq.getLeftHandSideExpression().accept(expressionVisitor);
		eq.getRightHandSideExpression().accept(expressionVisitor);

		return null;
	}

	@Override
	public VisitorResult visit(GEq geq) {
		System.out.println("Visiting GEq Expression");

		// Visit items
		ExpressionVisitor expressionVisitor = new PrintExpressionVisitor();
		geq.getLeftHandSideExpression().accept(expressionVisitor);
		geq.getRightHandSideExpression().accept(expressionVisitor);

		return null;
	}

	@Override
	public VisitorResult visit(GT gt) {
		System.out.println("Visiting GT Expression");

		// Visit items
		ExpressionVisitor expressionVisitor = new PrintExpressionVisitor();
		gt.getLeftHandSideExpression().accept(expressionVisitor);
		gt.getRightHandSideExpression().accept(expressionVisitor);

		return null;
	}

	@Override
	public VisitorResult visit(LEq leq) {
		System.out.println("Visiting LEq Expression");

		// Visit items
		ExpressionVisitor expressionVisitor = new PrintExpressionVisitor();
		leq.getLeftHandSideExpression().accept(expressionVisitor);
		leq.getRightHandSideExpression().accept(expressionVisitor);

		return null;
	}

	@Override
	public VisitorResult visit(LT lt) {
		System.out.println("Visiting LT Expression");

		// Visit items
		ExpressionVisitor expressionVisitor = new PrintExpressionVisitor();
		lt.getLeftHandSideExpression().accept(expressionVisitor);
		lt.getRightHandSideExpression().accept(expressionVisitor);

		return null;
	}

	@Override
	public VisitorResult visit(Mul mul) {
		System.out.println("Visiting Mul Expression");

		// Visit items
		ExpressionVisitor expressionVisitor = new PrintExpressionVisitor();
		mul.getLeftHandSideExpression().accept(expressionVisitor);
		mul.getRightHandSideExpression().accept(expressionVisitor);

		return null;
	}

	@Override
	public VisitorResult visit(Neg neg) {
		System.out.println("Visiting Neg Expression");

		// Visit items
		ExpressionVisitor expressionVisitor = new PrintExpressionVisitor();
		neg.getExpression().accept(expressionVisitor);

		return null;
	}

	@Override
	public VisitorResult visit(NEq neq) {
		System.out.println("Visiting NEq Expression");

		// Visit items
		ExpressionVisitor expressionVisitor = new PrintExpressionVisitor();
		neq.getLeftHandSideExpression().accept(expressionVisitor);
		neq.getRightHandSideExpression().accept(expressionVisitor);

		return null;
	}

	@Override
	public VisitorResult visit(Not not) {
		System.out.println("Visiting Not Expression");

		// Visit items
		ExpressionVisitor expressionVisitor = new PrintExpressionVisitor();
		not.getExpression().accept(expressionVisitor);

		return null;
	}

	@Override
	public VisitorResult visit(Or or) {
		System.out.println("Visiting Or Expression");

		// Visit items
		ExpressionVisitor expressionVisitor = new PrintExpressionVisitor();
		or.getLeftHandSideExpression().accept(expressionVisitor);
		or.getRightHandSideExpression().accept(expressionVisitor);

		return null;
	}

	@Override
	public VisitorResult visit(Pos pos) {
		System.out.println("Visiting Pos Expression");

		// Visit items
		ExpressionVisitor expressionVisitor = new PrintExpressionVisitor();
		pos.getExpression().accept(expressionVisitor);

		return null;
	}

	@Override
	public VisitorResult visit(Sub sub) {
		System.out.println("Visiting Sub Expression");

		// Visit items
		ExpressionVisitor expressionVisitor = new PrintExpressionVisitor();
		sub.getLeftHandSideExpression().accept(expressionVisitor);
		sub.getRightHandSideExpression().accept(expressionVisitor);

		return null;
	}

	@Override
	public VisitorResult visit(BoolExprType bool) {
		System.out.println("Visiting Bool Expression Type");

		return null;
	}

	@Override
	public VisitorResult visit(IdentExprType ident) {
		System.out.println("Visiting Ident Expression Type");

		return null;
	}

	@Override
	public VisitorResult visit(IntExprType intType) {
		System.out.println("Visiting Int Expression Type");

		return null;
	}

	@Override
	public VisitorResult visit(MoneyExprType money) {
		System.out.println("Visiting Money Expression Type");

		return null;
	}

	@Override
	public VisitorResult visit(StringExprType string) {
		System.out.println("Visiting String Expression Type");

		return null;
	}

}
