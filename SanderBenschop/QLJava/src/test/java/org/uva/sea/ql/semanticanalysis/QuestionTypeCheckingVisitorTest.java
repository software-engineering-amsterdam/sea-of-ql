package org.uva.sea.ql.semanticanalysis;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.expression.binary.EqualTo;
import org.uva.sea.ql.ast.expression.primary.Ident;
import org.uva.sea.ql.ast.expression.primary.Int;
import org.uva.sea.ql.ast.expression.primary.Str;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.general.SymbolTableImpl;

import static junit.framework.Assert.assertTrue;

public class QuestionTypeCheckingVisitorTest {

    private SourceCodeInformation sourceCodeInformation;
    private SemanticAnalysisVisitor semanticAnalysisVisitor;

    @Before
    public void init() throws IllegalAccessException {
        sourceCodeInformation = new SourceCodeInformation(0, 0);
        semanticAnalysisVisitor = new SemanticAnalysisVisitor(new SymbolTableImpl());
    }

    @Test
    public void shouldMakeIdentifierReducableToOwnType() {
        Ident ident = new Ident("age", sourceCodeInformation);
        Str label = new Str("\"How old are you?\"", sourceCodeInformation);
        Question question = new Question(ident, label, new IntegerType());

        Ident ident2 = new Ident("age", sourceCodeInformation);
        Int otherNumber = new Int(20, sourceCodeInformation);
        EqualTo twentyYearsOld = new EqualTo(ident2, otherNumber, sourceCodeInformation);

        boolean questionCorrect = semanticAnalysisVisitor.visitQuestion(question);
        boolean equalToCorrect = semanticAnalysisVisitor.visitEqualTo(twentyYearsOld);

        assertTrue(semanticAnalysisVisitor.getErrors().isEmpty());
        assertTrue(questionCorrect);
        assertTrue(equalToCorrect);
    }
}
