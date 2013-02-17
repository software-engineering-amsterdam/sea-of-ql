package org.uva.sea.ql.parser;

import org.uva.sea.ql.common.QLException;

public class ParseError extends QLException {
	private static final long serialVersionUID = 1L;

	public ParseError(String msg) {
		super(msg);
	}
}
