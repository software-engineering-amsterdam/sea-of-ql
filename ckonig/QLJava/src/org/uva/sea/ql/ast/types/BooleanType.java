package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.common.VisitorException;
import org.uva.sea.ql.common.interfaces.EvaluationVisitor;
import org.uva.sea.ql.common.interfaces.TypeVisitor;

public class BooleanType extends Type  {

	public BooleanType() {

	}
	
    @Override
    public final void accept(TypeVisitor v) {
       v.visit(this);
    }

    @Override
    public final void accept(EvaluationVisitor visitor) throws VisitorException {
        visitor.visit(this);
    }
}
