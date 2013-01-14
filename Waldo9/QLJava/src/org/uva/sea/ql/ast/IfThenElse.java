package org.uva.sea.ql.ast;

import java.util.List;

public class IfThenElse implements ASTNode {
	
	private List<Question> body;
	
	public IfThenElse(List<Question> body) {
		this.body = body;
	}

}
