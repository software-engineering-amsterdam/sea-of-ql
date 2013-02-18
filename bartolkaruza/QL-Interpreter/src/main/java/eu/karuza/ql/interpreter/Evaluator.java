package eu.karuza.ql.interpreter;


import eu.karuza.ql.ast.AnswerableQuestion;
import eu.karuza.ql.ast.ComputedQuestion;
import eu.karuza.ql.ast.ConditionalStatement;
import eu.karuza.ql.ast.Form;
import eu.karuza.ql.ast.Statement;
import eu.karuza.ql.ast.expr.value.Value;
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
	public Void visit(ConditionalStatement node) {
		for(Statement statement: node.getStatements()) {
			statement.accept(this);
		}
		Value value = node.getExpression().evaluate();
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
