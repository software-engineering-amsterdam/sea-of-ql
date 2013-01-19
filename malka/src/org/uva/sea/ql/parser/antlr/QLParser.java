// $ANTLR !Unknown version! QL.g 2013-01-19 20:02:05

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FORM", "IDENT", "STRING", "TYPE", "INT", "BOOL", "WS", "COMMENT", "IF", "ELSE", "'{'", "'}'", "':'", "'('", "')'", "'+'", "'-'", "'!'", "'*'", "'/'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", "'||'"
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
    public static final int ELSE=13;
    public static final int BOOL=9;
    public static final int INT=8;
    public static final int EOF=-1;
    public static final int IF=12;
    public static final int TYPE=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int WS=10;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int IDENT=5;
    public static final int FORM=4;
    public static final int COMMENT=11;
    public static final int STRING=6;

    // delegates
    // delegators


        public QLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public QLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[32+1];
             
             
        }
        

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "QL.g"; }



    // $ANTLR start "form"
    // QL.g:19:1: form returns [Form result] : FORM IDENT '{' (elements= formElementList )? '}' ;
    public final Form form() throws RecognitionException {
        Form result = null;
        int form_StartIndex = input.index();
        List<FormElement> elements = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }
            // QL.g:20:2: ( FORM IDENT '{' (elements= formElementList )? '}' )
            // QL.g:20:4: FORM IDENT '{' (elements= formElementList )? '}'
            {
            match(input,FORM,FOLLOW_FORM_in_form45); if (state.failed) return result;
            match(input,IDENT,FOLLOW_IDENT_in_form47); if (state.failed) return result;
            match(input,14,FOLLOW_14_in_form49); if (state.failed) return result;
            // QL.g:20:19: (elements= formElementList )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==IDENT) ) {
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
                    // QL.g:20:20: elements= formElementList
                    {
                    pushFollow(FOLLOW_formElementList_in_form54);
                    elements=formElementList();

                    state._fsp--;
                    if (state.failed) return result;

                    }
                    break;

            }

            match(input,15,FOLLOW_15_in_form58); if (state.failed) return result;
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
            if ( state.backtracking==0 ) {
              result = new ArrayList<FormElement>();
            }
            // QL.g:24:46: (element= formElement )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IDENT) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // QL.g:24:47: element= formElement
            	    {
            	    pushFollow(FOLLOW_formElement_in_formElementList80);
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
    // QL.g:27:1: formElement returns [FormElement result] : ( IDENT ':' STRING TYPE | IDENT ':' STRING TYPE '(' x= addExpr ')' );
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
            // QL.g:28:2: ( IDENT ':' STRING TYPE | IDENT ':' STRING TYPE '(' x= addExpr ')' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENT) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==16) ) {
                    int LA3_2 = input.LA(3);

                    if ( (LA3_2==STRING) ) {
                        int LA3_3 = input.LA(4);

                        if ( (LA3_3==TYPE) ) {
                            int LA3_4 = input.LA(5);

                            if ( (LA3_4==17) ) {
                                alt3=2;
                            }
                            else if ( (LA3_4==EOF||LA3_4==IDENT||LA3_4==15) ) {
                                alt3=1;
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
                            new NoViableAltException("", 3, 2, input);

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
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // QL.g:28:4: IDENT ':' STRING TYPE
                    {
                    IDENT1=(Token)match(input,IDENT,FOLLOW_IDENT_in_formElement99); if (state.failed) return result;
                    match(input,16,FOLLOW_16_in_formElement101); if (state.failed) return result;
                    STRING2=(Token)match(input,STRING,FOLLOW_STRING_in_formElement103); if (state.failed) return result;
                    TYPE3=(Token)match(input,TYPE,FOLLOW_TYPE_in_formElement105); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Question(new Ident((IDENT1!=null?IDENT1.getText():null)), new QLString((STRING2!=null?STRING2.getText():null)), new Type((TYPE3!=null?TYPE3.getText():null))); 
                    }

                    }
                    break;
                case 2 :
                    // QL.g:29:4: IDENT ':' STRING TYPE '(' x= addExpr ')'
                    {
                    IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_formElement112); if (state.failed) return result;
                    match(input,16,FOLLOW_16_in_formElement114); if (state.failed) return result;
                    STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_formElement116); if (state.failed) return result;
                    TYPE6=(Token)match(input,TYPE,FOLLOW_TYPE_in_formElement118); if (state.failed) return result;
                    match(input,17,FOLLOW_17_in_formElement120); if (state.failed) return result;
                    pushFollow(FOLLOW_addExpr_in_formElement124);
                    x=addExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    match(input,18,FOLLOW_18_in_formElement126); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new FormText(new Ident((IDENT4!=null?IDENT4.getText():null)), new QLString((STRING5!=null?STRING5.getText():null)), new Type((TYPE6!=null?TYPE6.getText():null)), x); 
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
    // QL.g:32:1: primary returns [Expr result] : ( INT | BOOL | STRING | IDENT | '(' x= orExpr ')' );
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
            // QL.g:33:3: ( INT | BOOL | STRING | IDENT | '(' x= orExpr ')' )
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
                    // QL.g:33:5: INT
                    {
                    INT7=(Token)match(input,INT,FOLLOW_INT_in_primary145); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Int(Integer.parseInt((INT7!=null?INT7.getText():null))); 
                    }

                    }
                    break;
                case 2 :
                    // QL.g:34:5: BOOL
                    {
                    BOOL8=(Token)match(input,BOOL,FOLLOW_BOOL_in_primary156); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Bool(Boolean.parseBoolean((BOOL8!=null?BOOL8.getText():null))); 
                    }

                    }
                    break;
                case 3 :
                    // QL.g:35:5: STRING
                    {
                    STRING9=(Token)match(input,STRING,FOLLOW_STRING_in_primary166); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new QLString((STRING9!=null?STRING9.getText():null)); 
                    }

                    }
                    break;
                case 4 :
                    // QL.g:36:5: IDENT
                    {
                    IDENT10=(Token)match(input,IDENT,FOLLOW_IDENT_in_primary174); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Ident((IDENT10!=null?IDENT10.getText():null)); 
                    }

                    }
                    break;
                case 5 :
                    // QL.g:37:5: '(' x= orExpr ')'
                    {
                    match(input,17,FOLLOW_17_in_primary183); if (state.failed) return result;
                    pushFollow(FOLLOW_orExpr_in_primary187);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    match(input,18,FOLLOW_18_in_primary189); if (state.failed) return result;
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
    // QL.g:40:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr | x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;
        int unExpr_StartIndex = input.index();
        Expr x = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }
            // QL.g:41:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr | x= primary )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt5=1;
                }
                break;
            case 20:
                {
                alt5=2;
                }
                break;
            case 21:
                {
                alt5=3;
                }
                break;
            case IDENT:
            case STRING:
            case INT:
            case BOOL:
            case 17:
                {
                alt5=4;
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
                    // QL.g:41:8: '+' x= unExpr
                    {
                    match(input,19,FOLLOW_19_in_unExpr214); if (state.failed) return result;
                    pushFollow(FOLLOW_unExpr_in_unExpr218);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Pos(x); 
                    }

                    }
                    break;
                case 2 :
                    // QL.g:42:8: '-' x= unExpr
                    {
                    match(input,20,FOLLOW_20_in_unExpr229); if (state.failed) return result;
                    pushFollow(FOLLOW_unExpr_in_unExpr233);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Neg(x); 
                    }

                    }
                    break;
                case 3 :
                    // QL.g:43:8: '!' x= unExpr
                    {
                    match(input,21,FOLLOW_21_in_unExpr244); if (state.failed) return result;
                    pushFollow(FOLLOW_unExpr_in_unExpr248);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Not(x); 
                    }

                    }
                    break;
                case 4 :
                    // QL.g:44:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr261);
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
    // QL.g:47:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;
        int mulExpr_StartIndex = input.index();
        Token op=null;
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }
            // QL.g:48:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // QL.g:48:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr295);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:48:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=22 && LA6_0<=23)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // QL.g:48:47: op= ( '*' | '/' ) rhs= unExpr
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

            	    pushFollow(FOLLOW_unExpr_in_mulExpr315);
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
    // QL.g:60:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;
        int addExpr_StartIndex = input.index();
        Token op=null;
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }
            // QL.g:61:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // QL.g:61:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr356);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:61:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=19 && LA7_0<=20)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // QL.g:61:48: op= ( '+' | '-' ) rhs= mulExpr
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

            	    pushFollow(FOLLOW_mulExpr_in_addExpr374);
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
    // QL.g:72:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;
        int relExpr_StartIndex = input.index();
        Token op=null;
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }
            // QL.g:73:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // QL.g:73:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr409);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:73:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=24 && LA8_0<=29)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // QL.g:73:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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

            	    pushFollow(FOLLOW_addExpr_in_relExpr433);
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
    // QL.g:96:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;
        int andExpr_StartIndex = input.index();
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }
            // QL.g:97:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // QL.g:97:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr471);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:97:46: ( '&&' rhs= relExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==30) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // QL.g:97:48: '&&' rhs= relExpr
            	    {
            	    match(input,30,FOLLOW_30_in_andExpr477); if (state.failed) return result;
            	    pushFollow(FOLLOW_relExpr_in_andExpr481);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;
            	    if ( state.backtracking==0 ) {
            	       result = new And(result, rhs); 
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
    // QL.g:101:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;
        int orExpr_StartIndex = input.index();
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }
            // QL.g:102:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // QL.g:102:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr516);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result = lhs; 
            }
            // QL.g:102:48: ( '||' rhs= andExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==31) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // QL.g:102:50: '||' rhs= andExpr
            	    {
            	    match(input,31,FOLLOW_31_in_orExpr522); if (state.failed) return result;
            	    pushFollow(FOLLOW_andExpr_in_orExpr526);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;
            	    if ( state.backtracking==0 ) {
            	       result = new Or(result, rhs); 
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

    // $ANTLR start synpred1_QL
    public final void synpred1_QL_fragment() throws RecognitionException {   
        List<FormElement> elements = null;


        // QL.g:20:20: (elements= formElementList )
        // QL.g:20:20: elements= formElementList
        {
        pushFollow(FOLLOW_formElementList_in_synpred1_QL54);
        elements=formElementList();

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


 

    public static final BitSet FOLLOW_FORM_in_form45 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_form47 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_form49 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_formElementList_in_form54 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_form58 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formElement_in_formElementList80 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_formElement99 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_formElement101 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_formElement103 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TYPE_in_formElement105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_formElement112 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_formElement114 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_formElement116 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TYPE_in_formElement118 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_formElement120 = new BitSet(new long[]{0x00000000003A0360L});
    public static final BitSet FOLLOW_addExpr_in_formElement124 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_formElement126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_primary145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_primary156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_primary166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_primary174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_primary183 = new BitSet(new long[]{0x00000000003A0360L});
    public static final BitSet FOLLOW_orExpr_in_primary187 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_primary189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_unExpr214 = new BitSet(new long[]{0x00000000003A0360L});
    public static final BitSet FOLLOW_unExpr_in_unExpr218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_unExpr229 = new BitSet(new long[]{0x00000000003A0360L});
    public static final BitSet FOLLOW_unExpr_in_unExpr233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_unExpr244 = new BitSet(new long[]{0x00000000003A0360L});
    public static final BitSet FOLLOW_unExpr_in_unExpr248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr295 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_set_in_mulExpr303 = new BitSet(new long[]{0x00000000003A0360L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr315 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr356 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_set_in_addExpr364 = new BitSet(new long[]{0x00000000003A0360L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr374 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr409 = new BitSet(new long[]{0x000000003F000002L});
    public static final BitSet FOLLOW_set_in_relExpr417 = new BitSet(new long[]{0x00000000003A0360L});
    public static final BitSet FOLLOW_addExpr_in_relExpr433 = new BitSet(new long[]{0x000000003F000002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr471 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_andExpr477 = new BitSet(new long[]{0x00000000003A0360L});
    public static final BitSet FOLLOW_relExpr_in_andExpr481 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr516 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_orExpr522 = new BitSet(new long[]{0x00000000003A0360L});
    public static final BitSet FOLLOW_andExpr_in_orExpr526 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_formElementList_in_synpred1_QL54 = new BitSet(new long[]{0x0000000000000002L});

}