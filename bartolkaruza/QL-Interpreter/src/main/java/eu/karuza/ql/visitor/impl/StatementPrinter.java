package eu.karuza.ql.visitor.impl;

import java.util.List;

import eu.karuza.ql.ast.ASTNode;
import eu.karuza.ql.ast.Form;
import eu.karuza.ql.ast.Statement;
import eu.karuza.ql.ast.statement.AnswerableQuestion;
import eu.karuza.ql.ast.statement.ComputedQuestion;
import eu.karuza.ql.ast.statement.IfConditionalStatement;
import eu.karuza.ql.ast.statement.IfElseConditionalStatement;
import eu.karuza.ql.visitor.ExpressionVisitor;
import eu.karuza.ql.visitor.StatementVisitor;

public class StatementPrinter implements StatementVisitor<Void> {

	private ExpressionVisitor<?> exprVisitor;

	public StatementPrinter(ExpressionVisitor<?> exprVisitor) {
		this.exprVisitor = exprVisitor;
	}

	@Override
	public Void visit(IfConditionalStatement node) {
		printNodeName(node);
		node.getExpr().accept(exprVisitor);
		acceptChildren(node.getStatements());
		return null;
	}

	@Override
	public Void visit(IfElseConditionalStatement node) {
		printNodeName(node);
		node.getExpr().accept(exprVisitor);
		acceptChildren(node.getAllStatements());
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
		acceptChildren(node.getStatements());
		return null;
	}

	private Void printNodeName(ASTNode node) {
		System.out.println("at node: " + node.getClass().getName());
		return null;
	}

	private void acceptChildren(List<Statement> statements) {
		for (Statement statement : statements) {
			statement.accept(this);
		}
	}

}
