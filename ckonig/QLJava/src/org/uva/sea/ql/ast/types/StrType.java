package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.common.EvaluationVisitor;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.interpretation.TypeVisitor;

public class StrType extends Type {
    public StrType() {

    }

    @Override
    public final void accept(TypeVisitor v) {
        v.visit(this);
    }

    @Override
    public final void accept(EvaluationVisitor visitor) throws QLException {
        visitor.visit(this);
    }
}
