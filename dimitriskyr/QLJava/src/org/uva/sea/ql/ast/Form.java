package org.uva.sea.ql.ast;

import java.util.List;

import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.ast.visitor.IStatementVisitor;

public class Form implements ASTNode { 
	private Ident name;
	private List<Statement> block ;
	
	public Form(Ident name, List<Statement> block){
		this.name=name;
		this.block=block;
	}
	
	public Value getName() {
		return name;
	}
	
	public List<Statement> getBlock() {
		return block;
	}
 
	public void accept(IStatementVisitor visitor) {
		visitor.visit(this);
	}
}
