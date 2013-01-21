package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.expressions.Identifier;

public class Form extends Statement {

	private Statement body;
	private Identifier name;

	public Form(ICodeLocationInformation info, Identifier name, Statement body) {
		super(info);
		this.name = name;
		this.body = body;
	}

	public Identifier getName() {
		return name;
	}

	public Statement getBody() {
		return body;
	}

}
