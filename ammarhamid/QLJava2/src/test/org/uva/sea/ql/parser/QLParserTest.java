package org.uva.sea.ql.parser;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.uva.sea.ql.parser.exception.ParserException;
import org.uva.sea.ql.parser.impl.ANTLRParser;

import java.text.ParseException;

public class QLParserTest
{
    private final IParser parser;

    public QLParserTest()
    {
        this.parser = new ANTLRParser();
    }

    @After
    public void tearDown()
    {
        System.out.println("OK");
    }

    @Test
    public void simpleValidFormTest() throws ParseException, RecognitionException
    {
        final String validSrc = "" +
                "form test " +
                "{ " +
                "	hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
                "	hasSoldCar: \"Did you sell a car in 2010?\" integer " +
                "	if (1+1==2) " +
                "	{ " +
                "		hasNothing: \"nothing?\" boolean " +
                "		hasNothing2: \"nothing?\" boolean " +
                "	}" +
                "	else" +
                "	{" +
                "		hasNothing: \"nothing?\" boolean " +
                "	}" +
                "}";

        QLParser qlParser = this.parser.createQLParser("1+2*1");
        String actualExpression = qlParser.expression().tree.toStringTree();
        System.out.println(actualExpression);
        final String expectedExpression = "(+ 1 (* 2 1))";
        Assert.assertEquals("Result should be the same", expectedExpression, actualExpression);

        QLParser qlParser2 = this.parser.createQLParser("if(1+2) { hasSoldIt: \"Really?\" boolean }");
        String actualIfBlock = qlParser2.ifStatement().tree.toStringTree();
        System.out.println(actualIfBlock);
        final String expectedIfBlock = "(IF (EXPRESSION (+ 1 2) (BLOCK (ASSIGNMENT hasSoldIt boolean))))";
        Assert.assertEquals("Result should be the same", expectedIfBlock, actualIfBlock);

        QLParser qlParser3 = this.parser.createQLParser(validSrc);
        String actualForm = qlParser3.form().tree.toStringTree();
        System.out.println(actualForm);
        final String expectedForm = "(FORM test (BLOCK (ASSIGNMENT hasSoldHouse boolean) (ASSIGNMENT hasSoldCar integer) (IF (EXPRESSION (== (+ 1 1) 2) (BLOCK (ASSIGNMENT hasNothing boolean) (ASSIGNMENT hasNothing2 boolean))) (EXPRESSION (BLOCK (ASSIGNMENT hasNothing boolean))))))";
        Assert.assertEquals("Result should be the same", expectedForm, actualForm);

        final QLParser qlParser4 = this.parser.createQLParser(validSrc);
        final CommonTree commonTree = (CommonTree) qlParser4.form().getTree();
        final CommonTreeNodeStream commonTreeNodeStream = new CommonTreeNodeStream(commonTree);
        final QLTreeWalker qlTreeWalker = new QLTreeWalker(commonTreeNodeStream);
        qlTreeWalker.walk();

        final QLParser qlParser5 = this.parser.createQLParser("(1+15)+20");
        final CommonTree commonTree1 = (CommonTree) qlParser5.expression().getTree();
        final CommonTreeNodeStream commonTreeNodeStream1 = new CommonTreeNodeStream(commonTree1);
        final QLTreeWalker qlTreeWalker1 = new QLTreeWalker(commonTreeNodeStream1);
        QLTreeWalker.expression_return expression = qlTreeWalker1.expression();
        System.out.println("walk = " + expression.node.evaluate());
    }

    @Ignore
    public void ifStatementTest() throws RecognitionException
    {
        final String validSrc = "" +
                "	if (1+1==2) " +
                "	{ " +
                "		hasNothing: \"nothing?\" boolean " +
                "		hasNothing2: \"nothing?\" boolean " +
                "	}" +
                "	else" +
                "	{" +
                "		hasNothing: \"nothing?\" boolean " +
                "	}";

        final QLParser qlParser = this.parser.createQLParser(validSrc);
        final CommonTree commonTree = (CommonTree) qlParser.ifStatement().getTree();
        final CommonTreeNodeStream commonTreeNodeStream = new CommonTreeNodeStream(commonTree);
        final QLTreeWalker qlTreeWalker = new QLTreeWalker(commonTreeNodeStream);
        QLTreeWalker.ifStatement_return expression = qlTreeWalker.ifStatement();
//        System.out.println("Test " +expression.node.evaluate());
    }

    @Test
    public void simpleInvalidFormTest()
    {
        try
        {
            this.parser.parseForm("" +
                    "test " +
                    "{ " +
                    "	hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
                    "	hasSoldCar: \"Did you sell a car in 2010?\" integer " +
                    "	if (1+1==2) " +
                    "	{ " +
                    "		hasNothing: \"nothing?\" boolean " +
                    "	}" +
                    "	else" +
                    "	{" +
                    "		hasNothing: \"nothing?\" boolean " +
                    "	}" +
                    "}");
            Assert.fail("Ill-formed program - test should fail !!");
        } catch(ParserException e)
        {
            // expected
            System.out.println(e.getMessage());
        }
    }
}
