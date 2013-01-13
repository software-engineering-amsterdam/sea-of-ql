package org.uva.sea.ql.parser.antlr.types;


public class Money extends DataType {
	private double value;

	public Money() { }
	
	
	public Money(String value) {
		this.value = Double.parseDouble(value);
	}
	
	public Object getValue() {
		return value;
	}
}
