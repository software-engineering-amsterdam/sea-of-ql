package org.uva.sea.ql.interpreter;

import javax.swing.JComponent;
import org.uva.sea.ql.eval.Value;

public class Control extends JComponent {

	private Value value;
	
	public Value getValue() {
		return value;
	}
	
	public void setValue(Value v) {
		value = v;
	}
	
}
