package org.uva.sea.ql.ast.types;


public class BoolType extends Type {
	
		

		

		@Override
		public boolean isCompatibleToType(Type type) {
			return type.isCompatibleToBoolType(); 
		}
		
		@Override
		public boolean isCompatibleToBoolType() {
			return true;
		}

}
