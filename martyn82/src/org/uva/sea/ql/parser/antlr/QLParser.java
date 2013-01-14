// $ANTLR 3.4 QL.g 2013-01-14 11:23:16

package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.declaration.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.value.*;
import org.uva.sea.ql.ast.type.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "Ident", "Int", "NEWLINE", "Str", "Type", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
    };

    public static final int EOF=-1;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
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
    public static final int Bool=4;
    public static final int COMMENT=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int NEWLINE=8;
    public static final int Str=9;
    public static final int Type=10;
    public static final int WS=11;

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
        this.state.ruleMemo = new HashMap[29+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "QL.g"; }



    // $ANTLR start "primary"
    // QL.g:19:1: primary returns [Expression result] : ( Bool | Int | strExpr | Ident | '(' x= orExpr ')' );
    public final Expression primary() throws RecognitionException {
        Expression result = null;

        int primary_StartIndex = input.index();

        Token Bool1=null;
        Token Int2=null;
        Token Ident4=null;
        Expression x =null;

        org.uva.sea.ql.ast.expression.value.Str strExpr3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // QL.g:20:3: ( Bool | Int | strExpr | Ident | '(' x= orExpr ')' )
            int alt1=5;
            switch ( input.LA(1) ) {
            case Bool:
                {
                alt1=1;
                }
                break;
            case Int:
                {
                alt1=2;
                }
                break;
            case Str:
                {
                alt1=3;
                }
                break;
            case Ident:
                {
                alt1=4;
                }
                break;
            case 15:
                {
                alt1=5;
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
                    // QL.g:20:5: Bool
                    {
                    Bool1=(Token)match(input,Bool,FOLLOW_Bool_in_primary46); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expression.value.Bool( Boolean.parseBoolean( (Bool1!=null?Bool1.getText():null) ) ); }

                    }
                    break;
                case 2 :
                    // QL.g:21:5: Int
                    {
                    Int2=(Token)match(input,Int,FOLLOW_Int_in_primary66); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expression.value.Int( Integer.parseInt( (Int2!=null?Int2.getText():null) ) ); }

                    }
                    break;
                case 3 :
                    // QL.g:22:5: strExpr
                    {
                    pushFollow(FOLLOW_strExpr_in_primary87);
                    strExpr3=strExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = strExpr3; }

                    }
                    break;
                case 4 :
                    // QL.g:23:5: Ident
                    {
                    Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_primary104); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident( (Ident4!=null?Ident4.getText():null) ); }

                    }
                    break;
                case 5 :
                    // QL.g:24:5: '(' x= orExpr ')'
                    {
                    match(input,15,FOLLOW_15_in_primary123); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary127);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,16,FOLLOW_16_in_primary129); if (state.failed) return result;

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
            if ( state.backtracking>0 ) { memoize(input, 1, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "strExpr"
    // QL.g:27:1: strExpr returns [org.uva.sea.ql.ast.expression.value.Str result] : Str ;
    public final org.uva.sea.ql.ast.expression.value.Str strExpr() throws RecognitionException {
        org.uva.sea.ql.ast.expression.value.Str result = null;

        int strExpr_StartIndex = input.index();

        Token Str5=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // QL.g:28:3: ( Str )
            // QL.g:28:5: Str
            {
            Str5=(Token)match(input,Str,FOLLOW_Str_in_strExpr148); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expression.value.Str( (Str5!=null?Str5.getText():null).substring( 1, (Str5!=null?Str5.getText():null).length() - 1 ) ); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, strExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "strExpr"



    // $ANTLR start "unExpr"
    // QL.g:31:1: unExpr returns [Expression result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expression unExpr() throws RecognitionException {
        Expression result = null;

        int unExpr_StartIndex = input.index();

        Expression x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // QL.g:32:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt2=1;
                }
                break;
            case 19:
                {
                alt2=2;
                }
                break;
            case 12:
                {
                alt2=3;
                }
                break;
            case Bool:
            case Ident:
            case Int:
            case Str:
            case 15:
                {
                alt2=4;
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
                    // QL.g:32:8: '+' x= unExpr
                    {
                    match(input,18,FOLLOW_18_in_unExpr174); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr178);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos( x ); }

                    }
                    break;
                case 2 :
                    // QL.g:33:8: '-' x= unExpr
                    {
                    match(input,19,FOLLOW_19_in_unExpr189); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr193);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg( x ); }

                    }
                    break;
                case 3 :
                    // QL.g:34:8: '!' x= unExpr
                    {
                    match(input,12,FOLLOW_12_in_unExpr204); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr208);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not( x ); }

                    }
                    break;
                case 4 :
                    // QL.g:35:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr221);
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
            if ( state.backtracking>0 ) { memoize(input, 3, unExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // QL.g:38:1: mulExpr returns [Expression result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expression mulExpr() throws RecognitionException {
        Expression result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // QL.g:39:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // QL.g:39:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr255);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:39:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17||LA3_0==20) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // QL.g:39:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==17||input.LA(1)==20 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr275);
            	    rhs=unExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	          if ((op!=null?op.getText():null).equals("*")) {
            	            result = new Mul(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("/")) {
            	            result = new Div(result, rhs);
            	          }
            	        }

            	    }
            	    break;

            	default :
            	    break loop3;
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
            if ( state.backtracking>0 ) { memoize(input, 4, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // QL.g:51:1: addExpr returns [Expression result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expression addExpr() throws RecognitionException {
        Expression result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // QL.g:52:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // QL.g:52:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr316);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:52:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= 18 && LA4_0 <= 19)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // QL.g:52:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 18 && input.LA(1) <= 19) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr334);
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
            if ( state.backtracking>0 ) { memoize(input, 5, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // QL.g:63:1: relExpr returns [Expression result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expression relExpr() throws RecognitionException {
        Expression result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // QL.g:64:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // QL.g:64:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr369);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:64:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13||(LA5_0 >= 22 && LA5_0 <= 26)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // QL.g:64:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==13||(input.LA(1) >= 22 && input.LA(1) <= 26) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr393);
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
            if ( state.backtracking>0 ) { memoize(input, 6, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // QL.g:87:1: andExpr returns [Expression result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expression andExpr() throws RecognitionException {
        Expression result = null;

        int andExpr_StartIndex = input.index();

        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // QL.g:88:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // QL.g:88:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr431);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:88:46: ( '&&' rhs= relExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // QL.g:88:48: '&&' rhs= relExpr
            	    {
            	    match(input,14,FOLLOW_14_in_andExpr437); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr441);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 7, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // QL.g:92:1: orExpr returns [Expression result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expression orExpr() throws RecognitionException {
        Expression result = null;

        int orExpr_StartIndex = input.index();

        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // QL.g:93:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // QL.g:93:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr476);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // QL.g:93:48: ( '||' rhs= andExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==27) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // QL.g:93:50: '||' rhs= andExpr
            	    {
            	    match(input,27,FOLLOW_27_in_orExpr482); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr486);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 8, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"



    // $ANTLR start "varDecl"
    // QL.g:96:1: varDecl returns [VarDeclaration result] : strExpr Ident ':' typeDecl ;
    public final VarDeclaration varDecl() throws RecognitionException {
        VarDeclaration result = null;

        int varDecl_StartIndex = input.index();

        Token Ident6=null;
        Type typeDecl7 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // QL.g:97:5: ( strExpr Ident ':' typeDecl )
            // QL.g:97:7: strExpr Ident ':' typeDecl
            {
            pushFollow(FOLLOW_strExpr_in_varDecl512);
            strExpr();

            state._fsp--;
            if (state.failed) return result;

            Ident6=(Token)match(input,Ident,FOLLOW_Ident_in_varDecl514); if (state.failed) return result;

            match(input,21,FOLLOW_21_in_varDecl516); if (state.failed) return result;

            pushFollow(FOLLOW_typeDecl_in_varDecl518);
            typeDecl7=typeDecl();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) {
                      result = new VarDeclaration( new Ident( (Ident6!=null?Ident6.getText():null) ), typeDecl7 );
                  }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, varDecl_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "varDecl"



    // $ANTLR start "typeDecl"
    // QL.g:102:1: typeDecl returns [Type result] : Type ;
    public final Type typeDecl() throws RecognitionException {
        Type result = null;

        int typeDecl_StartIndex = input.index();

        Token Type8=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // QL.g:103:5: ( Type )
            // QL.g:103:8: Type
            {
            Type8=(Token)match(input,Type,FOLLOW_Type_in_typeDecl542); if (state.failed) return result;

            if ( state.backtracking==0 ) {
                       if ( (Type8!=null?Type8.getText():null).equals( "boolean" ) ) {
                           result = new org.uva.sea.ql.ast.type.Bool();
                       }
                       else if ( (Type8!=null?Type8.getText():null).equals( "integer" ) ) {
                           result = new org.uva.sea.ql.ast.type.Int();
                       }
                       else if ( (Type8!=null?Type8.getText():null).equals( "string" ) ) {
                           result = new org.uva.sea.ql.ast.type.Str();
                       }
                   }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, typeDecl_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "typeDecl"

    // Delegated rules


 

    public static final BitSet FOLLOW_Bool_in_primary46 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary66 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_strExpr_in_primary87 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_primary123 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_orExpr_in_primary127 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_primary129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Str_in_strExpr148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unExpr174 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_unExpr189 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_unExpr204 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr255 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_set_in_mulExpr263 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr275 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr316 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_set_in_addExpr324 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr334 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr369 = new BitSet(new long[]{0x0000000007C02002L});
    public static final BitSet FOLLOW_set_in_relExpr377 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr393 = new BitSet(new long[]{0x0000000007C02002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr431 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_andExpr437 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr441 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr476 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_orExpr482 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr486 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_strExpr_in_varDecl512 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_varDecl514 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_varDecl516 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_typeDecl_in_varDecl518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Type_in_typeDecl542 = new BitSet(new long[]{0x0000000000000002L});

}