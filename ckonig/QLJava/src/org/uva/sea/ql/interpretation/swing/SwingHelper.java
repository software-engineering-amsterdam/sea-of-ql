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
    private final static String NEWLINE = "\n";
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
            this.log.append("file opened" + NEWLINE);
            parseFile();
        } catch (IOException ex) {
            this.log.append("error reading file" + NEWLINE);
        }
    }

    private void parseFile() {
        if (this.fileContent != null) {
            final IParse p = new ANTLRParser();
            try {
                this.ast = p.parseForm(this.fileContent);
                this.log.append("File parsed" + NEWLINE);
                validateAst();
            } catch (ParseError e) {
                this.log.append(e.getMessage() + NEWLINE);
            }
        }
    }

    private void validateAst() {
        final Validator v = new Validator(false);
        try {
            v.validate(this.ast);
            if (v.hasErrors()) {
                this.log.append("Errors during validation:" + NEWLINE);
                for (String error : v.getErrors()) {
                    this.log.append(error + NEWLINE);
                }
            } else {
                this.log.append("AST validated" + NEWLINE);
                interpretAst();
            }
        } catch (AstValidationError ex) {
            this.log.append(ex.getMessage() + NEWLINE);
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
                this.log.append("interpretation finished\n");
                this.buttonGenerate.setEnabled(true);
            } catch (QLException ex) {
                this.log.append(ex.getMessage() + NEWLINE);
            }

        } else {
            this.log.append("AST INVALID" + NEWLINE);
        }
    }

    public final void generateHtml() {

        if (this.ast != null) {
            try {
                final VisitorDocumentBuilder visitor = new VisitorDocumentBuilder(
                        new HTMLDocument());
                final Form f = (Form) this.ast;
                f.accept(visitor);
                final String output = (String) visitor.getOutput();
                IOHelper.write(IOHelper.OUT_PATH + f.getName() + ".html",
                        output);
                this.log.append(IOHelper.OUT_PATH + f.getName() + " created" + NEWLINE);
            } catch (QLException ex) {
                this.log.append(ex.getMessage());
            } catch (FileNotFoundException ex) {
                this.log.append(ex.getMessage());
            }
        } else {
            this.log.append("invalid AST" + NEWLINE);
        }

    }

}
