package org.uva.sea.ql.observer;

import javax.swing.JCheckBox;

import org.uva.sea.ql.ast.alg.Bool;
import org.uva.sea.ql.visitor.Value;

public class CheckBoxControl extends JCheckBox implements Control {
	@Override
	public void setValue(Value value) {
		setSelected(((Bool) value).getValue());
	}

}
