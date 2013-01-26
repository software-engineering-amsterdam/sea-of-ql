package org.uva.sea.ql.ast;

import java.util.ArrayList;

public class IfThenStatement extends ConditionalStatement {
	
	private final ArrayList<Statement> stmtList;
	private final Expr expr;
	
	public IfThenStatement(Expr e, ArrayList<Statement> stmtList) {
		this.expr = e;
		this.stmtList = stmtList;
	}
	
	public ArrayList<Statement> getStmtList() {
		return stmtList;
	}
	
	public Expr getExpr() {
		return expr;
	}
	

}
