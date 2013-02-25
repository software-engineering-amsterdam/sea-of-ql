package org.uva.sea.ql.common.returnfinder;

import java.util.List;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.types.AbstractType;

abstract class AbstractReturnFinderVisitor {
    protected AbstractType ret;
    protected List<Question> questions;

    public AbstractReturnFinderVisitor(List<Question> q) {
        this.questions = q;
    }

    final AbstractType getResult() {
        return this.ret;
    }
}
