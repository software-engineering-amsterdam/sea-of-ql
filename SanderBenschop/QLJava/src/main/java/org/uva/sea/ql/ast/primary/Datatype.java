package org.uva.sea.ql.ast.primary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.SourceCodeInformation;

public abstract class Datatype<T> extends QLExpression {

    public Datatype(SourceCodeInformation sourceCodeInformation) {
        super(sourceCodeInformation);
    }

    public abstract T getValue();
}
