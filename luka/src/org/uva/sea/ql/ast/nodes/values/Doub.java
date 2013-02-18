package org.uva.sea.ql.ast.nodes.values;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.DoubleType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Doub extends Numeric {

	public Doub(Double value) {
		super(); 
		this.value = value;
	}


	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new DoubleType();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Double getValue() {
		return this.value.doubleValue();
	}

	@Override
	protected Value addInt(Numeric arg) {
		double result = arg.getValue().doubleValue() + getValue();
		return new Doub(result);
	}

	@Override
	protected Value negInt(Numeric arg) {
		return new Doub(this.value.doubleValue());
	}

	@Override
	protected Value subInt(Numeric arg) {
		double result = arg.getValue().doubleValue() - getValue();
		return new Doub(result);
	}

	@Override
	protected Value mulInt(Numeric arg) {
		double result = arg.getValue().doubleValue() * getValue();
		return new Doub(result);
	}

	@Override
	protected Value divInt(Numeric arg) {
		double result = arg.getValue().doubleValue() / getValue();
		return new Doub(result);
	}

	@Override
	protected Value equInt(Numeric arg) {
		return new Bool(arg.getValue().doubleValue() == getValue());
	}

	@Override
	protected Value ltInt(Numeric arg) {
		return new Bool(arg.getValue().doubleValue() < getValue());
	}

	@Override
	protected Value lEqInt(Numeric arg) {
		return new Bool(arg.getValue().doubleValue() <= getValue());
	}

	@Override
	protected Value gtInt(Numeric arg) {
		return new Bool(arg.getValue().doubleValue() > getValue());
	}

	@Override
	protected Value posInt(Numeric arg) {
		return new Doub(arg.getValue().doubleValue());
	}

	@Override
	protected Value gEqInt(Numeric arg) {
		return new Bool(arg.getValue().doubleValue() >= getValue());
	}
}
