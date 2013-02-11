package org.uva.sea.ql.form;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.extensions.Tuple;
import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.interpreter.FormElement;
import org.uva.sea.ql.messages.Message;

public abstract class FormItem {
	
	protected List<Message> errors = new ArrayList<Message>();

	public abstract String getPrintableText(int level);
	
	public abstract List<FormElement> getFormComponents();
	
	public abstract boolean validate(Env environment);
	
	public abstract void eval(Env environment, Form form);
	
	protected String getIndent(int level) {
		String indent = "";
		for (int i = 0; i <= level; i++) {
			indent += "  ";
		}
		return indent;
	}
	
	protected String getErrorText() {
		String errorText = "";
		for (Message e : errors) {
			errorText += "!! -> " + e.getText() + "\n";
		}
		return errorText;
	}

	public abstract List<Tuple<Ident, Value>> getAllValues();
}
