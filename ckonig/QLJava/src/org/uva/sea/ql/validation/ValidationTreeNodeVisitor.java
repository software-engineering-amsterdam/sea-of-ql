package org.uva.sea.ql.validation;

import java.util.List;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.literals.BoolLiteral;
import org.uva.sea.ql.ast.literals.IntLiteral;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.Registry;
import org.uva.sea.ql.common.identfinder.RecursiveIdentVisitor;

public class ValidationTreeNodeVisitor implements RecursiveIdentVisitor {

    private final ValidationExpressionVisitor expressionVisitor;
    private final Class<?> type;
    private final Registry registry;
    private boolean result; 
    private List<String> errors;
    

    public ValidationTreeNodeVisitor(ValidationExpressionVisitor visitor,
            Class<?> t, Registry reg) {
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
            final Class<?> left = this.getReturnTypes(b.getLeft());
            final Class<?> right = this.getReturnTypes(b.getRight());
            this.result = left.equals(type) && right.equals(type);
        } catch (QLException ex) {
            this.errors.add(ex.getMessage());
        }
    }

    @Override
    public void visit(UnaryExpr u) {
        try {
            u.getAdjacent().accept(expressionVisitor);
            final Class<?> adjacent = this.getReturnTypes(u.getAdjacent());
            this.result = adjacent.equals(type);
        } catch (QLException ex) {
            this.errors.add(ex.getMessage());
        }
    }

    @Override
    public void visit(IntLiteral intLiteral) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visit(BoolLiteral boolLiteral) {
        // TODO Auto-generated method stub

    }

    public boolean getResult() {
        return result;
    }

    private Class<?> getReturnTypes(Expr ex) throws QLException {
        return this.registry.lookupReturnType(ex);
    }

}
