package org.uva.sea.ql.test.common;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.parser.ParseError;

public class BoolTestHelper extends AbstractTestHelper<BoolTestHelper> {
    
   

    public BoolTestHelper(TestParser parser) {
        super(parser);
    }

    public final void testRels(BoolTestHelper opposite) throws ParseError {
        testBinary(this.asClass, A + this.asString + B, Ident.class,
                Ident.class);
        testBinary(this.asClass, A + this.asString + B + opposite.asString + C,
                Ident.class, opposite.asClass);
        testBinary(this.asClass,
                A + this.asString + getBracket(B, opposite, C), Ident.class,
                opposite.asClass);
        testBinary(this.asClass,
                getBracket(A, opposite, B) + this.asString + C,
                opposite.asClass, Ident.class);
        testBinary(this.asClass, getBracket(A, this, B), Ident.class,
                Ident.class);
        testBinary(this.asClass, A + opposite.asString + B + this.asString + C,
                opposite.asClass, Ident.class);
        testBinary(this.asClass, A + this.asString + B + opposite.asString + C,
                Ident.class, opposite.asClass);
    }

    public final void testBools(BoolTestHelper opposite) throws ParseError {
        testBinary(this.asClass, getBracket(A, opposite, B) + this.asString
                + getBracket(B, opposite, C), opposite.asClass,
                opposite.asClass);
        testBinary(this.asClass, getBracket(A, this, B) + this.asString
                + getBracket(B, opposite, C), this.asClass, opposite.asClass);
        testBinary(this.asClass, getBracket(A, opposite, B) + this.asString
                + getBracket(B, this, C), opposite.asClass, this.asClass);
        testBinary(this.asClass, getBracket(A, this, B) + this.asString
                + getBracket(B, this, C), this.asClass, this.asClass);
    }

    public final void testComplexBools(BoolTestHelper opposite)
            throws ParseError {
        final String complex = getBracket(getBracket(A, this, B), opposite,
                getBracket(B, opposite, C))
                + this.asString
                + getBracket(getBracket(A, opposite, C), opposite,
                        getBracket(B, this, C));
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
        final Expr e = parser.parse(this.asString + B);
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
