package org.uva.sea.ql.gui.widget;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.uva.sea.ql.ast.primitive.Primitive;

public abstract class Widget implements ChangeEventSource {

	private List<ChangeEventListener> changeEventListeners;
	
	public Widget(){
		changeEventListeners = new ArrayList<ChangeEventListener>();
	}
	
	
	protected synchronized void fireChangeEvent() {
		
		ChangeEvent event = new ChangeEvent(this);
		Iterator<ChangeEventListener> i = changeEventListeners.iterator();
		
		while(i.hasNext())
			i.next().onChange(event);
	}

	
	public synchronized void addChangeEventListener(ChangeEventListener listener){
		changeEventListeners.add(listener);
	}
	
	
	public synchronized void removeChangeEventListener(ChangeEventListener listener){
		changeEventListeners.remove(listener);
	}
	
	
	public boolean isDefined() {
		return getValue().isDefined();
	}
	
	
	public abstract Component getComponent();
	
	public abstract Primitive getValue();
	
	
}
