package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.expressions.StringLiteral;

public class Form extends Statement {

	private Statement body;
	private String name;

	public Form(ICodeLocationInformation info, StringLiteral name, Statement body) {
		super(info);
		this.name = name.getValue();
		this.body = body;
	}

	public String getName() {
		return name;
	}

	public Statement getBody() {
		return body;
	}

}
