package org.uva.sea.ql.gui.render.widgets;

import java.awt.Component;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.gui.observe.AnswerableQuestionObservable;

public class NumericInputWidget extends Widget {

	private final JTextField _widget;
	
	public NumericInputWidget() {
		_widget = new JFormattedTextField(NumberFormat.getInstance());
		_widget.setColumns(15);
		_widget.setHorizontalAlignment(JTextField.RIGHT);
	}
	
	@Override
	public Value getValue() {
		return new Int(Integer.parseInt(_widget.getText().replace(".", "")));
	}

	@Override
	public void setValue(Value value) {
		_widget.setText(((Int)value).getValue().toString());
	}
	
	@Override
	public void setDefaultValue() {
		_widget.setText("0");
	}
	
	@Override
	public Component getWidget() {
		return _widget;
	}

	@Override
	public void setEnabled(boolean enabled) {
		_widget.setEnabled(enabled);
	}
	
	@Override
	public void addListener(AnswerableQuestionObservable observable) {
		_widget.addActionListener(observable);
	}
	
}