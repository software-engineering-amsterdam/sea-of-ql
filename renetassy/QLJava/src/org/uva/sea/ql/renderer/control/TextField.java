package org.uva.sea.ql.renderer.control;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.evaluation.values.Str;
import org.uva.sea.ql.evaluation.values.Value;
import org.uva.sea.ql.renderer.ObservableQuestion;

public class TextField extends Control {

	final int TEXTFIELD_SIZE = 15; 
	
	private final JTextField widget;
	
	public TextField () {
		widget = new JTextField(TEXTFIELD_SIZE);
	}
	
	@Override
	public Value getValue() {
		return new Str(widget.getText());
	}

	@Override
	public JComponent getWidget() {
		return widget;
	}

	@Override
	public void addListener(ObservableQuestion obsQuestion) {
		widget.addActionListener(obsQuestion);	
	}

	@Override
	public void setValue(Value v) {
		
		if (v instanceof Str) {
			widget.setText((String)(v.getValue()));
		}
			
		
	}

}
