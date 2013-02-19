package org.uva.sea.ql.booting;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.codegeneration.CodeGenerator;
import org.uva.sea.ql.codegeneration.WebAppCodeGeneratingVisitor;
import org.uva.sea.ql.general.QLError;
import org.uva.sea.ql.general.SymbolTable;
import org.uva.sea.ql.parsing.FormParser;
import org.uva.sea.ql.parsing.FormParsingResult;
import org.uva.sea.ql.semanticanalysis.SemanticAnalysisResults;
import org.uva.sea.ql.semanticanalysis.SemanticAnalysisVisitor;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class WebappBooter {

    private static final Logger LOGGER = Logger.getLogger(WebappBooter.class.getName());

    private final FormParser parser;
    private final CodeGenerator codeGenerator;

    public WebappBooter() {
        this.parser = new FormParser();
        this.codeGenerator = new WebAppCodeGeneratingVisitor();
    }

    public QLProgram bootstrapQLProgram(File sourceCode) throws IOException {
        FormParsingResult formParsingResult = parser.parse(sourceCode);
        if (!formParsingResult.hasErrors()) {
            return performSemanticAnalysis(formParsingResult.getForm());
        } else {
            LOGGER.severe("Syntactic analysis of the QL source code failed with the following errors:");
            logErrors(formParsingResult.getErrors());
            return new IncorrectQLProgram();
        }
    }

    private QLProgram performSemanticAnalysis(Form form) {
        SemanticAnalysisResults semanticAnalysisResults = SemanticAnalysisVisitor.semanticallyValidateForm(form);
        if (!semanticAnalysisResults.hasErrors()) {
            return generateCode(form, semanticAnalysisResults.getSymbolTable());
        } else {
            LOGGER.severe("Semantic analysis of the QL source code failed with the following errors:");
            logErrors(semanticAnalysisResults.getErrors());
            return new IncorrectQLProgram();
        }
    }

    private QLProgram generateCode(Form form, SymbolTable symbolTable) {
        String code = codeGenerator.generateQLCode(form);
        return new CorrectQLProgram(code, symbolTable);
    }

    private void logErrors(List<? extends QLError> errors) {
        for (QLError error : errors) {
            LOGGER.severe(error.getErrorMessage());
        }
    }
}
