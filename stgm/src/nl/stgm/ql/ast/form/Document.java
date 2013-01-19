package nl.stgm.ql.ast.form;
import nl.stgm.ql.ast.ASTNode;
import nl.stgm.ql.inspector.CodeInspector;

public class Document implements ASTNode
{
	public Document()
	{
	}
	
	public void accept(CodeInspector inspector)
	{
		inspector.visit(this);
	}
}
