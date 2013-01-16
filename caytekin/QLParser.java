// $ANTLR 3.4 C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-15 14:42:34

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Boolean_Type", "COMMENT", "Else_RW", "False_RW", "Ident", "If_RW", "Int", "Integer_Type", "SINGLE_LINE_COMMENT", "String_Literal", "String_Type", "Then_RW", "True_RW", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
    };

    public static final int EOF=-1;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int Boolean_Type=4;
    public static final int COMMENT=5;
    public static final int Else_RW=6;
    public static final int False_RW=7;
    public static final int Ident=8;
    public static final int If_RW=9;
    public static final int Int=10;
    public static final int Integer_Type=11;
    public static final int SINGLE_LINE_COMMENT=12;
    public static final int String_Literal=13;
    public static final int String_Type=14;
    public static final int Then_RW=15;
    public static final int True_RW=16;
    public static final int WS=17;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public QLParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public QLParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[37+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "question"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:16:1: question returns [Question result] : Ident ':' String_Literal t= type ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token Ident1=null;
        Token String_Literal2=null;
        Type t =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:17:3: ( Ident ':' String_Literal t= type )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:17:5: Ident ':' String_Literal t= type
            {
            Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_question48); if (state.failed) return result;

            match(input,27,FOLLOW_27_in_question50); if (state.failed) return result;

            String_Literal2=(Token)match(input,String_Literal,FOLLOW_String_Literal_in_question52); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_question56);
            t=type();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Question((Ident1!=null?Ident1.getText():null), (String_Literal2!=null?String_Literal2.getText():null), t); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, question_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "question"



    // $ANTLR start "type"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:21:1: type returns [Type result] : ( Boolean_Type | Integer_Type | String_Type );
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:4: ( Boolean_Type | Integer_Type | String_Type )
            int alt1=3;
            switch ( input.LA(1) ) {
            case Boolean_Type:
                {
                alt1=1;
                }
                break;
            case Integer_Type:
                {
                alt1=2;
                }
                break;
            case String_Type:
                {
                alt1=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:6: Boolean_Type
                    {
                    match(input,Boolean_Type,FOLLOW_Boolean_Type_in_type81); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Boolean_Type("" ); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:6: Integer_Type
                    {
                    match(input,Integer_Type,FOLLOW_Integer_Type_in_type90); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Integer_Type(""); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:6: String_Type
                    {
                    match(input,String_Type,FOLLOW_String_Type_in_type99); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new String_Type(""); }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"



    // $ANTLR start "primary"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:28:1: primary returns [Expr result] : ( Int | Ident | String_Literal | Boolean_Type | Integer_Type | String_Type | True_RW | False_RW | If_RW | Then_RW | Else_RW | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int3=null;
        Token Ident4=null;
        Token String_Literal5=null;
        Token Boolean_Type6=null;
        Token Integer_Type7=null;
        Token String_Type8=null;
        Token True_RW9=null;
        Token False_RW10=null;
        Token If_RW11=null;
        Token Then_RW12=null;
        Token Else_RW13=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:3: ( Int | Ident | String_Literal | Boolean_Type | Integer_Type | String_Type | True_RW | False_RW | If_RW | Then_RW | Else_RW | '(' x= orExpr ')' )
            int alt2=12;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt2=1;
                }
                break;
            case Ident:
                {
                alt2=2;
                }
                break;
            case String_Literal:
                {
                alt2=3;
                }
                break;
            case Boolean_Type:
                {
                alt2=4;
                }
                break;
            case Integer_Type:
                {
                alt2=5;
                }
                break;
            case String_Type:
                {
                alt2=6;
                }
                break;
            case True_RW:
                {
                alt2=7;
                }
                break;
            case False_RW:
                {
                alt2=8;
                }
                break;
            case If_RW:
                {
                alt2=9;
                }
                break;
            case Then_RW:
                {
                alt2=10;
                }
                break;
            case Else_RW:
                {
                alt2=11;
                }
                break;
            case 21:
                {
                alt2=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:5: Int
                    {
                    Int3=(Token)match(input,Int,FOLLOW_Int_in_primary121); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int3!=null?Int3.getText():null))); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:30:5: Ident
                    {
                    Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_primary131); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident4!=null?Ident4.getText():null)); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:31:5: String_Literal
                    {
                    String_Literal5=(Token)match(input,String_Literal,FOLLOW_String_Literal_in_primary139); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new String_Literal((String_Literal5!=null?String_Literal5.getText():null)); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:32:5: Boolean_Type
                    {
                    Boolean_Type6=(Token)match(input,Boolean_Type,FOLLOW_Boolean_Type_in_primary147); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Boolean_Type((Boolean_Type6!=null?Boolean_Type6.getText():null)); }

                    }
                    break;
                case 5 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:5: Integer_Type
                    {
                    Integer_Type7=(Token)match(input,Integer_Type,FOLLOW_Integer_Type_in_primary155); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Integer_Type((Integer_Type7!=null?Integer_Type7.getText():null)); }

                    }
                    break;
                case 6 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:34:5: String_Type
                    {
                    String_Type8=(Token)match(input,String_Type,FOLLOW_String_Type_in_primary163); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new String_Type((String_Type8!=null?String_Type8.getText():null)); }

                    }
                    break;
                case 7 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:35:5: True_RW
                    {
                    True_RW9=(Token)match(input,True_RW,FOLLOW_True_RW_in_primary172); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new True_RW((True_RW9!=null?True_RW9.getText():null)); }

                    }
                    break;
                case 8 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:5: False_RW
                    {
                    False_RW10=(Token)match(input,False_RW,FOLLOW_False_RW_in_primary180); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new False_RW((False_RW10!=null?False_RW10.getText():null)); }

                    }
                    break;
                case 9 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:5: If_RW
                    {
                    If_RW11=(Token)match(input,If_RW,FOLLOW_If_RW_in_primary190); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new If_RW((If_RW11!=null?If_RW11.getText():null)); }

                    }
                    break;
                case 10 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:5: Then_RW
                    {
                    Then_RW12=(Token)match(input,Then_RW,FOLLOW_Then_RW_in_primary200); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new Then_RW((Then_RW12!=null?Then_RW12.getText():null)); }

                    }
                    break;
                case 11 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:39:5: Else_RW
                    {
                    Else_RW13=(Token)match(input,Else_RW,FOLLOW_Else_RW_in_primary210); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new Else_RW((Else_RW13!=null?Else_RW13.getText():null)); }

                    }
                    break;
                case 12 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:40:5: '(' x= orExpr ')'
                    {
                    match(input,21,FOLLOW_21_in_primary223); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary227);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,22,FOLLOW_22_in_primary229); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = x; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unExpr"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt3=1;
                }
                break;
            case 25:
                {
                alt3=2;
                }
                break;
            case 18:
                {
                alt3=3;
                }
                break;
            case Boolean_Type:
            case Else_RW:
            case False_RW:
            case Ident:
            case If_RW:
            case Int:
            case Integer_Type:
            case String_Literal:
            case String_Type:
            case Then_RW:
            case True_RW:
            case 21:
                {
                alt3=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:8: '+' x= unExpr
                    {
                    match(input,24,FOLLOW_24_in_unExpr254); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr258);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:45:8: '-' x= unExpr
                    {
                    match(input,25,FOLLOW_25_in_unExpr269); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr273);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:46:8: '!' x= unExpr
                    {
                    match(input,18,FOLLOW_18_in_unExpr284); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr288);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr301);
                    x=primary();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = x; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, unExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr339);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==23||LA4_0==26) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==23||input.LA(1)==26 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr359);
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
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:63:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr400);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= 24 && LA5_0 <= 25)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 24 && input.LA(1) <= 25) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr418);
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
            	    break loop5;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:75:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:76:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:76:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr453);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:76:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19||(LA6_0 >= 28 && LA6_0 <= 32)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:76:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==19||(input.LA(1) >= 28 && input.LA(1) <= 32) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr477);
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
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:99:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr515);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:46: ( '&&' rhs= relExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==20) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:48: '&&' rhs= relExpr
            	    {
            	    match(input,20,FOLLOW_20_in_andExpr521); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr525);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

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
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr560);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:48: ( '||' rhs= andExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==33) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:50: '||' rhs= andExpr
            	    {
            	    match(input,33,FOLLOW_33_in_orExpr566); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr570);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

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
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"

    // Delegated rules


 

    public static final BitSet FOLLOW_Ident_in_question48 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_question50 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_String_Literal_in_question52 = new BitSet(new long[]{0x0000000000004810L});
    public static final BitSet FOLLOW_type_in_question56 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Boolean_Type_in_type81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Integer_Type_in_type90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_Type_in_type99 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_Literal_in_primary139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Boolean_Type_in_primary147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Integer_Type_in_primary155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_Type_in_primary163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_True_RW_in_primary172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_False_RW_in_primary180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_If_RW_in_primary190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Then_RW_in_primary200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Else_RW_in_primary210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_primary223 = new BitSet(new long[]{0x000000000325EFD0L});
    public static final BitSet FOLLOW_orExpr_in_primary227 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_primary229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_unExpr254 = new BitSet(new long[]{0x000000000325EFD0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_unExpr269 = new BitSet(new long[]{0x000000000325EFD0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unExpr284 = new BitSet(new long[]{0x000000000325EFD0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr339 = new BitSet(new long[]{0x0000000004800002L});
    public static final BitSet FOLLOW_set_in_mulExpr347 = new BitSet(new long[]{0x000000000325EFD0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr359 = new BitSet(new long[]{0x0000000004800002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr400 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_set_in_addExpr408 = new BitSet(new long[]{0x000000000325EFD0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr418 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr453 = new BitSet(new long[]{0x00000001F0080002L});
    public static final BitSet FOLLOW_set_in_relExpr461 = new BitSet(new long[]{0x000000000325EFD0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr477 = new BitSet(new long[]{0x00000001F0080002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr515 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_andExpr521 = new BitSet(new long[]{0x000000000325EFD0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr525 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr560 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_orExpr566 = new BitSet(new long[]{0x000000000325EFD0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr570 = new BitSet(new long[]{0x0000000200000002L});

}