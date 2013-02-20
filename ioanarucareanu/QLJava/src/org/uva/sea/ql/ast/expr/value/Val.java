package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.semanticchecker.ReturnType;

public abstract class Val extends Expr implements ReturnType {
	
	public Val add(Val value) {
		throw new UnsupportedOperationException();
	}

	public Val substract(Val value) {
		throw new UnsupportedOperationException();
	}

	public Val multiplyBy(Val value) {
		throw new UnsupportedOperationException();
	}

	public Val divideBy(Val value) {
		throw new UnsupportedOperationException();
	}
	
	public Val lessThan(Val value) {
		throw new UnsupportedOperationException();
	}
	
	public Val greaterThan(Val value) {
		throw new UnsupportedOperationException();
	}
	
	public Val equalTo(Val value) {
		throw new UnsupportedOperationException();
	}
	
	public Val notEqualTo(Val value) {
		throw new UnsupportedOperationException();
	}
	
	public Val lessOrEqualTo(Val value) {
		throw new UnsupportedOperationException();
	}
	
	public Val greaterOrEqualTo(Val value) {
		throw new UnsupportedOperationException();
	}
	
	public Val and(Val bool) {
		throw new UnsupportedOperationException();
	}

	public Val or(Val bool) {
		throw new UnsupportedOperationException();
	}

	public Val not() {
		throw new UnsupportedOperationException();
	}


}
