package org.uva.sea.ql.visitor.evaluator;

import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.TypeVisitor;
import org.uva.sea.ql.visitor.evaluator.value.BooleanValue;
import org.uva.sea.ql.visitor.evaluator.value.IntegerValue;
import org.uva.sea.ql.visitor.evaluator.value.MoneyValue;
import org.uva.sea.ql.visitor.evaluator.value.StringValue;
import org.uva.sea.ql.visitor.evaluator.value.Value;

class TypeInitializer implements TypeVisitor<Value> {
	public static Value initType( Type node ) {
		TypeInitializer init = new TypeInitializer();
		return node.accept( init );
	}

	private TypeInitializer() {}

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
}
