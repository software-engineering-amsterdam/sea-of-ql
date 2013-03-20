package org.uva.sea.ql.ast.statements;

import java.util.List;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.visitor.IFormVisitor;


public class IfStatement implements Statement {
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
	public void accept(IFormVisitor v) {
		v.visit(this);
	}

}
