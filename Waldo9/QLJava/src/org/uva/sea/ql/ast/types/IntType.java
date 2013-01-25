package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.ASTNodeVisitor;


public class IntType extends Type {
	
	public void accept(ASTNodeVisitor visitor) {
        visitor.visit(this);
    }

}
