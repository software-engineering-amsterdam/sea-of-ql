package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.common.EvaluationVisitor;
import org.uva.sea.ql.common.TypeVisitor;
import org.uva.sea.ql.common.VisitorException;

public class IntType extends Type {
    public IntType() {

    }

    @Override
    public void accept(TypeVisitor v) {
        v.visit(this);
    }

    @Override
    public void accept(EvaluationVisitor visitor) throws VisitorException {
       visitor.visit(this);
    }

}
