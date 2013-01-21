package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Type;

public class Declaration implements ASTNode {

	private final Ident identifier;
	private final Type type;
	
	public Declaration(Ident identifier, Type type) {
		this.identifier = identifier;
		this.type = type;
	}

	public Ident getIdentifier() { return identifier; }
	public Type getType() { return type; }
	
	@Override
	public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		visitor.visit(this, param);
		
		return null;
	}

}
