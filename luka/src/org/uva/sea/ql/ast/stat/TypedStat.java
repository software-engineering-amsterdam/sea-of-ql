package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.StatementVisitor;

public abstract class TypedStat  implements Stat { //extends Observable
	protected final Ident ident;
	protected final String label;
	protected final Type type;

	public TypedStat(Ident ident, String label, Type type) {
		this.ident = ident;
		this.label = label;
		this.type = type;
	}

	public Ident getIdent() {
		return this.ident;
	}

	public String getLabel() {
		return this.label;
	}

	public Type getType() {
		return this.type;
	}
	
	
	
	
	@Override
	public void accept(StatementVisitor visitor) {
	}
	
//	public void valueHasChanged(){
//		setChanged();
//	}

//	@Override
//	public synchronized void addObserver(Observer o) {
//		System.err.println("Adding observer to statement"+countObservers());
//		super.addObserver(o);
//	}
//
//	@Override
//	protected synchronized void clearChanged() {
//		super.clearChanged();
//	}
//
//	@Override
//	public synchronized int countObservers() {
//		return super.countObservers();
//	}
//
//	@Override
//	public synchronized void deleteObserver(Observer o) {
//		super.deleteObserver(o);
//	}
//
//	@Override
//	public synchronized void deleteObservers() {
//		super.deleteObservers();
//	}
//
//	@Override
//	public synchronized boolean hasChanged() {
//		return super.hasChanged();
//	}
//
//	@Override
//	public void notifyObservers() {
//		System.err.println("Notify observer to statement"+this.toString());
//		super.notifyObservers();
//	}
//
//	@Override
//	public void notifyObservers(Object arg) {
//		super.notifyObservers(arg);
//	}
//
//	@Override
//	protected synchronized void setChanged() {
//		super.setChanged();
//	}


}
