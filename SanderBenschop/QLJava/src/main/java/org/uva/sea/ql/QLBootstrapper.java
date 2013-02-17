package org.uva.sea.ql;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.error.QLError;
import org.uva.sea.ql.parser.Parser;
import org.uva.sea.ql.visitor.codegeneration.CodeGenerator;
import org.uva.sea.ql.visitor.semanticanalysis.SemanticalAnalyser;
import org.uva.sea.ql.visitor.semanticanalysis.error.SemanticQLError;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public final class QLBootstrapper {

    private static final String DESTINATION_FILE_NAME_TEMPLATE = "%s/index.html";
    private static final String PROPERTY_FILE_NAME = "qlang.properties";

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    private final Parser parser;
    private final SemanticalAnalyser semanticalAnalyser;
    private final CodeGenerator codeGenerator;

    public QLBootstrapper(Parser parser, SemanticalAnalyser semanticalAnalyser, CodeGenerator codeGenerator) {
        this.parser = parser;
        this.semanticalAnalyser = semanticalAnalyser;
        this.codeGenerator = codeGenerator;
    }

    public boolean checkAndBuildQLFile(File file) throws IOException {
        Form form = parser.parse(file);
        if (!parser.hasErrors()) {
            return performSemanticAnalysis(form);
        } else {
            LOGGER.severe("Syntactic analysis of the QL source code failed with the following errors:");
            logErrors(parser.getErrors());
            return false;
        }
    }

    private boolean performSemanticAnalysis(Form form) {
        List<SemanticQLError> semanticQLErrors = semanticalAnalyser.semanticallyValidateForm(form);
        if (semanticQLErrors.isEmpty()) {
            return generateCode(form);
        } else {
            LOGGER.severe("Semantic analysis of the QL source code failed with the following errors:");
            logErrors(semanticQLErrors);
            return false;
        }
    }

    private boolean generateCode(Form form) {
        String code = codeGenerator.generateQLCode(form);
        try {
            File file = createDestinationFile();
            FileUtils.writeStringToFile(file, code);
            return true;
        } catch (IOException ex) {
            LOGGER.severe("Writing generated code to file.");
            throw new RuntimeException(ex);
        }
    }

    private File createDestinationFile() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(PROPERTY_FILE_NAME));

        String qlTargetFolder = properties.getProperty("qlTargetFolder");
        String targetFolder = qlTargetFolder != null ? qlTargetFolder : ".";
        return new File(String.format(DESTINATION_FILE_NAME_TEMPLATE, targetFolder));
    }

    private void logErrors(List<? extends QLError> errors) {
        for (QLError error : errors) {
            LOGGER.severe(error.getErrorMessage());
        }
    }
}
