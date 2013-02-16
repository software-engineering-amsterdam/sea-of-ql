package org.uva.sea.ql.ast.bool;

import java.util.List;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;
import org.uva.sea.ql.ast.interfaces.Returns;
import org.uva.sea.ql.common.Evaluatable;

public abstract class UnaryBooleanOperator extends UnaryExpr implements
        Returns, Evaluatable {

    public UnaryBooleanOperator(Expr ex) {
        super(ex);
    }

    @Override
    public ReturnTypes getReturnType(List<Question> questions) {
        return ReturnTypes.BOOLEAN;
    }

}
