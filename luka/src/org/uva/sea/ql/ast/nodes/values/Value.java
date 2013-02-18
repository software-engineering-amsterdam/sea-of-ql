package org.uva.sea.ql.ast.nodes.values;

import org.uva.sea.ql.ast.expr.Expr;

public abstract class Value extends Expr {

	public abstract Object getValue();

	public abstract boolean isDefined();

	public abstract Value add(Value arg);

	// BOOLEAN
	public abstract Value and(Value arg);

	public abstract Value or(Value arg);

	public abstract Value equ(Value arg);

	public abstract Value nEqu(Value arg);

	public abstract Value not(); // Value val

	// BOOLEAN INTERNAL

	protected abstract Value andBool(Bool arg);

	protected abstract Value orBool(Bool arg);

	protected abstract Value equBool(Bool arg);

	protected abstract Value notBool(Bool arg);

	// INTEGER

	public abstract Value pos();

	public abstract Value div(Value arg);

	public abstract Value mul(Value arg);

	public abstract Value sub(Value arg);

	public abstract Value neg();

	public abstract Value lt(Value arg);

	public abstract Value lEq(Value arg);

	public abstract Value gt(Value arg);

	public abstract Value gEq(Value arg);

	// INTEGER INTERNAL
	protected abstract Value addInt(Numeric arg);

	protected abstract Value divInt(Numeric arg);

	protected abstract Value mulInt(Numeric arg);

	protected abstract Value subInt(Numeric arg);

	protected abstract Value equInt(Numeric arg);

	protected abstract Value posInt(Numeric arg);

	protected abstract Value negInt(Numeric arg);

	protected abstract Value ltInt(Numeric arg);

	protected abstract Value lEqInt(Numeric arg);

	protected abstract Value gtInt(Numeric arg);

	protected abstract Value gEqInt(Numeric arg);

	protected abstract Value nEquInt(Numeric arg);

}
