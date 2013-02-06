package org.uva.sea.ql.ast.bool;

import java.util.List;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;
import org.uva.sea.ql.ast.interfaces.Returns;
import org.uva.sea.ql.common.Evaluatable;

public abstract class BinaryBooleanOperator extends BinaryExpr implements Returns, Evaluatable{
    public BinaryBooleanOperator(Expr l, Expr r){
        super(l,r);
    }
    @Override
    public ReturnTypes getReturnType(List<Question> questions) {
        return ReturnTypes.BOOLEAN;
    }
}
