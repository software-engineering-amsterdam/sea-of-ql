package org.uva.sea.ql.ast.binary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.primary.Bool;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Or extends BinaryOperation {

	public Or(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

    @Override
    public List<Class<?>> getSupportedTypes() {
        List<Class<?>> supportedTypes = Arrays.asList(new Class<?>[]{Bool.class});
        return Collections.unmodifiableList(supportedTypes);
    }
}
