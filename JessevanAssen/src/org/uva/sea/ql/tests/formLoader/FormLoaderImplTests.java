package org.uva.sea.ql.tests.formLoader;

import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.formLoader.*;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.Parser;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import static org.mockito.Mockito.*;

public class FormLoaderImplTests {

    @Test
    public void loadFormCalled_resultFromFormSourceIsPassedToParser() throws ParseError {
        final String formSourceResult = "This is the result of the FormSource.loadFormData() call.";
        FormSource formSource = new StringFormSource(formSourceResult);

        Parser mockParser = mock(Parser.class);
        when(mockParser.parse(anyString())).thenReturn(new Form(new Identifier("a"), new NullStatement()));

        FormLoaderImpl formLoader = new FormLoaderImpl(formSource, mockParser);
        formLoader.loadForm();

        verify(mockParser).parse(formSourceResult);
    }

    @Test
    public void parseErrorThrown_wrapInFormLoaderException() throws ParseError {
        final String parseErrorMessage = "This is the parse error message.";
        try {
            Parser mockParser = mock(Parser.class);
            when(mockParser.parse(anyString())).thenThrow(new ParseError(parseErrorMessage));
            new FormLoaderImpl(
                    new StringFormSource(""),
                    mockParser
            ).loadForm();
            fail("FormLoaderException not thrown!");
        } catch (FormLoaderException ex) {
            assertEquals(ParseError.class, ex.getCause().getClass());
        }
    }

    @Test(expected = FormLoaderException.class)
    public void semanticAnalyzerFails_throwsFormLoaderException() throws ParseError {
        Parser mockParser = mock(Parser.class);
        final Form inconsistentForm = new Form(
                new Identifier(""),
                new CompositeStatement(Arrays.asList(
                        (Statement) new Question("", new Identifier("a"), new Bool()),
                        (Statement) new Question("", new Identifier("a"), new Bool())
                ))
        );
        when(mockParser.parse(anyString())).thenReturn(inconsistentForm);

        FormLoader formLoader = new FormLoaderImpl(
                new StringFormSource(""),
                mockParser
        );
        formLoader.loadForm();
    }

}
