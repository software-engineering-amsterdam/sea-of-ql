package org.uva.sea.ql.ast;
import java.util.List;

import org.uva.sea.ql.ast.visitor.Visitor;

public class Form implements ASTNode { 
	private Value name;
	private List<Statement> block ;
	
	public Form(Value name, List<Statement> block){
		this.name=name;
		this.block=block;
	}
	
	public Value getName() {
		return name;
	}
	
	public List<Statement> getBlock() {
		return block;
	}
 
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}


}
