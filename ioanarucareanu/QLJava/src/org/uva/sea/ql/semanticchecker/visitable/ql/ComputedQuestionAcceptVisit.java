package org.uva.sea.ql.semanticchecker.visitable.ql;

import org.uva.sea.ql.ast.ql.ComputedQuestion;
import org.uva.sea.ql.semanticchecker.QLItemVisitor;
import org.uva.sea.ql.semanticchecker.visitable.AcceptVisit;

public class ComputedQuestionAcceptVisit implements AcceptVisit<ComputedQuestion, QLItemVisitor>{

	@Override
	public void act(ComputedQuestion visitableElement, QLItemVisitor visitor) {
		visitor.visit(visitableElement);		
	}

}
