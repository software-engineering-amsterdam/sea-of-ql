package org.uva.sea.ql.parser;

import org.uva.sea.ql.common.VisitorException;

public class ParseError extends VisitorException {
	private static final long serialVersionUID = 1L;

	public ParseError(String msg) {
		super(msg);
	}
}
