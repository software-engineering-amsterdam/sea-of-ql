package org.uva.sea.ql.interpretation.swing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.IOHelper;
import org.uva.sea.ql.common.VisitorDocumentBuilder;
import org.uva.sea.ql.common.VisitorException;
import org.uva.sea.ql.generation.html.HTMLDocument;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.validation.AstValidationError;
import org.uva.sea.ql.validation.Validator;

public class SwingHelper {
    private String fileContent;
    private Expr ast;
    private JTextArea log;
    private JButton buttonGenerate;
    private JPanel centerPanel;

    public SwingHelper(JTextArea log, JButton generate, JPanel center) {
        this.log = log;
        this.buttonGenerate = generate;
        this.centerPanel = center;
    }

    public final void openFile(File file) {
        try {
            this.fileContent = IOHelper.read(file);
            this.log.append("file opened\n");
            parseFile();
        } catch (IOException ex) {
            this.log.append("error reading file");
        }
    }

    private void parseFile() {
        if (this.fileContent != null) {
            IParse p = new ANTLRParser();
            try {
                this.ast = p.parseDefaultFile();
                this.log.append("File parsed\n");
                validateAst();
            } catch (ParseError e) {
                this.log.append(e.getMessage());
            }
        }
    }

    private void validateAst() {
        final Validator v = new Validator();
        try {
            v.validate(ast);
            this.log.append("AST validated\n");
            interpretAst();
            this.buttonGenerate.setEnabled(true);
        } catch (AstValidationError ex) {
            this.log.append(ex.getMessage() + "\n");
        } catch (IOException e1) {
            this.log.append(e1.getMessage() + "\n");
        }
    }

    private void interpretAst() {
        final VisitorDocumentBuilder visitor = new VisitorDocumentBuilder(
                new SwingDocument());
        if (this.ast != null && ast instanceof Form) {
            try {
                ((Form) this.ast).accept(visitor);
                JPanel result = (JPanel) visitor.getOutput();
                this.centerPanel.add(result);
                result.setVisible(true);
                this.centerPanel.repaint();
                this.log.append("interpretation finished\n");
            } catch (VisitorException ex) {
                this.log.append(ex.getMessage() + "\n");
            }

        } else {
            this.log.append("AST INVALID\n");
        }
    }

    public final void generateHtml() {

        if (this.ast != null && ast instanceof Form) {
            try {
                final VisitorDocumentBuilder visitor = new VisitorDocumentBuilder(
                        new HTMLDocument());
                final Form f = (Form) ast;
                f.accept(visitor);
                String output = (String) visitor.getOutput();
                IOHelper.write(IOHelper.OUT_PATH + f.getName() + ".html",
                        output);
                this.log.append(IOHelper.OUT_PATH + f.getName() + " created\n");
            } catch (VisitorException ex) {
                this.log.append(ex.getMessage());
            } catch (FileNotFoundException ex) {
                this.log.append(ex.getMessage());
            }
        } else {
            this.log.append("invalid AST\n");
        }

    }

}
