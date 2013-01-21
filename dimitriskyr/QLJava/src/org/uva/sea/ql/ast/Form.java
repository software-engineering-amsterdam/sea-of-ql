package org.uva.sea.ql.ast;
import java.util.List;

import org.antlr.runtime.tree.CommonTree;
import org.uva.sea.ql.ast.visitor.Visitorinterface;

public class Form implements ASTNode { 
	private Type name;
	private List<Statement> block ;
	
	public Form(Type name, List<Statement> block){
		this.name=name;
		this.block=block;
	}
	
	public Type getName() {
		return name;
	}
	
	public List<Statement> getBlock() {
		return block;
	}
 
	@Override
	public void accept(Visitorinterface visitor) {
		visitor.visit(this);
		
	}

	public CommonTree getTree() {
		// TODO Auto-generated method stub
		return null;
	}
	}
