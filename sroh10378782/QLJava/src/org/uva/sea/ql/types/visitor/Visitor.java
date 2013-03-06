package org.uva.sea.ql.types.visitor;

import org.uva.sea.ql.types.TBool;
import org.uva.sea.ql.types.TInt;
import org.uva.sea.ql.types.TStr;
import org.uva.sea.ql.types.TMoney;
import org.uva.sea.ql.types.TNumeric;

public interface Visitor {
	void visit(TBool bool);
	void visit(TInt integer);
	void visit(TStr string);
	void visit(TMoney money);
	void visit(TNumeric numeric);
}