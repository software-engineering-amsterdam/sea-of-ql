package org.uva.sea.ql.ast.expression.impl;

import org.junit.Test;
import org.uva.sea.ql.ast.exception.InvalidTypeException;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.value.impl.BooleanNode;
import org.uva.sea.ql.ast.value.impl.IntegerNode;
import org.uva.sea.ql.ast.value.impl.MoneyNode;
import org.uva.sea.ql.ast.value.impl.StringNode;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ExpressionEvaluationTest
{

	@Test
	public void testEvaluateOnNumber()
	{
        ExprNode exprNode;
        final IntegerNode intValueNode1 = new IntegerNode(6);
		final IntegerNode intValueNode2 = new IntegerNode(3);

        exprNode = new AddNode(intValueNode1, intValueNode2);
		assertEquals("Add(+) operation on number", 9, exprNode.evaluate().getValue());

        exprNode = new SubtractNode(intValueNode1, intValueNode2);
        assertEquals("Subtract(-) operation on number", 3, exprNode.evaluate().getValue());

        exprNode = new MultiplyNode(intValueNode1, intValueNode2);
        assertEquals("Multiply(*) operation on number", 18, exprNode.evaluate().getValue());

        exprNode = new DivideNode(intValueNode1, intValueNode2);
        assertEquals("Divide(/) operation on number", 2, exprNode.evaluate().getValue());

        exprNode = new NotEqualNode(intValueNode1, intValueNode2);
        assertEquals("NotEqual(!=) operation on number", Boolean.TRUE, exprNode.evaluate().getValue());

        exprNode = new EqualNode(intValueNode1, intValueNode2);
        assertEquals("Equal(==) operation on number", Boolean.FALSE, exprNode.evaluate().getValue());

        exprNode = new GreaterEqualNode(intValueNode1, intValueNode2);
        assertEquals("GreaterEqual(>=) operation on number", Boolean.TRUE, exprNode.evaluate().getValue());

        exprNode = new GreaterThanNode(intValueNode1, intValueNode2);
        assertEquals("GreaterThan(>) operation on number", Boolean.TRUE, exprNode.evaluate().getValue());

        exprNode = new LessEqualNode(intValueNode1, intValueNode2);
        assertEquals("LessEqual(<=) operation on number", Boolean.FALSE, exprNode.evaluate().getValue());

        exprNode = new LessThanNode(intValueNode1, intValueNode2);
        assertEquals("LessThan(<) operation on number", Boolean.FALSE, exprNode.evaluate().getValue());

        exprNode = new NegateNode(intValueNode1);
        assertEquals("Negate(-) operation on number", -intValueNode1.getValue(), exprNode.evaluate().getValue());
    }

    @Test
    public void testEvaluateOnMoney()
    {
        ExprNode exprNode;
        final MoneyNode moneyValue1 = new MoneyNode("10000.00");
        final MoneyNode moneyValue2 = new MoneyNode("250.00");

        exprNode = new AddNode(moneyValue1, moneyValue2);
        assertEquals("Add(+) operation on money", new BigDecimal("10250.00"), exprNode.evaluate().getValue());

        exprNode = new SubtractNode(moneyValue1, moneyValue2);
        assertEquals("Subtract(-) operation on money", new BigDecimal("9750.00"), exprNode.evaluate().getValue());

        exprNode = new MultiplyNode(moneyValue1, moneyValue2);
        assertEquals("Multiply(*) operation on money", new BigDecimal("2500000.0000"), exprNode.evaluate().getValue());

        exprNode = new DivideNode(moneyValue1, moneyValue2);
        assertEquals("Divide(/) operation on money", new BigDecimal("40"), exprNode.evaluate().getValue());

        exprNode = new NotEqualNode(moneyValue1, moneyValue2);
        assertEquals("NotEqual(!=) operation on money", Boolean.TRUE, exprNode.evaluate().getValue());

        exprNode = new EqualNode(moneyValue1, moneyValue2);
        assertEquals("Equal(==) operation on money", Boolean.FALSE, exprNode.evaluate().getValue());

        exprNode = new GreaterEqualNode(moneyValue1, moneyValue2);
        assertEquals("GreaterEqual(>=) operation on money", Boolean.TRUE, exprNode.evaluate().getValue());

        exprNode = new GreaterThanNode(moneyValue1, moneyValue2);
        assertEquals("GreaterThan(>) operation on money", Boolean.TRUE, exprNode.evaluate().getValue());

        exprNode = new LessEqualNode(moneyValue1, moneyValue2);
        assertEquals("LessEqual(<=) operation on money", Boolean.FALSE, exprNode.evaluate().getValue());

        exprNode = new LessThanNode(moneyValue1, moneyValue2);
        assertEquals("LessThan(<) operation on money", Boolean.FALSE, exprNode.evaluate().getValue());

        exprNode = new NegateNode(moneyValue1);
        assertEquals("Negate(-) operation on money", moneyValue1.getValue().negate(), exprNode.evaluate().getValue());
    }
	
	@Test
	public void testEvaluateOnString()
	{
        ExprNode exprNode;
		final ExprNode stringValueNode = new StringNode("No.");
		final ExprNode intValueNode = new IntegerNode(5);

        exprNode = new AddNode(stringValueNode, intValueNode);
        assertEquals("Add(+) operation on string", "No.5", exprNode.evaluate().getValue());

        exprNode = new NotEqualNode(stringValueNode, intValueNode);
        assertEquals("NotEqual(!=) operation on string", Boolean.TRUE, exprNode.evaluate().getValue());

        exprNode = new EqualNode(stringValueNode, intValueNode);
        assertEquals("Equal(==) operation on string", Boolean.FALSE, exprNode.evaluate().getValue());
	}

    @Test
    public void testEvaluateOnBoolean()
    {
        ExprNode exprNode;
        final ExprNode booleanValueNode1 = new BooleanNode(Boolean.FALSE);
        final ExprNode booleanValueNode2 = new BooleanNode(Boolean.TRUE);

        exprNode = new NotNode(booleanValueNode1);
        assertEquals("Not(!) operation on boolean", Boolean.TRUE, exprNode.evaluate().getValue());

        exprNode = new AndNode(booleanValueNode1, booleanValueNode2);
        assertEquals("And(&&) operation on boolean", Boolean.FALSE, exprNode.evaluate().getValue());

        exprNode = new OrNode(booleanValueNode1, booleanValueNode2);
        assertEquals("Or(||) operation on boolean", Boolean.TRUE, exprNode.evaluate().getValue());
    }

    @Test
    public void testEvaluateOnInvalidType()
    {
        ExprNode exprNode;
        final ExprNode booleanValueNode = new BooleanNode("true");
        final ExprNode integerValueNode = new IntegerNode("123");

        exprNode = new AddNode(booleanValueNode, integerValueNode);
        testInvalidType(exprNode);

        exprNode = new SubtractNode(booleanValueNode, integerValueNode);
        testInvalidType(exprNode);

        exprNode = new MultiplyNode(booleanValueNode, integerValueNode);
        testInvalidType(exprNode);

        exprNode = new DivideNode(booleanValueNode, integerValueNode);
        testInvalidType(exprNode);

        exprNode = new GreaterEqualNode(booleanValueNode, integerValueNode);
        testInvalidType(exprNode);

        exprNode = new GreaterThanNode(booleanValueNode, integerValueNode);
        testInvalidType(exprNode);

        exprNode = new LessEqualNode(booleanValueNode, integerValueNode);
        testInvalidType(exprNode);

        exprNode = new LessThanNode(booleanValueNode, integerValueNode);
        testInvalidType(exprNode);

        exprNode = new NotNode(integerValueNode);
        testInvalidType(exprNode);

        exprNode = new NegateNode(booleanValueNode);
        testInvalidType(exprNode);

        exprNode = new AndNode(integerValueNode, booleanValueNode);
        testInvalidType(exprNode);

        exprNode = new OrNode(integerValueNode, booleanValueNode);
        testInvalidType(exprNode);
    }

    private void testInvalidType(final ExprNode exprNode)
    {
        try
        {
            exprNode.evaluate();
            fail("Evaluation should fail: " + exprNode.toTreeString(" "));
        }
        catch(InvalidTypeException e)
        {
            // expected
        }
    }

}
