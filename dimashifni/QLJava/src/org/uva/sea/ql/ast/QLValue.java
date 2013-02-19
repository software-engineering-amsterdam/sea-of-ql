package org.uva.sea.ql.ast;

public class QLValue implements Comparable<QLValue> 
{
	 public static final QLValue NULL = new QLValue();  
	  public static final QLValue VOID = new QLValue();  
	  
	  private Object value;  
	  
	  private QLValue() {  
	    // private constructor: only used for NULL and VOID  
	    value = new Object();  
	  }  
	  
	  public QLValue(Object v) {  
	    if(v == null) {  
	      throw new RuntimeException("v == null");  
	    }  
	    value = v;  
	    // only accept boolean, list, number or string types  
	    if(!(isBoolean() || isNumber() || isString())) {  
	      throw new RuntimeException("invalid type: " + v + " (" + v.getClass() + ")");  
	    }  
	  }  
	  
	  public Boolean asBoolean() {  
	    return (Boolean)value;  
	  }  
	  
	  public Double asDouble() {  
	    return ((Number)value).doubleValue();  
	  }  
	  
	  public Long asLong() {  
	    return ((Number)value).longValue();  
	  }  
	  
	  public String asString() {  
	    return (String)value;  
	  }  
	  
	  @Override  
	  public int compareTo(QLValue that) {  
	    if(this.isNumber() && that.isNumber()) {  
	      if(this.equals(that)) {  
	        return 0;  
	      }  
	      else {  
	        return this.asDouble().compareTo(that.asDouble());  
	      }  
	    }  
	    else if(this.isString() && that.isString()) {  
	      return this.asString().compareTo(that.asString());  
	    }  
	    else {  
	      throw new RuntimeException("illegal expression: can't compare `" +   
	          this + "` to `" + that + "`");  
	    }  
	  }  
	  
	  @Override  
	  public boolean equals(Object o) {  
	    if(this == VOID || o == VOID) {  
	      throw new RuntimeException("can't use VOID: " + this + " ==/!= " + o);  
	    }  
	    if(this == o) {  
	      return true;  
	    }  
	    if(o == null || this.getClass() != o.getClass()) {  
	      return false;  
	    }  
	    QLValue that = (QLValue)o;  
	    if(this.isNumber() && that.isNumber()) {  
	      double diff = Math.abs(this.asDouble() - that.asDouble());  
	      return diff < 0.00000000001;  
	    }  
	    else {  
	      return this.value.equals(that.value);  
	    }  
	  }  
	  
	  @Override  
	  public int hashCode() {  
	    return value.hashCode();  
	  }  
	  
	  public boolean isBoolean() {  
	    return value instanceof Boolean;  
	  }  
	  
	  public boolean isNumber() {  
	    return value instanceof Number;  
	  }
	  
	  public boolean isNull() {  
	    return this == NULL;  
	  }  
	  
	  public boolean isVoid() {  
	    return this == VOID;  
	  }  
	  
	  public boolean isString() {  
	    return value instanceof String;  
	  }  
	  
	  @Override  
	  public String toString() {  
	    return isNull() ? "NULL" : isVoid() ? "VOID" : String.valueOf(value);  
	  }  

}
