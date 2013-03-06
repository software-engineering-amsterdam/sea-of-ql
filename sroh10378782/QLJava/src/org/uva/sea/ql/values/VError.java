package org.uva.sea.ql.values;

public class VError extends Value{
	private final String error;
	public VError(String err){
		this.error = err;
	}
	
	public String getValue(){
		return this.error;
	}
	@Override
	public String toString() {
		return "VError: " + this.error;
	}

	@Override
	public boolean isDefined() {
		return true;
	}
}
