// $ANTLR !Unknown version! QL.g 2013-01-19 17:14:55

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.operations.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "STRING", "TYPE", "IF", "ELSE", "INT", "BOOL", "WS", "COMMENT", "'form'", "'{'", "'}'", "':'", "'('", "')'", "'+'", "'-'", "'!'", "'*'", "'/'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", "'||'"
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
    public static final int ELSE=8;
    public static final int BOOL=10;
    public static final int INT=9;
    public static final int EOF=-1;
    public static final int IF=7;
    public static final int TYPE=6;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int WS=11;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int IDENT=4;
    public static final int COMMENT=12;
    public static final int STRING=5;

    // delegates
    // delegators


        public QLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public QLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[34+1];
             
             
        }
        

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "QL.g"; }



    // $ANTLR start "form"
    // QL.g:19:1: form returns [Form result] : 'form' IDENT '{' ( formElementList )? '}' ;
    public final Form form() throws RecognitionException {
        Form result = null;
        int form_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }
            // QL.g:20:2: ( 'form' IDENT '{' ( formElementList )? '}' )
            // QL.g:20:4: 'form' IDENT '{' ( formElementList )? '}'
            {
            match(input,13,FOLLOW_13_in_form45); if (state.failed) return result;
            match(input,IDENT,FOLLOW_IDENT_in_form47); if (state.failed) return result;
            match(input,14,FOLLOW_14_in_form49); if (state.failed) return result;
            // QL.g:20:21: ( formElementList )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==IDENT||LA1_0==IF) ) {
                alt1=1;
            }
            else if ( (LA1_0==15) ) {
                int LA1_2 = input.LA(2);

                if ( (synpred1_QL()) ) {
                    alt1=1;
                }
            }
            switch (alt1) {
                case 1 :
                    // QL.g:0:0: formElementList
                    {
                    pushFollow(FOLLOW_formElementList_in_form51);
                    formElementList();

                    state._fsp--;
                    if (state.failed) return result;

                    }
                    break;

            }

            match(input,15,FOLLOW_15_in_form54); if (state.failed) return result;

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
    // QL.g:23:1: formElementList returns [List<FormElement> result] : (element= formElement )* ;
    public final List<FormElement> formElementList() throws RecognitionException {
        List<FormElement> result = null;
        int formElementList_StartIndex = input.index();
        FormElement element = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }
            // QL.g:24:2: ( (element= formElement )* )
            // QL.g:24:4: (element= formElement )*
            {
            // QL.g:24:4: (element= formElement )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IDENT||LA2_0==IF) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // QL.g:24:5: element= formElement
            	    {
            	    pushFollow(FOLLOW_formElement_in_formElementList72);
            	    element=formElement();

            	    state._fsp--;
            	    if (state.failed) return result;
            	    if ( state.backtracking==0 ) {
            	      result.add(element);
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
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
    // QL.g:27:1: formElement returns [FormElement result] : ( IDENT ':' STRING TYPE | IDENT ':' STRING TYPE '(' x= addExpr ')' | IF '(' orExpr ')' '{' formElementList '}' ( ELSE '{' formElementList '}' )? );
    public final FormElement formElement() throws RecognitionException {
        FormElement result = null;
        int formElement_StartIndex = input.index();
        Token IDENT1=null;
        Token STRING2=null;
        Token TYPE3=null;
        Token IDENT4=null;
        Token STRING5=null;
        Token TYPE6=null;
        Expr x = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }
            // QL.g:28:2: ( IDENT ':' STRING TYPE | IDENT ':' STRING TYPE '(' x= addExpr ')' | IF '(' orExpr ')' '{' formElementList '}' ( ELSE '{' formElementList '}' )? )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENT) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==16) ) {
                    int LA4_3 = input.LA(3);

                    if ( (LA4_3==STRING) ) {
                        int LA4_4 = input.LA(4);

                        if ( (LA4_4==TYPE) ) {
                            int LA4_5 = input.LA(5);

                            if ( (LA4_5==17) ) {
                                alt4=2;
                            }
                            else if ( (LA4_5==EOF||LA4_5==IDENT||LA4_5==IF||LA4_5==15) ) {
                                alt4=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 4, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return result;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 4, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA4_0==IF) ) {
                alt4=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // QL.g:28:4: IDENT ':' STRING TYPE
                    {
                    IDENT1=(Token)match(input,IDENT,FOLLOW_IDENT_in_formElement91); if (state.failed) return result;
                    match(input,16,FOLLOW_16_in_formElement93); if (state.failed) return result;
                    STRING2=(Token)match(input,STRING,FOLLOW_STRING_in_formElement95); if (state.failed) return result;
                    TYPE3=(Token)match(input,TYPE,FOLLOW_TYPE_in_formElement97); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Question(new Ident((IDENT1!=null?IDENT1.getText():null)), new QLString((STRING2!=null?STRING2.getText():null)), new Type((TYPE3!=null?TYPE3.getText():null))); 
                    }

                    }
                    break;
                case 2 :
                    // QL.g:29:4: IDENT ':' STRING TYPE '(' x= addExpr ')'
                    {
                    IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_formElement104); if (state.failed) return result;
                    match(input,16,FOLLOW_16_in_formElement106); if (state.failed) return result;
                    STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_formElement108); if (state.failed) return result;
                    TYPE6=(Token)match(input,TYPE,FOLLOW_TYPE_in_formElement110); if (state.failed) return result;
                    match(input,17,FOLLOW_17_in_formElement112); if (state.failed) return result;
                    pushFollow(FOLLOW_addExpr_in_formElement116);
                    x=addExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    match(input,18,FOLLOW_18_in_formElement118); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new FormText(new Ident((IDENT4!=null?IDENT4.getText():null)), new QLString((STRING5!=null?STRING5.getText():null)), new Type((TYPE6!=null?TYPE6.getText():null)), x); 
                    }

                    }
                    break;
                case 3 :
                    // QL.g:30:4: IF '(' orExpr ')' '{' formElementList '}' ( ELSE '{' formElementList '}' )?
                    {
                    match(input,IF,FOLLOW_IF_in_formElement125); if (state.failed) return result;
                    match(input,17,FOLLOW_17_in_formElement127); if (state.failed) return result;
                    pushFollow(FOLLOW_orExpr_in_formElement129);
                    orExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    match(input,18,FOLLOW_18_in_formElement131); if (state.failed) return result;
                    match(input,14,FOLLOW_14_in_formElement133); if (state.failed) return result;
                    pushFollow(FOLLOW_formElementList_in_formElement135);
                    formElementList();

                    state._fsp--;
                    if (state.failed) return result;
                    match(input,15,FOLLOW_15_in_formElement137); if (state.failed) return result;
                    // QL.g:30:46: ( ELSE '{' formElementList '}' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==ELSE) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // QL.g:30:47: ELSE '{' formElementList '}'
                            {
                            match(input,ELSE,FOLLOW_ELSE_in_formElement140); if (state.failed) return result;
                            match(input,14,FOLLOW_14_in_formElement142); if (state.failed) return result;
                            pushFollow(FOLLOW_formElementList_in_formElement144);
                            formElementList();

                            state._fsp--;
                            if (state.failed) return result;
                            match(input,15,FOLLOW_15_in_formElement146); if (state.failed) return result;

                            }
                            break;

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
    // QL.g:33:1: primary returns [Expr result] : ( INT | BOOL | STRING | IDENT | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;
        int primary_StartIndex = input.index();
        Token INT7=null;
        Token BOOL8=null;
        Token STRING9=null;
        Token IDENT10=null;
        Expr x = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }
            // QL.g:34:3: ( INT | BOOL | STRING | IDENT | '(' x= orExpr ')' )
            int alt5=5;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt5=1;
                }
                break;
            case BOOL:
                {
                alt5=2;
                }
                break;
            case STRING:
                {
                alt5=3;
                }
                break;
            case IDENT:
                {
                alt5=4;
                }
                break;
            case 17:
                {
                alt5=5;
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
                    // QL.g:34:5: INT
                    {
                    INT7=(Token)match(input,INT,FOLLOW_INT_in_primary164); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Int(Integer.parseInt((INT7!=null?INT7.getText():null))); 
                    }

                    }
                    break;
                case 2 :
                    // QL.g:35:5: BOOL
                    {
                    BOOL8=(Token)match(input,BOOL,FOLLOW_BOOL_in_primary175); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Bool(Boolean.parseBoolean((BOOL8!=null?BOOL8.getText():null))); 
                    }

                    }
                    break;
                case 3 :
                    // QL.g:36:5: STRING
                    {
                    STRING9=(Token)match(input,STRING,FOLLOW_STRING_in_primary185); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new QLString((STRING9!=null?STRING9.getText():null)); 
                    }

                    }
                    break;
                case 4 :
                    // QL.g:37:5: IDENT
                    {
                    IDENT10=(Token)match(input,IDENT,FOLLOW_IDENT_in_primary193); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Ident((IDENT10!=null?IDENT10.getText():null)); 
                    }

                    }
                    break;
                case 5 :
                    // QL.g:38:5: '(' x= orExpr ')'
                    {
                    match(input,17,FOLLOW_17_in_primary202); if (state.failed) return result;
                    pushFollow(FOLLOW_orExpr_in_primary206);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    match(input,18,FOLLOW_18_in_primary208); if (state.failed) return result;
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
    // QL.g:41:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr | x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;
        int unExpr_StartIndex = input.index();
        Expr x = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }
            // QL.g:42:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr | x= primary )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt6=1;
                }
                break;
            case 20:
                {
                alt6=2;
                }
                break;
            case 21:
                {
                alt6=3;
                }
                break;
            case IDENT:
            case STRING:
            case INT:
            case BOOL:
            case 17:
                {
                alt6=4;
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
                    // QL.g:42:8: '+' x= unExpr
                    {
                    match(input,19,FOLLOW_19_in_unExpr233); if (state.failed) return result;
                    pushFollow(FOLLOW_unExpr_in_unExpr237);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Pos(x); 
                    }

                    }
                    break;
                case 2 :
                    // QL.g:43:8: '-' x= unExpr
                    {
                    match(input,20,FOLLOW_20_in_unExpr248); if (state.failed) return result;
                    pushFollow(FOLLOW_unExpr_in_unExpr252);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Neg(x); 
                    }

                    }
                    break;
                case 3 :
                    // QL.g:44:8: '!' x= unExpr
                    {
                    match(input,21,FOLLOW_21_in_unExpr263); if (state.failed) return result;
                    pushFollow(FOLLOW_unExpr_in_unExpr267);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Not(x); 
                    }

                    }
                    break;
                case 4 :
                    // QL.g:45:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr280);
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
    // QL.g:48:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;
        int mulExpr_StartIndex = input.index();
        Token op=null;
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }
            // QL.g:49:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // QL.g:49:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr318);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:49:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=22 && LA7_0<=23)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // QL.g:49:47: op= ( '*' | '/' ) rhs= unExpr
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

            	    pushFollow(FOLLOW_unExpr_in_mulExpr338);
            	    rhs=unExpr();

            	    state._fsp--;
            	    if (state.failed) return result;
            	    if ( state.backtracking==0 ) {
            	       
            	            if ((op!=null?op.getText():null).equals("*")) {
            	              result = new Mul(result, rhs);
            	            }
            	            if ((op!=null?op.getText():null).equals("<=")) {
            	              result = new Div(result, rhs);      
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
            if ( state.backtracking>0 ) { memoize(input, 6, mulExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "mulExpr"


    // $ANTLR start "addExpr"
    // QL.g:61:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;
        int addExpr_StartIndex = input.index();
        Token op=null;
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }
            // QL.g:62:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // QL.g:62:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr379);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:62:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=19 && LA8_0<=20)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // QL.g:62:48: op= ( '+' | '-' ) rhs= mulExpr
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

            	    pushFollow(FOLLOW_mulExpr_in_addExpr397);
            	    rhs=mulExpr();

            	    state._fsp--;
            	    if (state.failed) return result;
            	    if ( state.backtracking==0 ) {
            	       
            	            if ((op!=null?op.getText():null).equals("+")) {
            	              result = new Add(result, rhs);
            	            }
            	            if ((op!=null?op.getText():null).equals("-")) {
            	              result = new Sub(result, rhs);      
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
            if ( state.backtracking>0 ) { memoize(input, 7, addExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "addExpr"


    // $ANTLR start "relExpr"
    // QL.g:73:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;
        int relExpr_StartIndex = input.index();
        Token op=null;
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }
            // QL.g:74:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // QL.g:74:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr432);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:74:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=24 && LA9_0<=29)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // QL.g:74:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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

            	    pushFollow(FOLLOW_addExpr_in_relExpr456);
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
            if ( state.backtracking>0 ) { memoize(input, 8, relExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "relExpr"


    // $ANTLR start "andExpr"
    // QL.g:97:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;
        int andExpr_StartIndex = input.index();
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }
            // QL.g:98:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // QL.g:98:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr494);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:98:46: ( '&&' rhs= relExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==30) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // QL.g:98:48: '&&' rhs= relExpr
            	    {
            	    match(input,30,FOLLOW_30_in_andExpr500); if (state.failed) return result;
            	    pushFollow(FOLLOW_relExpr_in_andExpr504);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;
            	    if ( state.backtracking==0 ) {
            	       result = new And(result, rhs); 
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
            if ( state.backtracking>0 ) { memoize(input, 9, andExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "andExpr"


    // $ANTLR start "orExpr"
    // QL.g:102:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;
        int orExpr_StartIndex = input.index();
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }
            // QL.g:103:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // QL.g:103:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr539);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result = lhs; 
            }
            // QL.g:103:48: ( '||' rhs= andExpr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==31) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // QL.g:103:50: '||' rhs= andExpr
            	    {
            	    match(input,31,FOLLOW_31_in_orExpr545); if (state.failed) return result;
            	    pushFollow(FOLLOW_andExpr_in_orExpr549);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;
            	    if ( state.backtracking==0 ) {
            	       result = new Or(result, rhs); 
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
            if ( state.backtracking>0 ) { memoize(input, 10, orExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "orExpr"

    // $ANTLR start synpred1_QL
    public final void synpred1_QL_fragment() throws RecognitionException {   
        // QL.g:20:21: ( formElementList )
        // QL.g:20:21: formElementList
        {
        pushFollow(FOLLOW_formElementList_in_synpred1_QL51);
        formElementList();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_QL

    // Delegated rules

    public final boolean synpred1_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_13_in_form45 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_form47 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_form49 = new BitSet(new long[]{0x0000000000008090L});
    public static final BitSet FOLLOW_formElementList_in_form51 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_form54 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formElement_in_formElementList72 = new BitSet(new long[]{0x0000000000000092L});
    public static final BitSet FOLLOW_IDENT_in_formElement91 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_formElement93 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_formElement95 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TYPE_in_formElement97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_formElement104 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_formElement106 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_formElement108 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TYPE_in_formElement110 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_formElement112 = new BitSet(new long[]{0x00000000003A0630L});
    public static final BitSet FOLLOW_addExpr_in_formElement116 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_formElement118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_formElement125 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_formElement127 = new BitSet(new long[]{0x00000000003A0630L});
    public static final BitSet FOLLOW_orExpr_in_formElement129 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_formElement131 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_formElement133 = new BitSet(new long[]{0x0000000000008090L});
    public static final BitSet FOLLOW_formElementList_in_formElement135 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_formElement137 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ELSE_in_formElement140 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_formElement142 = new BitSet(new long[]{0x0000000000008090L});
    public static final BitSet FOLLOW_formElementList_in_formElement144 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_formElement146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_primary164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_primary175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_primary185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_primary193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_primary202 = new BitSet(new long[]{0x00000000003A0630L});
    public static final BitSet FOLLOW_orExpr_in_primary206 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_primary208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_unExpr233 = new BitSet(new long[]{0x00000000003A0630L});
    public static final BitSet FOLLOW_unExpr_in_unExpr237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_unExpr248 = new BitSet(new long[]{0x00000000003A0630L});
    public static final BitSet FOLLOW_unExpr_in_unExpr252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_unExpr263 = new BitSet(new long[]{0x00000000003A0630L});
    public static final BitSet FOLLOW_unExpr_in_unExpr267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr318 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_set_in_mulExpr326 = new BitSet(new long[]{0x00000000003A0630L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr338 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr379 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_set_in_addExpr387 = new BitSet(new long[]{0x00000000003A0630L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr397 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr432 = new BitSet(new long[]{0x000000003F000002L});
    public static final BitSet FOLLOW_set_in_relExpr440 = new BitSet(new long[]{0x00000000003A0630L});
    public static final BitSet FOLLOW_addExpr_in_relExpr456 = new BitSet(new long[]{0x000000003F000002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr494 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_andExpr500 = new BitSet(new long[]{0x00000000003A0630L});
    public static final BitSet FOLLOW_relExpr_in_andExpr504 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr539 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_orExpr545 = new BitSet(new long[]{0x00000000003A0630L});
    public static final BitSet FOLLOW_andExpr_in_orExpr549 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_formElementList_in_synpred1_QL51 = new BitSet(new long[]{0x0000000000000002L});

}