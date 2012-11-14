package org.uva.sea.ql.semanticchecker.visitable.ql;

import org.uva.sea.ql.ast.ql.Question;
import org.uva.sea.ql.semanticchecker.QLItemVisitor;
import org.uva.sea.ql.semanticchecker.visitable.AcceptVisit;

public class QuestionAcceptVisit implements AcceptVisit<Question, QLItemVisitor> {

	@Override
	public void act(Question visitableElement, QLItemVisitor visitor) {
		visitor.visit(visitableElement);
	}

}
