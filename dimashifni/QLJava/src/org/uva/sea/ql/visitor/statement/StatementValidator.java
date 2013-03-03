package org.uva.sea.ql.visitor.statement;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.expression.ExpressionValidator;
import org.uva.sea.ql.visitor.type.DefaultValue;
import org.uva.sea.ql.visitor.type.TypeVisitor;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/28/13
 * Time: 12:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class StatementValidator implements StatementVisitor<Void> {
    private final Set<Ident> variables;
    private final List<String> errors;

    public StatementValidator() {
        this.variables = new HashSet<Ident>();
        errors = new ArrayList<String>();
    }

    @Override
    public Void visit(Assignment node) {
        checkVariable(node.getIdent());

        return null;
    }

    private boolean checkVariable(Ident ident)
    {
        final boolean result;
        if(this.variables.contains(ident))
        {
            errors.add("Variable is already defined: " + ident.getName());
            result = false;
        }
        else
        {
            this.variables.add(ident);
            result = true;
        }

        return result;
    }

    @Override
    public Void visit(IfStatement node) {

        ExpressionValidator expressionValidator = new ExpressionValidator();
        Expr orExpression = node.getOrExpression();
        orExpression.accept(expressionValidator);

        node.getIfBlock().accept(this);
        if(node.getElseBlock() != null) {
            node.getElseBlock().accept(this);
        }

        return null;
    }

    @Override
    public Void visit(ComputedAssignment node) {
        Ident ident = node.getIdent();
        checkVariable(ident);

        Expr expr = node.getExpr();
        Type exprType = expr.getType();
        Type nodeType = node.getType();

        if(!exprType.isCompatibleTo(nodeType)) {
            this.errors.add("Mismatch computed type: " +ident.getName());
        }

        return null;
    }

    @Override
    public Void visit(Block node) {
        for (Statement s : node.getStatements())
        {
            s.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(ObservableStatement node) {
        node.accept(this);
        return null;
    }

    public List<String> getErrors() {
        return errors;
    }
}
