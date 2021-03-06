package org.uva.sea.ql.ast.expr;


import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.VisitableExpr;


public abstract class Expr extends ASTNode implements VisitableExpr{
	 public abstract Type isOfType(Map<String, Type> typeEnv);

}
