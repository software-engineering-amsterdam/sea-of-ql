package org.uva.sea.ql.ui.components;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.StringVal;
import org.uva.sea.ql.interpreter.Value;

public class StringComponent extends ActiveComponent{
	
	private final static int UI_COMPONENT_WIDTH = 150;
	
	public StringComponent(final Env env, final Form form, final Ident name) {
		super("wrap, width :"+ UI_COMPONENT_WIDTH + ":", new JTextField());
		answerField.setSize(UI_COMPONENT_WIDTH, answerField.getHeight());
		((JTextField)answerField).getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				updateAnswerField();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateAnswerField();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {				
			}
			
			public void updateAnswerField(){
				if(!(((JTextField)answerField).getText().equals(""))){
					env.putValue(name, new StringVal(((JTextField)answerField).getText()));					
					form.eval(env);
				}
			}
		});
	}

	@Override
	public void updateValue(Value newValue) {
		((JTextField)answerField).setText(((StringVal)newValue).getValue());
	}

}
