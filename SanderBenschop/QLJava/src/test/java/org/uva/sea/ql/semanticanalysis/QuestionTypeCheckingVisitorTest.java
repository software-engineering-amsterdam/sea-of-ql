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

import static junit.framework.Assert.assertTrue;

public class QuestionTypeCheckingVisitorTest {

    private SourceCodeInformation sourceCodeInformation;
    private SemanticAnalyser semanticAnalyser;

    @Before
    public void init() throws IllegalAccessException {
        sourceCodeInformation = new SourceCodeInformation(0, 0);
        semanticAnalyser = new SemanticAnalyser();
    }

    @Test
    public void shouldMakeIdentifierReducableToOwnType() {
        Ident ident = new Ident("age", sourceCodeInformation);
        Str label = new Str("\"How old are you?\"", sourceCodeInformation);
        Question question = new Question(ident, label, new IntegerType());

        Ident ident2 = new Ident("age", sourceCodeInformation);
        Int otherNumber = new Int(20, sourceCodeInformation);
        EqualTo twentyYearsOld = new EqualTo(ident2, otherNumber, sourceCodeInformation);

        boolean questionCorrect = semanticAnalyser.visitQuestion(question);
        boolean equalToCorrect = semanticAnalyser.visitEqualTo(twentyYearsOld);

        assertTrue(semanticAnalyser.getErrors().isEmpty());
        assertTrue(questionCorrect);
        assertTrue(equalToCorrect);
    }
}
