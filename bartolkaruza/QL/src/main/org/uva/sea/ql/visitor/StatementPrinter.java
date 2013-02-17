package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.AnswerableQuestion;
import org.uva.sea.ql.ast.ComputedQuestion;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Statement;

public class StatementPrinter implements StatementVisitor<Void> {
	
	private ExpressionVisitor<?> exprVisitor;
	
	public StatementPrinter(ExpressionVisitor<?> exprVisitor) {
		this.exprVisitor = exprVisitor;
	}

	@Override
	public Void visit(ConditionalStatement node) {
		printNodeName(node);
		node.getExpression().accept(exprVisitor);
		for(Statement statement : node.getStatements()) {
			statement.accept(this);
		}
		return null;
	}

	@Override
	public Void visit(AnswerableQuestion node) {
		printNodeName(node);
		return null;
	}

	@Override
	public Void visit(ComputedQuestion node) {
		printNodeName(node);
		node.getExpr().accept(exprVisitor);
		return null;
	}

	@Override
	public Void visit(Form node) {
		printNodeName(node);
		for(Statement statement : node.getStatements()) {
			statement.accept(this);
		}
		return null;
	}
	
	private Void printNodeName(ASTNode node) {
		System.out.println("at node: " + node.getClass().getName());
		return null;
	}

}
