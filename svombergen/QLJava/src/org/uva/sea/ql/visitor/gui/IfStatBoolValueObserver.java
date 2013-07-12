package org.uva.sea.ql.visitor.gui;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import org.uva.sea.ql.ast.value.BoolValue;

public class IfStatBoolValueObserver implements Observer {

	private ArrayList<JComponent> list;
	
	public IfStatBoolValueObserver(ArrayList<JComponent> listComps) {
		list = listComps;
	}

	@Override
	public void update(Observable value, Object arg1) {
		BoolValue b = (BoolValue)value;
		for(JComponent c : list) 
			c.setEnabled(b.getValue());
	}

}
