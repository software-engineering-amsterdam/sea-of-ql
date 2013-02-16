package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.IStatementVisitor;
import org.uva.sea.ql.ast.expressions.Identifier;

/**
 *	Defines a form (questionnaire). This is the root of a QL program.
 */
public class Form extends Statement {

	private Statements body;
	private Identifier name;

	public Form(ICodeLocationInformation info, Identifier name, Statements body) {
		super(info);
		this.name = name;
		this.body = body;
	}

	public Identifier getName() {
		return name;
	}

	public Statements getBody() {
		return body;
	}
	@Override
	public void accept(IStatementVisitor visitor)  {
		visitor.visit(this);
	}

}
