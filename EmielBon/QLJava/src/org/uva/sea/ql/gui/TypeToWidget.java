package org.uva.sea.ql.gui;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.gui.controls.*;
import org.uva.sea.ql.interpreter.State;

public class TypeToWidget implements TypeVisitor<Control> {

	private final Identifier identifier;
	private final State state;
	
	public TypeToWidget(Identifier identifier, State state) {
		this.identifier = identifier;
		this.state = state;
	}
	
	public Control visit(Bool type) {
		return new RadioButton( identifier, state );
	}

	public Control visit(ErrorType type) {
		return null;
	}

	public Control visit(Int type) {
		return new TextField( identifier, state );
	}

	public Control visit(Numeric type) {
		return new TextField( identifier, state );
	}

	public Control visit(Str type) {
		return new TextField( identifier, state );
	}
	
}
