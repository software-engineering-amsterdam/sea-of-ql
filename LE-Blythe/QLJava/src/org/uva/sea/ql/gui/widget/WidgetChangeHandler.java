package org.uva.sea.ql.gui.widget;

import java.util.EventObject;
import java.util.Observable;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.util.Environment;


public class WidgetChangeHandler extends Observable implements ChangeEventListener {
	
	private Ident identifier;
	private Widget widget;
	private Environment environment;
	
	public WidgetChangeHandler(Ident identifier, Widget widget, Environment environment){
		
		this.widget = widget;
		this.identifier = identifier;
		this.environment = environment;
		
		widget.addChangeEventListener(this);
	}

	@Override
	public void onChange(EventObject e) {
		
		///update value in the environment
		if(widget.isDefined())
			environment.putValue(identifier, widget.getValue());
		
		setChanged();
		notifyObservers();
		
		widget.getComponent().invalidate();
		widget.getComponent().validate();
		
	}
}
