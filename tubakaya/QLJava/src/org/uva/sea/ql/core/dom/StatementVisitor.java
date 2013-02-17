package org.uva.sea.ql.core.dom;

import org.uva.sea.ql.core.dom.statements.*;

public interface StatementVisitor {
	
	boolean visit(Form form);
	boolean visit(Question question);
	boolean visit(ComputedValue computedValue);
	boolean visit(IfStatement ifStatement);
}
