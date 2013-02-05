package org.uva.sea.ql.validation;

import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.BlockElement;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.AcceptsBoolOperands;
import org.uva.sea.ql.ast.interfaces.AcceptsBothOperands;
import org.uva.sea.ql.ast.interfaces.AcceptsMathOperands;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;
import org.uva.sea.ql.ast.interfaces.Returns;
import org.uva.sea.ql.common.ElementVisitor;
import org.uva.sea.ql.common.VisitorException;

public class ValidationVisitor implements ElementVisitor {
    private Registry registry;

    public ValidationVisitor() {
        this.registry = new Registry();
    }

    @Override
    public final void visit(Form form) throws VisitorException {
        form.getBlock().accept(this);
    }

    @Override
    public final void visit(Block block) throws VisitorException {
        for (BlockElement expr : block.getContent()) {
            if (expr.getClass().equals(IfStatement.class)) {
                ((IfStatement) expr).accept(this);
            }
            if (expr.getClass().equals(Question.class)) {
                ((Question) expr).accept(this);
            }
        }
    }

    @Override
    public final void visit(Question question) throws VisitorException {
        for (Question q : this.registry.getQuestions()) {
            if (q.getIdentName().equals(question.getIdentName())) {
                throw new AstValidationError("duplicate question Identifier:"
                        + question.getIdentName());
            }
        }
        this.registry.addQuestion(question);

    }

    @Override
    public final void visit(IfStatement ifStatement) throws VisitorException {
        Returns r = (Returns) ifStatement.getCondition();
        if (r.getReturnType(registry.getQuestions())
                .equals(ReturnTypes.BOOLEAN)) {
            if (ifStatement.getCondition() instanceof AcceptsBoolOperands) {
                this.visit((AcceptsBoolOperands) ifStatement.getCondition());
            }
            if (ifStatement.getCondition() instanceof AcceptsMathOperands) {
                this.visit((AcceptsMathOperands) ifStatement.getCondition());
            }
            if (ifStatement.getCondition() instanceof AcceptsBothOperands) {
                this.visit((AcceptsBothOperands) ifStatement.getCondition());
            }
        } else {
            throw new AstValidationError("not a valid condition: "
                    + ifStatement.getCondition().getClass().toString());
        }

        ifStatement.getContent().accept(this);

    }

    private Returns getIdentOrOrigin(Expr e) throws VisitorException {
        if (e instanceof Ident) {
            e = this.registry.getQuestionTypeByIdent((Ident) e);
        }
        visitOperands(e);
        Returns r = (Returns) e;
        return r;
    }

    private void visitOperands(Expr e) throws VisitorException {
        if (e instanceof AcceptsMathOperands) {
            this.visit((AcceptsMathOperands) e);
        }
        if (e instanceof AcceptsBoolOperands) {
            this.visit((AcceptsBoolOperands) e);
        }
        if (e instanceof AcceptsBothOperands) {
            this.visit((AcceptsBothOperands) e);
        }
    }

    private void visit(AcceptsBoolOperands r) throws VisitorException {
        if (r instanceof BinaryExpr) {
            final BinaryExpr b = (BinaryExpr) r;
            final Returns left = this.getIdentOrOrigin(b.getLeft());
            final Returns right = this.getIdentOrOrigin(b.getRight());
            if (!(left.getReturnType(this.registry.getQuestions()).equals(
                    ReturnTypes.BOOLEAN) && right.getReturnType(
                    this.registry.getQuestions()).equals(ReturnTypes.BOOLEAN))) {
                throw new AstValidationError("both childs of " + b.getClass()
                        + " must be bool (left " + left.getClass() + ", right "
                        + right.getClass() + ")");
            }
        }

    }

    private void visit(AcceptsMathOperands r) throws VisitorException {
        if (r instanceof BinaryExpr) {
            final BinaryExpr b = (BinaryExpr) r;
            final Returns left = this.getIdentOrOrigin(b.getLeft());
            final Returns right = this.getIdentOrOrigin(b.getRight());
            if (!(left.getReturnType(this.registry.getQuestions()).equals(
                    ReturnTypes.MATH) && right.getReturnType(
                    this.registry.getQuestions()).equals(ReturnTypes.MATH))) {
                throw new AstValidationError("both childs of " + b.getClass()
                        + " must return math operands!");
            }
        }

    }

    private void visit(AcceptsBothOperands r) throws VisitorException {
        if (r instanceof BinaryExpr) {

            final BinaryExpr b = (BinaryExpr) r;
            final Returns left = getIdentOrOrigin(b.getLeft());
            final Returns right = getIdentOrOrigin(b.getRight());
            if (!((left.getReturnType(this.registry.getQuestions()).equals(
                    ReturnTypes.MATH) && right.getReturnType(
                    this.registry.getQuestions()).equals(ReturnTypes.MATH)) || (left
                    .getReturnType(this.registry.getQuestions()).equals(
                            ReturnTypes.BOOLEAN) && right.getReturnType(
                    this.registry.getQuestions()).equals(ReturnTypes.BOOLEAN)))) {
                throw new AstValidationError("BOTH childs of " + b.getClass()
                        + " must return either math OR bool operands");
            }
        }
    }
}
