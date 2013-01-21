package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.ASTNode;
import nl.stgm.ql.inspector.CodeInspector;

public class FormItem extends ASTNode
{
	public void accept(CodeInspector inspector)
	{
		inspector.visit(this);
	}
}
