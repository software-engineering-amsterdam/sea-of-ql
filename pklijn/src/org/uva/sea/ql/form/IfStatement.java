package org.uva.sea.ql.form;

import java.util.List;

import org.antlr.runtime.Token;

public class IfStatement extends FormItem {

	private String indentifier;
	private List<FormItem> elements;
	
	public IfStatement(String ident4, List<FormItem> elements) {
		this.indentifier = ident4;
		this.elements = elements;
	}
	
	public String getIndentier() {
		return indentifier;
	}
	
	public List<FormItem> getElements() {
		return elements;
	}

	@Override
	public void print(int level) {
		String s = "--";
		for (int i = 0; i < level; i++) {
			s += "--";
		}
		System.out.println(s + "IF id: "+ indentifier +" level:" + level);
		for (FormItem f : elements) {
			f.print(level + 1);
		}
	}
}
