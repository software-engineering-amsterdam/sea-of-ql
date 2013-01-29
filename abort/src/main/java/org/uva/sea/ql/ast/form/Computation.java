package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.types.datatypes.DataType;
import org.uva.sea.ql.ast.types.literals.Ident;

/**
 * QL Computation to display in a form.
 * 
 * @author J. Dijkstra
 */
public class Computation extends Element {
	/**
	 * Identity.
	 */
	private final Ident ident;
	/**
	 * Description.
	 */
	private final String description;
	/**
	 * Expected data type of the computation.
	 */
	private final DataType expectedType;
	/**
	 * Calculation (expression) that the computation should do before displaying
	 * it.
	 */
	private final Expression expression;

	/**
	 * Constructor.
	 * 
	 * @param ident
	 *            ident
	 * @param description
	 *            description
	 * @param expectedType
	 *            expected data type of the computation
	 * @param calculationOperation
	 *            calculation that should be done
	 */
	public Computation(final Ident ident, final String description,
			final DataType expectedType, final Expression calculationOperation) {
		this.ident = ident;
		this.description = description;
		this.expectedType = expectedType;
		this.expression = calculationOperation;
	}

	/**
	 * Retrieve the ident.
	 * 
	 * @return ident
	 */
	public Ident getIdent() {
		return ident;
	}

	/**
	 * Retrieve the description.
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Retrieve the expected data type of the calculation.
	 * 
	 * @return expected data type
	 */
	public DataType getExpectedType() {
		return expectedType;
	}

	/**
	 * Retrieve the computation expression that has to be evaluated before
	 * displayed.
	 * 
	 * @return computation expression
	 */
	public Expression getExpression() {
		return expression;
	}

	@Override
	public <T> T accept(final IVisitor<T> visitor) {
		// TODO: visit parent and elements
		return visitor.visit(this);
	}
}
