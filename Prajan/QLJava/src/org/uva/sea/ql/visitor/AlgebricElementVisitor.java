package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Primary;
import org.uva.sea.ql.ast.alg.Add;
import org.uva.sea.ql.ast.alg.And;
import org.uva.sea.ql.ast.alg.Bool;
import org.uva.sea.ql.ast.alg.Div;
import org.uva.sea.ql.ast.alg.Eq;
import org.uva.sea.ql.ast.alg.GEq;
import org.uva.sea.ql.ast.alg.GT;
import org.uva.sea.ql.ast.alg.Int;
import org.uva.sea.ql.ast.alg.LEq;
import org.uva.sea.ql.ast.alg.LT;
import org.uva.sea.ql.ast.alg.Money;
import org.uva.sea.ql.ast.alg.Mul;
import org.uva.sea.ql.ast.alg.NEq;
import org.uva.sea.ql.ast.alg.Neg;
import org.uva.sea.ql.ast.alg.Not;
import org.uva.sea.ql.ast.alg.Or;
import org.uva.sea.ql.ast.alg.Pos;
import org.uva.sea.ql.ast.alg.Str;
import org.uva.sea.ql.ast.alg.Sub;

public interface AlgebricElementVisitor<T> {

	public T visit(Add add);

	public T visit(And and);

	public T visit(Div div);

	public T visit(Eq eq);

	public T visit(GEq geq);

	public T visit(GT gt);

	public T visit(Int val);

	public T visit(LEq leq);

	public T visit(LT lt);

	public T visit(Mul mul);

	public T visit(Neg neg);

	public T visit(NEq neq);

	public T visit(Not not);

	public T visit(Or or);

	public T visit(Pos pos);

	public T visit(Sub sub);

	public T visit(Ident ast);

	public T visit(Primary ast);

	public T visit(Bool bool);

	public T visit(Str str);

	public T visit(Money money);

}
