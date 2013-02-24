package org.uva.sea.ql.gui.dependencies;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class ConditionObserver implements Observer {
	private final JPanel ifTrue;
	private final JPanel ifFalse;
	
	public ConditionObserver() {
		ifTrue = null;
		ifFalse = null;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
