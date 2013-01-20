package org.uva.sea.ql.ast;

public class CompositeFormElement implements FormElement {
    
	private final Iterable<FormElement> formElements;

    public CompositeFormElement(Iterable<FormElement> formElements) {
        this.formElements = formElements;
    }

    public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
        for(FormElement formElement : formElements)
            formElement.accept(visitor, param);

        return null;
    }

    public Iterable<FormElement> getFormElements() { return formElements; }
}
