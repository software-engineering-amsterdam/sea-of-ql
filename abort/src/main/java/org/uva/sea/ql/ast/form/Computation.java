package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.types.DataType;

/**
 * QL Computation to display in a form.
 * @author J. Dijkstra
 */
public class Computation extends Element {
	/**
	 * Label tag.
	 */
	private final Label label;
	/**
	 * Description.
	 */
	private final String description;
	/**
	 * Expected data type of the computation.
	 */
	private final Class<? extends DataType> expectedType;
	/**
	 * Calculation that the computation should do before displaying it.
	 */
	private final Node calculationOperation;
	
	/**
	 * Constructor.
	 * @param label label tag
	 * @param description description
	 * @param expectedType expected data type of the computation
	 * @param calculationOperation calculation that should be done
	 */
	public Computation(final Label label, final String description, final Class<? extends DataType> expectedType, final Node calculationOperation) {
		this.label = label;
		this.description = description;
		this.expectedType = expectedType;
		this.calculationOperation = calculationOperation;
	}
	
	/**
	 * Retrieve the label tag.
	 * @return label
	 */
	public Label getLabel() {
		return label;
	}
	
	/**
	 * Retrieve the description.
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Retrieve the expected data type of the calculation.
	 * @return expected data type
	 */
	public Class<? extends DataType> getExpectedType() {
		return expectedType;
	}

	/**
	 * Retrieve the calculation operation.
	 * @return calculation
	 */
	public Node getCalculationOperation() {
		return calculationOperation;
	}

	@Override
	public void accept(final IVisitor visitor) {
		label.accept(visitor);
		calculationOperation.accept(visitor);
		visitor.visit(this);		
	}
}
