package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.common.TypeVisitor;

public class Money extends AbstractMathType {
    public Money() {
    }

    @Override
    public final void accept(TypeVisitor v) {
        v.visit(this);
    }
    
    public boolean equals(Object o){
        return o instanceof AbstractMathType;
    }


}
