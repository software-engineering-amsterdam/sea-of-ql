package org.uva.sea.ql.form;

import java.util.ArrayList;
import java.util.List;

public class IfStatement extends FormItem {

	private String id;
	private List<FormItem> ifBody;
	private List<FormItem> elseBody;
	
	public IfStatement(String id, List<FormItem> ifBody, List<FormItem> elseBody) {
		this.id = id;
		this.ifBody = ifBody;
		this.elseBody = (elseBody != null) ? elseBody : new ArrayList<FormItem>();
	}
	
	public String getId() {
		return id;
	}
	
	public List<FormItem> getIfBody() {
		return ifBody;
	}
	
	public List<FormItem> getElseBody() {
		return elseBody;
	}

	@Override
	public void print(int level) {
		printIndent(level);
		System.out.println("IF id: "+ id);
		for (FormItem f : ifBody) {
			f.print(level + 1);
		}
		if (elseBody.size() > 0) {
			printIndent(level);
			System.out.println("ELSE");
			for (FormItem f : elseBody) {
				f.print(level + 1);
			}
		}
	}
}
