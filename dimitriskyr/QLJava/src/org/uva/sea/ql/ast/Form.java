package org.uva.sea.ql.ast;
import java.util.List;

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
	}
