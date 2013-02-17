package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.Evaluatable;
import org.uva.sea.ql.common.TypeVisitor;

public abstract class Type extends Expr implements Evaluatable {
    public Type() {

    }

    public abstract void accept(TypeVisitor v);
}
