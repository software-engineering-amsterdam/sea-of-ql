<<<<<<< HEAD:pklijn/src/org/uva/sea/ql/ast/Expr.java
package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.ast.types.Type;

public abstract class Expr implements ASTNode {
	
	public abstract Type typeOf(Map<Ident, Type> typeEnv);

	public abstract Value eval();
}
=======
package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.types.Type;

public abstract class Expr implements ASTNode {
	
	public abstract Type typeOf(Map<Ident, Type> typeEnv);
	
}
>>>>>>> 483057f28359ecac2b999d94a928c0aaf01d2a6e:gonzovilla/src/org/uva/sea/ql/ast/expr/Expr.java
