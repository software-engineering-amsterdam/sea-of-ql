package org.uva.sea.ql.errors;

public abstract class QLError {
	
	public abstract void accept(QLErrorPrinter visitor);
	
}
