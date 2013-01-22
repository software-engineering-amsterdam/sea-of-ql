package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.datatype.Datatype;
import org.uva.sea.ql.typechecker.SymbolTable;

public abstract class Expression implements ASTNode {
	public abstract Datatype typeOf(SymbolTable symbols);
}
