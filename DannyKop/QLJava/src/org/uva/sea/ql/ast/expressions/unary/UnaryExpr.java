package org.uva.sea.ql.ast.expressions.unary;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.visitor.SymbolTable;
import org.uva.sea.ql.ast.visitor.Visitor;

/**
 * Class: UnaryExpr
 * @author Danny
 *
 */
public class UnaryExpr extends Expr {
	
	// The operator of the expr
	protected final String op;
	
	// The expression
	private final Expr argument;
	
	/**
	 * UnaryExpr
	 * @param expr - the expr
	 */
	public UnaryExpr(Expr expr){
		this(expr, null);
	}
	
	/**
	 * Constructor
	 * @param expr - the expr
	 * @param op - the string of the operator or call other constructor
	 */
	public UnaryExpr(Expr expr, String op) {
		this.op = op;
		this.argument = expr;	
	}
	/**
	 * getArgument
	 * @return expr 
	 */
	public Expr getArgument(){
		return this.argument;
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
	 * getType
	 * @param st - the table to check for the type
	 * @return Expr - type
	 */
	@Override
	public Expr getType(SymbolTable st) {
		return this;
	}
	/**
	 * isCompatibleTo
	 * @param t type
	 * @return boolean - true if compatible false otherwise
	 */
	@Override
	public boolean isCompatibleTo(Expr t) {
		return t.isCompatibleTo(this);
	}

}
