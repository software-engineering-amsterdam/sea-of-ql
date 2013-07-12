package org.uva.sea.ql.ast.statements;

import java.util.List;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.value.BoolValue;
import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.gui.Environment;
import org.uva.sea.ql.visitor.IFormVisitor;


public class IfStatement implements Statement {
	protected Expr ifStat;
	protected List<Statement> sList;
	protected Environment environment;
	protected BoolValue value;
	
	
	public IfStatement(Expr x, List<Statement> list) {
		ifStat = x;
		sList = list;
		value = new BoolValue(false);
	}
	
	public List<Statement> getStatements(){
		return sList;
	}
	
	public Expr getCondition(){
		return ifStat;
	}
	
	public Value<?> getValue() {
		return value;
	}
	
	public void setEnvironment(Environment envir) {
		environment = envir;
	}
	
	@Override
	public <T> T accept(IFormVisitor<T> v){
		return v.visit(this);
	}

}
