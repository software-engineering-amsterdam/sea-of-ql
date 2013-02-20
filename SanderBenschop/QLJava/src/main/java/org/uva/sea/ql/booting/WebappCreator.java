package org.uva.sea.ql.booting;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.codegeneration.WebAppCodeGenerator;
import org.uva.sea.ql.general.QLError;
import org.uva.sea.ql.general.SymbolTable;
import org.uva.sea.ql.parsing.FormParser;
import org.uva.sea.ql.parsing.FormParsingResult;
import org.uva.sea.ql.semanticanalysis.SemanticAnalyser;
import org.uva.sea.ql.semanticanalysis.SemanticAnalysisResults;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class WebAppCreator {

    private static final Logger LOGGER = Logger.getLogger(WebAppCreator.class.getName());

    private final FormParser parser;
    private final WebAppCodeGenerator codeGenerator;

    public WebAppCreator() {
        this.parser = new FormParser();
        this.codeGenerator = new WebAppCodeGenerator();
    }

    public QLProgram createQLProgram(File sourceCode) throws IOException {
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
        SemanticAnalysisResults semanticAnalysisResults = SemanticAnalyser.semanticallyValidateForm(form);
        if (!semanticAnalysisResults.hasErrors()) {
            return generateCode(form, semanticAnalysisResults.getSymbolTable());
        } else {
            LOGGER.severe("Semantic analysis of the QL source code failed with the following errors:");
            logErrors(semanticAnalysisResults.getErrors());
            return new IncorrectQLProgram();
        }
    }

    private QLProgram generateCode(Form form, SymbolTable symbolTable) {
        String code = codeGenerator.generateCode(form);
        return new CorrectQLProgram(code, symbolTable);
    }

    private void logErrors(List<? extends QLError> errors) {
        for (QLError error : errors) {
            LOGGER.severe(error.getErrorMessage());
        }
    }
}
