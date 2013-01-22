package org.uva.sea.ql.errors;

import java.util.ArrayList;
import java.util.List;


public class AggregatedError extends Error{

	private List<Error> errors;
	
	public AggregatedError(){
		super();
		errors = new ArrayList<Error>();
	}
	
	
	public AggregatedError(String msg) {
		super(msg);
		errors = new ArrayList<Error>();
	}
	
	
	public void add(Error error){
		errors.add(error);
	}

	
	public List<Error> getAll(){
		List<Error> aggregated = new ArrayList<Error>();
		
		for(Error e: errors){
			
			if(e instanceof AggregatedError){
				AggregatedError aggregatedErr = (AggregatedError)e;
				aggregated.addAll(aggregatedErr.getAll());
			}
			else{
				aggregated.add(e);
			}
		}
		
		return aggregated;
	}
}
