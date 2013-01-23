package org.uva.sea.ql.visitor;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;

public class Registry {
	private List<Question> questions;
	private List<IfStatement> ifStatements;

	public Registry() {
		this.questions = new ArrayList<Question>();
		this.ifStatements = new ArrayList<IfStatement>();
	}	
	
	public void addQuestion(Question q){
		this.questions.add(q);
	}
	
	public void addIfStatement(IfStatement i){
		this.ifStatements.add(i);
	}
	
	public List<Question> getQuestions(){
		return this.questions;
	}
	
	public List<IfStatement> getIfStatements(){
		return this.ifStatements;
	}	
}
