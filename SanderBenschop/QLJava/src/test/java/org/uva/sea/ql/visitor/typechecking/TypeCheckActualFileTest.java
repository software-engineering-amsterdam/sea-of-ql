package org.uva.sea.ql.visitor.typechecking;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.Parser;
import org.uva.sea.ql.parser.exception.ParseError;
import org.uva.sea.ql.visitor.QLError;

public class TypeCheckActualFileTest {

    private Parser parser;
    private TypeCheckingVisitor typeChecker;

    @Before
    public void init() {
        parser = new ANTLRParser();
        typeChecker = new TypeCheckingVisitor();
    }

    @Test
    public void testCorrectFile() throws FileNotFoundException, ParseError {
        Form form = readAndParseToForm("src/test/resources/correctQLProgram.qlang");
        assertTrue(typeChecker.visitForm(form));
    }

    @Test
    public void testTypeErrorFile() throws FileNotFoundException, ParseError {
        Form form = readAndParseToForm("src/test/resources/typeErrorQLProgram.qlang");
        assertFalse(typeChecker.visitForm(form));
        List<QLError> errors = typeChecker.getErrors();
        assertEquals(1, errors.size());
        String errorMessage = errors.get(0).getErrorMessage();
        assertEquals("Error: variable on line '3' column position '12' of type Bool was expected to be of type Int.", errorMessage);
    }

    private Form readAndParseToForm(String file) throws FileNotFoundException, ParseError {
        File sourceFile = new File(file);
        Scanner scanner = new Scanner(sourceFile);
        String qlSourcecode = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return parser.parse(qlSourcecode);
    }
}
