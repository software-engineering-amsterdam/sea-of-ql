package org.uva.sea.ql.ast.types;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import org.uva.sea.ql.ast.values.BoolValue;
import org.uva.sea.ql.ast.values.Value;

import net.miginfocom.swing.MigLayout;

public class BoolType extends Type implements ItemListener {

	private Checkbox checkboxTrue;
	private Checkbox checkboxFalse;
	
	@Override
	public String toString() {
		return "Boolean";
	}
	
	@Override
	public Component getAnswerField(boolean enabled) {
		Container c = new Container();
		c.setLayout(new MigLayout("ins 1"));
		CheckboxGroup g = new CheckboxGroup();
		checkboxTrue = new Checkbox("Yes", g, false);
		checkboxFalse = new Checkbox("No", g, false);
		checkboxTrue.addItemListener(this);
		checkboxFalse.addItemListener(this);
		checkboxTrue.setEnabled(enabled);
		checkboxFalse.setEnabled(enabled);
		c.add(checkboxTrue);
		c.add(checkboxFalse);
		return c;
	}

	@Override
	public boolean hasValue() {
		return (checkboxTrue.getState() || checkboxFalse.getState());
	}
	
	@Override
	public Value getAnswerFieldValue(Component answerComponent) {
		return new BoolValue(checkboxTrue.getState());
	}
	
	@Override
	public void setAnswerFieldValue(Value value) {
		if (value.getClass().equals(new BoolValue().getClass())) {
			if (((BoolValue)value).getValue()) {
				checkboxTrue.setState(true);
			}
			else {
				checkboxFalse.setState(true);
			}
		}
		else {
			throw new IllegalArgumentException("The value given is not of the type Boolean");
		}
	}
	
	@Override
	public Value getDefaultValue() {
		return new BoolValue();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItemSelectable();
		if (source == checkboxTrue || source == checkboxFalse) {
			if (form != null) {
				form.eval();
			}
		}
	}
}
