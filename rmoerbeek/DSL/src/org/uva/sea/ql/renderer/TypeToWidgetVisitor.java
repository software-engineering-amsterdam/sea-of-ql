package org.uva.sea.ql.renderer;

import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Error;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.visitors.TypeVisitor;
import org.uva.sea.ql.evaluator.values.BoolValue;
import org.uva.sea.ql.evaluator.values.IntValue;
import org.uva.sea.ql.evaluator.values.StringValue;

public class TypeToWidgetVisitor implements TypeVisitor<Control> {
	
	private final State state;
	private final Question question;
	private final boolean editable;
	
	public TypeToWidgetVisitor(State s, Question q, boolean b) {
		this.state = s;
		this.question = q;
		this.editable = b;
	}
	
	

	@Override
	public Control visit(BooleanType type) {
		state.putValue(question.getIdentifier(), new BoolValue(false));
		return new CheckBox();
	}

	@Override
	public Control visit(IntType type) {
		state.putValue(question.getIdentifier(), new IntValue(0));
		return new NumField();
	}

	@Override
	public Control visit(StringType type) {
		state.putValue(question.getIdentifier(), new StringValue(""));
		return new TextField();
	}

	@Override
	public Control visit(Error type) {
		return null;
	}

}
