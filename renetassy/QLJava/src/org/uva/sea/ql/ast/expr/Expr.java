package org.uva.sea.ql.ast.expr;

import java.util.Map;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.ASTVisitor;
import org.uva.sea.ql.ast.types.Type;

public abstract class Expr implements ASTNode {
	
	public abstract boolean accept(ASTVisitor visitor);
	
	public abstract Type isOfType (Map<String, Type> typeEnv);

}
