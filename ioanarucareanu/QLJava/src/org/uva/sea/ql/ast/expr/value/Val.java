package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.semanticchecker.ReturnType;

public abstract class Val extends Expr implements ReturnType {
	
	private boolean defined;

	public boolean isDefined() {
		return defined;
	}

	public void setDefined(boolean defined) {
		this.defined = defined;
	}	

}
