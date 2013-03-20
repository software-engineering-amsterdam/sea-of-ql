package org.uva.sea.ql.ast.statements.types;

import org.uva.sea.ql.visitor.gui.FormRenderer;

public interface Type {
	public void accept(FormRenderer v);
}
