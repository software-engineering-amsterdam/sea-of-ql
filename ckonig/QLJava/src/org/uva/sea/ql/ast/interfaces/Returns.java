package org.uva.sea.ql.ast.interfaces;

import java.util.List;

import org.uva.sea.ql.ast.elements.Question;


public interface Returns {
    public ReturnTypes getReturnType(List<Question> questions);
}
