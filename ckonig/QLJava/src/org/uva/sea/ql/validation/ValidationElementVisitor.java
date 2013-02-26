package org.uva.sea.ql.validation;

import java.util.List;

import org.uva.sea.ql.ast.elements.AbstractBlockElement;
import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.common.ElementVisitor;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.identfinder.IdentFinder;

public class ValidationElementVisitor extends AbstractValidationVisitor
        implements ElementVisitor {

    public ValidationElementVisitor() {
        super(new ValidationRegistry());        
    }

    @Override
    public final void visit(Form form) {
        try {
            form.getBlock().accept(this);
        } catch (QLException ex) {
            this.errors.add(ex.getMessage());
        }
    }

    @Override
    public final void visit(Block block) {
        try {
            for (AbstractBlockElement expr : block.getContent()) {
                expr.accept(this);
            }
        } catch (QLException ex) {
            this.errors.add(ex.getMessage());
        }
    }

    @Override
    public final void visit(Question question) {
        try {
            this.checkDuplicateIdentName(question);
            if (question.hasAutoValue()) {
                this.checkSelfReference(question);
                this.checkConditionType(question);
            }

            this.registry.addQuestion(question);
        } catch (QLException ex) {
            this.errors.add(ex.getMessage());
        }
    }

    @Override
    public final void visit(IfStatement ifStatement) {
        try {
            this.visit(ifStatement.getCondition());
            if (!this.registry.returnTypeEquals(ifStatement.getCondition(),
                    new BooleanType())) {
                throwInvalidConditionError(ifStatement.getCondition());
            }

            ifStatement.getContent().accept(this);
        } catch (QLException ex) {
            this.errors.add(ex.getMessage());
        }

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
        this.visit(question.getCondition());
        if (!this.registry.returnTypeEquals(question.getCondition(),
                question.getType())) {

            this.errors.add("question condition invalid: expected "
                    + question.getType().getClass().toString() + " , got: "
                    + question.getCondition().getClass().toString());
        }
    }

    private void checkSelfReference(Question question)
            throws AstValidationError {
        final List<Ident> idents = IdentFinder.getIdents((TreeNode) question
                .getCondition());
        for (Ident ident : idents) {
            if (ident.getName().equals(question.getIdentName())) {
                this.errors.add("Question may not reference itself: "
                        + ident.getName());
            }
        }
    }

}
