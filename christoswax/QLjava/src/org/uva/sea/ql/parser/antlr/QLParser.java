// $ANTLR 3.4 /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-20 16:08:50

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.*;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "Ident", "Int", "NEWLINE", "STRING", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
    };

    public static final int EOF=-1;
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
    public static final int T__25=25;
    public static final int Bool=4;
    public static final int COMMENT=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int NEWLINE=8;
    public static final int STRING=9;
    public static final int WS=10;

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
        this.state.ruleMemo = new HashMap[24+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "/home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "primary"
    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:25:1: primary returns [Expr result] : ( Int | Ident | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int1=null;
        Token Ident2=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:26:3: ( Int | Ident | '(' x= orExpr ')' )
            int alt1=3;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt1=1;
                }
                break;
            case Ident:
                {
                alt1=2;
                }
                break;
            case 14:
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
                    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:26:5: Int
                    {
                    Int1=(Token)match(input,Int,FOLLOW_Int_in_primary86); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int1!=null?Int1.getText():null))); }

                    }
                    break;
                case 2 :
                    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:27:5: Ident
                    {
                    Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_primary96); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident2!=null?Ident2.getText():null)); }

                    }
                    break;
                case 3 :
                    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:28:5: '(' x= orExpr ')'
                    {
                    match(input,14,FOLLOW_14_in_primary104); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary108);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,15,FOLLOW_15_in_primary110); if (state.failed) return result;

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



    // $ANTLR start "unExpr"
    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:32:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:33:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt2=1;
                }
                break;
            case 18:
                {
                alt2=2;
                }
                break;
            case 11:
                {
                alt2=3;
                }
                break;
            case Ident:
            case Int:
            case 14:
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
                    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:33:8: '+' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr140); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr144);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:34:8: '-' x= unExpr
                    {
                    match(input,18,FOLLOW_18_in_unExpr155); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr159);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:35:8: '!' x= unExpr
                    {
                    match(input,11,FOLLOW_11_in_unExpr170); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr174);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:36:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr187);
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
            if ( state.backtracking>0 ) { memoize(input, 2, unExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:39:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:40:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:40:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr225);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:40:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16||LA3_0==19) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:40:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==16||input.LA(1)==19 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr245);
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
            if ( state.backtracking>0 ) { memoize(input, 3, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:52:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:53:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:53:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr285);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:53:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= 17 && LA4_0 <= 18)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:53:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 17 && input.LA(1) <= 18) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr303);
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
            if ( state.backtracking>0 ) { memoize(input, 4, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:64:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:65:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:65:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr338);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:65:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==12||(LA5_0 >= 20 && LA5_0 <= 24)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:65:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==12||(input.LA(1) >= 20 && input.LA(1) <= 24) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr362);
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
            if ( state.backtracking>0 ) { memoize(input, 5, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:88:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:89:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:89:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr400);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:89:46: ( '&&' rhs= relExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==13) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:89:48: '&&' rhs= relExpr
            	    {
            	    match(input,13,FOLLOW_13_in_andExpr406); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr410);
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
            if ( state.backtracking>0 ) { memoize(input, 6, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:93:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:94:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:94:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr445);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:94:48: ( '||' rhs= andExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==25) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/christos/Dropbox/SE_UvA/construction/christoswax/QLjava/src/org/uva/sea/ql/parser/antlr/QL.g:94:50: '||' rhs= andExpr
            	    {
            	    match(input,25,FOLLOW_25_in_orExpr451); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr455);
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
            if ( state.backtracking>0 ) { memoize(input, 7, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"

    // Delegated rules


 

    public static final BitSet FOLLOW_Int_in_primary86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary96 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_primary104 = new BitSet(new long[]{0x00000000000648C0L});
    public static final BitSet FOLLOW_orExpr_in_primary108 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_primary110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr140 = new BitSet(new long[]{0x00000000000648C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unExpr155 = new BitSet(new long[]{0x00000000000648C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_unExpr170 = new BitSet(new long[]{0x00000000000648C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr225 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_set_in_mulExpr233 = new BitSet(new long[]{0x00000000000648C0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr245 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr285 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_set_in_addExpr293 = new BitSet(new long[]{0x00000000000648C0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr303 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr338 = new BitSet(new long[]{0x0000000001F01002L});
    public static final BitSet FOLLOW_set_in_relExpr346 = new BitSet(new long[]{0x00000000000648C0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr362 = new BitSet(new long[]{0x0000000001F01002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr400 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_andExpr406 = new BitSet(new long[]{0x00000000000648C0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr410 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr445 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_orExpr451 = new BitSet(new long[]{0x00000000000648C0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr455 = new BitSet(new long[]{0x0000000002000002L});

}