package org.uva.sea.ql.form.questiontypes;

import javax.swing.JComponent;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.form.Form;

public abstract class AbstractQuestionTypeComponent {

	public abstract JComponent getAnswerField(boolean enabled, Env environment, Form form, Ident id);
	public abstract boolean hasValue();
	public abstract Value getAnswerFieldValue();
	public abstract void setAnswerFieldValue(Value value);
	public abstract void setVisible(boolean visible);
	
	protected void submitResult(Env environment, Form form, Ident id) {
		environment.addValue(id, getAnswerFieldValue());
		form.eval();
	}
}
