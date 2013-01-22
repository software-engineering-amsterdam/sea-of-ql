package org.uva.sea.ql.ast.expr;


import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.types.Type;




public abstract class Expr extends ASTNode {
	 public abstract Type isOfType(Map<Ident, Type> typeEnv);

}
