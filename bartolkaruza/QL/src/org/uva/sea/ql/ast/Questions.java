package org.uva.sea.ql.ast;

import java.beans.Statement;
import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.visitor.NodeVisitor;

public class Questions implements Question {

	private List<Question> questions = new ArrayList<Question>();
	private Statement statement;
	
	public Questions (Statement statement) {
		this.setStatement(statement);
	}
	
	@Override
	public void accept(NodeVisitor visitor) {
		for(Question question : questions) {
			visitor.visit(question);
		}
		visitor.visit(this);
	}
	
	public void add(Question question) {
		questions.add(question);
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	@Override
	public void walkChild(ASTNode parent) {
		
	}

}
