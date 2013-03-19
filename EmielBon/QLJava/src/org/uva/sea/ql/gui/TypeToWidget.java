package org.uva.sea.ql.gui;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.gui.controls.*;

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
		return new IntegerField( identifier, state );
	}

	public Control visit(Numeric type) {
		return null;
	}

	public Control visit(Str type) {
		return new TextField( identifier, state );
	}

	public Control visit(Money type) {
		return new MoneyField( identifier, state );
	}
	
}
