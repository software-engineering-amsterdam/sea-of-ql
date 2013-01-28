package org.uva.sea.ql.ast.nodetypes.binary;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.nodetypes.primary.Bool;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Or extends BinaryOperation {

	public Or(ASTNode leftHandSide, ASTNode rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

    @Override
    public List<Class<?>> getSupportedTypes() {
        List<Class<?>> supportedTypes = Arrays.asList(new Class<?>[]{Bool.class});
        return Collections.unmodifiableList(supportedTypes);
    }
}
