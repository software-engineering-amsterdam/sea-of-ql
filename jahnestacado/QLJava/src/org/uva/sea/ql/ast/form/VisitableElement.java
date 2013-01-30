package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.visitor.IElementVisitor;

public interface VisitableElement {
		public void accept(IElementVisitor qlElement);
}
