package org.uva.sea.ql;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.primary.typeClasses.BooleanType;
import org.uva.sea.ql.ast.primary.typeClasses.IntegerType;
import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.visitor.typechecking.error.SemanticQLError;
import org.uva.sea.ql.visitor.typechecking.error.IdentifierRedeclarationError;
import org.uva.sea.ql.visitor.typechecking.error.UnequalTypesError;
import org.uva.sea.ql.visitor.typechecking.error.UnsupportedTypeError;

import static org.junit.Assert.assertEquals;

public class TestQLErrors {

    private SourceCodeInformation sourceCodeInformation;

    @Before
    public void init() {
        this.sourceCodeInformation = new SourceCodeInformation(42, 2);
    }

    @Test
    public void shouldGetUnsupportedTypeErrorMessageForSingleAllowedType() {
        Type expectedType = new IntegerType(), actualType = new BooleanType();
        SemanticQLError error = new UnsupportedTypeError(sourceCodeInformation, expectedType, actualType);
        assertEquals("Error: variable on line '42' column position '2' of type Bool was expected to be of type Int.", error.getErrorMessage());
    }

    @Test
    public void shouldGetUnequalTypeErrorMessage() {
        SemanticQLError error = new UnequalTypesError(sourceCodeInformation, new IntegerType(), new BooleanType());
        assertEquals("Error: binary operation on line '42' column position '2' contains unequal types of respectively Int and Bool.", error.getErrorMessage());
    }

    @Test
    public void shouldGetIdentifierRedeclarationError() {
        String identifierName = "age";
        SemanticQLError error = new IdentifierRedeclarationError(sourceCodeInformation, identifierName);
        assertEquals("Error: attempt to declare identifier with name 'age' on line '42' column position '2' failed, because it is already defined.",
                error.getErrorMessage());
    }
}
