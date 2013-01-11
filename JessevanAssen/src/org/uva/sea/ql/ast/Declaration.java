package org.uva.sea.ql.ast;

import org.uva.sea.ql.ASTNodeVisitor;
import org.uva.sea.ql.ast.expr.Ident;

public class Declaration implements ASTNode {

	private final Ident identity;
	private final String type;
	
	public Declaration(Ident identity, String type) {
		this.identity = identity;
		this.type = type;
	}

	public Ident getIdentity() { return identity; }
	public String getType() { return type; }
	
	@Override
	public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		visitor.visit(this, param);
		
		return null;
	}

}
