package khosrow.uva.sea.ql.visitor;

import khosrow.uva.sea.ql.ast.expr.*;

public interface IExprVisitor<T> {
	
	public T visit(Add ast);
	public T visit(And ast);	
	public T visit(Div ast);
	public T visit(Eq ast);
	public T visit(GEq ast);
	public T visit(GT ast);
	public T visit(Ident ast);	
	public T visit(LEq ast);
	public T visit(LT ast);
	public T visit(Mod ast);	
	public T visit(Mul ast);
	public T visit(Neg ast);
	public T visit(NEq ast);
	public T visit(Not ast);
	public T visit(Or ast);
	public T visit(Pos ast);	
	public T visit(Sub ast);
	public T visit(IntLiteral ast);
	public T visit(BoolLiteral ast);	
	public T visit(MoneyLiteral ast);
	public T visit(StringLiteral ast);
	
}
