package org.uva.sea.ql.visitor.printer;

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
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class ExpressionVisitorPrinter  implements IExpressionVisitor<Boolean> {

	@Override
	public Boolean visit(Add ast) {
		System.out.println("Add");
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(And ast) {
		System.out.println("And");
		ast.getLhs().accept(this);
		System.out.println("Add LHS DONE!");
		ast.getRhs().accept(this);
		System.out.println("Add RHS DONE!");
		return true;
	}

	@Override
	public Boolean visit(Div ast) {
		System.out.println("Div");
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(Eq ast) {
		System.out.println("Eq");
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(GEq ast) {
		System.out.println("GEq");
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(GT ast) {
		System.out.println("GT");
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(LEq ast) {
		System.out.println("LEq");
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(LT ast) {
		System.out.println("LT");
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(Mul ast) {
		System.out.println("Mul");
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(NEq ast) {
		System.out.println("NEq");
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(Or ast) {
		System.out.println("Or");
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(Sub ast) {
		System.out.println("Sub");
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(Neg ast) {
		System.out.println("Neg");
		ast.getArg().accept(this);
		return true;
	}

	@Override
	public Boolean visit(Not ast) {
		System.out.println("Not");
		ast.getArg().accept(this);
		return true;
	}

	@Override
	public Boolean visit(Pos ast) {
		System.out.println("Pos");
		ast.getArg().accept(this);
		return true;
	}

	@Override
	public Boolean visit(Bool ast) {
		System.out.println("Bool: " + ast.getValue());
		return true;
	}

	@Override
	public Boolean visit(Ident ast) {
		System.out.println("Ident: " + ast.getValue());
		return true;
	}

	@Override
	public Boolean visit(Int ast) {
		System.out.println("Int: " + ast.getValue());
		return true;
	}

	@Override
	public Boolean visit(StringLiteral ast) {
		System.out.println("StringLiteral: " + ast.getValue());
		return true;
	}

}