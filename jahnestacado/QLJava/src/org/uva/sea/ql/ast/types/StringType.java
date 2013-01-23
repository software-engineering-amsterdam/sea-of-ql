package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class StringType extends Type {

	

	@Override
	public void accept(ASTNodeVisitor nodeVisitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCompatibleToType(Type type) {
		return type.isCompatibleToStringType();
	}
	
	@Override
	public boolean isCompatibleToStringType() {
		return true;
	}

}
