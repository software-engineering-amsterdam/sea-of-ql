// $ANTLR 3.4 src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-13 14:14:08

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.value.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "Ident", "Int", "Str", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
    };

    public static final int EOF=-1;
    public static final int T__10=10;
    public static final int T__11=11;
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
    public static final int Bool=4;
    public static final int COMMENT=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int Str=8;
    public static final int WS=9;

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
        this.state.ruleMemo = new HashMap[27+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "primary"
    // src/org/uva/sea/ql/parser/antlr/QL.g:17:1: primary returns [Expression result] : ( Bool | Int | strExpr | Ident | '(' x= orExpr ')' );
    public final Expression primary() throws RecognitionException {
        Expression result = null;

        int primary_StartIndex = input.index();

        Token Bool1=null;
        Token Int2=null;
        Token Ident4=null;
        Expression x =null;

        Str strExpr3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:18:3: ( Bool | Int | strExpr | Ident | '(' x= orExpr ')' )
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
            case 13:
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
                    // src/org/uva/sea/ql/parser/antlr/QL.g:18:5: Bool
                    {
                    Bool1=(Token)match(input,Bool,FOLLOW_Bool_in_primary46); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Bool( Boolean.parseBoolean( (Bool1!=null?Bool1.getText():null) ) ); }

                    }
                    break;
                case 2 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:19:5: Int
                    {
                    Int2=(Token)match(input,Int,FOLLOW_Int_in_primary66); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int( Integer.parseInt( (Int2!=null?Int2.getText():null) ) ); }

                    }
                    break;
                case 3 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:20:5: strExpr
                    {
                    pushFollow(FOLLOW_strExpr_in_primary87);
                    strExpr3=strExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = strExpr3; }

                    }
                    break;
                case 4 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:21:5: Ident
                    {
                    Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_primary104); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident( (Ident4!=null?Ident4.getText():null) ); }

                    }
                    break;
                case 5 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:22:5: '(' x= orExpr ')'
                    {
                    match(input,13,FOLLOW_13_in_primary123); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary127);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_primary129); if (state.failed) return result;

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
    // src/org/uva/sea/ql/parser/antlr/QL.g:25:1: strExpr returns [Str result] : Str ;
    public final Str strExpr() throws RecognitionException {
        Str result = null;

        int strExpr_StartIndex = input.index();

        Token Str5=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:26:3: ( Str )
            // src/org/uva/sea/ql/parser/antlr/QL.g:26:5: Str
            {
            Str5=(Token)match(input,Str,FOLLOW_Str_in_strExpr148); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Str( (Str5!=null?Str5.getText():null).substring( 1, (Str5!=null?Str5.getText():null).length() - 1 ) ); }

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
    // src/org/uva/sea/ql/parser/antlr/QL.g:29:1: unExpr returns [Expression result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expression unExpr() throws RecognitionException {
        Expression result = null;

        int unExpr_StartIndex = input.index();

        Expression x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:30:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt2=1;
                }
                break;
            case 17:
                {
                alt2=2;
                }
                break;
            case 10:
                {
                alt2=3;
                }
                break;
            case Bool:
            case Ident:
            case Int:
            case Str:
            case 13:
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
                    // src/org/uva/sea/ql/parser/antlr/QL.g:30:8: '+' x= unExpr
                    {
                    match(input,16,FOLLOW_16_in_unExpr174); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr178);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos( x ); }

                    }
                    break;
                case 2 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:31:8: '-' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr189); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr193);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg( x ); }

                    }
                    break;
                case 3 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:32:8: '!' x= unExpr
                    {
                    match(input,10,FOLLOW_10_in_unExpr204); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr208);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not( x ); }

                    }
                    break;
                case 4 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:33:8: x= primary
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
    // src/org/uva/sea/ql/parser/antlr/QL.g:36:1: mulExpr returns [Expression result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expression mulExpr() throws RecognitionException {
        Expression result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:37:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:37:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr255);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:37:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15||LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:37:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==15||input.LA(1)==18 ) {
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
    // src/org/uva/sea/ql/parser/antlr/QL.g:49:1: addExpr returns [Expression result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expression addExpr() throws RecognitionException {
        Expression result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:50:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:50:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr316);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:50:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= 16 && LA4_0 <= 17)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:50:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 16 && input.LA(1) <= 17) ) {
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
    // src/org/uva/sea/ql/parser/antlr/QL.g:61:1: relExpr returns [Expression result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expression relExpr() throws RecognitionException {
        Expression result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:62:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:62:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr369);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:62:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==11||(LA5_0 >= 19 && LA5_0 <= 23)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:62:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==11||(input.LA(1) >= 19 && input.LA(1) <= 23) ) {
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
    // src/org/uva/sea/ql/parser/antlr/QL.g:85:1: andExpr returns [Expression result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expression andExpr() throws RecognitionException {
        Expression result = null;

        int andExpr_StartIndex = input.index();

        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:86:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:86:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr431);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:86:46: ( '&&' rhs= relExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==12) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:86:48: '&&' rhs= relExpr
            	    {
            	    match(input,12,FOLLOW_12_in_andExpr437); if (state.failed) return result;

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
    // src/org/uva/sea/ql/parser/antlr/QL.g:90:1: orExpr returns [Expression result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expression orExpr() throws RecognitionException {
        Expression result = null;

        int orExpr_StartIndex = input.index();

        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:91:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:91:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr476);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // src/org/uva/sea/ql/parser/antlr/QL.g:91:48: ( '||' rhs= andExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==24) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:91:50: '||' rhs= andExpr
            	    {
            	    match(input,24,FOLLOW_24_in_orExpr482); if (state.failed) return result;

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

    // Delegated rules


 

    public static final BitSet FOLLOW_Bool_in_primary46 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary66 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_strExpr_in_primary87 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_primary123 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_primary127 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_primary129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Str_in_strExpr148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_unExpr174 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr189 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_unExpr204 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr255 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_set_in_mulExpr263 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr275 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr316 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_set_in_addExpr324 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr334 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr369 = new BitSet(new long[]{0x0000000000F80802L});
    public static final BitSet FOLLOW_set_in_relExpr377 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr393 = new BitSet(new long[]{0x0000000000F80802L});
    public static final BitSet FOLLOW_relExpr_in_andExpr431 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_andExpr437 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr441 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr476 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_orExpr482 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr486 = new BitSet(new long[]{0x0000000001000002L});

}