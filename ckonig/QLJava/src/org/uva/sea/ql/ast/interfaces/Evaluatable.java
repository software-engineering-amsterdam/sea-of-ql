package org.uva.sea.ql.ast.interfaces;

import org.uva.sea.ql.common.EvaluationVisitor;
import org.uva.sea.ql.common.QLException;

public interface Evaluatable {
    public void accept(EvaluationVisitor visitor) throws QLException;
}
