package org.uva.sea.ql.visitor.evaluator;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.Number;
import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.visitor.TypeVisitor;
import org.uva.sea.ql.visitor.evaluator.value.Boolean;
import org.uva.sea.ql.visitor.evaluator.value.Integer;
import org.uva.sea.ql.visitor.evaluator.value.String;
import org.uva.sea.ql.visitor.evaluator.value.Undefined;
import org.uva.sea.ql.visitor.evaluator.value.Value;

/**
 * Evaluator for type nodes.
 */
public class TypeInitializer implements TypeVisitor<Value> {
	@Override
	public Value visit( Bool node ) {
		return new Boolean( false );
	}

	@Override
	public Value visit( Int node ) {
		return new Integer( 0 );
	}

	@Override
	public Value visit( Str node ) {
		return new String( "" );
	}

	@Override
	public Value visit( Money node ) {
		return new org.uva.sea.ql.visitor.evaluator.value.Money( 0d );
	}

	@Override
	public Value visit( Number node ) {
		// TODO get this out

		if ( node instanceof Int ) {
			return this.visit( (Int) node );
		}
		else if ( node instanceof Money ) {
			return this.visit( (Money) node );
		}

		return Undefined.UNDEFINED;
	}
}
