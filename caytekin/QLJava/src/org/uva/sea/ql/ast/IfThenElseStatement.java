package org.uva.sea.ql.ast;

import java.util.ArrayList;

public class IfThenElseStatement extends ConditionalStatement {
	
	private final Expr e;
	private final ArrayList<Statement> thenStmtList;
	private final ArrayList<Statement> elseStmtList;
	
	public IfThenElseStatement(Expr e, 
				ArrayList<Statement> thenStmtList, ArrayList<Statement> elseStmtList) {
		this.e = e;
		this.thenStmtList = thenStmtList;
		this.elseStmtList = elseStmtList;
	}

}
