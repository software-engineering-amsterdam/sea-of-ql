package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.NodeVisitor;

public class Question implements QuestionElement {

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void add(QuestionElement question) {

	}

}
