package org.uva.sea.ql.semanticanalysis;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.general.SymbolTable;
import org.uva.sea.ql.parsing.FormParser;
import org.uva.sea.ql.parsing.exception.ParseException;
import org.uva.sea.ql.semanticanalysis.error.SemanticQLError;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import static junit.framework.Assert.*;

public class TypeCheckActualFileTest {

    private SemanticAnalysisVisitor semanticAnalysisVisitor;

    @Before
    public void init() {
        semanticAnalysisVisitor = new SemanticAnalysisVisitor();
    }

    @Test
    public void testCorrectFile() throws FileNotFoundException, ParseException {
        Form form = readAndParseToForm("src/test/resources/correctQLProgram.qlang");
        assertTrue(semanticAnalysisVisitor.visitForm(form));
    }

    @Test
    public void testTypeErrorFile() throws FileNotFoundException, ParseException {
        Form form = readAndParseToForm("src/test/resources/typeErrorQLProgram.qlang");
        assertFalse(semanticAnalysisVisitor.visitForm(form));
        List<SemanticQLError> errors = semanticAnalysisVisitor.getErrors();
        assertEquals(1, errors.size());
        String errorMessage = errors.get(0).getErrorMessage();
        assertEquals("Error: variable on line '3' column position '12' of type Bool was expected to be of type Int.", errorMessage);
    }

    private Form readAndParseToForm(String file) throws FileNotFoundException, ParseException {
        File sourceFile = new File(file);
        Scanner scanner = new Scanner(sourceFile);
        String qlSourcecode = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return new FormParser().parse(qlSourcecode).getForm();
    }
}
