package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.AnswerableQuestion;
import org.uva.sea.ql.ast.ComputedQuestion;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Statement;

public class StatementPrinter implements StatementVisitor {
	
	private ExpressionVisitor exprVisitor;
	
	public StatementPrinter(ExpressionVisitor exprVisitor) {
		this.exprVisitor = exprVisitor;
	}

	@Override
	public void visit(ConditionalStatement node) {
		printNodeName(node);
		node.getExpression().accept(exprVisitor);
		for(Statement statement : node.getStatements()) {
			statement.accept(this);
		}
	}

	@Override
	public void visit(AnswerableQuestion node) {
		printNodeName(node);
	}

	@Override
	public void visit(ComputedQuestion node) {
		printNodeName(node);
		node.getExpr().accept(exprVisitor);
	}

	@Override
	public void visit(Form node) {
		printNodeName(node);
		for(Statement statement : node.getStatements()) {
			statement.accept(this);
		}
	}
	
	private void printNodeName(ASTNode node) {
		System.out.println("at node: " + node.getClass().getName());
	}

}
