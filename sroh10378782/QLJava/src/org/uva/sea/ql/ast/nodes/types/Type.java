package org.uva.sea.ql.ast.nodes.types;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.visitor.Visitable;
import org.uva.sea.ql.visitor.Visitor;

public abstract class Type extends Expr implements Visitable{
	public abstract String toString();
	
	public boolean isComputatedType(){
		return false;
	}
	public boolean isCompatibleWithBool(){
		return false;
	}
	public boolean isCompatibleWithInt(){
		return false;
	}
	public boolean isCompatibleWithFloat(){
		return false;
	}
	public boolean isCompatibleWithMoney(){
		return false;
	}
	public boolean isCompatibleWithStr(){
		return false;
	}
	public boolean isCompatibleWithIndet(){
		return false;
	}
	
	public boolean isBoolType(){
		return false;
	}
	public boolean isIntType(){
		return false;
	}
	public boolean isFloatType(){
		return false;
	}
	public boolean isIdentType(){
		return false;
	}
	public boolean isMoneyType(){
		return false;
	}
	public boolean isStrType(){
		return false;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}