package org.uva.sea.ql.gui.widget;

import java.util.EventObject;
import java.util.Observable;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.util.Environment;


public class ObservableWidget extends Observable implements ChangeEventListener {
	
	private Ident identifier;
	private Widget widget;
	private Environment environment;
	
	public ObservableWidget(Ident identifier, Widget widget, Environment environment){
		
		this.widget = widget;
		this.identifier = identifier;
		this.environment = environment;
		
		widget.addChangeEventListener(this);
	}

	@Override
	public void onChange(EventObject e) {
		
		environment.putValue(identifier, widget.getValue());
		
		setChanged();
		notifyObservers();
	}
}
