package org.uva.sea.ql.semanticchecker.visitable.ql;

import org.uva.sea.ql.ast.ql.ConditionalQuestion;
import org.uva.sea.ql.semanticchecker.QLItemVisitor;
import org.uva.sea.ql.semanticchecker.visitable.AcceptVisit;

public class ConditionalQuestionAcceptVisit implements AcceptVisit<ConditionalQuestion, QLItemVisitor>{

	@Override
	public void act(ConditionalQuestion visitableElement, QLItemVisitor visitor) {
		visitor.visit(visitableElement);
	}

}
