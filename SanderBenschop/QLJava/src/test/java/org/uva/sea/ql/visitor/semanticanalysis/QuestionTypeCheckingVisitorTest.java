package org.uva.sea.ql.visitor.semanticanalysis;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.SourceCodeInformationImpl;
import org.uva.sea.ql.ast.binary.EqualTo;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.Int;
import org.uva.sea.ql.ast.primary.Str;
import org.uva.sea.ql.ast.primary.typeClasses.IntegerType;
import org.uva.sea.ql.ast.statement.Question;

import static junit.framework.Assert.assertTrue;

public class QuestionTypeCheckingVisitorTest {

    private SourceCodeInformation sourceCodeInformation;
    private SemanticAnalysisVisitor semanticAnalysisVisitor;

    @Before
    public void init() throws IllegalAccessException {
        sourceCodeInformation = new SourceCodeInformationImpl(0, 0);
        semanticAnalysisVisitor = new SemanticAnalysisVisitor();
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
