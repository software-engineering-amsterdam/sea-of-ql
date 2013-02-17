package org.uva.sea.ql.generation.html;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.ast.literals.IntLiteral;
import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.common.interfaces.TreeVisitor;

public class HTMLTreeVisitor implements TreeVisitor {
    private static String BROPEN = "(";
    private static String BRCLOSE = ")";
    private StringBuilder ret;

    public HTMLTreeVisitor() {
        this.ret = new StringBuilder();
    }

    public final String getRet() {
        return this.ret.toString();
    }

    @Override
    public final void visit(Ident i) {
        this.ret.append(i.getName());
        this.ret.append("()");
    }

    @Override
    public final void visit(BinaryExpr b) {
        this.ret.append(BROPEN);
        HTMLTreeVisitor v = new HTMLTreeVisitor();
        ((TreeNode) b.getLeft()).accept(v);
        this.ret.append(v.getRet());
        this.ret.append(b.toString());
        v = new HTMLTreeVisitor();
        ((TreeNode) b.getRight()).accept(v);
        this.ret.append(v.getRet());
        this.ret.append(BRCLOSE);
    }

    @Override
    public final void visit(UnaryExpr u) {
        this.ret.append(BROPEN);
        this.ret.append(u.toString());
        final HTMLTreeVisitor v = new HTMLTreeVisitor();
        ((TreeNode) u.getAdjacent()).accept(v);
        this.ret.append(v.getRet());
        this.ret.append(BRCLOSE);
    }

    @Override
    public final void visit(IntLiteral i) {
        this.ret.append(i.getValue());
    }

    @Override
    public final void visit(StringLiteral s) {
        this.ret.append(s.getValue());

    }

}
