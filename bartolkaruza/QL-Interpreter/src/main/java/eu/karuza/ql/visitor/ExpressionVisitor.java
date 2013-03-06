package eu.karuza.ql.visitor;


import eu.karuza.ql.ast.expr.Add;
import eu.karuza.ql.ast.expr.And;
import eu.karuza.ql.ast.expr.Div;
import eu.karuza.ql.ast.expr.Eq;
import eu.karuza.ql.ast.expr.GEq;
import eu.karuza.ql.ast.expr.GT;
import eu.karuza.ql.ast.expr.LEq;
import eu.karuza.ql.ast.expr.LT;
import eu.karuza.ql.ast.expr.Mul;
import eu.karuza.ql.ast.expr.NEq;
import eu.karuza.ql.ast.expr.Neg;
import eu.karuza.ql.ast.expr.Not;
import eu.karuza.ql.ast.expr.Or;
import eu.karuza.ql.ast.expr.Pos;
import eu.karuza.ql.ast.expr.Sub;
import eu.karuza.ql.ast.value.Bool;
import eu.karuza.ql.ast.value.Ident;
import eu.karuza.ql.ast.value.Int;
import eu.karuza.ql.ast.value.Money;
import eu.karuza.ql.ast.value.Text;

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
