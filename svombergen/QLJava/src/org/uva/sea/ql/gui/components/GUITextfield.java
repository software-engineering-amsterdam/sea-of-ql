package org.uva.sea.ql.gui.components;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.value.IntValue;
import org.uva.sea.ql.ast.value.StrValue;

@SuppressWarnings("serial")
public class GUITextfield extends JTextField implements Observer {

	public GUITextfield(String s) {
		super(s);
	}

	@Override
	public void update(Observable o, Object arg) {
		String s;
		
		if (o instanceof IntValue)
			s = ((IntValue)o).getValue().toString();
		else 
			s = ((StrValue)o).getValue().toString();
		
		this.setText(s);
	}
	
}
