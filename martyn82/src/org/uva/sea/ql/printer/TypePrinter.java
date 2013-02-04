package org.uva.sea.ql.printer;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.Number;
import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.visitor.ITypeVisitor;

/**
 * Represents a pretty printer for type nodes.
 */
public class TypePrinter extends PrintVisitor implements ITypeVisitor<Boolean> {
	/**
	 * Constructs a new TypePrinter instance.
	 *
	 * @param context
	 */
	public TypePrinter( PrintContext context ) {
		super( context );
	}

	@Override
	public Boolean visit( Bool node ) {
		this.writeName( node );
		return true;
	}

	@Override
	public Boolean visit( Int node ) {
		this.writeName( node );
		return true;
	}

	@Override
	public Boolean visit( Str node ) {
		this.writeName( node );
		return true;
	}

	@Override
	public Boolean visit( Money node ) {
		this.writeName( node );
		return true;
	}

	@Override
	public Boolean visit( Number node ) {
		this.writeName( node );
		return true;
	}
}
