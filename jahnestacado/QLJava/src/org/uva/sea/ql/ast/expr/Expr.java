package org.uva.sea.ql.ast.expr;


import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.types.Type;


public abstract class Expr extends ASTNode implements VisitableExpr{
	 public abstract Type getExprType(Map<String, Type> typeEnv);

}
