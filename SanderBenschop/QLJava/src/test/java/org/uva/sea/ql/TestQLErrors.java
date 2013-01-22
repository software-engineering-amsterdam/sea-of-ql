package org.uva.sea.ql;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.binary.Add;
import org.uva.sea.ql.ast.binary.BinaryOperation;
import org.uva.sea.ql.ast.primary.Bool;
import org.uva.sea.ql.ast.primary.Datatype;
import org.uva.sea.ql.ast.primary.Int;
import org.uva.sea.ql.ast.primary.Str;
import org.uva.sea.ql.visitor.QLError;
import org.uva.sea.ql.visitor.typechecking.errors.IdentifierRedeclarationError;
import org.uva.sea.ql.visitor.typechecking.errors.UnequalTypesError;
import org.uva.sea.ql.visitor.typechecking.errors.UnsupportedTypeError;

public class TestQLErrors {

    private static final int LINE_NUMBER = 42;

    @Test
    public void shouldGetUnsupportedTypeErrorMessageForSingleAllowedType() {
        ASTNode actualType = new Bool(false);

        List<Class<?>> allowedTypes = Arrays.asList(new Class<?>[] { Int.class });
        QLError error = new UnsupportedTypeError(LINE_NUMBER, actualType.getClass().getSimpleName(), allowedTypes);
        assertEquals("Error: variable on line 42 of type Bool was expected to be reduceable to Int.", error.getErrorMessage());
    }

    @Test
    public void shouldGetUnsupportedTypeErrorMessageForDoubleAllowedType() {
        ASTNode actualType = new Bool(false);

        List<Class<?>> allowedTypes = Arrays.asList(new Class<?>[] { Int.class, Bool.class });
        QLError error = new UnsupportedTypeError(LINE_NUMBER, actualType.getClass().getSimpleName(), allowedTypes);
        assertEquals("Error: variable on line 42 of type Bool was expected to be reduceable to Int or Bool.", error.getErrorMessage());
    }

    @Test
    public void shouldGetUnsupportedTypeErrorMessageForTripleAllowedType() {
        ASTNode actualType = new Bool(false);

        List<Class<?>> allowedTypes = Arrays.asList(new Class<?>[] { Int.class, Bool.class, Str.class });
        QLError error = new UnsupportedTypeError(LINE_NUMBER, actualType.getClass().getSimpleName(), allowedTypes);
        assertEquals("Error: variable on line 42 of type Bool was expected to be reduceable to Int, Bool or Str.", error.getErrorMessage());
    }

    @Test
    public void shouldGetUnequalTypeErrorMessage() {
        Datatype<Integer> leftHandSide = new Int(0);
        Datatype<Boolean> rightHandSide = new Bool(true);
        BinaryOperation binaryOperation = new Add(leftHandSide, rightHandSide);

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
