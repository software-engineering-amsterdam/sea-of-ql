package org.uva.sea.ql.validation;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.literals.BoolLiteral;
import org.uva.sea.ql.ast.literals.IntLiteral;
import org.uva.sea.ql.ast.types.AbstractType;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.TreeVisitor;

public class ValidationTreeNodeVisitor extends AbstractValidationVisitor
        implements TreeVisitor {

    private final ValidationExpressionVisitor expressionVisitor;
    private final AbstractType type;
    private boolean result;

    public ValidationTreeNodeVisitor(ValidationExpressionVisitor visitor,
            AbstractType t, ValidationRegistry reg) {
        super(reg);
        this.expressionVisitor = visitor;
        this.type = t;
    }

    @Override
    public final void visit(Ident i) {
        try {
            this.result = this.registry.returnTypeEquals(i, type);
        } catch (QLException ex) {
            this.errors.add(ex.getMessage());
        }
    }

    @Override
    public final void visit(BinaryExpr b) {
        try {
            b.getLeft().accept(expressionVisitor);
            b.getRight().accept(expressionVisitor);
            final boolean left = this.registry.returnTypeEquals(b.getLeft(),
                    type);
            final boolean right = this.registry.returnTypeEquals(b.getRight(),
                    type);
            this.result = left && right;
        } catch (QLException ex) {
            this.errors.add(ex.getMessage());
        }
    }

    @Override
    public final void visit(UnaryExpr u) {
        try {
            u.getAdjacent().accept(expressionVisitor);
            this.result = this.registry.returnTypeEquals(u.getAdjacent(), type);
        } catch (QLException ex) {
            this.errors.add(ex.getMessage());
        }
    }

    @Override
    public final void visit(IntLiteral intLiteral) {
        this.result = type.equals(new IntType());
    }

    @Override
    public final void visit(BoolLiteral boolLiteral) {
        this.result = type.equals(new BooleanType());
    }

    public final boolean getResult() {
        return result;
    }

}
