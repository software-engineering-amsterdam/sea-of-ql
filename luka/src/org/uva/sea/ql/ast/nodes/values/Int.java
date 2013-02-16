package org.uva.sea.ql.ast.nodes.values;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.IntType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Int extends Numeric {


	public Int(int val) {
		super(val);
		this.value = val;
	}
	
	public void setValue(Number n){
		this.value = n.intValue();
	}

	
	@Override
	public Integer getValue() {
		return this.value.intValue();
	}
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new IntType();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	protected Value addInt(Numeric arg) {
		int result = arg.getValue().intValue() + getValue();
		return new Int((int)result);
	}

	@Override
	protected Value negInt(Numeric arg) {
		return new Int(-this.value.intValue());
	}
	
	@Override
	protected Value subInt(Numeric arg) {
		return new Int(arg.getValue().intValue() - getValue());
	}

	@Override
	protected Value mulInt(Numeric arg) {
		return new Int(arg.getValue().intValue() * getValue());
	}

	@Override
	protected Value divInt(Numeric arg) {
		return new Int(arg.getValue().intValue() / getValue());
	}

	@Override
	protected Value equInt(Numeric arg) {
		return new Int(arg.getValue().intValue() * getValue());
	}

	@Override
	protected Value ltInt(Numeric arg) {
		return new Bool(arg.getValue().intValue() < getValue());
	}

	@Override
	protected Value lEqInt(Numeric arg) {
		return new Bool(arg.getValue().intValue() <= getValue());
	}

	@Override
	protected Value gtInt(Numeric arg) {
		return new Bool(arg.getValue().intValue() > getValue());
	}
	
}
