package org.uva.sea.ql.common;

import java.util.List;

import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.AbstractType;

public interface Registry {
    public boolean returnTypeEquals(Expr condition, AbstractType type) throws QLException;
    public List<Question> getQuestions();
    public List<IfStatement> getIfStatements();
}
