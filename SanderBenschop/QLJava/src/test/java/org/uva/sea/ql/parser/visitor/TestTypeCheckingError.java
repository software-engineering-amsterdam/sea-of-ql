package org.uva.sea.ql.parser.visitor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.nodetypes.binary.Add;
import org.uva.sea.ql.ast.nodetypes.binary.BinaryOperation;
import org.uva.sea.ql.ast.nodetypes.primary.Bool;
import org.uva.sea.ql.ast.nodetypes.primary.Int;
import org.uva.sea.ql.ast.nodetypes.primary.Str;
import org.uva.sea.ql.parser.visitor.typechecking.UnequalTypesError;
import org.uva.sea.ql.parser.visitor.typechecking.UnsupportedTypeError;

import java.util.Arrays;
import java.util.List;

public class TestTypeCheckingError {

    @Test
    public void shouldGetUnsupportedTypeErrorMessageForSingleAllowedType() {
        int line = 42;
        ASTNode expectedType = new Int(0);
        ASTNode actualType = new Bool(false);

        List<Class<?>> allowedTypes = Arrays.asList(new Class<?>[]{Int.class});
        QLError error = new UnsupportedTypeError(line, actualType.getClass().getSimpleName(), allowedTypes);
        assertEquals("Error: variable on line 42 of type Bool was expected to be reduceable to Int.", error.getErrorMessage());
    }

    @Test
    public void shouldGetUnsupportedTypeErrorMessageForDoubleAllowedType() {
        int line = 42;
        ASTNode actualType = new Bool(false);

        List<Class<?>> allowedTypes = Arrays.asList(new Class<?>[]{Int.class, Bool.class});
        QLError error = new UnsupportedTypeError(line, actualType.getClass().getSimpleName(), allowedTypes);
        assertEquals("Error: variable on line 42 of type Bool was expected to be reduceable to Int or Bool.", error.getErrorMessage());
    }

    @Test
    public void shouldGetUnsupportedTypeErrorMessageForTripleAllowedType() {
        int line = 42;
        ASTNode actualType = new Bool(false);

        List<Class<?>> allowedTypes = Arrays.asList(new Class<?>[]{Int.class, Bool.class, Str.class});
        QLError error = new UnsupportedTypeError(line, actualType.getClass().getSimpleName(), allowedTypes);
        assertEquals("Error: variable on line 42 of type Bool was expected to be reduceable to Int, Bool or Str.", error.getErrorMessage());
    }

    @Test
    public void shouldGetUnequalTypeErrorMessage() {
        int line = 42;
        QLExpression leftHandSide = new Int(0);
        QLExpression rightHandSide = new Bool(true);
        BinaryOperation binaryOperation = new Add(leftHandSide, rightHandSide);

        QLError error = new UnequalTypesError(line, binaryOperation);
        assertEquals("Error: binary operation on line 42 contains unequal types of respectively Int and Bool.", error.getErrorMessage());
    }
}
