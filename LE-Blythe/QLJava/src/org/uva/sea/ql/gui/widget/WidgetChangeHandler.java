package org.uva.sea.ql.gui.widget;

import java.util.EventObject;
import java.util.Observable;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.eval.value.Value;
import org.uva.sea.ql.util.Environment;


public class WidgetChangeHandler extends Observable implements ChangeEventListener {
	
	private Ident identifier;
	private Widget widget;
	private Environment<Ident, Value> environment;
	
	public WidgetChangeHandler(Ident identifier, Widget widget, Environment<Ident, Value> environment){
		
		this.widget = widget;
		this.identifier = identifier;
		this.environment = environment;
		
		widget.addChangeEventListener(this);
	}

	@Override
	public void onChange(EventObject e) {
		
		///update value in the environment
		if(widget.isDefined())
			environment.put(identifier, widget.getValue());
		
		setChanged();
		notifyObservers();		
	}
}
