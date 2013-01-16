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
	}

	public String getIdentity() {
		return identity;
	}
	
	public List<FormItem> getFormItems() {
		return formItems;
	}

}
