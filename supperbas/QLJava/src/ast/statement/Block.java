package ast.statement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import ast.Statement;
import ast.visitor.Visitor;

public class Block extends Statement implements Iterable<Statement> {
	
	private final List<Statement> statements;
	
	public Block(Statement statement){
		this();
		this.statements.add(statement);
	}
	
	public Block(Statement statement, Block block) {
		this(statement);
		this.statements.addAll(block.getStatements());
	}
	
	public Block(){
		this.statements = new ArrayList<Statement>();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
	public List<Statement> getStatements(){
		return this.statements;
	}

	@Override
	public Iterator<Statement> iterator() {
		return new Iterator<Statement>(){
			private int index = 0;
			@Override
			public boolean hasNext() {
				if(statements==null)
					return false;
				return (statements.size()!=index);
			}

			@Override
			public Statement next() {
				return statements.get(index++);
				
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
		};
	}
}
