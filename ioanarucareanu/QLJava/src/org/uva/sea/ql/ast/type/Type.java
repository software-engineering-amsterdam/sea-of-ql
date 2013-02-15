package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.semanticchecker.ReturnType;

public abstract class Type implements ASTNode, ReturnType { 
	
	abstract public Value<?> createValueOfType();
	
	abstract public String toString(); 
	
}
