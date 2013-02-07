package org.uva.sea.ql.visitor.evaluator;

import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.NumberType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.visitor.TypeVisitor;
import org.uva.sea.ql.visitor.evaluator.value.BooleanValue;
import org.uva.sea.ql.visitor.evaluator.value.IntegerValue;
import org.uva.sea.ql.visitor.evaluator.value.MoneyValue;
import org.uva.sea.ql.visitor.evaluator.value.StringValue;
import org.uva.sea.ql.visitor.evaluator.value.UndefinedValue;
import org.uva.sea.ql.visitor.evaluator.value.Value;

/**
 * Evaluator for type nodes.
 */
public class TypeInitializer implements TypeVisitor<Value> {
	@Override
	public Value visit( BooleanType node ) {
		return new BooleanValue( false );
	}

	@Override
	public Value visit( IntegerType node ) {
		return new IntegerValue( 0 );
	}

	@Override
	public Value visit( StringType node ) {
		return new StringValue( "" );
	}

	@Override
	public Value visit( MoneyType node ) {
		return new MoneyValue( 0d );
	}

	@Override
	public Value visit( NumberType node ) {
		// TODO get this out

		if ( node instanceof IntegerType ) {
			return this.visit( (IntegerType) node );
		}
		else if ( node instanceof MoneyType ) {
			return this.visit( (MoneyType) node );
		}

		return UndefinedValue.UNDEFINED;
	}
}
