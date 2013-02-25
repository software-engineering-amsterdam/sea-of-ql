package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.statements.Statements;

/**
 * Defines a form (questionnaire). This is the root of a QL program.
 */
public class Form extends Node {

	private final Statements body;
	private final String name;

	public Form(final ICodeLocationInformation info, final String name,
			final Statements body) {
		super(info);
		this.name = name;
		this.body = body;
	}

	public Statements getBody() {
		return this.body;
	}

	public String getName() {
		return this.name;
	}
}
