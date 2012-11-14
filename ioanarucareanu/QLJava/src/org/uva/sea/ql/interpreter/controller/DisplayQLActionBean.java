package org.uva.sea.ql.interpreter.controller;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

@UrlBinding(value = DisplayQLActionBean.URL_BINDING)
public class DisplayQLActionBean implements ActionBean {

	/** Constant denoting the url binding for the current action bean. */
    public static final String URL_BINDING = "/protected/questionnaire";
    
    /** Constant denoting the path to the form view. */
	private static final String FORM_VIEW_PATH = "/WEB-INF/jsp/index.jsp";
	private ActionBeanContext context;
	
	@DefaultHandler
    public Resolution view() {
        
        return new ForwardResolution(FORM_VIEW_PATH);
    }
	 
	@Override
	public ActionBeanContext getContext() {
		
		return context;
	}

	@Override
	public void setContext(ActionBeanContext arg0) {
		
		context = arg0;
	}

}
