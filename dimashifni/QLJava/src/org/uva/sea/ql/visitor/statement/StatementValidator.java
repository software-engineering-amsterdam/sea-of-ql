package org.uva.sea.ql.visitor.statement;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.type.DefaultValue;
import org.uva.sea.ql.visitor.type.TypeVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/28/13
 * Time: 12:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class StatementValidator implements StatementVisitor<Boolean> {
    private final Map<Ident, Value> variables;
    private final List<String> errors;

    public StatementValidator(Map<Ident, Value> variables) {
        this.variables = variables;
        errors = new ArrayList<String>();
    }

    @Override
    public Boolean visit(Assignment node) {
        return checkVariable(node.getIdent(), node.getType());
    }

    private boolean checkVariable(Ident ident, Type type)
    {
        final boolean result;
        if(this.variables.containsKey(ident))
        {
            errors.add("Variable is already defined: " + ident.getName());
            result = false;
        }
        else
        {
            result = true;
        }

        return result;
    }

    @Override
    public Boolean visit(IfStatement node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean visit(Block node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<String> getErrors() {
        return errors;
    }
}
