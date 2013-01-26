package org.uva.sea.ql.visitor.typechecker;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.Number;
import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.visitor.ITypeVisitor;

public class TypeChecker extends NodeTypeChecker implements ITypeVisitor<Boolean> {
	@Override
	public Boolean visit( Bool node ) {
		return true;
	}

	@Override
	public Boolean visit( Int node ) {
		return true;
	}

	@Override
	public Boolean visit( Str node ) {
		return true;
	}

	@Override
	public Boolean visit( Money node ) {
		return true;
	}

	@Override
	public Boolean visit( Number node ) {
		return true;
	}
}
