package org.uva.sea.ql.ast.nodetypes.binary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.nodetypes.primary.Bool;
import org.uva.sea.ql.ast.nodetypes.primary.Int;

import java.util.*;

public class EqualTo extends MultipleTypeBinaryOperation {

	public EqualTo(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

    @Override
    public Collection<Class<?>> getSupportedTypes() {
        List<Class<?>> supportedTypes = Arrays.asList(new Class<?>[]{ Int.class, Bool.class });
        return Collections.unmodifiableList(supportedTypes);
    }
}
