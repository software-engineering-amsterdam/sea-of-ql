package org.uva.sea.ql.ast.nodes.values;

import org.uva.sea.ql.ast.expr.Expr;

public abstract class Value extends Expr {

	
	public Value add(Value arg) {
		  throw new UnsupportedOperationException();
		}
		public Value pos() {
		  throw new UnsupportedOperationException();
		}
		public Value div(Value arg) {
		  throw new UnsupportedOperationException();
		}
		public Value mul(Value arg) {
		  throw new UnsupportedOperationException();
		}
		public Value sub(Value arg) {
		  throw new UnsupportedOperationException();
		}
		public Value and(Value arg) {
		  throw new UnsupportedOperationException();
		}
		
	protected Value addInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	protected Value divInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	protected Value mulInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	protected Value subInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	

}
