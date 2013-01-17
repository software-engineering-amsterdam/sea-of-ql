package org.uva.sea.ql.ast.statement;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.Visitor;

/**
 * 
 */
public class Statements implements ASTNode, Iterable<Statement> {
	private final List<Statement> statements;
	
	public Statements( Statement statement, Statements statements ) {
		this( statement );
		this.statements.addAll( statements.statements );
	}
	
	public Statements( Statement statement ) {
		this.statements = new LinkedList<Statement>();
		this.statements.add( statement );
	}
	
	@Override
	public void accept( Visitor visitor ) {
		visitor.visit( this );
	}

	@Override
	public Iterator<Statement> iterator() {
		return this.statements.iterator();
	}
	
}
