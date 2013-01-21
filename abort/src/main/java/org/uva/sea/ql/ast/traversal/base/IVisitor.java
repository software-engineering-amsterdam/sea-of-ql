package org.uva.sea.ql.ast.traversal.base;

import org.uva.sea.ql.ast.conditionals.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.operators.binary.*;
import org.uva.sea.ql.ast.operators.unary.*;
import org.uva.sea.ql.ast.types.*;

/**
 * Interface for the visitor that traverses all nodes in the abstract syntax tree.
 * @author J. Dijkstra
 */
public interface IVisitor {
	// Binary operators
	/**
	 * Visits add.
	 * @param add add to visit
	 */
	void visit(Add add);
	/**
	 * Visits and.
	 * @param and and to visit
	 */
	void visit(And and);
	/**
	 * Visits division.
	 * @param div div to visit
	 */
	void visit(Div div);
	/**
	 * Visits equals.
	 * @param eq eq to visit
	 */
	void visit(Eq eq);
	/**
	 * Visits greater than or equal to.
	 * @param geq geq to visit
	 */
	void visit(GEq geq);
	/**
	 * Visits greater than.
	 * @param gt gt to visit
	 */
	void visit(GT gt);
	/**
	 * Visits less than or equal to.
	 * @param leq leq to visit
	 */
	void visit(LEq leq);
	/**
	 * Visits less than.
	 * @param lt lt to visit
	 */
	void visit(LT lt);
	/**
	 * Visits multiplication.
	 * @param mul mul to visit
	 */
	void visit(Mul mul);
	/**
	 * Visits not equal to.
	 * @param neq neq to visit
	 */
	void visit(NEq neq);
	/**
	 * Visits or.
	 * @param or or to visit
	 */
	void visit(Or or);
	/**
	 * Visits subtraction.
	 * @param sub sub to visit
	 */
	void visit(Sub sub);
	
	// Unary operators
	/**
	 * Visits negative.
	 * @param neg neg to visit
	 */
	void visit(Neg neg);
	/**
	 * Visits not.
	 * @param not not to visit
	 */
	void visit(Not not);
	/**
	 * Visits positive.
	 * @param pos pos to visit
	 */
	void visit(Pos pos);
	
	// Form
	/**
	 * Visits computation.
	 * @param computation computation to visit
	 */
	void visit(Computation computation);
	/**
	 * Visits form.
	 * @param form form to visit
	 */
	void visit(Form form);
	/**
	 * Visits question.
	 * @param question question to visit
	 */
	void visit(Question question);
	/**
	 * Visits label.
	 * @param label label to visit
	 */
	void visit(Label label);
	
	// Conditionals
	/**
	 * Visit if then.
	 * @param ifThen if then to visit
	 */
	void visit(IfThen ifThen);
	/**
	 * Visit if then else.
	 * @param ifThenElse if then else to visit
	 */
	void visit(IfThenElse ifThenElse);

	// Types
	/**
	 * Visit bool.
	 * @param bool visit bool
	 */
	void visit(Bool bool);
	/**
	 * Visit int.
	 * @param i int to visit
	 */
	void visit(Int i);
	/**
	 * Visit money.
	 * @param money money to visit
	 */
	void visit(Money money);
	/**
	 * Visit string literal.
	 * @param literal string literal to visit
	 */
	void visit(StringLiteral literal);
	/**
	 * Visit ident.
	 * @param ident ident to visit
	 */
	void visit(Ident ident);
}
