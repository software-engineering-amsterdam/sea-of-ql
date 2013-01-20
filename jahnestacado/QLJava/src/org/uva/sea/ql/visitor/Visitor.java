package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Binary;

public interface Visitor {
		public void visit(Binary expr);
}
