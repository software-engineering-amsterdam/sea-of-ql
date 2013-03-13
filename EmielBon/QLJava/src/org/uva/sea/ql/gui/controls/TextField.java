package org.uva.sea.ql.gui.controls;

import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.eval.IntegerValue;
import org.uva.sea.ql.eval.Value;
import org.uva.sea.ql.interpreter.State;

public class TextField extends Control implements CaretListener {

	private JTextField component;
	
	public TextField(Identifier identifier, State state) {
		super(identifier, state);
		component = new JTextField();
		component.setPreferredSize(new Dimension(100, 24));
		component.addCaretListener(this);
		component.setText("0");
	}
	
	public JComponent getUIComponent() {
		return component;
	}

	public void setEnabled(boolean enabled) {
		component.setEnabled(enabled);
	}

	public void caretUpdate(CaretEvent e) {
		try {
			IntegerValue value = new IntegerValue(Integer.parseInt(component.getText()));
			setChanged();
			getState().putValue(getIdentifier(), value);
			getState().notify(getIdentifier());
		}
		catch(NumberFormatException ex) {
			
		}
	}
	
	public void setValue(Value value) {
		component.setText(value.toString());
		setChanged();
		getState().putValue(getIdentifier(), value);
		getState().notify(getIdentifier());
	}
	
}
