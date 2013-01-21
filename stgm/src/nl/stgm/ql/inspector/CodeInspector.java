package nl.stgm.ql.inspector;

import nl.stgm.ql.ast.*;

public interface CodeInspector
{
	public void visit(ASTNode node);
}
