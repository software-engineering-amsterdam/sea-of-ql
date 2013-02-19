package org.uva.sea.ql.interpreter.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.Val;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationError;
import net.sourceforge.stripes.validation.ValidationErrorHandler;
import net.sourceforge.stripes.validation.ValidationErrors;

public abstract class ProcessResponseActionBean implements ActionBean, ValidationErrorHandler {
    
	@Validate(required=true)
	private String identName;
	
	private Map<Ident, TypeValuePair> symbolTypeValueTable;
	
	private ActionBeanContext context;
	
	private void initAttrFromSession() {
		HttpSession session = context.getRequest().getSession(); 
		symbolTypeValueTable = (Map<Ident, TypeValuePair>) session.getAttribute(DisplayQLActionBean.SYMBOL_TABLE_SESSION_ATTR);
	}
	
	private void saveAttrOnSession() {
		HttpSession session = context.getRequest().getSession();
		session.setAttribute(DisplayQLActionBean.SYMBOL_TABLE_SESSION_ATTR, symbolTypeValueTable);
	}
	
	@DefaultHandler
	public Resolution view() {
		
		initAttrFromSession();
		Ident ident = new Ident(getIdentName());
		Val val = getAnswerVal();
		symbolTypeValueTable.get(ident).setValue(val);
		saveAttrOnSession();
		return new RedirectResolution(DisplayQLActionBean.URL_BINDING + "?view=");
	}
	
	@Override
	public Resolution handleValidationErrors(ValidationErrors errors)
			throws Exception {
		StringBuilder errorsBuilder = new StringBuilder();
		for (Map.Entry<String, List<ValidationError>> entry : errors.entrySet()) {
			for (ValidationError error : entry.getValue()) {
				errorsBuilder.append(error.getMessage(context.getLocale()) + "\n");
			}
		}
		return new ForwardResolution(DisplayQLActionBean.URL_BINDING + "?view=")
			.addParameter("errors", errorsBuilder.toString());

	}

//	public abstract void resetAnswer();
	
	public String getIdentName() {
		return identName;
	}

	public void setIdentName(String identName) {
		this.identName = identName;
	}
	
	public abstract Val getAnswerVal();

	@Override
	public ActionBeanContext getContext() {
		
		return context;
	}

	@Override
	public void setContext(ActionBeanContext context) {
		
		this.context = context;
	}

}
