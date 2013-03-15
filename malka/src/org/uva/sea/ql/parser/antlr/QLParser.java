// $ANTLR !Unknown version! QL.g 2013-03-09 00:38:26

package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.integer.*;
import org.uva.sea.ql.ast.expression.bool.*;
import org.uva.sea.ql.ast.expression.string.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.expression.integer.operation.*;
import org.uva.sea.ql.ast.expression.bool.operation.logical.*;
import org.uva.sea.ql.ast.expression.bool.operation.relational.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FORM", "IDENT", "STRING", "IF", "ELSE", "INT", "BOOL", "BOOL_TYPE", "INT_TYPE", "STRING_TYPE", "COMMENT", "WS", "'{'", "'}'", "':'", "'('", "')'", "'+'", "'-'", "'!'", "'*'", "'/'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", "'||'"
    };
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int BOOL_TYPE=11;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int ELSE=8;
    public static final int BOOL=10;
    public static final int INT=9;
    public static final int INT_TYPE=12;
    public static final int EOF=-1;
    public static final int IF=7;
    public static final int T__19=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int WS=15;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int STRING_TYPE=13;
    public static final int IDENT=5;
    public static final int FORM=4;
    public static final int COMMENT=14;
    public static final int STRING=6;

    // delegates
    // delegators


        public QLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public QLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[36+1];
             
             
        }
        

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "QL.g"; }


    private List<String> errors = new Stack<String>();
    public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
    	String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        errors.add(hdr + " " + msg);
    }

    public List<String> getErrors() {
    	return errors;
    }



    // $ANTLR start "form"
    // QL.g:40:1: form returns [Form result] : FORM IDENT '{' elements= formElementList '}' ;
    public final Form form() throws RecognitionException {
        Form result = null;
        int form_StartIndex = input.index();
        Token IDENT1=null;
        List<FormElement> elements = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }
            // QL.g:41:2: ( FORM IDENT '{' elements= formElementList '}' )
            // QL.g:41:4: FORM IDENT '{' elements= formElementList '}'
            {
            match(input,FORM,FOLLOW_FORM_in_form54); if (state.failed) return result;
            IDENT1=(Token)match(input,IDENT,FOLLOW_IDENT_in_form56); if (state.failed) return result;
            match(input,16,FOLLOW_16_in_form58); if (state.failed) return result;
            pushFollow(FOLLOW_formElementList_in_form62);
            elements=formElementList();

            state._fsp--;
            if (state.failed) return result;
            match(input,17,FOLLOW_17_in_form64); if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result = new Form((IDENT1!=null?IDENT1.getText():null), elements); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, form_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "form"


    // $ANTLR start "formElementList"
    // QL.g:44:1: formElementList returns [List<FormElement> result] : (element= formElement )* ;
    public final List<FormElement> formElementList() throws RecognitionException {
        List<FormElement> result = null;
        int formElementList_StartIndex = input.index();
        FormElement element = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }
            // QL.g:45:2: ( (element= formElement )* )
            // QL.g:45:4: (element= formElement )*
            {
            if ( state.backtracking==0 ) {
              result = new ArrayList<FormElement>();
            }
            // QL.g:45:46: (element= formElement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==IDENT||LA1_0==IF) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // QL.g:45:47: element= formElement
            	    {
            	    pushFollow(FOLLOW_formElement_in_formElementList86);
            	    element=formElement();

            	    state._fsp--;
            	    if (state.failed) return result;
            	    if ( state.backtracking==0 ) {
            	      result.add(element);
            	    }

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, formElementList_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "formElementList"


    // $ANTLR start "formElement"
    // QL.g:48:1: formElement returns [FormElement result] : ( IDENT ':' STRING t= type | IDENT ':' STRING t= type '(' x= addExpr ')' | IF '(' condition= orExpr ')' '{' if_list= formElementList '}' ( ELSE '{' else_list= formElementList '}' )? );
    public final FormElement formElement() throws RecognitionException {
        FormElement result = null;
        int formElement_StartIndex = input.index();
        Token IDENT2=null;
        Token STRING3=null;
        Token IDENT4=null;
        Token STRING5=null;
        Type t = null;

        Expression x = null;

        Expression condition = null;

        List<FormElement> if_list = null;

        List<FormElement> else_list = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }
            // QL.g:49:2: ( IDENT ':' STRING t= type | IDENT ':' STRING t= type '(' x= addExpr ')' | IF '(' condition= orExpr ')' '{' if_list= formElementList '}' ( ELSE '{' else_list= formElementList '}' )? )
            int alt3=3;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // QL.g:49:4: IDENT ':' STRING t= type
                    {
                    IDENT2=(Token)match(input,IDENT,FOLLOW_IDENT_in_formElement105); if (state.failed) return result;
                    match(input,18,FOLLOW_18_in_formElement107); if (state.failed) return result;
                    STRING3=(Token)match(input,STRING,FOLLOW_STRING_in_formElement109); if (state.failed) return result;
                    pushFollow(FOLLOW_type_in_formElement113);
                    t=type();

                    state._fsp--;
                    if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Question(new Identifier((IDENT2!=null?IDENT2.getText():null)), new StringPrimitive((STRING3!=null?STRING3.getText():null)), t); 
                    }

                    }
                    break;
                case 2 :
                    // QL.g:50:4: IDENT ':' STRING t= type '(' x= addExpr ')'
                    {
                    IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_formElement120); if (state.failed) return result;
                    match(input,18,FOLLOW_18_in_formElement122); if (state.failed) return result;
                    STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_formElement124); if (state.failed) return result;
                    pushFollow(FOLLOW_type_in_formElement128);
                    t=type();

                    state._fsp--;
                    if (state.failed) return result;
                    match(input,19,FOLLOW_19_in_formElement130); if (state.failed) return result;
                    pushFollow(FOLLOW_addExpr_in_formElement134);
                    x=addExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    match(input,20,FOLLOW_20_in_formElement136); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new FormText(new Identifier((IDENT4!=null?IDENT4.getText():null)), new StringPrimitive((STRING5!=null?STRING5.getText():null)), t, x); 
                    }

                    }
                    break;
                case 3 :
                    // QL.g:51:4: IF '(' condition= orExpr ')' '{' if_list= formElementList '}' ( ELSE '{' else_list= formElementList '}' )?
                    {
                    match(input,IF,FOLLOW_IF_in_formElement143); if (state.failed) return result;
                    match(input,19,FOLLOW_19_in_formElement145); if (state.failed) return result;
                    pushFollow(FOLLOW_orExpr_in_formElement149);
                    condition=orExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    match(input,20,FOLLOW_20_in_formElement151); if (state.failed) return result;
                    match(input,16,FOLLOW_16_in_formElement153); if (state.failed) return result;
                    pushFollow(FOLLOW_formElementList_in_formElement157);
                    if_list=formElementList();

                    state._fsp--;
                    if (state.failed) return result;
                    match(input,17,FOLLOW_17_in_formElement159); if (state.failed) return result;
                    // QL.g:51:64: ( ELSE '{' else_list= formElementList '}' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==ELSE) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // QL.g:51:66: ELSE '{' else_list= formElementList '}'
                            {
                            match(input,ELSE,FOLLOW_ELSE_in_formElement163); if (state.failed) return result;
                            match(input,16,FOLLOW_16_in_formElement165); if (state.failed) return result;
                            pushFollow(FOLLOW_formElementList_in_formElement169);
                            else_list=formElementList();

                            state._fsp--;
                            if (state.failed) return result;
                            match(input,17,FOLLOW_17_in_formElement171); if (state.failed) return result;

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      		
                      		if (condition instanceof Identifier) {
                             		condition = new BooleanVariable((Identifier) condition);
                            	}
                            		
                      		if (condition instanceof BooleanExpression) {
                      			result = new IfStatement((BooleanExpression)condition, if_list, else_list);
                      		} else {
                      			throw new TypeException();
                      		}
                      	
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, formElement_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "formElement"


    // $ANTLR start "primary"
    // QL.g:66:1: primary returns [Expression result] : ( INT | BOOL | STRING | IDENT | '(' x= orExpr ')' );
    public final Expression primary() throws RecognitionException {
        Expression result = null;
        int primary_StartIndex = input.index();
        Token INT6=null;
        Token BOOL7=null;
        Token STRING8=null;
        Token IDENT9=null;
        Expression x = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }
            // QL.g:67:3: ( INT | BOOL | STRING | IDENT | '(' x= orExpr ')' )
            int alt4=5;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt4=1;
                }
                break;
            case BOOL:
                {
                alt4=2;
                }
                break;
            case STRING:
                {
                alt4=3;
                }
                break;
            case IDENT:
                {
                alt4=4;
                }
                break;
            case 19:
                {
                alt4=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // QL.g:67:5: INT
                    {
                    INT6=(Token)match(input,INT,FOLLOW_INT_in_primary193); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new IntegerPrimitive(Integer.parseInt((INT6!=null?INT6.getText():null))); 
                    }

                    }
                    break;
                case 2 :
                    // QL.g:68:5: BOOL
                    {
                    BOOL7=(Token)match(input,BOOL,FOLLOW_BOOL_in_primary204); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new BooleanPrimitive(Boolean.parseBoolean((BOOL7!=null?BOOL7.getText():null))); 
                    }

                    }
                    break;
                case 3 :
                    // QL.g:69:5: STRING
                    {
                    STRING8=(Token)match(input,STRING,FOLLOW_STRING_in_primary214); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new StringPrimitive((STRING8!=null?STRING8.getText():null)); 
                    }

                    }
                    break;
                case 4 :
                    // QL.g:70:5: IDENT
                    {
                    IDENT9=(Token)match(input,IDENT,FOLLOW_IDENT_in_primary222); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Identifier((IDENT9!=null?IDENT9.getText():null)); 
                    }

                    }
                    break;
                case 5 :
                    // QL.g:71:5: '(' x= orExpr ')'
                    {
                    match(input,19,FOLLOW_19_in_primary231); if (state.failed) return result;
                    pushFollow(FOLLOW_orExpr_in_primary235);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    match(input,20,FOLLOW_20_in_primary237); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = x; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, primary_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "primary"


    // $ANTLR start "type"
    // QL.g:74:1: type returns [Type result] : ( BOOL_TYPE | INT_TYPE | STRING_TYPE );
    public final Type type() throws RecognitionException {
        Type result = null;
        int type_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }
            // QL.g:75:2: ( BOOL_TYPE | INT_TYPE | STRING_TYPE )
            int alt5=3;
            switch ( input.LA(1) ) {
            case BOOL_TYPE:
                {
                alt5=1;
                }
                break;
            case INT_TYPE:
                {
                alt5=2;
                }
                break;
            case STRING_TYPE:
                {
                alt5=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // QL.g:75:4: BOOL_TYPE
                    {
                    match(input,BOOL_TYPE,FOLLOW_BOOL_TYPE_in_type256); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                      result = new BooleanType();
                    }

                    }
                    break;
                case 2 :
                    // QL.g:76:4: INT_TYPE
                    {
                    match(input,INT_TYPE,FOLLOW_INT_TYPE_in_type263); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                      result = new IntegerType();
                    }

                    }
                    break;
                case 3 :
                    // QL.g:77:4: STRING_TYPE
                    {
                    match(input,STRING_TYPE,FOLLOW_STRING_TYPE_in_type270); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                      result = new StringType();
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, type_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "type"


    // $ANTLR start "unExpr"
    // QL.g:80:1: unExpr returns [Expression result] : (op= ( '+' | '-' ) x= unExpr | '!' x= unExpr | x= primary );
    public final Expression unExpr() throws RecognitionException {
        Expression result = null;
        int unExpr_StartIndex = input.index();
        Token op=null;
        Expression x = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }
            // QL.g:81:5: (op= ( '+' | '-' ) x= unExpr | '!' x= unExpr | x= primary )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 21:
            case 22:
                {
                alt6=1;
                }
                break;
            case 23:
                {
                alt6=2;
                }
                break;
            case IDENT:
            case STRING:
            case INT:
            case BOOL:
            case 19:
                {
                alt6=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // QL.g:81:8: op= ( '+' | '-' ) x= unExpr
                    {
                    op=(Token)input.LT(1);
                    if ( (input.LA(1)>=21 && input.LA(1)<=22) ) {
                        input.consume();
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return result;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_unExpr_in_unExpr305);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       
                          	IntegerExpression operand = null;
                          	if (x instanceof Identifier) {
                             		operand = new IntegerVariable((Identifier) x);
                            	}
                            	else if (x instanceof IntegerExpression)
                          	{
                          		 operand = (IntegerExpression) x;
                          	}
                          	
                          	if (operand != null)
                          	{
                          		if ((op!=null?op.getText():null).equals("+"))
                          			result = new Pos( operand );
                          		else if ((op!=null?op.getText():null).equals("-"))
                          			result = new Neg( operand );
                          	}
                          	else
                          	{
                          		throw new TypeException();
                          	}
                          	
                          
                    }

                    }
                    break;
                case 2 :
                    // QL.g:105:8: '!' x= unExpr
                    {
                    match(input,23,FOLLOW_23_in_unExpr321); if (state.failed) return result;
                    pushFollow(FOLLOW_unExpr_in_unExpr325);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       
                          	BooleanExpression operand = null;
                          	if (x instanceof Identifier) {
                             		operand = new BooleanVariable((Identifier) x);
                            	}
                            	else if (x instanceof BooleanExpression)
                          	{
                          		 operand = (BooleanExpression) x;
                          	}
                          	
                          	if (operand != null)
                          	{
                          		result = new Not( operand );
                          	}
                          	else
                          	{
                          		throw new TypeException();
                          	}
                          
                    }

                    }
                    break;
                case 3 :
                    // QL.g:125:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr342);
                    x=primary();

                    state._fsp--;
                    if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = x; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, unExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "unExpr"


    // $ANTLR start "mulExpr"
    // QL.g:128:1: mulExpr returns [Expression result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expression mulExpr() throws RecognitionException {
        Expression result = null;
        int mulExpr_StartIndex = input.index();
        Token op=null;
        Expression lhs = null;

        Expression rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }
            // QL.g:129:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // QL.g:129:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr376);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:129:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=24 && LA7_0<=25)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // QL.g:129:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=24 && input.LA(1)<=25) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_unExpr_in_mulExpr396);
            	    rhs=unExpr();

            	    state._fsp--;
            	    if (state.failed) return result;
            	    if ( state.backtracking==0 ) {
            	       
            	            
            	            if (result instanceof Identifier) {
            	              result = new IntegerVariable((Identifier) result);
            	            }
            	            if (rhs instanceof Identifier) {
            	              rhs = new IntegerVariable((Identifier) rhs);
            	            }
            	             
            	            if ( result instanceof IntegerExpression
            	                    && rhs instanceof IntegerExpression ) {
            	            	if ((op!=null?op.getText():null).equals("*")) {
            	                result = new Mul((IntegerExpression)result, (IntegerExpression)rhs);
            	              }
            	              if ((op!=null?op.getText():null).equals("/")) {
            	                result = new Div((IntegerExpression)result, (IntegerExpression)rhs);      
            	              }
            	              
            	              
            	            } else {
            	            	throw new TypeException();
            	            }
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, mulExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "mulExpr"


    // $ANTLR start "addExpr"
    // QL.g:156:1: addExpr returns [Expression result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expression addExpr() throws RecognitionException {
        Expression result = null;
        int addExpr_StartIndex = input.index();
        Token op=null;
        Expression lhs = null;

        Expression rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }
            // QL.g:157:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // QL.g:157:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr437);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:157:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=21 && LA8_0<=22)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // QL.g:157:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=21 && input.LA(1)<=22) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_mulExpr_in_addExpr455);
            	    rhs=mulExpr();

            	    state._fsp--;
            	    if (state.failed) return result;
            	    if ( state.backtracking==0 ) {

            	            if (result instanceof Identifier) {
            	              result = new IntegerVariable((Identifier) result);
            	            }
            	            if (rhs instanceof Identifier) {
            	              rhs = new IntegerVariable((Identifier) rhs);
            	            }
            	            
            	            if ( result instanceof IntegerExpression
            	                    && rhs instanceof IntegerExpression ) {
            	            	if ((op!=null?op.getText():null).equals("+")) {
            	              	result = new Add((IntegerExpression)result, (IntegerExpression)rhs);
            	            	}
            	            	if ((op!=null?op.getText():null).equals("-")) {
            	      	        result = new Sub((IntegerExpression)result, (IntegerExpression)rhs);
            	          	}
            	            } else {
            	            	throw new TypeException();
            	            }
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, addExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "addExpr"


    // $ANTLR start "relExpr"
    // QL.g:180:1: relExpr returns [Expression result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expression relExpr() throws RecognitionException {
        Expression result = null;
        int relExpr_StartIndex = input.index();
        Token op=null;
        Expression lhs = null;

        Expression rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }
            // QL.g:181:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // QL.g:181:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr490);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:181:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=26 && LA9_0<=31)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // QL.g:181:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=26 && input.LA(1)<=31) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_addExpr_in_relExpr514);
            	    rhs=addExpr();

            	    state._fsp--;
            	    if (state.failed) return result;
            	    if ( state.backtracking==0 ) {
            	       
            	            if ((op!=null?op.getText():null).equals("<")) {
            	              result = new LT(result, rhs);
            	            }
            	            if ((op!=null?op.getText():null).equals("<=")) {
            	              result = new LEq(result, rhs);      
            	            }
            	            if ((op!=null?op.getText():null).equals(">")) {
            	              result = new GT(result, rhs);
            	            }
            	            if ((op!=null?op.getText():null).equals(">=")) {
            	              result = new GEq(result, rhs);
            	            }
            	            if ((op!=null?op.getText():null).equals("==")) {
            	              result = new Eq(result, rhs);
            	            }
            	            if ((op!=null?op.getText():null).equals("!=")) {
            	              result = new NEq(result, rhs);
            	            }
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, relExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "relExpr"


    // $ANTLR start "andExpr"
    // QL.g:204:1: andExpr returns [Expression result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expression andExpr() throws RecognitionException {
        Expression result = null;
        int andExpr_StartIndex = input.index();
        Expression lhs = null;

        Expression rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }
            // QL.g:205:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // QL.g:205:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr552);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:205:46: ( '&&' rhs= relExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==32) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // QL.g:205:48: '&&' rhs= relExpr
            	    {
            	    match(input,32,FOLLOW_32_in_andExpr558); if (state.failed) return result;
            	    pushFollow(FOLLOW_relExpr_in_andExpr562);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;
            	    if ( state.backtracking==0 ) {

            	            if (result instanceof Identifier) {
            	              result = new BooleanVariable((Identifier) result);
            	            }
            	            if (rhs instanceof Identifier) {
            	              rhs = new BooleanVariable((Identifier) rhs);
            	            }
            	            
            	            if ( result instanceof BooleanExpression
            	                    && rhs instanceof BooleanExpression ) {
            	            	
            	            	result = new And((BooleanExpression)result, (BooleanExpression)rhs);
            	            } else {
            	            	throw new TypeException();
            	            }
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, andExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "andExpr"


    // $ANTLR start "orExpr"
    // QL.g:225:1: orExpr returns [Expression result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expression orExpr() throws RecognitionException {
        Expression result = null;
        int orExpr_StartIndex = input.index();
        Expression lhs = null;

        Expression rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }
            // QL.g:226:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // QL.g:226:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr601);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result = lhs; 
            }
            // QL.g:226:48: ( '||' rhs= andExpr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==33) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // QL.g:226:50: '||' rhs= andExpr
            	    {
            	    match(input,33,FOLLOW_33_in_orExpr607); if (state.failed) return result;
            	    pushFollow(FOLLOW_andExpr_in_orExpr611);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;
            	    if ( state.backtracking==0 ) {

            	            if (result instanceof Identifier) {
            	              result = new BooleanVariable((Identifier) result);
            	            }
            	            if (rhs instanceof Identifier) {
            	              rhs = new BooleanVariable((Identifier) rhs);
            	            }
            	            
            	            if ( result instanceof BooleanExpression
            	                    && rhs instanceof BooleanExpression ) {
            	            	
            	            	result = new Or((BooleanExpression)result, (BooleanExpression)rhs);
            	            } else {
            	            	throw new TypeException();
            	            }
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, orExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "orExpr"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\12\uffff";
    static final String DFA3_eofS =
        "\5\uffff\3\11\2\uffff";
    static final String DFA3_minS =
        "\1\5\1\22\1\uffff\1\6\1\13\3\5\2\uffff";
    static final String DFA3_maxS =
        "\1\7\1\22\1\uffff\1\6\1\15\3\23\2\uffff";
    static final String DFA3_acceptS =
        "\2\uffff\1\3\5\uffff\1\2\1\1";
    static final String DFA3_specialS =
        "\12\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\1\1\uffff\1\2",
            "\1\3",
            "",
            "\1\4",
            "\1\5\1\6\1\7",
            "\1\11\1\uffff\1\11\11\uffff\1\11\1\uffff\1\10",
            "\1\11\1\uffff\1\11\11\uffff\1\11\1\uffff\1\10",
            "\1\11\1\uffff\1\11\11\uffff\1\11\1\uffff\1\10",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "48:1: formElement returns [FormElement result] : ( IDENT ':' STRING t= type | IDENT ':' STRING t= type '(' x= addExpr ')' | IF '(' condition= orExpr ')' '{' if_list= formElementList '}' ( ELSE '{' else_list= formElementList '}' )? );";
        }
    }
 

    public static final BitSet FOLLOW_FORM_in_form54 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_form56 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_form58 = new BitSet(new long[]{0x00000000000200A0L});
    public static final BitSet FOLLOW_formElementList_in_form62 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_form64 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formElement_in_formElementList86 = new BitSet(new long[]{0x00000000000000A2L});
    public static final BitSet FOLLOW_IDENT_in_formElement105 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_formElement107 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_formElement109 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_type_in_formElement113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_formElement120 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_formElement122 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_formElement124 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_type_in_formElement128 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_formElement130 = new BitSet(new long[]{0x0000000000E80660L});
    public static final BitSet FOLLOW_addExpr_in_formElement134 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_formElement136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_formElement143 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_formElement145 = new BitSet(new long[]{0x0000000000E80660L});
    public static final BitSet FOLLOW_orExpr_in_formElement149 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_formElement151 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_formElement153 = new BitSet(new long[]{0x00000000000200A0L});
    public static final BitSet FOLLOW_formElementList_in_formElement157 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_formElement159 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ELSE_in_formElement163 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_formElement165 = new BitSet(new long[]{0x00000000000200A0L});
    public static final BitSet FOLLOW_formElementList_in_formElement169 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_formElement171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_primary193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_primary204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_primary214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_primary222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_primary231 = new BitSet(new long[]{0x0000000000E80660L});
    public static final BitSet FOLLOW_orExpr_in_primary235 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_primary237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_TYPE_in_type256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_TYPE_in_type263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_TYPE_in_type270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_unExpr297 = new BitSet(new long[]{0x0000000000E80660L});
    public static final BitSet FOLLOW_unExpr_in_unExpr305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_unExpr321 = new BitSet(new long[]{0x0000000000E80660L});
    public static final BitSet FOLLOW_unExpr_in_unExpr325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr376 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_set_in_mulExpr384 = new BitSet(new long[]{0x0000000000E80660L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr396 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr437 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_set_in_addExpr445 = new BitSet(new long[]{0x0000000000E80660L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr455 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr490 = new BitSet(new long[]{0x00000000FC000002L});
    public static final BitSet FOLLOW_set_in_relExpr498 = new BitSet(new long[]{0x0000000000E80660L});
    public static final BitSet FOLLOW_addExpr_in_relExpr514 = new BitSet(new long[]{0x00000000FC000002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr552 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_andExpr558 = new BitSet(new long[]{0x0000000000E80660L});
    public static final BitSet FOLLOW_relExpr_in_andExpr562 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr601 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_orExpr607 = new BitSet(new long[]{0x0000000000E80660L});
    public static final BitSet FOLLOW_andExpr_in_orExpr611 = new BitSet(new long[]{0x0000000200000002L});

}