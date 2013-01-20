package org.uva.sea.ql.webUI;

import org.uva.sea.ql.ASTNodeVisitor;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.Str;

import java.util.ArrayList;
import java.util.List;

public class KnockoutJSViewModelBuilderVisitor implements ASTNodeVisitor<Void, KnockoutJSViewModelBuilderVisitor.Context>{

    public static class Context {
        private final List<String> identities;
        private final StringBuilder objectHierarchy;

        public Context() {
            this.identities = new ArrayList<String>();
            this.objectHierarchy = new StringBuilder();
        }

        public List<String> getIdentities() { return identities; }
        public StringBuilder getObjectHierarchy() { return objectHierarchy; }
    }

    @Override
    public Void visit(Add astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(And astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(Bool astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(Computed astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(Declaration astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(Div astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(Eq astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(Form astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(GEq astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(GT astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(Ident astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(If astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(Int astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(LEq astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(LT astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(Mul astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(Neg astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(NEq astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(Not astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(Or astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(Pos astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(Question astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(Str astNode, Context param) {
        return null; 
    }

    @Override
    public Void visit(Sub astNode, Context param) {
        return null; 
    }
}