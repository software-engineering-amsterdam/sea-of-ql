package org.uva.sea.ql.interpreter;

import org.uva.sea.ql.ast.types.TypeBool;
import org.uva.sea.ql.ast.types.TypeError;
import org.uva.sea.ql.ast.types.TypeInt;
import org.uva.sea.ql.ast.types.TypeString;
import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.StringValue;
import org.uva.sea.ql.ast.values.BoolValue;
import org.uva.sea.ql.ast.visitor.VisitorTypes;

public class VisitorInitType implements VisitorTypes<Void> {

	private final State state;
	private final String name;

	public VisitorInitType(State state, String name) {
		this.state = state;
		this.name = name;
	}
	
	@Override
	public Void visit(TypeBool typeBool) {
		state.putValue(name, new BoolValue(false));
		return null;
	}

	@Override
	public Void visit(TypeError typeError) {
		return null;
	}

	@Override
	public Void visit(TypeInt typeInt) {
		state.putValue(name, new Int(0));
		return null;
	}

	@Override
	public Void visit(TypeString typeString) {
		state.putValue(name, new StringValue(""));
		return null;
	}

}
