package org.uva.sea.ql.ast.math;

import java.util.List;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.AcceptsMathOperands;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;
import org.uva.sea.ql.ast.interfaces.Returns;

public class Mul extends BinaryExpr implements AcceptsMathOperands, Returns {
    public static final String STR = "*";

    public Mul(Expr left, Expr right) {
        super(left, right);
    }

    @Override
    public final String toString() {
        return STR;
    }

    @Override
    public ReturnTypes getReturnType(List<Question> questions) {
        return ReturnTypes.MATH;
    }
}
