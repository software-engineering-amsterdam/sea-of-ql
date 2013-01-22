package org.uva.sea.ql.ast.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.types.Type;

public abstract class Expr implements ASTNode {
	
	@Override
	public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visit(this);
    }
	
	public abstract Type typeOf(Map<String, Type> typeEnvironment);

}
