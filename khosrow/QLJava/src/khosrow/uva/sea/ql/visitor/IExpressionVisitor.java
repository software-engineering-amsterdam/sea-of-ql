package khosrow.uva.sea.ql.visitor;

import khosrow.uva.sea.ql.ast.expr.*;

public interface IExpressionVisitor<T> {
	
	public T Visit(Add ast);
	public T Visit(And ast);	
	public T Visit(Div ast);
	public T Visit(Eq ast);
	public T Visit(GEq ast);
	public T Visit(GT ast);
	public T Visit(Ident ast);	
	public T Visit(LEq ast);
	public T Visit(LT ast);
	public T Visit(Mod ast);	
	public T Visit(Mul ast);
	public T Visit(Neg ast);
	public T Visit(NEq ast);
	public T Visit(Not ast);
	public T Visit(Or ast);
	public T Visit(Pos ast);	
	public T Visit(Sub ast);
	public T Visit(Unary ast);
	public T Visit(IntLiteral ast);
	public T Visit(BoolLiteral ast);	
	public T Visit(MoneyLiteral ast);
	public T Visit(StringLiteral ast);
	
}
