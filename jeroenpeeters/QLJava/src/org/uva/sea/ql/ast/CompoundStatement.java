package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class CompoundStatement extends Statement {

	private final List<Statement> statementList = new ArrayList<Statement>();
	
	public CompoundStatement(final Statement statement){
		this.statementList.add(statement);
	}
	
	public void add(final Statement statement){
		this.statementList.add(statement);
	}
	
	public void accept(ASTVisitor v){
		v.visit(this);
	}
	
	public Iterator<Statement> getStatementIterator(){
		return statementList.iterator();
	}
	
}
