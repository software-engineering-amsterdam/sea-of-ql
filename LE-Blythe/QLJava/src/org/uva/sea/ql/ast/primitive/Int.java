package org.uva.sea.ql.ast.primitive;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.IVisitorExpr;
import org.uva.sea.ql.util.Environment;

public class Int extends Primitive {

	private int value;
	
	public Int(int n){
		value = n;
	}
	
	
	public Integer getValue(){
		return value;
	}
	
	@Override
	public Type typeOf(Environment env){
		return new org.uva.sea.ql.ast.types.Int();
	}
	
	
	@Override
	public <T> T accept(IVisitorExpr<T> visitor) {
		return visitor.visit(this);
	}	
	
	@Override
	public String toString(){
		return Integer.toString(value);
	}
	
	//----------- Generic Numeric -------------------------
	@Override
	public Primitive add(Primitive arg) {
		return arg.addInt(this);
	}

	@Override
	public Primitive div(Primitive arg) {
		return arg.divInt(this);
	}

	@Override
	public Primitive mul(Primitive arg) {
		return arg.mulInt(this);
	}

	@Override
	public Primitive sub(Primitive arg) {
		return arg.subInt(this);
	}

	@Override
	public Primitive pos() {
		return new Int(Math.abs(this.getValue()));
	}

	@Override
	public Primitive neg() {
		return new Int(-1* this.getValue());
	}

	//----------- Generic Comparative-------------------------
	@Override
	public Primitive eq(Primitive arg) {
		return arg.eqInt(this);
	}

	@Override
	public Primitive gEq(Primitive arg) {
		return arg.gEqInt(this);
	}

	@Override
	public Primitive gt(Primitive arg) {
		return arg.gtInt(this);
	}

	@Override
	public Primitive lEq(Primitive arg) {
		return arg.lEqInt(this);
	}

	@Override
	public Primitive lt(Primitive arg) {
		return arg.ltInt(this);
	}

	@Override
	public Primitive nEq(Primitive arg) {
		return arg.nEqInt(this);
	}
	
	//----------- Int Numeric-------------------------
	@Override
	protected Primitive addInt(Int arg) {
		return new Int(arg.getValue() + this.getValue());
	}

	@Override
	protected Primitive divInt(Int arg) {
		return new Int(arg.getValue() / this.getValue());
	}

	@Override
	protected Primitive mulInt(Int arg) {
		return new Int(arg.getValue() * this.getValue());
	}

	@Override
	protected Primitive subInt(Int arg) {
		return new Int(arg.getValue() - this.getValue());
	}
	
	//----------- Int Comparative -------------------------
	@Override
	protected Primitive eqInt(Int arg) {
		return new Bool(arg.getValue() == this.getValue());
	}
	
	@Override
	protected Primitive nEqInt(Int arg) {
		return new Bool(arg.getValue() != this.getValue());
	}
	
	@Override
	protected Primitive gEqInt(Int arg) {
		return new Bool(arg.getValue() >= this.getValue());
	}
	
	@Override
	protected Primitive gtInt(Int arg) {
		return new Bool(arg.getValue() > this.getValue());
	}
	
	@Override
	protected Primitive lEqInt(Int arg) {
		return new Bool(arg.getValue() <= this.getValue());
	}
	
	@Override
	protected Primitive ltInt(Int arg) {
		return new Bool(arg.getValue() < this.getValue());
	}
	
}
