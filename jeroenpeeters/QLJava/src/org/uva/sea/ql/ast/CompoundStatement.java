package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.ASTVisitor;

public class CompoundStatement extends Expr {

	private final List<Expr> expressionList = new ArrayList<Expr>();
	
	public CompoundStatement(final Expr expression){
		this.expressionList.add(expression);
	}
	
	public void add(final Expr expression){
		this.expressionList.add(expression);
	}
	
	@Override
	public void accept(final ASTVisitor v){
		super.accept(v);
		

		for(final Expr expr : this.expressionList){
			expr.accept(v);
		}
		
	}
	
}
