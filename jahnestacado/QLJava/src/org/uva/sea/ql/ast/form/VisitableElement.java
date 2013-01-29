package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.visitor.checkers.ElementChecker;

public interface VisitableElement {
		public void accept(ElementChecker qlElement);
}
