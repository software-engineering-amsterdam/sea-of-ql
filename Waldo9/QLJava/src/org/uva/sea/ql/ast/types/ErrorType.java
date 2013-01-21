package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.ASTNodeVisitor;


public class ErrorType extends Type {
	
	@Override
	public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
