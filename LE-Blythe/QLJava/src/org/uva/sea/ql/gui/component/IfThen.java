package org.uva.sea.ql.gui.component;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.primitive.Bool;
import org.uva.sea.ql.util.Environment;

public class IfThen extends Statement {

	private static final long serialVersionUID = 1L;
	protected Expr condition;
	protected Block ifBlock;
	
	public IfThen(Expr condition, Block ifBlock, Environment env) {
		super(env);
		this.condition = condition;
		this.ifBlock = ifBlock;
	}

	
	protected boolean isConditionFulfilled(){
		Bool interpreted = (Bool)condition.interpret(this.environment);
		return interpreted.getValue();
	}
	
	
	@Override
	public boolean evaluateVisibility() {
	
		boolean visible = isConditionFulfilled();
		
		ifBlock.setVisible(visible);
		return visible;
	}

}
