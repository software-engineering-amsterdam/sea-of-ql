package org.uva.sea.ql.common;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.ast.literals.BoolLiteral;
import org.uva.sea.ql.ast.literals.IntLiteral;

public class IdentFinder {
    private IdentFinderVisitor visitor;

    public IdentFinder(TreeNode t) {
        this.visitor = new IdentFinderVisitor();
        t.accept(this.visitor);
    }

    public final void reset() {
        this.visitor.reset();
    }

    public final List<Ident> getIdents() {
        return this.visitor.getIdents();
    }

    private class IdentFinderVisitor implements RecursiveIdentVisitor {
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

        @Override
        public void visit(IntLiteral intLiteral) {
            // do nothing
        }

        private void addAllIdents(TreeNode n) {
            final IdentFinder finder = new IdentFinder(n);
            this.idents.addAll(finder.getIdents());
        }

        @Override
        public void visit(BoolLiteral boolLiteral) {
            //do nothing
        }

    }

}
