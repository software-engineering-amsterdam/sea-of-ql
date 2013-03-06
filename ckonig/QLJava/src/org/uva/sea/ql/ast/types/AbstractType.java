package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.common.TypeVisitor;

public abstract class AbstractType {

    protected AbstractType() {

    }

    public abstract void accept(TypeVisitor v);
    
}
