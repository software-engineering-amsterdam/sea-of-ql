package org.uva.sea.ql.interpreter;

import org.uva.sea.ql.ast.AnswerableQuestion;
import org.uva.sea.ql.ast.ComputedQuestion;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.visitor.StatementVisitor;

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
