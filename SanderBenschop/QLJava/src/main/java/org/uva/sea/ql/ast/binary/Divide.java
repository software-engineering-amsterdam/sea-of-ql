package org.uva.sea.ql.ast.binary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.primary.Int;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Divide extends BinaryOperation {

	public Divide(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

    @Override
    public List<Class<?>> getSupportedTypes() {
        List<Class<?>> supportedTypes = Arrays.asList(new Class<?>[]{Int.class});
        return Collections.unmodifiableList(supportedTypes);
    }
}
