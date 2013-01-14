package org.uva.sea.ql.ast.expressions;
import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.types.QLType;

public abstract class Expression extends Node {
	public abstract QLType getType();
	
	public Expression(ICodeLocationInformation codeLocation)
	{
		super(codeLocation);
	}
}
