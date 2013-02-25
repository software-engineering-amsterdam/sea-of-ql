package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.common.TypeVisitor;

public class IntType extends AbstractMathType {
   
    public IntType() {

    }

    @Override
    public final void accept(TypeVisitor v) {
        v.visit(this);
    }

    @Override
    public boolean equals(Object o){
        return o instanceof AbstractMathType;
    }

}
