package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.Node;

public class TypeDeclaration extends Node {

	private final QLType type;

	public TypeDeclaration(ICodeLocationInformation info, QLType type) {
		super(info);
		this.type = type;
	}

	public QLType getType() {
		return type;
	}

}
