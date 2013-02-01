package org.uva.sea.ql.ast.operators.binary;

import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.operators.base.BinaryOperator;
import org.uva.sea.ql.ast.traversal.SymbolTable;
import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.types.datatypes.BoolType;
import org.uva.sea.ql.ast.types.datatypes.DataType;

/**
 * Represents a less than or equal to operation in the QL language.
 * 
 * @author J. Dijkstra
 */
public class LEq extends BinaryOperator {
	private static final DataType TYPE = new BoolType();

	/**
	 * Constructor.
	 * 
	 * @param leftHandSide
	 *            left hand side of the operator
	 * @param rightHandSide
	 *            right hand side of the operator
	 */
	public LEq(final Expression leftHandSide, final Expression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

	@Override
	public DataType typeOf(final SymbolTable symbolTable) {
		return TYPE;
	}

	@Override
	public <T> T accept(final IVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
