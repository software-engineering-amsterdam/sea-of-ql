package org.uva.sea.ql.interpretation;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.ast.literals.IntLiteral;
import org.uva.sea.ql.ast.literals.StringLiteral;

public class IdentFinder implements TreeVisitor {
    private List<Ident> idents;

    public IdentFinder() {
        this.idents = new ArrayList<Ident>();
    }

    public final void reset() {
        this.idents = new ArrayList<Ident>();
    }

    public final List<Ident> getIdents() {
        return this.idents;
    }

    @Override
    public final void visit(Ident i) {
        this.idents.add(i);
    }

    @Override
    public final void visit(BinaryExpr b) {
        final IdentFinder i = new IdentFinder();
        ((TreeNode) b.getLeft()).accept(i);
        this.idents.addAll(i.getIdents());
        i.reset();
        ((TreeNode) b.getRight()).accept(i);
        this.idents.addAll(i.getIdents());
    }

    @Override
    public final void visit(UnaryExpr u) {
        final IdentFinder i = new IdentFinder();
        ((TreeNode) u.getAdjacent()).accept(i);
        this.idents.addAll(i.getIdents());
    }

    @Override
    public final void visit(IntLiteral i) {

    }

    @Override
    public final void visit(StringLiteral s) {

    }

}
