package eu.karuza.ql.service;

import java.util.ArrayList;
import java.util.List;

import eu.karuza.ql.QuestionResult;
import eu.karuza.ql.ast.Form;
import eu.karuza.ql.ast.Statement;
import eu.karuza.ql.ast.statement.AnswerableQuestion;
import eu.karuza.ql.ast.statement.ComputedQuestion;
import eu.karuza.ql.ast.statement.IfConditionalStatement;
import eu.karuza.ql.ast.statement.IfElseConditionalStatement;
import eu.karuza.ql.visitor.StatementVisitor;

public class StoreListGenerator implements StatementVisitor<Void> {

	private List<QuestionResult> questions = new ArrayList<QuestionResult>();
	
	public List<QuestionResult> getQuestions() {
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
	public Void visit(IfConditionalStatement node) {
		acceptChildren(node.getStatements());
		return null;
	}
	
	@Override
	public Void visit(IfElseConditionalStatement node) {
		acceptChildren(node.getAllStatements());
		return null;
	}

	@Override
	public Void visit(AnswerableQuestion node) {
		QuestionResult questionResult = new QuestionResult();
		questionResult.setName(node.getName());
		questionResult.setValue(node.getRawValue().toString());
		questions.add(questionResult);
		return null;
	}

	@Override
	public Void visit(ComputedQuestion node) {
		return null;
	}
	
	private void acceptChildren(List<Statement> statements) {
		for(Statement statement : statements) {
			statement.accept(this);
		}
	}
}
