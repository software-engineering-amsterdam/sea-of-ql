package org.uva.sea.ql.ast.stmt;

import java.util.List;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.IFormVisitor;

public class IfThenElse extends IfThen {

	private final List<Statement> elseBlock;
	
	public IfThenElse(Expr condition, List<Statement> ifBlock, List<Statement> elseBlock) {
		super(condition, ifBlock);
		this.elseBlock = elseBlock;
	}

	public List<Statement> getElseBlock() {
		return elseBlock;
	}

	@Override
	public void accept(IFormVisitor visitor) {
		visitor.visit(this);
	}
}
