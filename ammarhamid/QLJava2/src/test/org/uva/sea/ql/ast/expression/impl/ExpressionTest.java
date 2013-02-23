package org.uva.sea.ql.ast.expression.impl;

import junit.framework.Assert;
import org.junit.Test;
import org.uva.sea.ql.Message;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.value.impl.BooleanValue;
import org.uva.sea.ql.value.impl.IntegerValue;
import org.uva.sea.ql.value.impl.MoneyValue;
import org.uva.sea.ql.value.impl.StringValue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class ExpressionTest
{

    @Test
    public void evaluateOnIntegerTest()
    {
        final ExprNode intValueNode1 = new ValueNode(new IntegerValue(6));
        final ExprNode intValueNode2 = new ValueNode(new IntegerValue(3));

        ExprNode exprNode;
        exprNode = new AddNode(intValueNode1, intValueNode2);
        assertEquals("Add(+) operation on number", new IntegerValue(9), exprNode.evaluate());

        exprNode = new SubtractNode(intValueNode1, intValueNode2);
        assertEquals("Subtract(-) operation on number", new IntegerValue(3), exprNode.evaluate());

        exprNode = new MultiplyNode(intValueNode1, intValueNode2);
        assertEquals("Multiply(*) operation on number", new IntegerValue(18), exprNode.evaluate());

        exprNode = new DivideNode(intValueNode1, intValueNode2);
        assertEquals("Divide(/) operation on number", new IntegerValue(2), exprNode.evaluate());

        exprNode = new NotEqualNode(intValueNode1, intValueNode2);
        assertEquals("NotEqual(!=) operation on number", new BooleanValue(true), exprNode.evaluate());

        exprNode = new EqualNode(intValueNode1, intValueNode2);
        assertEquals("Equal(==) operation on number", new BooleanValue(false), exprNode.evaluate());

        exprNode = new GreaterEqualNode(intValueNode1, intValueNode2);
        assertEquals("GreaterEqual(>=) operation on number", new BooleanValue(true), exprNode.evaluate());

        exprNode = new GreaterThanNode(intValueNode1, intValueNode2);
        assertEquals("GreaterThan(>) operation on number", new BooleanValue(true), exprNode.evaluate());

        exprNode = new LessEqualNode(intValueNode1, intValueNode2);
        assertEquals("LessEqual(<=) operation on number", new BooleanValue(false), exprNode.evaluate());

        exprNode = new LessThanNode(intValueNode1, intValueNode2);
        assertEquals("LessThan(<) operation on number", new BooleanValue(false), exprNode.evaluate());

        exprNode = new NegateNode(intValueNode1);
        assertEquals("Negate(-) operation on number", intValueNode1.evaluate().negate(), exprNode.evaluate());
    }

    @Test
    public void evaluateOnMoneyTest()
    {
        final ExprNode moneyValueNode1 = new ValueNode(new MoneyValue("10000.00"));
        final ExprNode moneyValueNode2 = new ValueNode(new MoneyValue("250.00"));

        ExprNode exprNode;
        exprNode = new AddNode(moneyValueNode1, moneyValueNode2);
        assertEquals("Add(+) operation on money", new MoneyValue(new BigDecimal("10250.00")), exprNode.evaluate());

        exprNode = new SubtractNode(moneyValueNode1, moneyValueNode2);
        assertEquals("Subtract(-) operation on money", new MoneyValue(new BigDecimal("9750.00")), exprNode.evaluate());

        exprNode = new MultiplyNode(moneyValueNode1, moneyValueNode2);
        assertEquals("Multiply(*) operation on money", new MoneyValue(new BigDecimal("2500000.0000")), exprNode.evaluate());

        exprNode = new DivideNode(moneyValueNode1, moneyValueNode2);
        assertEquals("Divide(/) operation on money", new MoneyValue(new BigDecimal("40")), exprNode.evaluate());

        exprNode = new NotEqualNode(moneyValueNode1, moneyValueNode2);
        assertEquals("NotEqual(!=) operation on money", new BooleanValue(Boolean.TRUE), exprNode.evaluate());

        exprNode = new EqualNode(moneyValueNode1, moneyValueNode2);
        assertEquals("Equal(==) operation on money", new BooleanValue(Boolean.FALSE), exprNode.evaluate());

        exprNode = new GreaterEqualNode(moneyValueNode1, moneyValueNode2);
        assertEquals("GreaterEqual(>=) operation on money", new BooleanValue(Boolean.TRUE), exprNode.evaluate());

        exprNode = new GreaterThanNode(moneyValueNode1, moneyValueNode2);
        assertEquals("GreaterThan(>) operation on money", new BooleanValue(Boolean.TRUE), exprNode.evaluate());

        exprNode = new LessEqualNode(moneyValueNode1, moneyValueNode2);
        assertEquals("LessEqual(<=) operation on money", new BooleanValue(Boolean.FALSE), exprNode.evaluate());

        exprNode = new LessThanNode(moneyValueNode1, moneyValueNode2);
        assertEquals("LessThan(<) operation on money", new BooleanValue(Boolean.FALSE), exprNode.evaluate());

        exprNode = new NegateNode(moneyValueNode1);
        assertEquals("Negate(-) operation on money", moneyValueNode1.evaluate().negate(), exprNode.evaluate());
    }

    @Test
    public void evaluateOnStringTest()
    {
        final ExprNode stringValueNode = new ValueNode(new StringValue("No."));
        final ExprNode intValueNode = new ValueNode(new IntegerValue(5));

        ExprNode exprNode;
        exprNode = new NotEqualNode(stringValueNode, intValueNode);
        assertEquals("NotEqual(!=) operation on string", new BooleanValue(Boolean.TRUE), exprNode.evaluate());

        exprNode = new EqualNode(stringValueNode, intValueNode);
        assertEquals("Equal(==) operation on string", new BooleanValue(Boolean.FALSE), exprNode.evaluate());
    }

    @Test
    public void evaluateOnBooleanTest()
    {
        ExprNode exprNode;
        final ExprNode booleanValueNode1 = new ValueNode(new BooleanValue(Boolean.FALSE));
        final ExprNode booleanValueNode2 = new ValueNode(new BooleanValue(Boolean.TRUE));

        exprNode = new NotNode(booleanValueNode1);
        assertEquals("Not(!) operation on boolean", new BooleanValue(Boolean.TRUE), exprNode.evaluate());

        exprNode = new AndNode(booleanValueNode1, booleanValueNode2);
        assertEquals("And(&&) operation on boolean", new BooleanValue(Boolean.FALSE), exprNode.evaluate());

        exprNode = new OrNode(booleanValueNode1, booleanValueNode2);
        assertEquals("Or(||) operation on boolean", new BooleanValue(Boolean.TRUE), exprNode.evaluate());
    }

    @Test
    public void evaluateOnInvalidTypeTest()
    {
        ExprNode exprNode;
        final ExprNode booleanValueNode = new ValueNode(new BooleanValue("true"));
        final ExprNode integerValueNode = new ValueNode(new IntegerValue("123"));

        exprNode = new AddNode(booleanValueNode, integerValueNode);
        invalidTypeTest(exprNode);

        exprNode = new SubtractNode(booleanValueNode, integerValueNode);
        invalidTypeTest(exprNode);

        exprNode = new MultiplyNode(booleanValueNode, integerValueNode);
        invalidTypeTest(exprNode);

        exprNode = new DivideNode(booleanValueNode, integerValueNode);
        invalidTypeTest(exprNode);

        exprNode = new GreaterEqualNode(booleanValueNode, integerValueNode);
        invalidTypeTest(exprNode);

        exprNode = new GreaterThanNode(booleanValueNode, integerValueNode);
        invalidTypeTest(exprNode);

        exprNode = new LessEqualNode(booleanValueNode, integerValueNode);
        invalidTypeTest(exprNode);

        exprNode = new LessThanNode(booleanValueNode, integerValueNode);
        invalidTypeTest(exprNode);

        exprNode = new NotNode(integerValueNode);
        invalidTypeTest(exprNode);

        exprNode = new NegateNode(booleanValueNode);
        invalidTypeTest(exprNode);

        exprNode = new AndNode(integerValueNode, booleanValueNode);
        invalidTypeTest(exprNode);

        exprNode = new OrNode(integerValueNode, booleanValueNode);
        invalidTypeTest(exprNode);
    }

    private void invalidTypeTest(final ExprNode exprNode)
    {
        Collection<Message> messages = new ArrayList<>();
        exprNode.validate(messages);
        Assert.assertTrue("Error message should be exist", messages.size() > 0);
    }

}
