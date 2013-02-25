package org.uva.sea.ql.validation;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.elements.AbstractBlockElement;
import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.ast.types.AbstractType;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.common.ElementVisitor;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.identfinder.IdentFinder;

public class ValidationElementVisitor implements ElementVisitor {
    private ValidationRegistry registry;
    private List<String> errors;

    public ValidationElementVisitor() {
        this.registry = new ValidationRegistry();
        this.errors = new ArrayList<String>();
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
            this.checkConditionType(question);
        }

        this.registry.addQuestion(question);
    }

    @Override
    public final void visit(IfStatement ifStatement) throws QLException {
        final Expr condition = ifStatement.getCondition();
        final AbstractType r = this.getReturnTypes(condition);
        if (!new BooleanType().equals(r)) {
            throwInvalidConditionError(ifStatement.getCondition());
        }

        ifStatement.getContent().accept(this);

    }

    private void throwInvalidConditionError(Expr e) throws AstValidationError {
        final String err = "not a valid condition: " + e.getClass().toString();
        this.errors.add(err);
    }

    private void visit(Expr operator) throws QLException {
        final ValidationExpressionVisitor visitor = new ValidationExpressionVisitor(
                this.registry);
        operator.accept(visitor);
        this.errors.addAll(visitor.getErrors());
    }

    private AbstractType getReturnTypes(Expr e) throws QLException {
        this.visit(e);
        return this.registry.lookupReturnType(e);
    }

    private void checkDuplicateIdentName(Question question)
            throws AstValidationError {
        for (Question q : this.registry.getQuestions()) {
            if (q.getIdentName().equals(question.getIdentName())) {
                final String err = "duplicate question Identifier:"
                        + question.getIdentName();
                this.errors.add(err);
            }
        }
    }

    private void checkConditionType(Question question) throws QLException {
        final AbstractType r = this.getReturnTypes(question.getExpr());
        final AbstractType typeResult = question.getType();
        if (!r.equals(typeResult)) {
            throw new AstValidationError(
                    "question condition invalid: expected "
                            + question.getType().getClass().toString()
                            + " , got: " + r.toString());
        }
    }

    private void checkSelfReference(Question question)
            throws AstValidationError {
        final List<Ident> idents = IdentFinder.getIdents((TreeNode) question
                .getExpr());
        for (Ident ident : idents) {
            if (ident.getName().equals(question.getIdentName())) {
                throw new AstValidationError(
                        "Question may not reference itself: " + ident.getName());
            }
        }
    }

}
