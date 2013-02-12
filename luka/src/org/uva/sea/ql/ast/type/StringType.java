package org.uva.sea.ql.ast.type;

public class StringType extends Type{

	// Double dispatch
		@Override
		public boolean isCompatibleTo(Type t) {
			return t.isCompatibleToStr();
		}

}
