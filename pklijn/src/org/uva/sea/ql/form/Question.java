package org.uva.sea.ql.form;

public class Question extends FormItem {

	private String id;
	private String question;
	
	public Question(String id, String question) {
		this.id = id;
		this.question = question;
	}
	
	public String getId() {
		return id;
	}
	
	public String getQuestion() {
		return question;
	}

	@Override
	public void print(int level) {
		String s = "--";
		for (int i = 0; i < level; i++) {
			s += "--";
		}
		System.out.println(s + "Q:" + question + " (id: " + id + ")");
	}
}
