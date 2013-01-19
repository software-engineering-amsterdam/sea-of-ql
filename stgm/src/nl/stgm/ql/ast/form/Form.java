package nl.stgm.ql.ast.form;
import nl.stgm.ql.ast.ASTNode;

public class Form implements ASTNode
{
	private String id;
	
	public Form(String id)
	{
		this.id = id;
	}
}
