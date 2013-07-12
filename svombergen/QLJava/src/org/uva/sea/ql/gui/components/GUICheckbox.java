package org.uva.sea.ql.gui.components;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JCheckBox;

import org.uva.sea.ql.ast.value.BoolValue;

@SuppressWarnings("serial")
public class GUICheckbox extends JCheckBox implements Observer {
	
	@Override
	public void update(Observable o, Object arg) {
		boolean b;
		
		b = ((BoolValue)o).getValue();
		
		this.setSelected(b);
	}

}
