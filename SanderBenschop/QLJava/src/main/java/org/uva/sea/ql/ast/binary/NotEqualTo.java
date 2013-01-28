package org.uva.sea.ql.ast.binary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.primary.Bool;
import org.uva.sea.ql.ast.primary.Int;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NotEqualTo extends BinaryOperation {

	public NotEqualTo(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

    @Override
    public List<Class<?>> getSupportedTypes() {
        List<Class<?>> supportedTypes = Arrays.asList(new Class<?>[]{Int.class, Bool.class});
        return Collections.unmodifiableList(supportedTypes);
    }
}
