package org.uva.sea.ql.ast;


public abstract class Binary extends Expr {

	private Expr left;
	private Expr right;
	
	public Binary(Expr left, Expr right){
		this.left = left; 
		this.right = right;
	}
	
	protected Expr getLeft(){
		return left; 
	}
	
	protected Expr getRight(){
		return right;
	}

}
