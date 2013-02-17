package org.uva.sea.ql.ast.interfaces;

import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.interfaces.EvaluationVisitor;

public interface Evaluatable {
    public void accept(EvaluationVisitor visitor) throws QLException;
}
