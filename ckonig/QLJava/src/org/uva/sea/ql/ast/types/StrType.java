package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.interpretation.TypeVisitor;

public class StrType extends AbstractType {
    public StrType() {

    }

    @Override
    public final void accept(TypeVisitor v) {
        v.visit(this);
    }

}
