package org.uva.sea.ql.visitor;

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
import org.uva.sea.ql.ast.expr.primary.Bool;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.expr.primary.Int;
import org.uva.sea.ql.ast.expr.primary.StringLiteral;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;

public class ExpressionVisitorPrinter  implements ExpressionVisitor<Boolean> {

	@Override
	public Boolean visit(Add ast) {
		System.out.println("Add");
		return true;
	}

	@Override
	public Boolean visit(And ast) {
		System.out.println("And");
		return true;
	}

	@Override
	public Boolean visit(Div div) {
		System.out.println("Div");
		return true;
	}

	@Override
	public Boolean visit(Eq eq) {
		System.out.println("Eq");
		return true;
	}

	@Override
	public Boolean visit(GEq geq) {
		System.out.println("GEq");
		return true;
	}

	@Override
	public Boolean visit(GT gt) {
		System.out.println("GT");
		return true;
	}

	@Override
	public Boolean visit(LEq leq) {
		System.out.println("LEq");
		return true;
	}

	@Override
	public Boolean visit(LT lt) {
		System.out.println("LT");
		return true;
	}

	@Override
	public Boolean visit(Mul mul) {
		System.out.println("Mul");
		return true;
	}

	@Override
	public Boolean visit(NEq neq) {
		System.out.println("NEq");
		return true;
	}

	@Override
	public Boolean visit(Or or) {
		System.out.println("Or");
		return true;
	}

	@Override
	public Boolean visit(Sub sub) {
		System.out.println("Sub");
		return true;
	}

	@Override
	public Boolean visit(Neg neg) {
		System.out.println("Neg");
		return true;
	}

	@Override
	public Boolean visit(Not not) {
		System.out.println("Not");
		return true;
	}

	@Override
	public Boolean visit(Pos pos) {
		System.out.println("Pos");
		return true;
	}

	@Override
	public Boolean visit(Bool bool) {
		System.out.println("Bool");
		return true;
	}

	@Override
	public Boolean visit(Ident ident) {
		System.out.println("Ident");
		return true;
	}

	@Override
	public Boolean visit(Int integer) {
		System.out.println("Int");
		return true;
	}

	@Override
	public Boolean visit(StringLiteral stringLiteral) {
		System.out.println("StringLiteral");
		return true;
	}

}