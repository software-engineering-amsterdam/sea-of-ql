package org.uva.sea.ql.visitor;

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
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.Money;
import org.uva.sea.ql.ast.expr.value.Text;

public interface ExpressionVisitor<T> extends NodeVisitor<T> {
	
	public T visit(Ident node);
	
	public T visit(Add node);

	public T visit(And node);

	public T visit(Div node);

	public T visit(Eq node);

	public T visit(GEq node);

	public T visit(GT node);

	public T visit(LEq node);

	public T visit(LT node);

	public T visit(Mul node);

	public T visit(Neg node);

	public T visit(NEq node);

	public T visit(Not node);

	public T visit(Or node);

	public T visit(Pos node);

	public T visit(Sub node);

	public T visit(Bool node);

	public T visit(Int node);

	public T visit(Money node);

	public T visit(Text node);

}
