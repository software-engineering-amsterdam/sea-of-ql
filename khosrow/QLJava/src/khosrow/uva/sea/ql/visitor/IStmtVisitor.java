package khosrow.uva.sea.ql.visitor;

import khosrow.uva.sea.ql.ast.stmt.*;

public interface IStmtVisitor<T> {
	public T visit (Assign stmt);
	public T visit (If stmt);
	public T visit (ExpressionQuestion stmt);
	public T visit (SimpleQuestion stmt);
	public T visit (Label stmt);
	public T visit(Stmts stmts);
}
