package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.*;

/**
 * Class: BinExpr.
 * @author Danny
 *
 * BinExpr: binary expression
 */
public class BinExpr extends Expr {
	// Expr left and right
	private final Expr 	left, 
				 		right;
	
	// The operator of the expr
	protected final String op;
		
	/**
	 * Constructor 
	 * @param l - the left expr
	 * @param r - the right expr
	 * @param op - the operator value as a string or null 
	 */
	public BinExpr(Expr l, Expr r, String op){
		this.left = l;
		this.right = r;
		this.op = op;
	}
	/**
	 * getLeft()
	 * @return left
	 */
	public Expr getLeft(){
		return this.left;
	}
	/**
	 * getRight()
	 * @return right
	 */
	public Expr getRight(){
		return this.right;
	}
	/**
	 * getOperator
	 * @return String - the operator or null when no value is given
	 */
	public String getOperator(){
		return this.op;
	}
	/**
	 * accept()
	 * @param visitor
	 */
	@Override
	public void accept(Visitor visitor){
		visitor.visit(this);
	}
	/**
	 * isCompatibleTo
	 * @param t type
	 * @return boolean - true if compatible false otherwise
	 */
	@Override
	public boolean isCompatibleTo(Expr t) {
		return false;
	}
	/**
	 * getType
	 * @param st - the table to check for the type
	 * @return Expr - type
	 */
	@Override
	public Expr getType(SymbolTable st) {
		return this;
	}

}
