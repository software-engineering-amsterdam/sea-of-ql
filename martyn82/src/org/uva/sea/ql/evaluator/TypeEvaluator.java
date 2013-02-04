package org.uva.sea.ql.evaluator;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.Number;
import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.evaluator.value.Boolean;
import org.uva.sea.ql.evaluator.value.Integer;
import org.uva.sea.ql.evaluator.value.String;
import org.uva.sea.ql.evaluator.value.Undefined;
import org.uva.sea.ql.evaluator.value.Value;
import org.uva.sea.ql.visitor.ITypeVisitor;

/**
 * Evaluator for type nodes.
 */
public class TypeEvaluator implements ITypeVisitor<Value> {
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
		return new org.uva.sea.ql.evaluator.value.Money( 0d );
	}

	@Override
	public Value visit( Number node ) {
		if ( node instanceof Int ) {
			return this.visit( (Int) node );
		}
		else if ( node instanceof Money ) {
			return this.visit( (Money) node );
		}

		return new Undefined();
	}
}
