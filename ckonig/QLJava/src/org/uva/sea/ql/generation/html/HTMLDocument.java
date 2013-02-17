package org.uva.sea.ql.generation.html;

import java.util.List;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.common.IdentFinder;
import org.uva.sea.ql.common.Registry;
import org.uva.sea.ql.common.interfaces.QLDocument;
import org.uva.sea.ql.generation.GeneratorException;

public class HTMLDocument implements QLDocument {
    private Registry registry;
    private String heading;
    private StringBuilder body;
    private StringBuilder script;

    private Templates templates;

    public HTMLDocument() throws GeneratorException {
        this.body = new StringBuilder();
        this.script = new StringBuilder();
        this.templates = new Templates("templates/");
        this.registry = new Registry();
    }

    private void appendToBody(String s) {
        this.body.append(s);
    }

    private void appendToScript(String s) {
        this.script.append(s);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.uva.sea.ql.generation.IDocumentBuilder#getOutput()
     */
    @Override
    public final String getOutput() {
        return this.templates.document(this.heading, this.body.toString(),
                this.script.toString());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.uva.sea.ql.generation.IDocumentBuilder#setHeading(java.lang.String)
     */
    @Override
    public final void setHeading(String content) {
        this.heading = content;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.uva.sea.ql.generation.IDocumentBuilder#appendQuestion(org.uva.sea
     * .ql.ast.elements.Question)
     */
    @Override
    public final void appendQuestion(Question question) {
        this.registry.addQuestion(question);
        final Type type = question.getType();
        final String name = question.getIdentName();
        final HTMLInputTypeVisitor v = new HTMLInputTypeVisitor();
        type.accept(v);
        final InputTypes t = v.getType();
        final String input = this.templates.input(name, t);
        final StringLiteral content = question.getContent();
        this.appendToBody(this.templates.question(content.toString(), input));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.uva.sea.ql.generation.IDocumentBuilder#beginIf(org.uva.sea.ql.ast
     * .elements.IfStatement)
     */
    @Override
    public final void beginIf(IfStatement ifStatement) {
        this.registry.addIfStatement(ifStatement);
        this.appendToBody(this.templates.hiddenStart(String.valueOf(ifStatement
                .hashCode())));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.uva.sea.ql.generation.IDocumentBuilder#endIf()
     */
    @Override
    public final void endIf() {
        this.appendToBody(this.templates.hiddenEnd());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.uva.sea.ql.generation.IDocumentBuilder#create(java.util.List,
     * java.util.List)
     */
    @Override
    public final void create() {
        final IdentFinder finder = new IdentFinder();
        for (Question q : this.registry.getQuestions()) {
            this.addGetter(q);
        }
        for (IfStatement i : this.registry.getIfStatements()) {
            this.appendToScript(this.templates.evaluator(
                    String.valueOf(i.hashCode()),
                    getConditionString(i.getCondition())));
            ((TreeNode) i.getCondition()).accept(finder);
            final List<Ident> idents = finder.getIdents();
            for (Ident ident : idents) {
                this.appendToScript(this.templates.listener(ident.getName(),
                        String.valueOf(i.hashCode())));
            }
        }
    }

    private void addGetter(Question q) {
        final GetterTypeVisitor v = new GetterTypeVisitor(this.templates,
                q.getIdentName());
        q.getType().accept(v);
        this.appendToScript(v.getGetter());
    }

    /**
     * Returns a string representing the given Expression, eg. "((1 + 5) > 1)".
     * Accepts any BinaryExpr using toString() as tree nodes (recursive).
     * Supports Ident, IntLiteral and StringLiteral as leaves. Ident will be
     * represented by a function call, eg.
     * "(hasBoughtHouse() && valueResidue() < 4000)"
     * 
     * @param expression
     * @return a string representing the expression
     */
    private static String getConditionString(Expr expression) {
        final HTMLTreeVisitor v = new HTMLTreeVisitor();
        ((TreeNode) expression).accept(v);
        return v.getRet();
    }
}
