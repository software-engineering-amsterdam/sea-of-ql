package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expression.binary.*;
import org.uva.sea.ql.ast.expression.primary.Bool;
import org.uva.sea.ql.ast.expression.primary.Ident;
import org.uva.sea.ql.ast.expression.primary.Int;
import org.uva.sea.ql.ast.expression.primary.Str;
import org.uva.sea.ql.ast.statement.Computation;
import org.uva.sea.ql.ast.statement.IfElseStatement;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.expression.unary.Negative;
import org.uva.sea.ql.ast.expression.unary.Not;
import org.uva.sea.ql.ast.expression.unary.Positive;

public interface NodeVisitor<T> {

    T visitForm(Form form);

    T visitComputation(Computation computation);

    T visitIfStatement(IfStatement ifStatement);

    T visitIfElseStatement(IfElseStatement ifElseStatement);

    T visitQuestion(Question question);

    T visitPositive(Positive positive);

    T visitNegative(Negative negative);

    T visitNot(Not not);

    T visitMultiply(Multiply multiply);

    T visitDivide(Divide divide);

    T visitSubtract(Subtract subtract);

    T visitAdd(Add add);

    T visitAnd(And and);

    T visitOr(Or or);

    T visitEqualTo(EqualTo equalTo);

    T visitNotEqualTo(NotEqualTo notEqualTo);

    T visitGreaterThan(GreaterThan greaterThan);

    T visitGreaterThanOrEqualTo(GreaterThanOrEqualTo greaterThanOrEqualTo);

    T visitLessThan(LessThan lessThan);

    T visitLessThanOrEqualTo(LessThanOrEqualTo lessThanOrEqualTo);

    T visitIdent(Ident ident);

    T visitBool(Bool boolLiteral);

    T visitInt(Int intLiteral);

    T visitStr(Str str);
}
