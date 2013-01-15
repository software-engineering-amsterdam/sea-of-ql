package org.uva.sea.ql.ast;

import java.util.List;

public class Form {

	private String identity;
	private List<Question> questions;
	
	public Form(String identity, List<Question> questions) {
		this.identity = identity;
		this.questions = questions;
		System.out.println("Form: " + identity);
		int i = 1;
		for (Question q : questions) {
			System.out.println("--Q" + i + ": " + q.getId() + " ::> " + q.getQuestion());
			i++;
		}
	}

	public String getIdentity() {
		return identity;
	}
	
	public List<Question> getQuestions() {
		return questions;
	}

}
