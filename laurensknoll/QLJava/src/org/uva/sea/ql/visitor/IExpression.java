package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.expr.atom.Bool;
import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.expr.atom.Int;
import org.uva.sea.ql.ast.expr.atom.Money;
import org.uva.sea.ql.ast.expr.atom.String;
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

public interface IExpression<T> {

	/*
	 * Binary Expressions
	 */
	public T visit(Add add);

	public T visit(And and);

	public T visit(Div div);

	public T visit(Eq eq);

	public T visit(GEq geq);

	public T visit(GT gt);

	public T visit(LEq leq);

	public T visit(LT lt);

	public T visit(Mul mul);

	public T visit(NEq neq);

	public T visit(Or or);

	public T visit(Sub sub);

	/*
	 * Unary expressions
	 */
	public T visit(Neg neg);

	public T visit(Not not);

	public T visit(Pos pos);

	/*
	 * Types
	 */
	public T visit(Bool bool);

	public T visit(Ident ident);

	public T visit(Int intType);

	public T visit(Money money);

	public T visit(String string);
}
