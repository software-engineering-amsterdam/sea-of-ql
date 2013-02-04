package org.uva.sea.ql.ast;

import java.util.List;

public class IfStatement extends Statement {
	
	protected Expr ifStat;
	protected List<Statement> sList;
	
	
	public IfStatement(Expr x, List<Statement> list) {
		ifStat = x;
		sList = list;
	}

}
