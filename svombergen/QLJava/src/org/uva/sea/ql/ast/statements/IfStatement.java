package org.uva.sea.ql.ast.statements;

import java.util.List;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.visitor.Visitor;


public class IfStatement extends Statement {
	protected Expr ifStat;
	protected List<Statement> sList;
	
	
	public IfStatement(Expr x, List<Statement> list) {
		ifStat = x;
		sList = list;
	}
	
	public List<Statement> getStatements(){
		return sList;
	}
	
	public Expr getCondition(){
		return ifStat;
	}
	
	@Override
	public void accept(Visitor v){
		v.visit(this);
	}

}
