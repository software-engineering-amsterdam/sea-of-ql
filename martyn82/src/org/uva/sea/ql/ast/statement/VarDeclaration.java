package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.Visitor;

/**
 * Represents a variable declaration.
 */
public class VarDeclaration extends Statement {
	private final ASTNode ident;
	private final ASTNode type;
	
	public VarDeclaration( ASTNode ident, ASTNode type ) {
		this.ident = ident;
		this.type = type;
	}
	
	public ASTNode getIdent() {
		return this.ident;
	}
	
	public ASTNode getType() {
		return this.type;
	}

	@Override
	public void accept( Visitor visitor ) {
//		visitor.visit( this );
	}
}
