package org.uva.sea.ql.visitor.print;

import org.uva.sea.ql.ast.expr.atom.Bool;
import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.expr.atom.Int;
import org.uva.sea.ql.ast.expr.atom.Money;
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
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;

public class Expression implements
		org.uva.sea.ql.visitor.Expression<Boolean> {

	@Override
	public Boolean visit(Add add) {
		System.out.println("Visiting Add Expression");

		// Visit items
		add.getLeftHandSideExpression().accept(this);
		add.getRightHandSideExpression().accept(this);

		System.out.println("Ended visiting Add Expression");
		System.out.println();

		return true;
	}

	@Override
	public Boolean visit(And and) {
		System.out.println("Visiting And Expression");

		// Visit items
		and.getLeftHandSideExpression().accept(this);
		and.getRightHandSideExpression().accept(this);

		System.out.println("Ended visiting And Expression");
		System.out.println();

		return true;
	}

	@Override
	public Boolean visit(Div div) {
		System.out.println("Visiting Div Expression");

		// Visit items
		div.getLeftHandSideExpression().accept(this);
		div.getRightHandSideExpression().accept(this);

		System.out.println("Ended visiting Div Expression");
		System.out.println();

		return true;
	}

	@Override
	public Boolean visit(Eq eq) {
		System.out.println("Visiting Eq Expression");

		// Visit items
		eq.getLeftHandSideExpression().accept(this);
		eq.getRightHandSideExpression().accept(this);

		System.out.println("Ended visiting Eq Expression");
		System.out.println();

		return true;
	}

	@Override
	public Boolean visit(GEq geq) {
		System.out.println("Visiting GEq Expression");

		// Visit items
		geq.getLeftHandSideExpression().accept(this);
		geq.getRightHandSideExpression().accept(this);

		System.out.println("Ended visiting GEq Expression");
		System.out.println();

		return true;
	}

	@Override
	public Boolean visit(GT gt) {
		System.out.println("Visiting GT Expression");

		// Visit items
		gt.getLeftHandSideExpression().accept(this);
		gt.getRightHandSideExpression().accept(this);

		System.out.println("Ended visiting GT Expression");
		System.out.println();

		return true;
	}

	@Override
	public Boolean visit(LEq leq) {
		System.out.println("Visiting LEq Expression");

		// Visit items
		leq.getLeftHandSideExpression().accept(this);
		leq.getRightHandSideExpression().accept(this);

		System.out.println("Ended visiting LEq Expression");
		System.out.println();

		return true;
	}

	@Override
	public Boolean visit(LT lt) {
		System.out.println("Visiting LT Expression");

		// Visit items
		lt.getLeftHandSideExpression().accept(this);
		lt.getRightHandSideExpression().accept(this);

		System.out.println("Ended visiting LT Expression");
		System.out.println();

		return true;
	}

	@Override
	public Boolean visit(Mul mul) {
		System.out.println("Visiting Mul Expression");

		// Visit items
		mul.getLeftHandSideExpression().accept(this);
		mul.getRightHandSideExpression().accept(this);

		System.out.println("Ended visiting Mul Expression");
		System.out.println();

		return true;
	}

	@Override
	public Boolean visit(Neg neg) {
		System.out.println("Visiting Neg Expression");

		// Visit items
		neg.getExpression().accept(this);

		System.out.println("Ended visiting Neg Expression");
		System.out.println();

		return true;
	}

	@Override
	public Boolean visit(NEq neq) {
		System.out.println("Visiting NEq Expression");

		// Visit items
		neq.getLeftHandSideExpression().accept(this);
		neq.getRightHandSideExpression().accept(this);

		System.out.println("Ended visiting NEq Expression");
		System.out.println();

		return true;
	}

	@Override
	public Boolean visit(Not not) {
		System.out.println("Visiting Not Expression");

		// Visit items
		not.getExpression().accept(this);

		System.out.println("Ended visiting Not Expression");
		System.out.println();

		return true;
	}

	@Override
	public Boolean visit(Or or) {
		System.out.println("Visiting Or Expression");

		// Visit items
		or.getLeftHandSideExpression().accept(this);
		or.getRightHandSideExpression().accept(this);

		System.out.println("Ended visiting Or Expression");
		System.out.println();

		return true;
	}

	@Override
	public Boolean visit(Pos pos) {
		System.out.println("Visiting Pos Expression");

		// Visit items
		pos.getExpression().accept(this);

		System.out.println("Ended visiting Pos Expression");
		System.out.println();

		return true;
	}

	@Override
	public Boolean visit(Sub sub) {
		System.out.println("Visiting Sub Expression");

		// Visit items
		sub.getLeftHandSideExpression().accept(this);
		sub.getRightHandSideExpression().accept(this);

		System.out.println("Ended visiting Sub Expression");
		System.out.println();

		return true;
	}

	@Override
	public Boolean visit(Bool bool) {
		String boolVisitMessage = String.format(
				"Visiting Bool Expression Type: %b", bool.getValue());

		System.out.println(boolVisitMessage);

		return true;
	}

	@Override
	public Boolean visit(Ident ident) {
		String identVisitMessage = String.format(
				"Visiting Ident Expression Type: %s", ident.getName());

		System.out.println(identVisitMessage);

		return true;
	}

	@Override
	public Boolean visit(Int intType) {
		String intVisitMessage = String.format(
				"Visiting Int Expression Type: %d", intType.getValue());

		System.out.println(intVisitMessage);

		return true;
	}

	@Override
	public Boolean visit(Money money) {
		String moneyVisitMessage = String.format(
				"Visiting Money Expression Type: %.2f", money.getValue());

		System.out.println(moneyVisitMessage);

		return true;
	}

	@Override
	public Boolean visit(org.uva.sea.ql.ast.expr.atom.String string) {
		String stringVisitMessage = String.format(
				"Visiting String Expression Type: %s", string.getValue());

		System.out.println(stringVisitMessage);

		return true;
	}

}
