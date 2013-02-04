package khosrow.uva.sea.ql.visitor;

import khosrow.uva.sea.ql.ast.stmt.*;

public interface IStmtVisitor {	
	public void visit (Assign stmt);
	public void visit (If stmt);
	public void visit (ExpressionQuestion stmt);
	public void visit (SimpleQuestion stmt);
	public void visit (Label stmt);
}
