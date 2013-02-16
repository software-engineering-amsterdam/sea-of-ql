package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.base.*;
import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.ast.types.datatypes.DataType;

/**
 * Computation as defined in the QL language.
 * 
 * @author J. Dijkstra
 */
public class Computation extends Statement {
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
	 * Calculation (expression) that the computation should do before displaying it.
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
	 * @param syntaxPosition
	 *            the original position of the expression in the input syntax
	 */
	public Computation(final Ident ident, final String description, final DataType expectedType,
			final Expression calculationOperation, final SyntaxPosition syntaxPosition) {
		super(syntaxPosition);

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
	 * Retrieve the computation expression that has to be evaluated before displayed.
	 * 
	 * @return computation expression
	 */
	public Expression getExpression() {
		return expression;
	}

	@Override
	public <T> T accept(final IVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
