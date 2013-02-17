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
import org.uva.sea.ql.ast.literals.IntLiteral;
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
import org.uva.sea.ql.common.interfaces.EvaluationVisitor;

public class ReturnFinder implements EvaluationVisitor {

    private ReturnTypes ret;
    private List<Question> questions;

    public ReturnFinder(List<Question> q) {
        this.questions = q;
    }

    public final ReturnTypes getResult() {
        return this.ret;
    }

    @Override
    public final void visit(Add add) throws QLException {
      this.ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public final void visit(Mul mul) throws QLException {
      this.ret = ReturnTypes.MATH;
    }

    @Override
    public final void visit(Div div) throws QLException {
      this.ret = ReturnTypes.MATH;
    }

    @Override
    public final void visit(Sub sub) throws QLException {
      this.ret = ReturnTypes.MATH;
    }

    @Override
    public final void visit(And and) throws QLException {
      this.ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public final void visit(Or or) throws QLException {
      this.ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public final void visit(Eq eq) throws QLException {
      this.ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public final void visit(NEq neq) throws QLException {
      this.ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public final void visit(GT gt) throws QLException {
      this.ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public final void visit(GEq geq) throws QLException {
      this.ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public final void visit(LT lt) throws QLException {
      this.ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public final void visit(LEq leq) throws QLException {
      this.ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public final void visit(Not not) throws QLException {
      this.ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public final void visit(Pos pos) throws QLException {
      this.ret = ReturnTypes.MATH;
    }

    @Override
    public final void visit(Neg neg) throws QLException {
      this.ret = ReturnTypes.MATH;
    }

    @Override
    public final void visit(Ident ident) throws QLException {
        boolean found = false;
        for (Question question : this.questions) {
            if (question.getIdentName().equals(ident.getName())) {
                final ReturnFinder f = new ReturnFinder(this.questions);
                question.getType().accept(f);
              this.ret = f.getResult();
                found = true;
            }
        }
        if (!found) {
            throw new RuntimeException("Question not found: " + ident.getName());
        }
    }

    @Override
    public final void visit(IntLiteral i) throws QLException {
      this.ret = ReturnTypes.MATH;
    }

    @Override
    public final void visit(BooleanType b) {
      this.ret = ReturnTypes.BOOLEAN;
    }

    @Override
    public final void visit(Money m) {
      this.ret = ReturnTypes.MATH;
    }

    @Override
    public final void visit(StrType s) {
      this.ret = ReturnTypes.OTHER;
    }

    @Override
    public final void visit(IntType i) {
      this.ret = ReturnTypes.MATH;
    }

}
