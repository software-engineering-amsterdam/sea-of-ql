package org.uva.sea.ql.ast.traversal.base;

import org.uva.sea.ql.ast.conditionals.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.operators.base.BinaryOperator;
import org.uva.sea.ql.ast.operators.base.UnaryOperator;
import org.uva.sea.ql.ast.operators.binary.*;
import org.uva.sea.ql.ast.operators.unary.*;
import org.uva.sea.ql.ast.types.literals.*;

/**
 * Interface for the visitor that traverses all nodes in the abstract syntax tree.
 * @author J. Dijkstra
 */
public interface IVisitor<T> {
	// Binary operators
	/**
	 * Visits add add.
	 * @param operator operator to visit
	 * @return predefined return type
	 */
	T visit(Add add);
	
	/**
	 * Visits and.
	 * @param and and to visit
	 * @return predefined return type
	 */
	T visit(And and);
	/**
	 * Visits division.
	 * @param div div to visit
	 * @return predefined return type 
	 */
	T visit(Div div);
	/**
	 * Visits equals.
	 * @param eq eq to visit
	 * @return predefined return type
	 */
	T visit(Eq eq);
	/**
	 * Visits greater than or equal to.
	 * @param geq geq to visit
	 * @return predefined return type
	 */
	T visit(GEq geq);
	/**
	 * Visits greater than.
	 * @param gt gt to visit
	 * @return predefined return type
	 */
	T visit(GT gt);
	/**
	 * Visits less than or equal to.
	 * @param leq leq to visit
	 * @return predefined return type
	 */
	T visit(LEq leq);
	/**
	 * Visits less than.
	 * @param lt lt to visit
	 * @return predefined return type
	 */
	T visit(LT lt);
	/**
	 * Visits multiplication.
	 * @param mul mul to visit
	 * @return predefined return type
	 */
	T visit(Mul mul);
	/**
	 * Visits not equal to.
	 * @param neq neq to visit
	 * @return predefined return type
	 */
	T visit(NEq neq);
	/**
	 * Visits or.
	 * @param or or to visit
	 * @return predefined return type
	 */
	T visit(Or or);
	/**
	 * Visits subtraction.
	 * @param sub sub to visit
	 * @return predefined return type
	 */
	T visit(Sub sub);

	// Unary operators
	/**
	 * Visits negative.
	 * @param neg neg to visit
	 * @return predefined return type
	 */
	T visit(Neg neg);
	/**
	 * Visits not.
	 * @param not not to visit
	 * @return predefined return type
	 */
	T visit(Not not);
	/**
	 * Visits positive.
	 * @param pos pos to visit
	 * @return predefined return type
	 */
	T visit(Pos pos);

	// Form
	/**
	 * Visits computation.
	 * @param computation computation to visit
	 * @return predefined return type
	 */
	T visit(Computation computation);
	/**
	 * Visits form.
	 * @param form form to visit
	 * @return predefined return type
	 */
	T visit(Form form);
	/**
	 * Visits question.
	 * @param question question to visit
	 * @return predefined return type
	 */
	T visit(Question question);
	
	// Conditionals
	/**
	 * Visit if then.
	 * @param ifThen if then to visit
	 * @return predefined return type
	 */
	T visit(IfThen ifThen);
	/**
	 * Visit if then else.
	 * @param ifThenElse if then else to visit
	 * @return predefined return type
	 */
	T visit(IfThenElse ifThenElse);

	// Types
	/**
	 * Visit bool.
	 * @param bool visit bool
	 * @return predefined return type
	 */
	T visit(BoolLiteral bool);
	/**
	 * Visit int.
	 * @param i int to visit
	 * @return predefined return type
	 */
	T visit(IntLiteral i);
	/**
	 * Visit money.
	 * @param money money to visit
	 * @return predefined return type
	 */
	T visit(MoneyLiteral money);
	/**
	 * Visit string literal.
	 * @param literal string literal to visit
	 * @return predefined return type
	 */
	T visit(StringLiteral literal);
	/**
	 * Visit ident.
	 * @param ident ident to visit
	 * @return predefined return type
	 */
	T visit(Ident ident);
}
