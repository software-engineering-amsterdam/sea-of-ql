package org.uva.sea.ql.interpreter.controller;

import org.uva.sea.ql.ast.expr.value.Val;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.Validate;

public class ProcessResponseActionBean implements ActionBean {

	/** Constant denoting the url binding for the current action bean. */
    public static final String URL_BINDING = "/protected/question/processResponse";
    
	private ActionBeanContext context;
	
	@Validate(field="value", converter=GenericValueTypeConverter.class)
	private Val value;
	@Validate(field="identName", required=true)
	private String identName;
	
	public Resolution view() {
		return null;
	}
	
	public Val getValue() {
		return value;
	}

	public void setValue(Val value) {
		this.value = value;
	}

	public String getIdentName() {
		return identName;
	}


	public void setIdentName(String identName) {
		this.identName = identName;
	}


	@Override
	public ActionBeanContext getContext() {
		
		return context;
	}

	@Override
	public void setContext(ActionBeanContext context) {
		
		this.context = context;
	}

}
