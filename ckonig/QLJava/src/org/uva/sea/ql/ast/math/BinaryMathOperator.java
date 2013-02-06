package org.uva.sea.ql.ast.math;

import java.util.List;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Accepts;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;
import org.uva.sea.ql.ast.interfaces.Returns;
import org.uva.sea.ql.common.Evaluatable;

public abstract class BinaryMathOperator extends BinaryExpr implements Returns,
        Accepts, Evaluatable {
    public BinaryMathOperator(Expr l, Expr r) {
        super(l, r);
    }

    @Override
    public ReturnTypes getReturnType(List<Question> questions) {
        return ReturnTypes.MATH;
    }

    @Override
    public boolean accepts(ReturnTypes r) {
        return r.equals(ReturnTypes.MATH);
    }

}
