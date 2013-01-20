package nl.stgm.ql.ast;
import nl.stgm.ql.inspector.*;

public interface ASTNode
{
	public void accept(CodeInspector inspector);
}
