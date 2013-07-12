package org.uva.sea.ql.ast;

import java.util.List;

import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.visitor.IFormVisitor;


public class Form {
	protected Expr name;
	protected List<Statement> sList;

	public Form(Expr x, List<Statement> r){
		name = x;
		sList = r;
	}
	
	public List<Statement> getStatements(){
		return sList;
	}
	
	public String toString(){
		return name.toString() + ", " +sList.toString();
	}
	
	public <T> T accept(IFormVisitor<T> v){
		return v.visit(this);
	}
}
