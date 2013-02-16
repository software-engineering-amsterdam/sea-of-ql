package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Type;

public class Str extends Type {
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToStr();
	}
	
	@Override
	public boolean isCompatibleToStr() { return true; }
}