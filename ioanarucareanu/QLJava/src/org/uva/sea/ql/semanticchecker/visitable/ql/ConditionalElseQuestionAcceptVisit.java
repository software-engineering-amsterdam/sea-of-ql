package org.uva.sea.ql.semanticchecker.visitable.ql;

import org.uva.sea.ql.ast.ql.ConditionalElseQuestion;
import org.uva.sea.ql.semanticchecker.QLItemVisitor;
import org.uva.sea.ql.semanticchecker.visitable.AcceptVisit;

public class ConditionalElseQuestionAcceptVisit implements AcceptVisit<ConditionalElseQuestion, QLItemVisitor>{

	@Override
	public void act(ConditionalElseQuestion visitableElement,
			QLItemVisitor visitor) {
		visitor.visit(visitableElement);		
	}

}
