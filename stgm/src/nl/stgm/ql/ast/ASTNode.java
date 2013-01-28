package nl.stgm.ql.ast;
import nl.stgm.ql.inspector.*;

public abstract class ASTNode
{
	//
	// Default acceptor for visitors: needs to be overridden 
	// for classes that are composed (in order to also visit
	// child nodes).
	//
	public void accept(CodeInspector inspector)
	{
		inspector.visit(this);
	}
	
	public String toString()
	{
		return(this.getClass().getSimpleName());
	}
}
