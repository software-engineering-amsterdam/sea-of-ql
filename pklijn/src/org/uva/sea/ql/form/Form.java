package org.uva.sea.ql.form;

import java.util.List;

public class Form {

	private String identity;
	private List<FormItem> formItems;
	
	public Form(String identity, List<FormItem> formItems) {
		this.identity = identity;
		this.formItems = formItems;
		System.out.println("formItems: " + identity + " size: " + formItems.size());
		for (FormItem f : formItems) {
			f.print(0);
		}
//		int i = 1;
//		for (Question q : formItems) {
//			System.out.println("--Q" + i + ": " + q.getId() + " ::> " + q.getQuestion());
//			i++;
//		}
	}

	public String getIdentity() {
		return identity;
	}
	
	public List<FormItem> getFormItems() {
		return formItems;
	}

}
