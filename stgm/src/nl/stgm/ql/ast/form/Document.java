package nl.stgm.ql.ast.form;

import java.util.List;
import nl.stgm.ql.ast.ASTNode;
import nl.stgm.ql.inspector.CodeInspector;

public class Document implements ASTNode
{
	private List<Form> forms;
	
	public Document(List<Form> forms)
	{
		this.forms = forms;
	}
	
	public void accept(CodeInspector inspector)
	{
		for (Form form: forms)
		{
			form.accept(inspector);
		}
		
		inspector.visit(this);
	}
	
	public String toString()
	{
		return("Document");
	}
}
