package org.uva.sea.ql.ast.statements;

import java.util.ArrayList;

public class StatementBody {
	private final ArrayList<FormStatement> _body;

	public StatementBody() {
		_body = new ArrayList<FormStatement>();
	}
	
	public void add(FormStatement statement) {
		_body.add(statement);
	}
	
	public ArrayList<FormStatement> getStatements() {
		return _body;
	}
}