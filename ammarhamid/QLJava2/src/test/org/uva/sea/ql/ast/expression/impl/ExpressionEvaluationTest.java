package org.uva.sea.ql.ast.expression.impl;

import org.junit.Ignore;
import org.junit.Test;
import org.uva.sea.ql.ast.AssignmentNode;
import org.uva.sea.ql.ast.IfNode;
import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.VariableScope;
import org.uva.sea.ql.ast.exception.InvalidTypeException;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.ast.value.impl.BooleanValue;
import org.uva.sea.ql.ast.value.impl.IntegerValue;
import org.uva.sea.ql.ast.value.impl.MoneyValue;
import org.uva.sea.ql.ast.value.impl.StringValue;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ExpressionEvaluationTest
{

	@Test
	public void evaluateOnIntegerTest()
	{
        ExprNode exprNode;
        final IntegerValue intValueNode1 = new IntegerValue(6);
		final IntegerValue intValueNode2 = new IntegerValue(3);

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
        assertEquals("Negate(-) operation on number", new IntegerValue(-intValueNode1.getValue()), exprNode.evaluate());
    }

    @Test
    public void evaluateOnMoneyTest()
    {
        ExprNode exprNode;
        final MoneyValue moneyValue1 = new MoneyValue("10000.00");
        final MoneyValue moneyValue2 = new MoneyValue("250.00");

        exprNode = new AddNode(moneyValue1, moneyValue2);
        assertEquals("Add(+) operation on money", new MoneyValue(new BigDecimal("10250.00")), exprNode.evaluate());

        exprNode = new SubtractNode(moneyValue1, moneyValue2);
        assertEquals("Subtract(-) operation on money", new MoneyValue(new BigDecimal("9750.00")), exprNode.evaluate());

        exprNode = new MultiplyNode(moneyValue1, moneyValue2);
        assertEquals("Multiply(*) operation on money", new MoneyValue(new BigDecimal("2500000.0000")), exprNode.evaluate());

        exprNode = new DivideNode(moneyValue1, moneyValue2);
        assertEquals("Divide(/) operation on money", new MoneyValue(new BigDecimal("40")), exprNode.evaluate());

        exprNode = new NotEqualNode(moneyValue1, moneyValue2);
        assertEquals("NotEqual(!=) operation on money", new BooleanValue(Boolean.TRUE), exprNode.evaluate());

        exprNode = new EqualNode(moneyValue1, moneyValue2);
        assertEquals("Equal(==) operation on money", new BooleanValue(Boolean.FALSE), exprNode.evaluate());

        exprNode = new GreaterEqualNode(moneyValue1, moneyValue2);
        assertEquals("GreaterEqual(>=) operation on money", new BooleanValue(Boolean.TRUE), exprNode.evaluate());

        exprNode = new GreaterThanNode(moneyValue1, moneyValue2);
        assertEquals("GreaterThan(>) operation on money", new BooleanValue(Boolean.TRUE), exprNode.evaluate());

        exprNode = new LessEqualNode(moneyValue1, moneyValue2);
        assertEquals("LessEqual(<=) operation on money", new BooleanValue(Boolean.FALSE), exprNode.evaluate());

        exprNode = new LessThanNode(moneyValue1, moneyValue2);
        assertEquals("LessThan(<) operation on money", new BooleanValue(Boolean.FALSE), exprNode.evaluate());

        exprNode = new NegateNode(moneyValue1);
        assertEquals("Negate(-) operation on money", new MoneyValue(moneyValue1.getValue().negate()), exprNode.evaluate());
    }
	
	@Test
	public void evaluateOnStringTest()
	{
        ExprNode exprNode;
		final ExprNode stringValueNode = new StringValue("No.");
		final ExprNode intValueNode = new IntegerValue(5);

        exprNode = new NotEqualNode(stringValueNode, intValueNode);
        assertEquals("NotEqual(!=) operation on string", new BooleanValue(Boolean.TRUE), exprNode.evaluate());

        exprNode = new EqualNode(stringValueNode, intValueNode);
        assertEquals("Equal(==) operation on string", new BooleanValue(Boolean.FALSE), exprNode.evaluate());
	}

    @Test
    public void evaluateOnBooleanTest()
    {
        ExprNode exprNode;
        final ExprNode booleanValueNode1 = new BooleanValue(Boolean.FALSE);
        final ExprNode booleanValueNode2 = new BooleanValue(Boolean.TRUE);

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
        final ExprNode booleanValueNode = new BooleanValue("true");
        final ExprNode integerValueNode = new IntegerValue("123");

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

    @Ignore
    public void ifStatementTest()
    {
        // TODO continue test !!
        final Value integerValue = new IntegerValue(5);
        final Value integerValue2 = new IntegerValue(15);
        final ExprNode expectedNode = new IntegerValue(18);
        final ExprNode addNode = new AddNode(integerValue, integerValue2);
        final VariableScope variableScope = new VariableScope();
        String variableName = "foo";

        final IfNode ifNode = new IfNode();
        final ExprNode equalNode = new EqualNode(expectedNode, addNode);
        final Node assignmentNode = new AssignmentNode(variableName, integerValue, variableScope);
        final Node assignmentNode2 = new AssignmentNode(variableName, integerValue2, variableScope);
        ifNode.addBranch(equalNode, assignmentNode);
        ifNode.addBranch(new BooleanValue("true"), assignmentNode2);
        ifNode.evaluate();

        assertEquals("Result should be the same", integerValue2, variableScope.resolve(variableName));
    }

}
