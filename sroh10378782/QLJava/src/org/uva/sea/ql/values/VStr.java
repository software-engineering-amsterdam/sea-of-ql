package org.uva.sea.ql.values;

public class VStr extends Value {
	private final String value;
	public VStr(String value){
		this.value = value;
	}
	public String getValue(){
		return this.value;
	}
	@Override
	public boolean isDefined() {
		if(this.value != null){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
