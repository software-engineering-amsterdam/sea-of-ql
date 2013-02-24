package org.uva.sea.ql.common.identfinder;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.ast.literals.BoolLiteral;
import org.uva.sea.ql.ast.literals.IntLiteral;

 class IdentFinderVisitor implements RecursiveIdentVisitor {
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
        addAllIdents((TreeNode) b.getLeft());
        addAllIdents((TreeNode) b.getRight());
    }

    @Override
    public final void visit(UnaryExpr u) {
        addAllIdents((TreeNode) u.getAdjacent());
    }

    private void addAllIdents(TreeNode n) {
        final IdentFinder finder = new IdentFinder(n);
        this.idents.addAll(finder.getIdents());
    }

    @Override
    public void visit(BoolLiteral boolLiteral) {
        //do nothing
    }
    
    @Override
    public void visit(IntLiteral intLiteral) {
        // do nothing
    }

}
