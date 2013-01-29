package org.uva.sea.ql.form;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.interpreter.FormElement;
import org.uva.sea.ql.messages.Message;

public abstract class FormItem {
	
	protected List<Message> errors = new ArrayList<Message>();

	public abstract void print(int level);
	
	public abstract List<FormElement> getFormComponents();
	
	public abstract boolean validate(Env environment);
	
	protected void printIndent(int level) {
		for (int i = 0; i <= level; i++) {
			System.out.print("  ");
		}
	}
	
	protected void printErrors() {
		for (Message e : errors) {
			System.out.println("!! -> " + e.getText());
		}
	}
}
