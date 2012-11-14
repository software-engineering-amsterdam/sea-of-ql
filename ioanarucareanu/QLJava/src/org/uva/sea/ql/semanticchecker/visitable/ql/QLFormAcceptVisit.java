package org.uva.sea.ql.semanticchecker.visitable.ql;

import org.uva.sea.ql.ast.ql.QLForm;
import org.uva.sea.ql.semanticchecker.QLItemVisitor;
import org.uva.sea.ql.semanticchecker.visitable.AcceptVisit;

public class QLFormAcceptVisit implements AcceptVisit<QLForm, QLItemVisitor>{

	@Override
	public void act(QLForm visitableElement, QLItemVisitor visitor) {
		visitor.visit(visitableElement);	
	}

}
