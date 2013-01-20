package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class BoolType extends Type {
	
		public BoolType(String typeName) {
			super(typeName);
		}

		@Override
		public void accept(ASTNodeVisitor nodeVisitor) {
			// TODO Auto-generated method stub
			
		}

}
