package org.uva.sea.ql.test.common;

import static org.junit.Assert.assertEquals;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.parser.ParseError;

public class MathTestHelper extends AbstractTestHelper<MathTestHelper> {
    private boolean processFirst;

    public MathTestHelper(TestParser parser) {
        super(parser);
    }

    public final MathTestHelper setClass(Class<?> c) {
        setClassAndString(c);
        switch (this.asString) {
        case "+":
            this.processFirst = false;
            break;
        case "-":
            this.processFirst = false;
            break;
        case "*":
            this.processFirst = true;
            break;
        case "/":
            this.processFirst = true;
            break;
        case "&&":
            this.processFirst = true;
            break;
        case "||":
            this.processFirst = false;
            break;
        default:
            throw new RuntimeException("unknown type");
        }
        return this;
    }

    public final void testMathOperations(MathTestHelper opposite)
            throws ParseError {
        testBinary(this.asClass, getBracket(A, this, B), Ident.class,
                Ident.class);
        testBinary(this.asClass, A + this.asString + getBracket(B, this, C),
                Ident.class, this.asClass);
        testBinary(this.asClass, getBracket(A, this, B) + this.asString + C,
                this.asClass, Ident.class);
        testBinary(this.asClass, getBracket(A, this, B), Ident.class,
                Ident.class);
        testBinary(this.asClass,
                getBracket(A, opposite, B) + this.asString + C,
                opposite.asClass, Ident.class);
        testBinary(opposite.asClass,
                A + opposite.asString + getBracket(B, this, C), Ident.class,
                this.asClass);
        testBinary(this.asClass, getBracket(A, this, B) + this.asString
                + getBracket(C, this, D), this.asClass, this.asClass);
        testBinary(this.asClass, getBracket(A, this, B) + this.asString
                + getBracket(C, opposite, D), this.asClass, opposite.asClass);
        testBinary(this.asClass, getBracket(A, this, B) + this.asString
                + getBracket(C, this, D), opposite.asClass, this.asClass);
        testBinary(this.asClass, getBracket(A, opposite, B) + this.asString
                + getBracket(C, opposite, D), opposite.asClass,
                opposite.asClass);

        if (this.processFirst && !opposite.processFirst) {
            assertEquals(opposite.asClass,
                    parser.parse(A + this.asString + B + opposite.asString + C)
                            .getClass());
            assertEquals(opposite.asClass,
                    parser.parse(A + this.asString + B + opposite.asString + C)
                            .getClass());
            assertEquals(
                    opposite.asClass,
                    parser.parse(
                            A + this.asString + B + opposite.asString + C
                                    + opposite.asString + D).getClass());
            assertEquals(
                    opposite.asClass,
                    parser.parse(
                            A + opposite.asString + D + this.asString + B
                                    + opposite.asString + C).getClass());
            assertEquals(
                    opposite.asClass,
                    parser.parse(
                            A + opposite.asString + B + opposite.asString + C
                                    + this.asString + D).getClass());
        }
        if (opposite.processFirst && !this.processFirst) {
            assertEquals(this.asClass,
                    parser.parse(A + this.asString + B + opposite.asString + C)
                            .getClass());
            assertEquals(this.asClass,
                    parser.parse(A + this.asString + B + opposite.asString + C)
                            .getClass());
        }
    }

}
