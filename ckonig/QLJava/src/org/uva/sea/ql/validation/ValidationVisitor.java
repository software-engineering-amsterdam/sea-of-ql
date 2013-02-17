package org.uva.sea.ql.validation;

import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.BlockElement;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Evaluatable;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;
import org.uva.sea.ql.common.Registry;
import org.uva.sea.ql.common.ReturnFinder;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.interfaces.ElementVisitor;

public class ValidationVisitor implements ElementVisitor {
    private Registry registry;

    public ValidationVisitor() {
        this.registry = new Registry();
    }

    @Override
    public final void visit(Form form) throws QLException {
        form.getBlock().accept(this);
    }

    @Override
    public final void visit(Block block) throws QLException {
        for (BlockElement expr : block.getContent()) {
            expr.accept(this);
        }
    }

    @Override
    public final void visit(Question question) throws QLException {
        for (Question q : this.registry.getQuestions()) {
            if (q.getIdentName().equals(question.getIdentName())) {
                throw new AstValidationError("duplicate question Identifier:"
                        + question.getIdentName());
            }
        }
        this.registry.addQuestion(question);

    }

    @Override
    public final void visit(IfStatement ifStatement) throws QLException {
        final ReturnFinder f = new ReturnFinder(this.registry.getQuestions());
        final Expr condition = ifStatement.getCondition();
        ((Evaluatable) condition).accept(f);
        final ReturnTypes r = f.getResult();
        if (r.equals(ReturnTypes.BOOLEAN)) {

            this.visit(ifStatement.getCondition());
        } else {
            throwInvalidConditionError(ifStatement.getCondition());
        }

        ifStatement.getContent().accept(this);

    }

    private void throwInvalidConditionError(Expr e) throws AstValidationError {
        throw new AstValidationError("not a valid condition: "
                + e.getClass().toString());
    }

    private void visit(Expr operator) throws QLException {
        final AcceptFinder f = new AcceptFinder();
        ((Evaluatable) operator).accept(f);
        if (f.getResult().equals(ReturnTypes.BOOLEAN)) {
            if (!(bothhaveEqualReturnType(operator, ReturnTypes.BOOLEAN))) {
                throwError(operator, "boolean");
            }
        }
        if (f.getResult().equals(ReturnTypes.MATH)) {
            if (!(bothhaveEqualReturnType(operator, ReturnTypes.MATH))) {
                throwError(operator, "math");
            }
        }
        if (f.getResult().equals(ReturnTypes.BOTH)) {
            if (!((bothhaveEqualReturnType(operator, ReturnTypes.MATH)) || (bothhaveEqualReturnType(
                    operator, ReturnTypes.BOOLEAN)))) {
                throwError(operator, "either math OR bool");
            }
        }
    }

    private void throwError(Expr r, String msg) throws AstValidationError {
        final BinaryExpr b = (BinaryExpr) r;
        throw new AstValidationError("BOTH childs of " + r.getClass()
                + " must return " + msg + " operands: "
                + b.getLeft().getClass() + ", " + b.getRight().getClass());
    }

    private boolean bothhaveEqualReturnType(Expr r, ReturnTypes type)
            throws QLException {
        final BinaryExpr b = (BinaryExpr) r;
        final ReturnTypes left = this.getReturnTypes(b.getLeft());
        final ReturnTypes right = this.getReturnTypes(b.getRight());
        return left != null && left.equals(type) && right != null
                && right.equals(type);
    }

    private ReturnTypes getReturnTypes(Expr e) throws QLException {
        final ReturnFinder f = new ReturnFinder(this.registry.getQuestions());
        this.visit(e);
        ((Evaluatable) e).accept(f);
        return f.getResult();
    }
}
