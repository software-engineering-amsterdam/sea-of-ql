package org.uva.sea.ql.validation;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.elements.AbstractBlockElement;
import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Expression;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.ast.types.AbstractMathType;
import org.uva.sea.ql.ast.types.AbstractType;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.common.ElementVisitor;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.identfinder.IdentFinder;
import org.uva.sea.ql.common.returnfinder.ReturnFinder;

public class ValidationVisitor implements ElementVisitor {
    private Registry registry;
    private boolean throwExceptions;
    private List<String> errors;

    public ValidationVisitor() {
        this.registry = new Registry();
        this.errors = new ArrayList<String>();
        this.throwExceptions = true;
    }

    public ValidationVisitor(boolean throwErrors) {
        this();
        this.throwExceptions = throwErrors;
    }

    public final List<String> getErrors() {
        return this.errors;
    }

    public final boolean hasErrors() {
        return this.errors.size() > 0;
    }

    @Override
    public final void visit(Form form) throws QLException {
        form.getBlock().accept(this);
    }

    @Override
    public final void visit(Block block) throws QLException {
        for (AbstractBlockElement expr : block.getContent()) {
            expr.accept(this);
        }
    }

    @Override
    public final void visit(Question question) throws QLException {
        this.checkDuplicateIdentName(question);
        if (question.hasAutoValue()) {
            this.checkSelfReference(question);
            this.checkValidCondition(question);
        }

        this.registry.addQuestion(question);
    }

    @Override
    public final void visit(IfStatement ifStatement) throws QLException {
        final Expr condition = ifStatement.getCondition();
        final ReturnFinder f = new ReturnFinder(this.registry.getQuestions(),
                ((Expression) condition));
        final Class<?> r = f.getResult();
        if (r.equals(BooleanType.class)) {
            this.visit(ifStatement.getCondition());
        } else {
            throwInvalidConditionError(ifStatement.getCondition());
        }

        ifStatement.getContent().accept(this);

    }

    private void throwInvalidConditionError(Expr e) throws AstValidationError {
        final String err = "not a valid condition: " + e.getClass().toString();
        if (this.throwExceptions) {
            throw new AstValidationError(err);
        } else {
            this.errors.add(err);
        }
    }

    private void visit(Expr operator) throws QLException {
        final AcceptFinder f = new AcceptFinder();
        ((Expression) operator).accept(f);
        if (f.getResult().equals(BooleanType.class)) {
            if (!(bothhaveEqualReturnType(operator, BooleanType.class))) {
                throwError(operator, "boolean");
            }
        }

        if (f.getResult().equals(AbstractMathType.class)) {
            if (!(bothhaveEqualReturnType(operator, AbstractMathType.class))) {
                throwError(operator, "math ( " + f.getResult().toString()
                        + ") ");
            }
        }

        if (f.getResult().equals(AbstractType.class)) {
            if (!((bothhaveEqualReturnType(operator, AbstractMathType.class)) || (bothhaveEqualReturnType(
                    operator, BooleanType.class)))) {
                throwError(operator, "either math OR bool");
            }
        }
    }

    private void throwError(Expr r, String msg) throws AstValidationError {
        final BinaryExpr b = (BinaryExpr) r;
        final String err = "BOTH childs of " + r.getClass() + " must return "
                + msg + " operands: " + b.getLeft().getClass() + ", "
                + b.getRight().getClass();
        if (this.throwExceptions) {
            throw new AstValidationError(err);
        } else {
            this.errors.add(err);
        }
    }

    private boolean bothhaveEqualReturnType(Expr r, Class<?> type)
            throws QLException {
        final BinaryExpr b = (BinaryExpr) r;
        final Class<?> left = this.getReturnTypes(b.getLeft());
        final Class<?> right = this.getReturnTypes(b.getRight());
        System.out.println(left + " - " + right);
        return left.equals(type) && right.equals(type);
    }

    private Class<?> getReturnTypes(Expr e) throws QLException {
        this.visit(e);
        final ReturnFinder f = new ReturnFinder(this.registry.getQuestions(),
                ((Expression) e));
        return f.getResult();
    }

    private void checkDuplicateIdentName(Question question)
            throws AstValidationError {
        for (Question q : this.registry.getQuestions()) {
            if (q.getIdentName().equals(question.getIdentName())) {
                final String err = "duplicate question Identifier:"
                        + question.getIdentName();
                if (this.throwExceptions) {
                    throw new AstValidationError(err);
                } else {
                    this.errors.add(err);
                }
            }
        }
    }

    private void checkValidCondition(Question question) throws QLException {
        this.visit(question.getExpr());
        final ReturnFinder typeRet = new ReturnFinder(
                this.registry.getQuestions(), question.getType());
        final ReturnFinder f = new ReturnFinder(this.registry.getQuestions(),
                (Expression) question.getExpr());
        final Class<?> r = f.getResult();
        final Class<?> typeResult = typeRet.getResult();
        if (!typeResult.equals(r)) {
            throw new AstValidationError(
                    "question condition invalid: expected "
                            + question.getType().getClass().toString()
                            + " , got: " + r.toString());
        }
    }

    private void checkSelfReference(Question question)
            throws AstValidationError {
        IdentFinder finder = new IdentFinder((TreeNode) question.getExpr());
        List<Ident> idents = finder.getIdents();
        for (Ident ident : idents) {
            if (ident.getName().equals(question.getIdentName())) {
                throw new AstValidationError(
                        "Question may not reference itself: " + ident.getName());
            }
        }
    }

}
