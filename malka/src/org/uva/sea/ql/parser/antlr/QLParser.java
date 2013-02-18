// $ANTLR !Unknown version! QL.g 2013-01-28 14:43:38

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.integer.IntegerExpression;
import org.uva.sea.ql.ast.expression.bool.BooleanExpression;
import org.uva.sea.ql.ast.expression.bool.BooleanPrimitive;
import org.uva.sea.ql.ast.expression.bool.BooleanVariable;
import org.uva.sea.ql.ast.expression.bool.operation.logical.*;
import org.uva.sea.ql.ast.expression.bool.operation.relational.*;
import org.uva.sea.ql.ast.expression.integer.IntegerPrimitive;
import org.uva.sea.ql.ast.expression.integer.IntegerVariable;
import org.uva.sea.ql.ast.expression.integer.operation.*;
import org.uva.sea.ql.ast.expression.string.StringPrimitive;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.type.*;


import org.antlr.runtime.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FORM", "IDENT", "STRING", "TYPE", "IF", "ELSE", "INT", "BOOL", "COMMENT", "WS", "'{'", "'}'", "':'", "'('", "')'", "'+'", "'-'", "'!'", "'*'", "'/'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", "'||'"
    };
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int ELSE=9;
    public static final int BOOL=11;
    public static final int INT=10;
    public static final int EOF=-1;
    public static final int IF=8;
    public static final int TYPE=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int WS=13;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int IDENT=5;
    public static final int FORM=4;
    public static final int COMMENT=12;
    public static final int STRING=6;

    // delegates
    // delegators


        public QLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public QLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[33+1];
             
             
        }
        

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "QL.g"; }



    // $ANTLR start "form"
    // QL.g:22:1: form returns [Form result] : FORM IDENT '{' elements= formElementList '}' ;
    public final Form form() throws RecognitionException {
        Form result = null;
        int form_StartIndex = input.index();
        List<IFormElement> elements = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }
            // QL.g:23:2: ( FORM IDENT '{' elements= formElementList '}' )
            // QL.g:23:4: FORM IDENT '{' elements= formElementList '}'
            {
            match(input,FORM,FOLLOW_FORM_in_form45); if (state.failed) return result;
            match(input,IDENT,FOLLOW_IDENT_in_form47); if (state.failed) return result;
            match(input,14,FOLLOW_14_in_form49); if (state.failed) return result;
            pushFollow(FOLLOW_formElementList_in_form53);
            elements=formElementList();

            state._fsp--;
            if (state.failed) return result;
            match(input,15,FOLLOW_15_in_form55); if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result = new Form(elements); 
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
    // QL.g:26:1: formElementList returns [List<FormElement> result] : (element= formElement )* ;
    public final List<IFormElement> formElementList() throws RecognitionException {
        List<IFormElement> result = null;
        int formElementList_StartIndex = input.index();
        IFormElement element = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }
            // QL.g:27:2: ( (element= formElement )* )
            // QL.g:27:4: (element= formElement )*
            {
            if ( state.backtracking==0 ) {
              result = new ArrayList<IFormElement>();
            }
            // QL.g:27:46: (element= formElement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==IDENT||LA1_0==IF) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // QL.g:27:47: element= formElement
            	    {
            	    pushFollow(FOLLOW_formElement_in_formElementList77);
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
    // QL.g:30:1: formElement returns [FormElement result] : ( IDENT ':' STRING TYPE | IDENT ':' STRING TYPE '(' x= addExpr ')' | IF '(' condition= orExpr ')' '{' if_list= formElementList '}' ( ELSE '{' else_list= formElementList '}' )? );
    public final IFormElement formElement() throws RecognitionException {
        IFormElement result = null;
        int formElement_StartIndex = input.index();
        Token IDENT1=null;
        Token STRING2=null;
        Token TYPE3=null;
        Token IDENT4=null;
        Token STRING5=null;
        Token TYPE6=null;
        Expression x = null;

        Expression condition = null;

        List<IFormElement> if_list = null;

        List<IFormElement> else_list = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }
            // QL.g:31:2: ( IDENT ':' STRING TYPE | IDENT ':' STRING TYPE '(' x= addExpr ')' | IF '(' condition= orExpr ')' '{' if_list= formElementList '}' ( ELSE '{' else_list= formElementList '}' )? )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENT) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==16) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==STRING) ) {
                        int LA3_4 = input.LA(4);

                        if ( (LA3_4==TYPE) ) {
                            int LA3_5 = input.LA(5);

                            if ( (LA3_5==17) ) {
                                alt3=2;
                            }
                            else if ( (LA3_5==EOF||LA3_5==IDENT||LA3_5==IF||LA3_5==15) ) {
                                alt3=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return result;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA3_0==IF) ) {
                alt3=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // QL.g:31:4: IDENT ':' STRING TYPE
                    {
                    IDENT1=(Token)match(input,IDENT,FOLLOW_IDENT_in_formElement96); if (state.failed) return result;
                    match(input,16,FOLLOW_16_in_formElement98); if (state.failed) return result;
                    STRING2=(Token)match(input,STRING,FOLLOW_STRING_in_formElement100); if (state.failed) return result;
                    TYPE3=(Token)match(input,TYPE,FOLLOW_TYPE_in_formElement102); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Question(new Identifier((IDENT1!=null?IDENT1.getText():null)), new StringPrimitive((STRING2!=null?STRING2.getText():null)), new Type((TYPE3!=null?TYPE3.getText():null))); 
                    }

                    }
                    break;
                case 2 :
                    // QL.g:32:4: IDENT ':' STRING TYPE '(' x= addExpr ')'
                    {
                    IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_formElement109); if (state.failed) return result;
                    match(input,16,FOLLOW_16_in_formElement111); if (state.failed) return result;
                    STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_formElement113); if (state.failed) return result;
                    TYPE6=(Token)match(input,TYPE,FOLLOW_TYPE_in_formElement115); if (state.failed) return result;
                    match(input,17,FOLLOW_17_in_formElement117); if (state.failed) return result;
                    pushFollow(FOLLOW_addExpr_in_formElement121);
                    x=addExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    match(input,18,FOLLOW_18_in_formElement123); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new FormText(new Identifier((IDENT4!=null?IDENT4.getText():null)), new StringPrimitive((STRING5!=null?STRING5.getText():null)), new Type((TYPE6!=null?TYPE6.getText():null)), x); 
                    }

                    }
                    break;
                case 3 :
                    // QL.g:33:4: IF '(' condition= orExpr ')' '{' if_list= formElementList '}' ( ELSE '{' else_list= formElementList '}' )?
                    {
                    match(input,IF,FOLLOW_IF_in_formElement130); if (state.failed) return result;
                    match(input,17,FOLLOW_17_in_formElement132); if (state.failed) return result;
                    pushFollow(FOLLOW_orExpr_in_formElement136);
                    condition=orExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    match(input,18,FOLLOW_18_in_formElement138); if (state.failed) return result;
                    match(input,14,FOLLOW_14_in_formElement140); if (state.failed) return result;
                    pushFollow(FOLLOW_formElementList_in_formElement144);
                    if_list=formElementList();

                    state._fsp--;
                    if (state.failed) return result;
                    match(input,15,FOLLOW_15_in_formElement146); if (state.failed) return result;
                    // QL.g:33:64: ( ELSE '{' else_list= formElementList '}' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==ELSE) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // QL.g:33:66: ELSE '{' else_list= formElementList '}'
                            {
                            match(input,ELSE,FOLLOW_ELSE_in_formElement150); if (state.failed) return result;
                            match(input,14,FOLLOW_14_in_formElement152); if (state.failed) return result;
                            pushFollow(FOLLOW_formElementList_in_formElement156);
                            else_list=formElementList();

                            state._fsp--;
                            if (state.failed) return result;
                            match(input,15,FOLLOW_15_in_formElement158); if (state.failed) return result;

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      result = new IfStatement(condition, if_list, else_list); 
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
    // QL.g:36:1: primary returns [Expression result] : ( INT | BOOL | STRING | IDENT | '(' x= orExpr ')' );
    public final Expression primary() throws RecognitionException {
        Expression result = null;
        int primary_StartIndex = input.index();
        Token INT7=null;
        Token BOOL8=null;
        Token STRING9=null;
        Token IDENT10=null;
        Expression x = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }
            // QL.g:37:3: ( INT | BOOL | STRING | IDENT | '(' x= orExpr ')' )
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
            case 17:
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
                    // QL.g:37:5: INT
                    {
                    INT7=(Token)match(input,INT,FOLLOW_INT_in_primary179); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new IntegerPrimitive(Integer.parseInt((INT7!=null?INT7.getText():null))); 
                    }

                    }
                    break;
                case 2 :
                    // QL.g:38:5: BOOL
                    {
                    BOOL8=(Token)match(input,BOOL,FOLLOW_BOOL_in_primary190); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new BooleanPrimitive(Boolean.parseBoolean((BOOL8!=null?BOOL8.getText():null))); 
                    }

                    }
                    break;
                case 3 :
                    // QL.g:39:5: STRING
                    {
                    STRING9=(Token)match(input,STRING,FOLLOW_STRING_in_primary200); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new StringPrimitive((STRING9!=null?STRING9.getText():null)); 
                    }

                    }
                    break;
                case 4 :
                    // QL.g:40:5: IDENT
                    {
                    IDENT10=(Token)match(input,IDENT,FOLLOW_IDENT_in_primary208); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Identifier((IDENT10!=null?IDENT10.getText():null)); 
                    }

                    }
                    break;
                case 5 :
                    // QL.g:41:5: '(' x= orExpr ')'
                    {
                    match(input,17,FOLLOW_17_in_primary217); if (state.failed) return result;
                    pushFollow(FOLLOW_orExpr_in_primary221);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    match(input,18,FOLLOW_18_in_primary223); if (state.failed) return result;
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


    // $ANTLR start "unExpr"
    // QL.g:44:1: unExpr returns [Expression result] : (op= ( '+' | '-' ) x= unExpr | '!' x= unExpr | x= primary );
    public final Expression unExpr() throws RecognitionException {
        Expression result = null;
        int unExpr_StartIndex = input.index();
        Token op=null;
        Expression x = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }
            // QL.g:45:5: (op= ( '+' | '-' ) x= unExpr | '!' x= unExpr | x= primary )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 19:
            case 20:
                {
                alt5=1;
                }
                break;
            case 21:
                {
                alt5=2;
                }
                break;
            case IDENT:
            case STRING:
            case INT:
            case BOOL:
            case 17:
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
                    // QL.g:45:8: op= ( '+' | '-' ) x= unExpr
                    {
                    op=(Token)input.LT(1);
                    if ( (input.LA(1)>=19 && input.LA(1)<=20) ) {
                        input.consume();
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return result;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_unExpr_in_unExpr258);
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
                          		throw new RecognitionException();
                          	}
                          	
                          
                    }

                    }
                    break;
                case 2 :
                    // QL.g:69:8: '!' x= unExpr
                    {
                    match(input,21,FOLLOW_21_in_unExpr274); if (state.failed) return result;
                    pushFollow(FOLLOW_unExpr_in_unExpr278);
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
                          		throw new RecognitionException();
                          	}
                          
                    }

                    }
                    break;
                case 3 :
                    // QL.g:89:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr295);
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
            if ( state.backtracking>0 ) { memoize(input, 5, unExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "unExpr"


    // $ANTLR start "mulExpr"
    // QL.g:92:1: mulExpr returns [Expression result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expression mulExpr() throws RecognitionException {
        Expression result = null;
        int mulExpr_StartIndex = input.index();
        Token op=null;
        Expression lhs = null;

        Expression rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }
            // QL.g:93:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // QL.g:93:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr329);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:93:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=22 && LA6_0<=23)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // QL.g:93:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=22 && input.LA(1)<=23) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_unExpr_in_mulExpr349);
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
            	            	throw new RecognitionException();
            	            }
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, mulExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "mulExpr"


    // $ANTLR start "addExpr"
    // QL.g:120:1: addExpr returns [Expression result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expression addExpr() throws RecognitionException {
        Expression result = null;
        int addExpr_StartIndex = input.index();
        Token op=null;
        Expression lhs = null;

        Expression rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }
            // QL.g:121:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // QL.g:121:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr390);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:121:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=19 && LA7_0<=20)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // QL.g:121:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=19 && input.LA(1)<=20) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_mulExpr_in_addExpr408);
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
            	            	throw new RecognitionException();
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
            if ( state.backtracking>0 ) { memoize(input, 7, addExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "addExpr"


    // $ANTLR start "relExpr"
    // QL.g:144:1: relExpr returns [Expression result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expression relExpr() throws RecognitionException {
        Expression result = null;
        int relExpr_StartIndex = input.index();
        Token op=null;
        Expression lhs = null;

        Expression rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }
            // QL.g:145:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // QL.g:145:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr443);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:145:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=24 && LA8_0<=29)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // QL.g:145:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=24 && input.LA(1)<=29) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_addExpr_in_relExpr467);
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
            if ( state.backtracking>0 ) { memoize(input, 8, relExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "relExpr"


    // $ANTLR start "andExpr"
    // QL.g:168:1: andExpr returns [Expression result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expression andExpr() throws RecognitionException {
        Expression result = null;
        int andExpr_StartIndex = input.index();
        Expression lhs = null;

        Expression rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }
            // QL.g:169:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // QL.g:169:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr505);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:169:46: ( '&&' rhs= relExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==30) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // QL.g:169:48: '&&' rhs= relExpr
            	    {
            	    match(input,30,FOLLOW_30_in_andExpr511); if (state.failed) return result;
            	    pushFollow(FOLLOW_relExpr_in_andExpr515);
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
            	            	throw new RecognitionException();
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
            if ( state.backtracking>0 ) { memoize(input, 9, andExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "andExpr"


    // $ANTLR start "orExpr"
    // QL.g:189:1: orExpr returns [Expression result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expression orExpr() throws RecognitionException {
        Expression result = null;
        int orExpr_StartIndex = input.index();
        Expression lhs = null;

        Expression rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }
            // QL.g:190:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // QL.g:190:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr554);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result = lhs; 
            }
            // QL.g:190:48: ( '||' rhs= andExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==31) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // QL.g:190:50: '||' rhs= andExpr
            	    {
            	    match(input,31,FOLLOW_31_in_orExpr560); if (state.failed) return result;
            	    pushFollow(FOLLOW_andExpr_in_orExpr564);
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
            	            	throw new RecognitionException();
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
            if ( state.backtracking>0 ) { memoize(input, 10, orExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "orExpr"

    // Delegated rules


 

    public static final BitSet FOLLOW_FORM_in_form45 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_form47 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_form49 = new BitSet(new long[]{0x0000000000008120L});
    public static final BitSet FOLLOW_formElementList_in_form53 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_form55 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formElement_in_formElementList77 = new BitSet(new long[]{0x0000000000000122L});
    public static final BitSet FOLLOW_IDENT_in_formElement96 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_formElement98 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_formElement100 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TYPE_in_formElement102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_formElement109 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_formElement111 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_formElement113 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TYPE_in_formElement115 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_formElement117 = new BitSet(new long[]{0x00000000003A0C60L});
    public static final BitSet FOLLOW_addExpr_in_formElement121 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_formElement123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_formElement130 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_formElement132 = new BitSet(new long[]{0x00000000003A0C60L});
    public static final BitSet FOLLOW_orExpr_in_formElement136 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_formElement138 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_formElement140 = new BitSet(new long[]{0x0000000000008120L});
    public static final BitSet FOLLOW_formElementList_in_formElement144 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_formElement146 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_ELSE_in_formElement150 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_formElement152 = new BitSet(new long[]{0x0000000000008120L});
    public static final BitSet FOLLOW_formElementList_in_formElement156 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_formElement158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_primary179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_primary190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_primary200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_primary208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_primary217 = new BitSet(new long[]{0x00000000003A0C60L});
    public static final BitSet FOLLOW_orExpr_in_primary221 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_primary223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_unExpr250 = new BitSet(new long[]{0x00000000003A0C60L});
    public static final BitSet FOLLOW_unExpr_in_unExpr258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_unExpr274 = new BitSet(new long[]{0x00000000003A0C60L});
    public static final BitSet FOLLOW_unExpr_in_unExpr278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr329 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_set_in_mulExpr337 = new BitSet(new long[]{0x00000000003A0C60L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr349 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr390 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_set_in_addExpr398 = new BitSet(new long[]{0x00000000003A0C60L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr408 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr443 = new BitSet(new long[]{0x000000003F000002L});
    public static final BitSet FOLLOW_set_in_relExpr451 = new BitSet(new long[]{0x00000000003A0C60L});
    public static final BitSet FOLLOW_addExpr_in_relExpr467 = new BitSet(new long[]{0x000000003F000002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr505 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_andExpr511 = new BitSet(new long[]{0x00000000003A0C60L});
    public static final BitSet FOLLOW_relExpr_in_andExpr515 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr554 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_orExpr560 = new BitSet(new long[]{0x00000000003A0C60L});
    public static final BitSet FOLLOW_andExpr_in_orExpr564 = new BitSet(new long[]{0x0000000080000002L});

}