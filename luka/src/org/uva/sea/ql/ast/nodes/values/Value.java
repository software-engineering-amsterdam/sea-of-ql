package org.uva.sea.ql.ast.nodes.values;

import org.uva.sea.ql.ast.expr.ASTNode;
import org.uva.sea.ql.ast.expr.Expr;


public abstract class Value extends Expr{
	
	// TODO MUST HERE support operations FOR ALL TYPES
	
	
	 public static final ASTNode NULL = new ASTNode();  
	 public static final ASTNode VOID = new ASTNode(); 
}
