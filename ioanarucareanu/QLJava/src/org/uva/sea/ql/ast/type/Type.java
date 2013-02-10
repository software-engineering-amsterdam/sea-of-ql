package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expr.value.Value;

public abstract class Type implements ASTNode { 
	
	abstract public Value<?> createValueOfType();
	
	abstract public String getHumanReadableType(); 
}
