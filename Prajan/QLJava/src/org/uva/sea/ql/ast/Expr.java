package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.AlgebricElementVisitor;

public abstract class Expr implements ASTNode {

	public abstract Type typeOf(Map<Ident, Type> typeEnv);

	public abstract <T> T accept(AlgebricElementVisitor<T> visitor);

}
