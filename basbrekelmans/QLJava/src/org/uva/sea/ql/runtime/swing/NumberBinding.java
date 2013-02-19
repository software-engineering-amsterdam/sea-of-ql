package org.uva.sea.ql.runtime.swing;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.uva.sea.ql.runtime.Binding;
import org.uva.sea.ql.runtime.Value;
import org.uva.sea.ql.runtime.Variable;

public class NumberBinding extends Binding<JSpinner>{

	public NumberBinding(Variable variable, JSpinner spinner) {
		super(variable, spinner);
		spinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
								
			}
		});
	}

	@Override
	protected void setGuiValue(Value value) {
		
		
	}

}
