package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.Node;

public class TypeNode extends Node {

	private final Type type;

	public TypeNode(final ICodeLocationInformation info, final Type type) {
		super(info);
		this.type = type;
	}

	public Type getType() {
		return this.type;
	}

}
