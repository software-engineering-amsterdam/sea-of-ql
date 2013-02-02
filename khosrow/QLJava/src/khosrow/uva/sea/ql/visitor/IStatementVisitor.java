package khosrow.uva.sea.ql.visitor;

import khosrow.uva.sea.ql.ast.stmt.*;

public interface IStatementVisitor {	
	public void Visit (If stmt);
	public void Visit (ExpressionQuestion stmt);
	public void Visit (SimpleQuestion stmt);
	public void Visit (Label stmt);
}
