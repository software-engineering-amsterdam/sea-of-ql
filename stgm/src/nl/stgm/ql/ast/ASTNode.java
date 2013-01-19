package nl.stgm.ql.ast;
import nl.stgm.ql.inspector.*;

public interface ASTNode
{
	void accept(CodeInspector inspector);
}
