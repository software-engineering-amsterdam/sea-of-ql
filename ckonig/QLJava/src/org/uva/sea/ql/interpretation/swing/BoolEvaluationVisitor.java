package org.uva.sea.ql.interpretation.swing;

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
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
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
import org.uva.sea.ql.common.Evaluatable;
import org.uva.sea.ql.common.EvaluationVisitor;
import org.uva.sea.ql.common.ReturnFinder;
import org.uva.sea.ql.common.VisitorException;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BoolEvaluationVisitor implements EvaluationVisitor {

    private SwingRegistry registry;
    private boolean ret;
    private MathEvaluationVisitor math;

    public BoolEvaluationVisitor(SwingRegistry reg) {
        this.registry = reg;
        this.math = new MathEvaluationVisitor(reg);
    }

    public boolean eval(Expr e) throws VisitorException {
        ((Evaluatable) e).accept(this);
        return ret;
    }

    @Override
    public void visit(Add add) throws VisitorException {
        throw new NotImplementedException();
    }

    @Override
    public void visit(Mul mul) throws VisitorException {
        throw new NotImplementedException();
    }

    @Override
    public void visit(Div div) throws VisitorException {
        throw new NotImplementedException();
    }

    @Override
    public void visit(Sub sub) throws VisitorException {
        throw new NotImplementedException();
    }

    @Override
    public void visit(And and) throws VisitorException {
        ret = eval(and.getLeft()) && eval(and.getRight());
    }

    @Override
    public void visit(Or or) throws VisitorException {
        ret = eval(or.getLeft()) || eval(or.getRight());
    }

    @Override
    public void visit(Eq eq) throws VisitorException {
        if (checkReturn(eq, registry.getQuestionsAst(), ReturnTypes.BOOLEAN)) {
            ret = eval(eq.getLeft()) == eval(eq.getRight());
        }
        if (checkReturn(eq, registry.getQuestionsAst(), ReturnTypes.MATH)) {
            ret = math.eval(eq.getLeft()) == math.eval(eq.getRight());
        }
    }

    private boolean checkReturn(BinaryExpr ex, List<Question> questions,
            ReturnTypes type) throws VisitorException {
        return checkReturn(ex.getLeft(), questions, type)
                && checkReturn(ex.getRight(), questions, type);
    }

    private boolean checkReturn(Expr ex, List<Question> questions,
            ReturnTypes type) throws VisitorException {
        ReturnFinder r = new ReturnFinder(questions);
        ((Evaluatable) ex).accept(r);
        return r.getResult().equals(type);
    }

    @Override
    public void visit(NEq neq) throws VisitorException {
        if (checkReturn(neq, registry.getQuestionsAst(), ReturnTypes.BOOLEAN)) {
            ret = eval(neq.getLeft()) != eval(neq.getRight());
        }
        if (checkReturn(neq, registry.getQuestionsAst(), ReturnTypes.MATH)) {
            ret = math.eval(neq.getLeft()) != math.eval(neq.getRight());
        }
    }

    @Override
    public void visit(GT gt) throws VisitorException {
        ret = math.eval(gt.getLeft()) > math.eval(gt.getRight());
    }

    @Override
    public void visit(GEq geq) throws VisitorException {
        ret = math.eval(geq.getLeft()) >= math.eval(geq.getRight());
    }

    @Override
    public void visit(LT lt) throws VisitorException {
        ret = math.eval(lt.getLeft()) < math.eval(lt.getRight());
    }

    @Override
    public void visit(LEq leq) throws VisitorException {
        ret = math.eval(leq.getLeft()) <= math.eval(leq.getRight());
    }

    @Override
    public void visit(Not not) throws VisitorException {
        ret = !eval(not.getAdjacent());
    }

    @Override
    public void visit(Pos pos) throws VisitorException {
        throw new NotImplementedException();
    }

    @Override
    public void visit(Neg neg) throws VisitorException {
        throw new NotImplementedException();
    }

    @Override
    public void visit(Ident ident) throws VisitorException {
        final QuestionPanel q = this.registry.getQuestionPanelByIdent(ident);
        ReturnFinder f = new ReturnFinder(this.registry.getQuestionsAst());
        ident.accept(f);
        ReturnTypes r = f.getResult();
        if (r.equals(ReturnTypes.BOOLEAN)) {
            ret = q.getBoolValue();
        }
    }

    @Override
    public void visit(IntLiteral i) throws VisitorException {
        throw new NotImplementedException();
    }

    @Override
    public void visit(BooleanType booleanType) {
        throw new NotImplementedException();
    }

    @Override
    public void visit(IntType intType) {
        throw new NotImplementedException();
    }

    @Override
    public void visit(Money money) {
        throw new NotImplementedException();
    }

    @Override
    public void visit(StrType strType) {
        throw new NotImplementedException();
    }

}
