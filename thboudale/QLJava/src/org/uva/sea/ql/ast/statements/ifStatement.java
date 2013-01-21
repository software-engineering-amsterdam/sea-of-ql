package org.uva.sea.ql.ast.statements;

import java.util.ArrayList;
import org.uva.sea.ql.ast.expressions.Expr;

public class ifStatement extends Statement {
	private final Expr condition;
	private final ArrayList<Statement> ifStms;
	
	public ifStatement(Expr condition, ArrayList<Statement> ifStms) {
		this.condition = condition;
		this.ifStms = ifStms;
	}
	
	public Expr getCondition() {
		return condition;
	}
	
	public ArrayList<Statement> getIfStms() {
		return ifStms;
	}
}