package org.uva.sea.ql.common.identfinder;

import java.util.List;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.interfaces.TreeNode;

public final class IdentFinder {
    private IdentFinderVisitor visitor;

    private IdentFinder(TreeNode t) {
        this.visitor = new IdentFinderVisitor();
        t.accept(this.visitor);
    }

    private final List<Ident> getIdents() {
        return this.visitor.getIdents();
    }

    public static final List<Ident> getIdents(TreeNode t) {
        return new IdentFinder(t).getIdents();
    }

}
