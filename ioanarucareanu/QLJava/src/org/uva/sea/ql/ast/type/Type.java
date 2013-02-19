package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expr.value.Val;
import org.uva.sea.ql.semanticchecker.ReturnType;

public abstract class Type implements ASTNode, ReturnType { 
	
//	abstract public Val createValOfType();
	
	abstract public String toString(); 
	
}
