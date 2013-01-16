package org.uva.sea.ql.form;

import java.util.List;

public class IfStatement extends FormItem {

	private String id;
	private List<FormItem> formItems;
	
	public IfStatement(String id, List<FormItem> formItems) {
		this.id = id;
		this.formItems = formItems;
	}
	
	public String getId() {
		return id;
	}
	
	public List<FormItem> getFormItems() {
		return formItems;
	}

	@Override
	public void print(int level) {
		super.print(level);
		System.out.println("IF id: "+ id +" level:" + level);
		for (FormItem f : formItems) {
			f.print(level + 1);
		}
	}
}
