package org.uva.sea.ql.ast;

import java.util.List;

public class IfStatement {
	protected Expr ifStat;
	protected List<Question> qList;
	
	
	public IfStatement(Expr x, List<Question> list) {
		ifStat = x;
		qList = list;
	}

}
