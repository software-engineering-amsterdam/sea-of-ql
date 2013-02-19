package org.uva.sea.ql.bootstrapper;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.error.QLError;
import org.uva.sea.ql.parser.Parser;
import org.uva.sea.ql.visitor.codegeneration.CodeGenerator;
import org.uva.sea.ql.visitor.semanticanalysis.SemanticalAnalyser;
import org.uva.sea.ql.visitor.semanticanalysis.error.SemanticQLError;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public final class QLBootstrapperImpl implements QLBootstrapper {

    private static final Logger LOGGER = Logger.getLogger(QLBootstrapperImpl.class.getName());

    private final Parser parser;
    private final SemanticalAnalyser semanticalAnalyser;
    private final CodeGenerator codeGenerator;

    public QLBootstrapperImpl(Parser parser, SemanticalAnalyser semanticalAnalyser, CodeGenerator codeGenerator) {
        this.parser = parser;
        this.semanticalAnalyser = semanticalAnalyser;
        this.codeGenerator = codeGenerator;
    }

    @Override
    public QLProgram bootstrapQLProgram(File sourceCode) throws IOException {
        Form form = parser.parse(sourceCode);
        if (!parser.hasErrors()) {
            return performSemanticAnalysis(form);
        } else {
            LOGGER.severe("Syntactic analysis of the QL source code failed with the following errors:");
            logErrors(parser.getErrors());
            return new IncorrectQLProgram();
        }
    }

    private QLProgram performSemanticAnalysis(Form form) {
        List<SemanticQLError> semanticQLErrors = semanticalAnalyser.semanticallyValidateForm(form);
        if (semanticQLErrors.isEmpty()) {
            return generateCode(form);
        } else {
            LOGGER.severe("Semantic analysis of the QL source code failed with the following errors:");
            logErrors(semanticQLErrors);
            return new IncorrectQLProgram();
        }
    }

    private QLProgram generateCode(Form form) {
        String code = codeGenerator.generateQLCode(form);
        return new CorrectQLProgram(code);
    }

    private void logErrors(List<? extends QLError> errors) {
        for (QLError error : errors) {
            LOGGER.severe(error.getErrorMessage());
        }
    }
}
