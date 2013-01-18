package org.uva.sea.ql.form;

public abstract class FormItem {

	public abstract void print(int level);
	
	protected void printIndent(int level) {
		for (int i = 0; i <= level; i++) {
			System.out.print("  ");
		}
	}
}
