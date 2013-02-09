package org.uva.sea.ql.ast.ql;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.semanticchecker.VisitableQLItem;

public interface QLItem extends Statement, VisitableQLItem<QLItem> {
	
}
