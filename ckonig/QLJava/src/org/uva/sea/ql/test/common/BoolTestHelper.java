package org.uva.sea.ql.test.common;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.parser.ParseError;

public class BoolTestHelper extends TestHelper<BoolTestHelper> {
    private final static String A = " a ";
    private final static String B = " b ";
    private final static String C = " c ";

    public BoolTestHelper(TestParser parser) {
        super(parser);
    }

    public final void testRels(BoolTestHelper opposite) throws ParseError {
        testBinary(this.asClass, A + this.asString + B, Ident.class,
                Ident.class);
        testBinary(this.asClass, A + this.asString + B + opposite.asString + C,
                Ident.class, opposite.asClass);
        testBinary(this.asClass, A + this.asString + " (b " + opposite.asString
                + " c)", Ident.class, opposite.asClass);
        testBinary(this.asClass, "(a " + opposite.asString + " b) "
                + this.asString + C, opposite.asClass, Ident.class);
        testBinary(this.asClass, "(a " + this.asString + " b)", Ident.class,
                Ident.class);
        testBinary(this.asClass, A + opposite.asString + B + this.asString + C,
                opposite.asClass, Ident.class);
        testBinary(this.asClass, A + this.asString + B + opposite.asString + C,
                Ident.class, opposite.asClass);
    }

    public final void testBools(BoolTestHelper opposite) throws ParseError {
        testBinary(this.asClass, "(a " + opposite.asString + " b) "
                + this.asString + " (b " + opposite.asString + " c)",
                opposite.asClass, opposite.asClass);
        testBinary(this.asClass, "(a " + this.asString + " b) " + this.asString
                + " (b " + opposite.asString + " c)", this.asClass,
                opposite.asClass);
        testBinary(this.asClass, "(a " + opposite.asString + " b) "
                + this.asString + " (b " + this.asString + " c)",
                opposite.asClass, this.asClass);
        testBinary(this.asClass, "(a " + this.asString + " b) " + this.asString
                + " (b " + this.asString + " c)", this.asClass, this.asClass);
    }

    public final void testComplexBools(BoolTestHelper opposite)
            throws ParseError {
        final String complex = "(" + "(a " + this.asString + " b)" + " "
                + opposite.asString + "" + " ( b " + opposite.asString + " c)"
                + " ) " + "" + this.asString + " " + "(" + "(a "
                + opposite.asString + " c)" + " " + opposite.asString + " "
                + "(b " + this.asString + " c)" + ") ";
        final Expr e = parser.parse(complex);
        Assert.assertNotNull(e);
        assertEquals(this.asClass, e.getClass());
        final BinaryExpr b = (BinaryExpr) e;
        final BinaryExpr left = (BinaryExpr) b.getLeft();
        final BinaryExpr right = (BinaryExpr) b.getRight();
        assertEquals(opposite.asClass, left.getClass());
        assertEquals(opposite.asClass, right.getClass());
        assertEquals(this.asClass, left.getLeft().getClass());
        assertEquals(opposite.asClass, left.getRight().getClass());
        assertEquals(opposite.asClass, right.getLeft().getClass());
        assertEquals(this.asClass, right.getRight().getClass());
        assertEquals(Ident.class, ((BinaryExpr) left.getLeft()).getLeft()
                .getClass());
        assertEquals(Ident.class, ((BinaryExpr) left.getLeft()).getRight()
                .getClass());
        assertEquals(Ident.class, ((BinaryExpr) left.getRight()).getLeft()
                .getClass());
        assertEquals(Ident.class, ((BinaryExpr) left.getRight()).getRight()
                .getClass());
        assertEquals(Ident.class, ((BinaryExpr) right.getLeft()).getLeft()
                .getClass());
        assertEquals(Ident.class, ((BinaryExpr) right.getLeft()).getRight()
                .getClass());
        assertEquals(Ident.class, ((BinaryExpr) right.getRight()).getLeft()
                .getClass());
        assertEquals(Ident.class, ((BinaryExpr) right.getRight()).getRight()
                .getClass());
    }

    public final void testUnary() throws ParseError {
        final Expr e = parser.parse(this.asString + "b");
        Assert.assertNotNull(e);
        assertEquals(this.asClass, e.getClass());
    }

    @Override
    public final BoolTestHelper setClass(Class<?> c) {
        setClassAndString(c);
        this.asClass = c;
        return this;
    }

}
