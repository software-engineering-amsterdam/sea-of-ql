package org.uva.sea.ql.gui.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.uva.sea.ql.ast.value.Value;

public class TextboxEventListener implements ActionListener {
	
	private Value<?> value;
	
	public TextboxEventListener(Value<?> v) {
		value = v;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		value.setValue(event.getActionCommand());
	}

}
