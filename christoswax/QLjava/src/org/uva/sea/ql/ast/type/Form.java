package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.statement.*;

public class Form extends Type {
	private final Ident ident;
	private final StatementsBlock block;

	public Form(Ident ident, StatementsBlock block) {
		this.ident = ident;
		this.block = block;
	}

	public Ident getIdent() {
		return ident;
	}

	public StatementsBlock getBlock() {
		return block;
	}
}