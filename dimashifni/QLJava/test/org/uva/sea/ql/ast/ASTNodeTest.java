/**
 * 
 */
package org.uva.sea.ql.ast;

import junit.framework.Assert;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;
import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;
import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.MoneyValue;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.expression.ExpressionValidator;
import org.uva.sea.ql.visitor.statement.StatementValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimashifni
 *
 */
public class ASTNodeTest {

    @Test
    public void testAdd()
    {
        IntegerValue value1 = new IntegerValue(5);
        IntegerValue value2 = new IntegerValue(15);
        Value result = value1.add(value2);
        Assert.assertEquals("20", result.getValue().toString());
    }

    @Test
    public void testAnd()
    {
        BooleanValue value1 = new BooleanValue(true);
        BooleanValue value2 = new BooleanValue(false);
        Value result = value1.and(value2);
        Assert.assertEquals("false", result.getValue().toString());
    }

    @Test
    public void testOr()
    {
        BooleanValue value1 = new BooleanValue(1 > 2);
        BooleanValue value2 = new BooleanValue(false);
        Value result = value1.or(value2);
        Assert.assertEquals("false", result.getValue().toString());
    }

    @Test
    public void testDiv()
    {
        IntegerValue value1 = new IntegerValue(1);
        IntegerValue value2 = new IntegerValue(2);
        Value result = value1.div(value2);
        Assert.assertEquals("0", result.getValue().toString());
    }

    @Test
    public void testEq()
    {
        BooleanValue value1 = new BooleanValue(true);
        BooleanValue value2 = new BooleanValue(false);
        Value result = value1.eq(value2);
        Assert.assertEquals("false", result.getValue().toString());
    }

    @Test
    public void testGeq()
    {
        IntegerValue value1 = new IntegerValue(1);
        IntegerValue value2 = new IntegerValue(1);
        Value result = value1.gEq(value2);
        Assert.assertEquals("true", result.getValue().toString());
    }

    @Test
    public void testGT()
    {
        MoneyValue value1 = new MoneyValue(1.00);
        MoneyValue value2 = new MoneyValue(0.00);
        Value result = value1.gT(value2);
        Assert.assertEquals("true", result.getValue().toString());
    }

    @Test
    public void testLEq()
    {
        IntegerValue value1 = new IntegerValue(1);
        IntegerValue value2 = new IntegerValue(1);
        Value result = value1.lEq(value2);
        Assert.assertEquals("true", result.getValue().toString());
    }

    @Test
    public void testLT()
    {
        IntegerValue value1 = new IntegerValue(1);
        IntegerValue value2 = new IntegerValue(1);
        Value result = value1.lT(value2);
        Assert.assertEquals("false", result.getValue().toString());
    }

    @Test
    public void testMul()
    {
        MoneyValue value1 = new MoneyValue(1.00);
        MoneyValue value2 = new MoneyValue(1.00);
        Value result = value1.mul(value2);
        Assert.assertEquals("1.0", result.getValue().toString());
    }

    @Test
    public void testNeq()
    {
        MoneyValue value1 = new MoneyValue(1.00);
        MoneyValue value2 = new MoneyValue(1.00);
        Value result = value1.nEq(value2);
        Assert.assertEquals("true", result.getValue().toString());
    }

    @Test
    public void testNeg()
    {
        IntegerValue value1 = new IntegerValue(1);
        Value result = value1.neg();
        Assert.assertEquals("-1", result.getValue().toString());
    }

    @Test
    public void testPos()
    {
        MoneyValue value1 = new MoneyValue(1.00);
        Value result = value1.pos();
        Assert.assertEquals("1.0", result.getValue().toString());
    }

    @Test
    public void testNot()
    {
        BooleanValue value1 = new BooleanValue(true);
        Value result = value1.not();
        Assert.assertEquals("false", result.getValue().toString());
    }

    @Test
    public void testSub()
    {
        MoneyValue value1 = new MoneyValue(2.00);
        MoneyValue value2 = new MoneyValue(1.00);
        Value result = value1.sub(value2);
        Assert.assertEquals("1.0", result.getValue().toString());
    }

    @Test
    public void testIdent()
    {
        Ident variable1 = new Ident("variable1", null);
        Ident variable2 = new Ident("variable2", null);
        Map<Ident, Value> variables = new HashMap<Ident, Value>();
        variables.put(variable1, new IntegerValue(10));
        variables.put(variable2, new BooleanValue(true));
        Assert.assertEquals("10", variable1.evaluate(variables).getValue().toString());
        Assert.assertEquals("true", variable2.evaluate(variables).getValue().toString());
    }

    @Test
    public void testAddValidator()
    {
        ANTLRStringStream stream = new ANTLRStringStream("1+2.00");
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(new QLLexer(stream));
        QLParser parser = new QLParser(tokens);
        try {
            Expr result = parser.addExpression().result;
            ExpressionValidator expressionValidator = new ExpressionValidator();
            result.accept(expressionValidator);

            } catch (RecognitionException e) {
                e.printStackTrace();
        }
    }

    @Test
    public void testMulValidator()
    {
        ANTLRStringStream stream = new ANTLRStringStream("1 * true");
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(new QLLexer(stream));
        QLParser parser = new QLParser(tokens);
        try {
            Expr result = parser.multiplyExpression().result;
            ExpressionValidator expressionValidator = new ExpressionValidator();
            result.accept(expressionValidator);
            System.out.println(expressionValidator.getErrors());

        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStatementValidator()
    {
        ANTLRStringStream stream = new ANTLRStringStream("1 * true");
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(new QLLexer(stream));
        QLParser parser = new QLParser(tokens);
        try {
            Expr result = parser.multiplyExpression().result;
            ExpressionValidator expressionValidator = new ExpressionValidator();
            result.accept(expressionValidator);
            System.out.println(expressionValidator.getErrors());

        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}
