package org.uva.sea.ql.form;

import java.util.List;

public class Form {

	private String id;
	private List<FormItem> formItems;
	
	public Form(String id, List<FormItem> formItems) {
		this.id = id;
		this.formItems = formItems;
		print();
	}

	public String getIdentity() {
		return id;
	}
	
	public List<FormItem> getFormItems() {
		return formItems;
	}

	public void print() {
		System.out.println("formItems: " + id);
		for (FormItem f : formItems) {
			f.print(0);
		}		
	}
}
