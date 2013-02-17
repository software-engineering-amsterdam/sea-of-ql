package org.uva.sea.ql.generation.html;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.ast.literal.IntLiteral;
import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.common.TreeVisitor;

public class HTMLTreeVisitor implements TreeVisitor {
    private StringBuilder ret;

    public String getRet() {
        return ret.toString();
    }

    public HTMLTreeVisitor() {
        this.ret = new StringBuilder();
    }

    @Override
    public final void visit(Ident i) {
        this.ret.append(i.getName());
        this.ret.append("()");
    }

    @Override
    public final void visit(BinaryExpr b) {
        this.ret.append("(");
        HTMLTreeVisitor v = new HTMLTreeVisitor();
        ((TreeNode) b.getLeft()).accept(v);
        this.ret.append(v.getRet());
        this.ret.append(b.toString());
        v = new HTMLTreeVisitor();
        ((TreeNode) b.getRight()).accept(v);
        this.ret.append(v.getRet());
        this.ret.append(")");
    }

    @Override
    public final void visit(UnaryExpr u) {
        this.ret.append("(");
        this.ret.append(u.toString());
        HTMLTreeVisitor v = new HTMLTreeVisitor();
        ((TreeNode) u.getAdjacent()).accept(v);
        this.ret.append(v.getRet());
        this.ret.append(")");
    }

    @Override
    public final void visit(IntLiteral i) {
        this.ret.append((i).getValue());
    }

    @Override
    public final void visit(StringLiteral s) {
        this.ret.append((s).getValue());

    }

}
