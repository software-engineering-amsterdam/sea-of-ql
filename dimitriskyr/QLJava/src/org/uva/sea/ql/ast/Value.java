package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.values.Bool;
import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.Money;

public abstract class Value extends Expr {

	public Value add(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value and(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value div(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value eq(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value geq(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value gt(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value leq(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value lt(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value mul(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value neg() {
		throw new UnsupportedOperationException();
	}
	
	public Value neq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value not() {
		throw new UnsupportedOperationException();
	}

	public Value or(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value pos() {
		throw new UnsupportedOperationException();
	}

	public Value sub(Value arg) {
		throw new UnsupportedOperationException();
	} 
	
	public Value addInt(Int arg) {
		throw new UnsupportedOperationException();
		}
	
	public Value addMoney(Money arg) {
		throw new UnsupportedOperationException();
		}
	
	public Value andBool(Bool arg) {
		throw new UnsupportedOperationException();
		}
	
	public Value divInt(Int arg) {
		throw new UnsupportedOperationException();
		}
	
	public Value divMoney(Money arg) {
		throw new UnsupportedOperationException();
		}
	
	public Value eqInt(Int arg) {
		throw new UnsupportedOperationException();
		}
	
	public Value eqMoney(Money arg) {
		throw new UnsupportedOperationException();
		}
	
	public Value eqBool(Bool arg) {
		throw new UnsupportedOperationException();
		}
	
	public Value geqInt(Int arg) {
		throw new UnsupportedOperationException();
		}
	
	public Value geqMoney(Money arg) {
		throw new UnsupportedOperationException();
		}
	
	public Value gtInt(Int value) {
		throw new UnsupportedOperationException();
	}
	
	public Value gtMoney(Money value) {
		throw new UnsupportedOperationException();
	}
	
	public Value leqInt(Int value) {
		throw new UnsupportedOperationException();
	}
	
	public Value leqMoney(Money value) {
		throw new UnsupportedOperationException();
	}

	public Value ltInt(Int value) {
		throw new UnsupportedOperationException();
	}

	public Value ltMoney(Money value) {
		throw new UnsupportedOperationException();
	}
	
	public Value mulInt(Int arg) {
		throw new UnsupportedOperationException();
		}
	
	public Value mulMoney(Money arg) {
		throw new UnsupportedOperationException();
		}
	
	public Value neqInt(Int Value) {
		throw new UnsupportedOperationException();
	}

	public Value neqMoney(Money value) {
		throw new UnsupportedOperationException();
	}

	public Value neqBool(Bool value) {
		throw new UnsupportedOperationException();
	}

	public Value orBool(Bool value) {
		throw new UnsupportedOperationException();
	}
	
	public Value subInt(Int arg) {
		throw new UnsupportedOperationException();
		}
	
	public Value subMoney(Money arg) {
		throw new UnsupportedOperationException();
		}
	} 

