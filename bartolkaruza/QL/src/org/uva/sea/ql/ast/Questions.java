package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.visitor.NodeVisitor;

public class Questions implements QuestionElement {

	private List<QuestionElement> questions = new ArrayList<QuestionElement>();
	private Stmt statement;
	
	public Questions() {
		
	}
	
	public Questions (Stmt s) {
		this.setStatement(s);
	}
	
	@Override
	public void accept(NodeVisitor visitor) {
		if(statement != null) {
			statement.accept(visitor);
		}
		if(questions != null && questions.size() > 0) {
			for(QuestionElement question : questions) {
				visitor.visit(question);
			}
		}
	}
	
	public void add(QuestionElement question) {
		questions.add(question);
	}

	public Stmt getStatement() {
		return statement;
	}

	public void setStatement(Stmt statement) {
		this.statement = statement;
	}

}
