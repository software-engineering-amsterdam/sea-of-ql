package org.uva.sea.ql.ast.type;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.IntVal;
import org.uva.sea.ql.interpreter.Value;

import ui.ErrorScreen;
import ui.UIComponent;

public class Numeric extends Type {
	
	private final int UI_COMPONENT_WIDTH = 100;
	private JTextField answerField;
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToNumeric();
	}
	
	@Override
	public boolean isCompatibleToInt() { 
		return true; 
	}
	
	@Override
	public boolean isCompatibleToMoney() { 
		return true; 
	}
	
	@Override
	public boolean isCompatibleToNumeric() { 
		return true; 
	} 
	
	@Override
	public UIComponent getAnswerComp(final Env env, final Form form, final Ident name) {
		answerField = new JTextField();
		answerField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				try{
					if(!(answerField.getText().equals(""))){
						IntVal value = new IntVal(Integer.parseInt(answerField.getText().trim()));
						env.putType(name, new Numeric());
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
		
		
		return new UIComponent(answerField, "wrap, width :"+ UI_COMPONENT_WIDTH + ":");
	}

	@Override
	public void updateAnswerComp(Value newValue) {
		answerField.setText("" + ((IntVal)newValue).getVal());
	}

	@Override
	public Value getDefaultValue() {
		return new IntVal(0);
	}

}
