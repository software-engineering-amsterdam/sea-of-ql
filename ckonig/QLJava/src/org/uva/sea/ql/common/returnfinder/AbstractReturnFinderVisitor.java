package org.uva.sea.ql.common.returnfinder;

import java.util.List;

import org.uva.sea.ql.ast.elements.Question;

 abstract class AbstractReturnFinderVisitor{
    protected Class<?> ret;
    protected List<Question> questions;

    public AbstractReturnFinderVisitor(List<Question> q) {
        this.questions = q;
    }

    final Class<?> getResult() {
        return this.ret;
    }
}
