package eu.karuza.ql.visitor;

import eu.karuza.ql.ast.ASTNode;
import eu.karuza.ql.ast.AnswerableQuestion;
import eu.karuza.ql.ast.ComputedQuestion;
import eu.karuza.ql.ast.ConditionalStatement;
import eu.karuza.ql.ast.Form;
import eu.karuza.ql.ast.Statement;

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
