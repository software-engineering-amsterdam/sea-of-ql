package org.uva.sea.ql.gui.widget;

import java.util.Observable;
import java.util.Observer;

public abstract class WidgetObserver implements Observer{
	
	public abstract void evaluate();
	
	@Override
	public void update(Observable o, Object arg) {
		evaluate();
	}
}
