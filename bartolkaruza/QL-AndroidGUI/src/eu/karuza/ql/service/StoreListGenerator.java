package eu.karuza.ql.service;

import java.util.ArrayList;
import java.util.List;


import eu.karuza.ql.ast.AnswerableQuestion;
import eu.karuza.ql.ast.ComputedQuestion;
import eu.karuza.ql.ast.ConditionalStatement;
import eu.karuza.ql.ast.Form;
import eu.karuza.ql.ast.Statement;
import eu.karuza.ql.visitor.StatementVisitor;

public class StoreListGenerator implements StatementVisitor<Void> {

	private List<AnswerableQuestion> questions = new ArrayList<AnswerableQuestion>();
	
	public List<AnswerableQuestion> getQuestions() {
		return questions;
	}
	
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
		return null;
	}

	@Override
	public Void visit(AnswerableQuestion node) {
		questions.add(node);
		return null;
	}

	@Override
	public Void visit(ComputedQuestion node) {
		return null;
	}

}
