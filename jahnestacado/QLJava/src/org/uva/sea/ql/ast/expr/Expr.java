package org.uva.sea.ql.ast.expr;


import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.Visitable;


public abstract class Expr extends ASTNode implements Visitable{
	 public abstract Type isOfType(Map<Ident, Type> typeEnv);

}
