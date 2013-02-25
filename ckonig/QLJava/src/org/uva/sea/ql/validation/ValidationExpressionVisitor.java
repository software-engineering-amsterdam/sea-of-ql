package org.uva.sea.ql.validation;

import java.util.ArrayList;
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
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.ast.literals.BoolLiteral;
import org.uva.sea.ql.ast.literals.IntLiteral;
import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Neg;
import org.uva.sea.ql.ast.math.Pos;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.ast.types.AbstractMathType;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;

class ValidationExpressionVisitor implements ExpressionVisitor {

    private ValidationRegistry registry;
    private List<String> errors;

    public ValidationExpressionVisitor(ValidationRegistry reg) {
        this.errors = new ArrayList<String>();
        this.registry = reg;
    }

    public List<String> getErrors() {
        return this.errors;
    }

    @Override
    public final void visit(Add add) throws QLException {
        acceptMathOperators(add);
    }

    @Override
    public final void visit(Mul mul) throws QLException {
        acceptMathOperators(mul);
    }

    @Override
    public final void visit(Div div) throws QLException {
        acceptMathOperators(div);
    }

    @Override
    public final void visit(Sub sub) throws QLException {
        acceptMathOperators(sub);
    }

    @Override
    public final void visit(And and) throws QLException {
        acceptBoolOperators(and);
    }

    @Override
    public final void visit(Or or) throws QLException {
        acceptBoolOperators(or);
    }

    @Override
    public final void visit(Eq eq) throws QLException {
        acceptBoth(eq);
    }

    @Override
    public final void visit(NEq neq) throws QLException {
        acceptBoth(neq);
    }

    @Override
    public final void visit(GT gt) throws QLException {
        acceptMathOperators(gt);
    }

    @Override
    public final void visit(GEq geq) throws QLException {
        acceptMathOperators(geq);
    }

    @Override
    public final void visit(LT lt) throws QLException {
        acceptMathOperators(lt);
    }

    @Override
    public final void visit(LEq leq) throws QLException {
        acceptMathOperators(leq);
    }

    @Override
    public final void visit(Not not) throws QLException {
        acceptBoolOperators(not);
    }

    @Override
    public final void visit(Pos pos) throws QLException {
        acceptMathOperators(pos);
    }

    @Override
    public final void visit(Neg neg) throws QLException {
        acceptMathOperators(neg);
    }

    @Override
    public final void visit(Ident ident) throws QLException {
        setNull();
    }

    @Override
    public final void visit(IntLiteral i) throws QLException {
        setNull();
    }

    @Override
    public void visit(BoolLiteral b) throws QLException {
        acceptBoolOperators(b);
    }

    @Override
    public void visit(StringLiteral s) throws QLException {
        setNull();
    }

    private void acceptMathOperators(Expr operator) throws QLException {
        if (!(acceptsMath(operator))) {
            throwError(operator, "math ( " + operator.toString() + ") ");
        }
    }

    private void acceptBoolOperators(Expr operator) throws QLException {
        if (!(acceptsBool(operator))) {
            throwError(operator, "boolean");
        }
    }
    
    private boolean acceptsBool(Expr operator) throws QLException{
        return bothhaveEqualReturnType(operator, BooleanType.class);
    }
    
    private boolean acceptsMath(Expr operator) throws QLException {
        return bothhaveEqualReturnType(operator, AbstractMathType.class);
    }

    private void setNull() {
        // do nothing
    }

    private void acceptBoth(Expr operator) throws QLException {
        if (!((acceptsMath(operator)) || (acceptsBool(operator)))) {
            throwError(operator, "either math OR bool");
        }
    }

    private boolean bothhaveEqualReturnType(Expr r, Class<?> type)
            throws QLException {
        ValidationTreeNodeVisitor v = new ValidationTreeNodeVisitor(this, type, this.registry);
        ((TreeNode) r).accept(v);
        return v.getResult();
    }

    private void throwError(Expr r, String msg) throws AstValidationError {
        final String err = "childs of " + r.getClass() + " must return "
                + msg + " operands ";
        this.errors.add(err);
    }

   

}
