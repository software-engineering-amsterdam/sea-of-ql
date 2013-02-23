package eu.karuza.ql.visitor.impl;


import eu.karuza.ql.ast.Form;
import eu.karuza.ql.ast.Statement;
import eu.karuza.ql.ast.statement.AnswerableQuestion;
import eu.karuza.ql.ast.statement.ComputedQuestion;
import eu.karuza.ql.ast.statement.IfConditionalStatement;
import eu.karuza.ql.ast.statement.IfElseConditionalStatement;
import eu.karuza.ql.ast.value.Value;
import eu.karuza.ql.visitor.StatementVisitor;

public class Evaluator implements StatementVisitor<Void> {

	@Override
	public Void visit(Form node) {
		for(Statement statement : node.getStatements()) {
			statement.accept(this);
		}
		return null;
	}

	@Override
	public Void visit(IfConditionalStatement node) {
		for(Statement statement: node.getStatements()) {
			statement.accept(this);
		}
		Value value = node.getExpr().evaluate();
		node.setVisible((Boolean)value.getRawValue());
		return null;
	}
	
	@Override
	public Void visit(IfElseConditionalStatement node) {
		for(Statement statement: node.getAllStatements()) {
			statement.accept(this);
		}
		Value value = node.getExpr().evaluate();
		node.setVisible((Boolean)value.getRawValue());
		return null;
	}

	@Override
	public Void visit(AnswerableQuestion node) {
		return null;
	}

	@Override
	public Void visit(ComputedQuestion node) {
		node.getExpr().evaluate();
		return null;
	}
}
