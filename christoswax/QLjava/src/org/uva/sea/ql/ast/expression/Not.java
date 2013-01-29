package org.uva.sea.ql.ast.expression; 
import org.uva.sea.ql.ast.*;

public class Not extends Unary {

	public Not(Expr x) {
		super(x);
	}
}