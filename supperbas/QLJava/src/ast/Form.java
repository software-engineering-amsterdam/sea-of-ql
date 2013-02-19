package ast;

import visitor.checker.StatementChecker;
import visitor.evaluator.StatementEvaluator;
import visitor.ui.UIVisitor;
import ast.expression.Ident;
import ast.statement.Block;

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

	public Statement getContent() {
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
