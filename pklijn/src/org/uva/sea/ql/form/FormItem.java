package org.uva.sea.ql.form;

public abstract class FormItem {

	public void print(int level) {
		// Print some nice indentation
		for (int i = 0; i <= level; i++) {
			System.out.print("  ");
		}
	}
}
