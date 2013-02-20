package org.uva.sea.ql.codegeneration;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;
import org.uva.sea.ql.ast.Form;

public class WebAppCodeGenerator {

    private final STGroupFile mainTemplateGroup;
    private final HTMLGenerator htmlGenerator;
    private final JavaScriptGenerator javaScriptGenerator;

    public WebAppCodeGenerator() {
        this.mainTemplateGroup = new STGroupFile("src/main/resources/templates/qlmain.stg", '$', '$');
        this.htmlGenerator = new HTMLGenerator();
        this.javaScriptGenerator = new JavaScriptGenerator();
    }

    public String generateCode(Form form) {
        ST pageTemplate = mainTemplateGroup.getInstanceOf("page"), formTemplate = mainTemplateGroup.getInstanceOf("form");

        formTemplate.add("statements", htmlGenerator.visitForm(form));
        pageTemplate.add("formName", form.getName());
        pageTemplate.add("documentReadyContent", javaScriptGenerator.visitForm(form));

        pageTemplate.add("formContent", formTemplate.render());
        return pageTemplate.render();
    }
}
