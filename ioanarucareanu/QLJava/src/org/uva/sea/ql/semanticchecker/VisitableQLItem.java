package org.uva.sea.ql.semanticchecker;

import org.uva.sea.ql.ast.ql.QLItem;

public interface VisitableQLItem<T extends QLItem> {
	
	void accept(T visitableElement, QLItemSemanticVisitor visitor);

}
