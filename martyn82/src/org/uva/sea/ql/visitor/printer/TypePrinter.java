package org.uva.sea.ql.visitor.printer;

import java.io.OutputStream;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.Number;
import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.visitor.ITypeVisitor;

public class TypePrinter extends PrintVisitor implements ITypeVisitor<Boolean> {
	/**
	 * Constructs a new TypePrinter instance.
	 *
	 * @param out
	 */
	public TypePrinter( OutputStream out ) {
		super( out );
	}

	@Override
	public Boolean visit( Bool node ) {
		writeName( node );
		return true;
	}

	@Override
	public Boolean visit( Int node ) {
		writeName( node );
		return true;
	}

	@Override
	public Boolean visit( Str node ) {
		writeName( node );
		return true;
	}

	@Override
	public Boolean visit( Money node ) {
		writeName( node );
		return true;
	}

	@Override
	public Boolean visit( Number node ) {
		writeName( node );
		return true;
	}
}
