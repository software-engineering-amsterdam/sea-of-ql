package org.uva.sea.ql.rendering;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.ErrorType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.TypeVisitor;
import org.uva.sea.ql.evaluation.values.Bool;
import org.uva.sea.ql.evaluation.values.Int;

public class InitializationTypeVisitor implements TypeVisitor<Object> {
	
	private final State state;
	private final Ident identifier;
	
	public InitializationTypeVisitor(State state, Ident identifier) {
		this.state = state;
		this.identifier = identifier;
	}

	@Override
	public Object visit(IntType intType) {
		state.putValue(identifier, new Int(0));
		return null;
	}

	@Override
	public Object visit(StringType stringType) {
		state.putValue(identifier, new org.uva.sea.ql.evaluation.values.String(""));
		return null;
	}

	@Override
	public Object visit(BoolType boolType) {
		state.putValue(identifier, new Bool(false));
		return null;
	}

	@Override
	public Object visit(ErrorType errorType) {
		return null;
	}

}
