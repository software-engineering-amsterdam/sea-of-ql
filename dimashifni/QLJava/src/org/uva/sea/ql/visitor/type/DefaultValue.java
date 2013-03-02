package org.uva.sea.ql.visitor.type;

import org.uva.sea.ql.type.BoolType;
import org.uva.sea.ql.type.IntType;
import org.uva.sea.ql.type.NumericType;
import org.uva.sea.ql.type.StringType;
import org.uva.sea.ql.value.*;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/28/13
 * Time: 12:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultValue implements TypeVisitor<Value> {
    private final String emptyString = "";

    @Override
    public Value visit(IntType type) {
        return new IntegerValue(0);
    }

    @Override
    public Value visit(NumericType type) {
        return new MoneyValue(0.00);
    }

    @Override
    public Value visit(BoolType type) {
        return new BooleanValue(false);
    }

    @Override
    public Value visit(StringType type) {
        return new StringValue(emptyString);
    }
}
