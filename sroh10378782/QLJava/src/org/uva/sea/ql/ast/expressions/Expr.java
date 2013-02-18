package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.nodes.ASTNode;
import org.uva.sea.ql.visitor.Visitable;
import org.uva.sea.ql.visitor.Visitor;

public abstract class Expr implements ASTNode, Visitable {
	private final String astNodeType = "Expression";
	public String getNodeType(){
		return this.astNodeType;
	}
	
	public boolean isAddExpression(){
		return false;
	}
	public boolean isAndExpression(){
		return false;
	}
	public boolean isDivExpression(){
		return false;
	}
	public boolean isEqExpression(){
		return false;
	}
	public boolean isGEqExpression(){
		return false;
	}
	public boolean isGTExpression(){
		return false;
	}
	public boolean isLEqExpression(){
		return false;
	}
	public boolean isLTExpression(){
		return false;
	}
	public boolean isMulExpression(){
		return false;
	}
	public boolean isNegExpression(){
		return false;
	}
	public boolean isNEqExpression(){
		return false;
	}
	public boolean isNotExpression(){
		return false;
	}
	public boolean isOrExpression(){
		return false;
	}
	public boolean isPosExpression(){
		return false;
	}
	public boolean isSubExpression(){
		return false;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
