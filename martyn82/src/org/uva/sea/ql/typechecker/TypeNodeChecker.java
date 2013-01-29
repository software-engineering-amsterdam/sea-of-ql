package org.uva.sea.ql.typechecker;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.Number;
import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.eval.Environment;
import org.uva.sea.ql.visitor.ITypeVisitor;

/**
 * Represents a type checker for type nodes.
 */
public class TypeNodeChecker extends TypeCheckVisitor implements ITypeVisitor<Boolean> {
	/**
	 * Constructs a new TypeChecker instance.
	 *
	 * @param environment
	 */
	public TypeNodeChecker( Environment environment ) {
		super( environment );
	}

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
