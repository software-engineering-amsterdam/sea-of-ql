package org.uva.sea.ql.interpreter;

import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.ErrorType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.evaluator.values.BoolValue;
import org.uva.sea.ql.evaluator.values.IntValue;
import org.uva.sea.ql.evaluator.values.StrValue;
import org.uva.sea.ql.visitor.ITypeVisitor;

public class InitializeValues  implements ITypeVisitor<Void> {
	private final Question stmt;
	private final State state;
	
	public InitializeValues(Question stmt, State state) {
		this.stmt = stmt;
		this.state = state;
	}
	
	@Override
	public Void visit(BoolType type) {
		state.putValue(stmt.getIdent(), new BoolValue(false));
		return null;
	}
	
	@Override
	public Void visit(IntType type) {
		state.putValue(stmt.getIdent(), new IntValue(0));
		return null;
	}
	
	@Override
	public Void visit(StringType type) {
		state.putValue(stmt.getIdent(), new StrValue(""));
		return null;
	}
	
	@Override
	public Void visit(ErrorType type) {
		return null;
	}
}