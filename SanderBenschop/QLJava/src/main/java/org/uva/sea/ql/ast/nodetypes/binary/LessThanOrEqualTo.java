package org.uva.sea.ql.ast.nodetypes.binary;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.nodetypes.primary.Int;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LessThanOrEqualTo extends BinaryOperation {

	public LessThanOrEqualTo(ASTNode leftHandSide, ASTNode rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

    @Override
    public List<Class<?>> getSupportedTypes() {
        List<Class<?>> supportedTypes = Arrays.asList(new Class<?>[]{Int.class});
        return Collections.unmodifiableList(supportedTypes);
    }
}
