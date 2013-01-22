package org.uva.sea.ql.ast.literals;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.ASTNodeVisitor;

public class StringLiteral implements ASTNode {
	
	private String value;
	
	public StringLiteral(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public void accept(ASTNodeVisitor visitor) {
        visitor.visit(this);
    }

}
