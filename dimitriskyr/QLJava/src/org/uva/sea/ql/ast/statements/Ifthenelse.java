package org.uva.sea.ql.ast.statements;

import java.util.List;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Statement;

public class Ifthenelse extends Statement {
	private Expr expression;
	private List<Statement> block1,block2;
	
	public Ifthenelse (Expr expression, List<Statement> block1, List<Statement> block2){
		this.expression=expression;
		this.block1 = block1;
		this.block2 = block2;
	}
	
	public Expr getExpression() {
		return expression;
	}
	
	public List<Statement> getBlock1() {
		return block1;
	}
	
	public List<Statement> getBlock2() {
		return block2;
	}

}

	
