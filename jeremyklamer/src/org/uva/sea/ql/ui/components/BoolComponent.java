package org.uva.sea.ql.ui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.interpreter.BoolVal;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.Value;


public class BoolComponent extends ActiveComponent {
	
	public BoolComponent(final Env env, final Form form, final Ident name) {
		super("wrap", new JCheckBox());	
		((JCheckBox)answerField).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BoolVal value = new BoolVal(((JCheckBox)answerField).isSelected());
				env.putValue(name, value);
				form.eval(env);
			}
		});
	}
	
	@Override
	public void updateValue(Value newValue) {
		((JCheckBox)answerField).setSelected(((BoolVal)newValue).getValue());
	}

}
