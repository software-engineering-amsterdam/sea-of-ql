package org.uva.sea.ql.ast.statements;

import java.util.ArrayList;
import org.uva.sea.ql.ast.expressions.Expr;

public class ifElseStatement extends ifStatement {
	private final ArrayList<Statement> elseStms;
	
	public ifElseStatement(Expr condition, ArrayList<Statement> ifStms, ArrayList<Statement> elseStms) {
		super(condition, ifStms);
		this.elseStms = elseStms;
	}
	
	public ArrayList<Statement> getElseStms() {
		return elseStms;
	}
}