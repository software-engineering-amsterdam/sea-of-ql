package org.uva.sea.ql.ast;

import java.util.Calendar;

public class Date extends Expr {

	private final Calendar value;

	public Date(Calendar d) {
		this.value = d;
	}

	public Calendar getValue() {
		return this.value;
	}
	
}
