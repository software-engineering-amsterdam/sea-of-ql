package org.uva.sea.ql.renderer.control;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JSpinner;

import org.uva.sea.ql.evaluation.values.Int;
import org.uva.sea.ql.evaluation.values.Value;
import org.uva.sea.ql.renderer.ObservableQuestion;

public class Spinner extends Control {

	final int SPINNER_WIDTH = 80;
	final int SPINNER_HEIGHT = 5;
	
	private final JSpinner widget;
	
	public Spinner() {
		
		widget = new JSpinner();
		widget.setPreferredSize(new Dimension(SPINNER_WIDTH,SPINNER_HEIGHT));
	}
	
	@Override
	public Value getValue() {
		return new Int((Integer)(widget.getValue()));
	}

	@Override
	public JComponent getWidget() {
		return widget;
	}

	@Override
	public void addListener(ObservableQuestion obsQuestion) {
		
		JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) widget.getEditor();
		editor.getTextField().addFocusListener(obsQuestion);	
	}

	@Override
	public void setValue(Value v) {
		
		if (v instanceof Int) {
			widget.setValue((Integer)(v.getValue()));
		}
		
	}

}