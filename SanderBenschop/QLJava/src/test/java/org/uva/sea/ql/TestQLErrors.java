package org.uva.sea.ql;

import org.junit.Test;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.binary.Add;
import org.uva.sea.ql.ast.binary.BinaryOperation;
import org.uva.sea.ql.ast.primary.Bool;
import org.uva.sea.ql.ast.primary.Datatype;
import org.uva.sea.ql.ast.primary.Int;
import org.uva.sea.ql.ast.primary.typeClasses.BooleanType;
import org.uva.sea.ql.ast.primary.typeClasses.IntegerType;
import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.visitor.QLError;
import org.uva.sea.ql.visitor.typechecking.errors.IdentifierRedeclarationError;
import org.uva.sea.ql.visitor.typechecking.errors.UnequalTypesError;
import org.uva.sea.ql.visitor.typechecking.errors.UnsupportedTypeError;

import static org.junit.Assert.assertEquals;

public class TestQLErrors {

    private static final int LINE_NUMBER = 42;

    @Test
    public void shouldGetUnsupportedTypeErrorMessageForSingleAllowedType() {
        Type expectedType = new IntegerType(), actualType = new BooleanType();
        QLError error = new UnsupportedTypeError(LINE_NUMBER, actualType, expectedType);
        assertEquals("Error: variable on line 42 of type BooleanType was expected to be of type IntegerType.", error.getErrorMessage());
    }

    @Test
    public void shouldGetUnequalTypeErrorMessage() {

        Datatype<Integer> leftHandSide = new Int(0, new SourceCodeInformation(LINE_NUMBER, 0));
        Datatype<Boolean> rightHandSide = new Bool(true, new SourceCodeInformation(LINE_NUMBER, 2));
        BinaryOperation binaryOperation = new Add(leftHandSide, rightHandSide, new SourceCodeInformation(LINE_NUMBER, 1));

        QLError error = new UnequalTypesError(LINE_NUMBER, binaryOperation);
        assertEquals("Error: binary operation on line 42 contains unequal types of respectively Int and Bool.", error.getErrorMessage());
    }

    @Test
    public void shouldGetIdentifierRedeclarationError() {
        String identifierName = "age";
        QLError error = new IdentifierRedeclarationError(LINE_NUMBER, identifierName);
        assertEquals("Error: attempt to declare identifier with name 'age' on line 42 failed, because it is already defined.", error.getErrorMessage());
    }
}
