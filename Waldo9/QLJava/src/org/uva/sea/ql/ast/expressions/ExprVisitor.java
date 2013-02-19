package org.uva.sea.ql.ast.expressions;


public interface ExprVisitor<T> {

	public T visit(StringLiteral stringLiteral);

	public T visit(Add add);

	public T visit(And and);

	public T visit(Div div);

	public T visit(Eq eq);

	public T visit(GEq gEq);

	public T visit(GT gt);

	public T visit(Ident ident);

	public T visit(Int int1);

	public T visit(LEq lEq);

	public T visit(LT lt);

	public T visit(Mul mul);

	public T visit(Neg neg);

	public T visit(NEq nEq);

	public T visit(Not not);

	public T visit(Or or);

	public T visit(Pos pos);

	public T visit(Sub sub);

	public T visit(BooleanLiteral booleanLiteral);

}
