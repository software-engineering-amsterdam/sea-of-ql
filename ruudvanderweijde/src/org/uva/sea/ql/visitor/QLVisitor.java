package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.*;

interface QLVisitor {
	void visit(Form form);
}
