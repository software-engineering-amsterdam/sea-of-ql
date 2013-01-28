package org.uva.sea.ql.ast.type;
import org.uva.sea.ql.ast.*;

public class StringType extends Type {
	private final String value;

	public StringType(String value) {
		this.value = value;
	}

}

