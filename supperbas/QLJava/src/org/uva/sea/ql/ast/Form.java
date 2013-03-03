package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.checker.StatementChecker;
import org.uva.sea.ql.evaluator.StatementEvaluator;
import org.uva.sea.ql.ui.UIVisitor;


public class Form implements ASTNode {

	private final Ident ident;
	private final Block content;

	public Form(Ident ident, Block content) {
		this.ident = ident;
		this.content = content;
	}

	public Ident getIdent() {
		return ident;
	}

	public Block getContent() {
		return content;
	}

	public void accept(StatementChecker visitor) {
		visitor.visit(this);
	}

	public void accept(StatementEvaluator visitor) {
		visitor.visit(this);
	}

	public void accept(UIVisitor visitor) {
		visitor.visit(this);
	}

}
