package org.uva.sea.ql.common;

import java.util.List;

import org.uva.sea.ql.ast.bool.And;
import org.uva.sea.ql.ast.bool.Eq;
import org.uva.sea.ql.ast.bool.GEq;
import org.uva.sea.ql.ast.bool.GT;
import org.uva.sea.ql.ast.bool.LEq;
import org.uva.sea.ql.ast.bool.LT;
import org.uva.sea.ql.ast.bool.NEq;
import org.uva.sea.ql.ast.bool.Not;
import org.uva.sea.ql.ast.bool.Or;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;
import org.uva.sea.ql.ast.literal.IntLiteral;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Neg;
import org.uva.sea.ql.ast.math.Pos;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;

public class ReturnFinder implements EvaluationVisitor {

    private ReturnTypes ret;
    private List<Question> questions;

    public ReturnFinder(List<Question> questions) {
        this.questions = questions;
    }

    public ReturnTypes getResult() {
        return ret;
    }

    @Override
    public void visit(Add add) throws VisitorException {
        ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public void visit(Mul mul) throws VisitorException {
        ret = ReturnTypes.MATH;
    }

    @Override
    public void visit(Div div) throws VisitorException {
        ret = ReturnTypes.MATH;
    }

    @Override
    public void visit(Sub sub) throws VisitorException {
        ret = ReturnTypes.MATH;
    }

    @Override
    public void visit(And and) throws VisitorException {
        ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public void visit(Or or) throws VisitorException {
        ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public void visit(Eq eq) throws VisitorException {
        ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public void visit(NEq neq) throws VisitorException {
        ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public void visit(GT gt) throws VisitorException {
        ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public void visit(GEq geq) throws VisitorException {
        ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public void visit(LT lt) throws VisitorException {
        ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public void visit(LEq leq) throws VisitorException {
        ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public void visit(Not not) throws VisitorException {
        ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public void visit(Pos pos) throws VisitorException {
        ret = ReturnTypes.MATH;
    }

    @Override
    public void visit(Neg neg) throws VisitorException {
        ret = ReturnTypes.MATH;
    }

    @Override
    public void visit(Ident ident) throws VisitorException {
        boolean found = false;
        for (Question question : questions) {
            if (question.getIdentName().equals(ident.getName())) {
                ReturnFinder f = new ReturnFinder(questions);
                question.getType().accept(f);
                ret = f.getResult();
                found = true;
            }
        }
        if (!found) {
            throw new RuntimeException("Question not found: " + ident.getName());
        }
    }

    @Override
    public void visit(IntLiteral i) throws VisitorException {
        ret = ReturnTypes.MATH;
    }

    @Override
    public void visit(BooleanType b) {
        ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public void visit(Money m) {
        ret = ReturnTypes.MATH;
    }

    @Override
    public void visit(StrType s) {
        ret = ReturnTypes.OTHER;
    }

    @Override
    public void visit(IntType i) {
        ret = ReturnTypes.MATH;
    }

}
