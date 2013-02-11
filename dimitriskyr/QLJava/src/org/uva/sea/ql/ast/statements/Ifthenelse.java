package org.uva.sea.ql.ast.statements;

import java.util.List;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.visitor.IStatementVisitor;

public class Ifthenelse extends Statement {
	private Expr expression;
	private List<Statement> thenBlock,elseBlock;
	
	public Ifthenelse (Expr expression, List<Statement> thenBlock, List<Statement> elseBlock){
		this.expression=expression;
		this.thenBlock = thenBlock;
		this.elseBlock = elseBlock;
	}
	
	public Expr getExpression() {
		return expression;
	}
	
	public List<Statement> getBlock1() {
		return thenBlock;
	}
	
	public List<Statement> getBlock2() {
		return elseBlock;
	}
	
	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visit(this);
	}

}

	
