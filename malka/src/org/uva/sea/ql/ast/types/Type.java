package org.uva.sea.ql.ast.types;

import java.util.Arrays;
import java.util.List;


public class Type {
	
	private final String type;
	
	public Type(String type) throws TypeNotSupportedException {
		if (getPossibleTypes().contains(type)) {
			this.type = type;
		} else {
			throw new TypeNotSupportedException();
		}
	}
	
	public String getType() {
		return type;
	}
	
	protected List<String> getPossibleTypes() {
		return Arrays.asList("boolean", "integer", "string");
	}
	
}
