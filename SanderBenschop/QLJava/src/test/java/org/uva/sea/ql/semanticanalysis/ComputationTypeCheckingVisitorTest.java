package org.uva.sea.ql.semanticanalysis;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.sourcecodeinformation.SourceCodeInformation;
import org.uva.sea.ql.ast.sourcecodeinformation.SourceCodeInformationImpl;
import org.uva.sea.ql.ast.binary.Multiply;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.Int;
import org.uva.sea.ql.ast.primary.Str;
import org.uva.sea.ql.ast.statement.Computation;

import static junit.framework.Assert.assertTrue;

public class ComputationTypeCheckingVisitorTest {

    private SourceCodeInformation sourceCodeInformation;
    private SemanticAnalysisVisitor semanticAnalysisVisitor;

    @Before
    public void init() {
        sourceCodeInformation = new SourceCodeInformationImpl(0, 0);
        semanticAnalysisVisitor = new SemanticAnalysisVisitor();
    }

    @Test
    public void shouldReduceProperly() {
        Ident ident = new Ident("test", sourceCodeInformation);
        Str str = new Str("\"Label\"", sourceCodeInformation);
        Int number = new Int(0, sourceCodeInformation);
        Computation computation = new Computation(ident, str, number);

        boolean computationCorrect = semanticAnalysisVisitor.visitComputation(computation);
        assertTrue(semanticAnalysisVisitor.getErrors().isEmpty());
        assertTrue(computationCorrect);
    }

    @Test
    public void shouldMakeIdentifierReduceableIfExpressionIsReduceable() {
        Int leftHandSide = new Int(1, sourceCodeInformation);
        Int rightHandSide = new Int(3, sourceCodeInformation);
        Int rightHandSide2 = new Int(5, sourceCodeInformation);
        Multiply multiply = new Multiply(leftHandSide, rightHandSide, sourceCodeInformation);
        //
        Ident ident = new Ident("test", sourceCodeInformation);
        Str str = new Str("\"Label\"", sourceCodeInformation);
        Computation computation = new Computation(ident, str, multiply);
        Multiply multiply2 = new Multiply(ident, rightHandSide2, sourceCodeInformation);

        boolean computationCorrect = semanticAnalysisVisitor.visitComputation(computation);
        boolean multiplyCorrect = semanticAnalysisVisitor.visitMultiply(multiply2);

        assertTrue(semanticAnalysisVisitor.getErrors().isEmpty());
        assertTrue(computationCorrect);
        assertTrue(multiplyCorrect);
    }
}
