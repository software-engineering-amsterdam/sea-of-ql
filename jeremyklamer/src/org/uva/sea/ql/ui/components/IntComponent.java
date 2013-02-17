package org.uva.sea.ql.ui.components;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.type.IntType;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.IntVal;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.ui.ErrorScreen;

public class IntComponent extends ActiveComponent{

	private final static int UI_COMPONENT_WIDTH = 100;
	
	public IntComponent(final Env env, final Form form, final Ident name) {
		super("wrap, width :"+ UI_COMPONENT_WIDTH + ":", new JTextField());
		answerField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				try{
					if(!(((JTextField)answerField).getText().equals(""))){
						IntVal value = new IntVal(Integer.parseInt(((JTextField)answerField).getText().trim()));
						env.putType(name, new IntType());
						env.putValue(name, value);
						answerField.setBackground(Color.WHITE);
						form.eval(env);
					}
				}
				catch(NumberFormatException ex){
					answerField.setBackground(Color.RED);
					new ErrorScreen("Input should be of type : Numeric");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
	}
	
	@Override
	public void updateValue(Value newValue) {
		((JTextField)answerField).setText("" + ((IntVal)newValue).getValue());
	}

}
