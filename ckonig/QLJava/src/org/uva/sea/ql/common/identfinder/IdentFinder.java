package org.uva.sea.ql.common.identfinder;

import java.util.List;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.interfaces.TreeNode;

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
}
