package org.uva.sea.ql.ast.stmt;

import java.util.Collections;
import java.util.List;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.Visitor;

public class IfThenElse extends Statement {

	private final Expr condition;
	private final List<Statement> ifBlock;
	private final List<Statement> elseBlock;
	
	public IfThenElse(Expr condition, List<Statement> ifBlock,
			List<Statement> elseBlock) {
		this.condition = condition;
		this.ifBlock = ifBlock;
		this.elseBlock = elseBlock;
	}

	public IfThenElse(Expr condition, List<Statement> ifBlock) {
		this.condition = condition;
		this.ifBlock = ifBlock;
		this.elseBlock = Collections.emptyList();;
	}

	public Expr getCondition() {
		return condition;
	}

	public List<Statement> getIfBlock() {
		return ifBlock;
	}

	public List<Statement> getElseBlock() {
		return elseBlock;
	}

	@Override
	public void accept(Visitor visitor) {
		condition.accept(visitor);
		
		for(ASTNode node : ifBlock) {
            node.accept(visitor);
        }
		
		for(ASTNode node : elseBlock) {
            node.accept(visitor);
        }
		
		visitor.visit(this);
	}
}
