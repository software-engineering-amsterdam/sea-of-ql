package org.uva.sea.ql.tests.semanticAnalyzer.semanticAnalyzerVisitorTests;

import org.uva.sea.ql.semanticAnalyzer.SemanticAnalyzerVisitor;

import java.lang.reflect.Constructor;

public abstract class SemanticAnalyzerVisitorTests {

	protected final SemanticAnalyzerVisitor visitor;
	protected final SemanticAnalyzerVisitor.Context context;
	
	public SemanticAnalyzerVisitorTests() {
		visitor = createSemanticAnalysisVisitor();
		context = new SemanticAnalyzerVisitor.Context();
	}

    private SemanticAnalyzerVisitor createSemanticAnalysisVisitor() {
        try{
            Constructor<SemanticAnalyzerVisitor> constructor = SemanticAnalyzerVisitor.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception x) {
            throw new RuntimeException("Problems occurred while creating a new instance of the SemanticAnalyzerVisitor using reflection.", x);
        }
    }
	
}
