package org.uva.sea.ql.gui.controls;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.eval.StringValue;
import org.uva.sea.ql.eval.Value;
import org.uva.sea.ql.interpreter.State;

public class TextField extends Control implements CaretListener {

	private JTextField component;
	private Border originalBorder;
	
	public TextField(Identifier identifier, State state) {
		super(identifier, state);
		component = new JTextField();
		component.setPreferredSize(new Dimension(100, 24));
		component.addCaretListener(this);
		originalBorder = component.getBorder();
	}
	
	public JComponent getUIComponent() {
		return component;
	}

	public void setEnabled(boolean enabled) {
		component.setEnabled(enabled);
	}

	public String getText() {
		return component.getText();
	}
	
	public void setText(String text) {
		component.setText(text);
	}
	
	public void caretUpdate(CaretEvent e) {
		if (isValid()) {
			Value value = textToValue();
			setChanged();
			getState().putValue(getIdentifier(), value);
			getState().notify(getIdentifier());
			component.setBorder(originalBorder);
		} else {
			component.setBorder(BorderFactory.createLineBorder(Color.red));
		}
	}
	
	public boolean isValid() {
		return true;
	}
	
	public Value textToValue() {
		return new StringValue(getText());
	}
	
	public void setValue(Value value) {
		setText(value.toString());
		setChanged();
		getState().putValue(getIdentifier(), value);
		getState().notify(getIdentifier());
	}
	
}
