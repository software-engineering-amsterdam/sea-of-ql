package nl.stgm.ql.ast.form;
import nl.stgm.ql.ast.ASTNode;
import nl.stgm.ql.inspector.CodeInspector;

public class Form implements ASTNode
{
	private String id;
	
	public Form(String id)
	{
		this.id = id;
	}

	public void accept(CodeInspector inspector)
	{
		inspector.visit(this);
	}
}
