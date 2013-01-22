package org.uva.sea.ql.form;

import java.util.List;

public class Form {

	private String id;
	private List<FormItem> body;
	
	public Form(String id, List<FormItem> formItems) {
		this.id = id;
		this.body = formItems;
	}

	public String getIdentity() {
		return id;
	}
	
	public List<FormItem> getBody() {
		return body;
	}

	public void print() {
		System.out.println("formItems: " + id);
		for (FormItem f : body) {
			f.print(0);
		}		
	}
}
