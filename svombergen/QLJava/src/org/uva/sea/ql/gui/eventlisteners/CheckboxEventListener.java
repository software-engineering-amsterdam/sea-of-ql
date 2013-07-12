package org.uva.sea.ql.gui.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

import org.uva.sea.ql.ast.value.BoolValue;
import org.uva.sea.ql.ast.value.Value;

public class CheckboxEventListener implements ActionListener {

private BoolValue value;
	
	public CheckboxEventListener(Value<?> val) {
		value = (BoolValue)val;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		AbstractButton btn = (AbstractButton)event.getSource();
		value.setValue(btn.isSelected());
	}

}
