package org.uva.sea.ql.common.identfinder;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.ast.literals.BoolLiteral;
import org.uva.sea.ql.ast.literals.IntLiteral;
import org.uva.sea.ql.common.TreeVisitor;

class IdentFinderVisitor implements TreeVisitor {
    private List<Ident> idents;

    public IdentFinderVisitor() {
        this.idents = new ArrayList<Ident>();
    }

    void reset() {
        this.idents = new ArrayList<Ident>();
    }

    final List<Ident> getIdents() {
        return this.idents;
    }

    @Override
    public final void visit(Ident i) {
        this.idents.add(i);
    }

    @Override
    public final void visit(BinaryExpr b) {
        ((TreeNode)b.getLeft()).accept(this);
        ((TreeNode)b.getRight()).accept(this);
    }

    @Override
    public final void visit(UnaryExpr u) {
        ((TreeNode)u.getAdjacent()).accept(this);
    }

    @Override
    public void visit(BoolLiteral boolLiteral) {
        // do nothing
    }

    @Override
    public void visit(IntLiteral intLiteral) {
        // do nothing
    }

}
