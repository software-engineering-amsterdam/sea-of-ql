package org.uva.sea.ql.ast;

import org.uva.sea.ql.ASTNodeVisitor;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Type;

public class Declaration implements ASTNode {

	private final Ident identity;
	private final Type type;
	
	public Declaration(Ident identity, Type type) {
		this.identity = identity;
		this.type = type;
	}

	public Ident getIdentity() { return identity; }
	public Type getType() { return type; }
	
	@Override
	public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		visitor.visit(this, param);
		
		return null;
	}

}
