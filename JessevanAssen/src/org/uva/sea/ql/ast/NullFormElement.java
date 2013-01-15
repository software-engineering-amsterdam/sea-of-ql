package org.uva.sea.ql.ast;

import org.uva.sea.ql.ASTNodeVisitor;

public class NullFormElement implements FormElement {

	@Override
	public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return null;
	}

}
