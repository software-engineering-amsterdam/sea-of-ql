package org.uva.sea.ql.ast.statement;

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
	
	public Iterator<Statement> getStatementIterator(){
		return statementList.iterator();
	}
	
	public <T> T accept(final StatementVisitor<T> v){
		return v.visit(this);
	}
	
}