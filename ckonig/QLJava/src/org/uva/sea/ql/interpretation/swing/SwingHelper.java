package org.uva.sea.ql.interpretation.swing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.common.IOHelper;
import org.uva.sea.ql.common.VisitorDocumentBuilder;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.generation.html.HTMLDocument;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.validation.AstValidationError;
import org.uva.sea.ql.validation.Validator;

public class SwingHelper {
    private String fileContent;
    private Form ast;
    private JTextArea log;
    private JButton buttonGenerate;
    private JPanel centerPanel;

    public SwingHelper(JTextArea area, JButton generate, JPanel center) {
        this.log = area;
        this.buttonGenerate = generate;
        this.centerPanel = center;
    }

    public final void openFile(File file) {
        try {
            this.fileContent = IOHelper.read(file);
            this.appendToLog("file opened");
            parseFile();
        } catch (IOException ex) {
            this.appendToLog("error reading file");
        }
    }

    private void parseFile() {
        if (this.fileContent != null) {
            final IParse parser = new ANTLRParser();
            try {
                this.ast = parser.parseForm(this.fileContent);
                this.appendToLog("File parsed");
                validateAst();
            } catch (ParseError e) {
                this.appendToLog(e.getMessage());
            }
        }
    }

    private void validateAst() {
        final Validator validator = new Validator(false);
        try {
            validator.validate(this.ast);
            if (validator.hasErrors()) {
                this.appendToLog("Errors during validation:");
                for (String error : validator.getErrors()) {
                    this.appendToLog(error);
                }
            } else {
                this.appendToLog("AST validated");
                interpretAst();
            }
        } catch (AstValidationError ex) {
            this.appendToLog(ex.getMessage());
        }
    }

    private void interpretAst() {
        final VisitorDocumentBuilder visitor = new VisitorDocumentBuilder(
                new SwingDocument());
        if (this.ast != null) {
            try {
                ((Form) this.ast).accept(visitor);
                final JPanel result = (JPanel) visitor.getOutput();
                this.centerPanel.add(result);
                result.setVisible(true);
                this.centerPanel.repaint();
                this.appendToLog("interpretation finished\n");
                this.buttonGenerate.setEnabled(true);
            } catch (QLException ex) {
                this.appendToLog(ex.getMessage());
            }

        } else {
            this.appendToLog("AST INVALID");
        }
    }

    public final void generateHtml() {

        if (this.ast != null) {
            try {
                final VisitorDocumentBuilder visitor = new VisitorDocumentBuilder(
                        new HTMLDocument());
                final Form form = (Form) this.ast;
                form.accept(visitor);
                final String output = (String) visitor.getOutput();
                IOHelper.write(IOHelper.OUT_PATH + form.getName() + ".html",
                        output);
                this.appendToLog(IOHelper.OUT_PATH + form.getName() + " created");
            } catch (QLException ex) {
                this.appendToLog(ex.getMessage());
            } catch (FileNotFoundException ex) {
                this.appendToLog(ex.getMessage());
            }
        } else {
            this.appendToLog("invalid AST");
        }

    }

    private void appendToLog(String str) {
        this.log.append(str + "\n");
    }

}
