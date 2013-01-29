package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.Node;

public class TypeNode extends Node {

	public Type type;
	
	public TypeNode(ICodeLocationInformation info, Type type) {
		super(info);
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}

}
