package org.uva.sea.ql.visitor.expression;

import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.type.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/28/13
 * Time: 12:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class ExpressionValidator implements ExpressionVisitor<Boolean> {
    private List<String> errors = new ArrayList<String>();

    @Override
    public Boolean visit(Add node) {
        Type lhsType = node.getLhs().getType();
        Type rhsType = node.getRhs().getType();
        boolean compatible = lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric();
        if(!compatible)
        {
            errors.add("incompatible type for +");
        }

        return compatible;
    }

    @Override
    public Boolean visit(And node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean visit(Div node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean visit(Eq node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean visit(GEq node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean visit(GT node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean visit(Ident node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean visit(Int node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean visit(Money node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean visit(LEq node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean visit(LT node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean visit(Mul node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean visit(Neg node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean visit(NEq node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean visit(Not node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean visit(Or node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean visit(Pos node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean visit(Sub node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
