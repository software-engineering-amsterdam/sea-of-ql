package nl.stgm.ql.inspector;
import nl.stgm.ql.ast.*;

public interface CodeInspector
{
	void visit(ASTNode node);
}
