package org.uva.sea.ql.type;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.type.TypeCheckError;

public interface ITypeCheck {
	Expr check(Expr x) throws TypeCheckError;
}
