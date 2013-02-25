package org.uva.sea.ql.validation;

import java.util.List;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.literals.BoolLiteral;
import org.uva.sea.ql.ast.literals.IntLiteral;
import org.uva.sea.ql.ast.types.AbstractType;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.Registry;
import org.uva.sea.ql.common.identfinder.RecursiveIdentVisitor;

public class ValidationTreeNodeVisitor implements RecursiveIdentVisitor {

    private final ValidationExpressionVisitor expressionVisitor;
    private final AbstractType type;
    private final Registry registry;
    private boolean result;
    private List<String> errors;

    public ValidationTreeNodeVisitor(ValidationExpressionVisitor visitor,
            AbstractType t, Registry reg) {
        this.expressionVisitor = visitor;
        this.type = t;
        this.registry = reg;
    }

    @Override
    public void visit(Ident i) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visit(BinaryExpr b) {
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
    public void visit(UnaryExpr u) {
        try {
            u.getAdjacent().accept(expressionVisitor);
            this.result = this.registry.returnTypeEquals(u.getAdjacent(), type);
        } catch (QLException ex) {
            this.errors.add(ex.getMessage());
        }
    }

    @Override
    public void visit(IntLiteral intLiteral) {
        this.result = type.equals(new IntType());
    }

    @Override
    public void visit(BoolLiteral boolLiteral) {
        this.result = type.equals(new BooleanType());
    }

    public boolean getResult() {
        return result;
    }

}
