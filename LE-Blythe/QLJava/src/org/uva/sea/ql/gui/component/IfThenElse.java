package org.uva.sea.ql.gui.component;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.util.Environment;

public class IfThenElse extends IfThen {

	private static final long serialVersionUID = 1L;

	private Block elseBlock;
	
	public IfThenElse(Expr condition, Block ifBlock, Block elseBlock, Environment env) {
		super(condition, ifBlock, env);
		this.elseBlock = elseBlock;
	}
	
	@Override
	public boolean evaluateVisibility() {
	
		boolean visible = isConditionFulfilled();
		
		ifBlock.setVisible(visible);
		elseBlock.setVisible(!visible);
		
		return visible;
	}

}
