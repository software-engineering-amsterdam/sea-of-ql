// $ANTLR 3.4 QL.g 2013-01-07 22:55:36

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COLON", "COMMENT", "Ident", "Int", "LBRACE", "RBRACE", "String", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'form'", "'if'", "'money'", "'||'"
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
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int COLON=4;
    public static final int COMMENT=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int LBRACE=8;
    public static final int RBRACE=9;
    public static final int String=10;
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
        this.state.ruleMemo = new HashMap[31+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "QL.g"; }



    // $ANTLR start "qlprogram"
    // QL.g:15:1: qlprogram : 'form' Ident compoundblock ;
    public final void qlprogram() throws RecognitionException {
        int qlprogram_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }

            // QL.g:15:11: ( 'form' Ident compoundblock )
            // QL.g:15:13: 'form' Ident compoundblock
            {
            match(input,27,FOLLOW_27_in_qlprogram40); if (state.failed) return ;

            match(input,Ident,FOLLOW_Ident_in_qlprogram42); if (state.failed) return ;

            pushFollow(FOLLOW_compoundblock_in_qlprogram44);
            compoundblock();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, qlprogram_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "qlprogram"



    // $ANTLR start "compoundblock"
    // QL.g:17:1: compoundblock : LBRACE ( stmt )* RBRACE ;
    public final void compoundblock() throws RecognitionException {
        int compoundblock_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }

            // QL.g:17:15: ( LBRACE ( stmt )* RBRACE )
            // QL.g:17:17: LBRACE ( stmt )* RBRACE
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_compoundblock53); if (state.failed) return ;

            // QL.g:17:24: ( stmt )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Ident||LA1_0==28) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // QL.g:17:24: stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_compoundblock55);
            	    stmt();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input,RBRACE,FOLLOW_RBRACE_in_compoundblock58); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, compoundblock_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "compoundblock"


    public static class stmt_return extends ParserRuleReturnScope {
        public Stmt result;
    };


    // $ANTLR start "stmt"
    // QL.g:19:1: stmt returns [Stmt result] : (x= Ident COLON st= String t= type | 'if' '(' Ident ')' compoundblock );
    public final QLParser.stmt_return stmt() throws RecognitionException {
        QLParser.stmt_return retval = new QLParser.stmt_return();
        retval.start = input.LT(1);

        int stmt_StartIndex = input.index();

        Token x=null;
        Token st=null;
        void t =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

            // QL.g:20:11: (x= Ident COLON st= String t= type | 'if' '(' Ident ')' compoundblock )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Ident) ) {
                alt2=1;
            }
            else if ( (LA2_0==28) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // QL.g:20:13: x= Ident COLON st= String t= type
                    {
                    x=(Token)match(input,Ident,FOLLOW_Ident_in_stmt88); if (state.failed) return retval;

                    match(input,COLON,FOLLOW_COLON_in_stmt90); if (state.failed) return retval;

                    st=(Token)match(input,String,FOLLOW_String_in_stmt94); if (state.failed) return retval;

                    pushFollow(FOLLOW_type_in_stmt98);
                    type();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.result = new Stmt(x,st,t); }

                    }
                    break;
                case 2 :
                    // QL.g:21:13: 'if' '(' Ident ')' compoundblock
                    {
                    match(input,28,FOLLOW_28_in_stmt114); if (state.failed) return retval;

                    match(input,15,FOLLOW_15_in_stmt116); if (state.failed) return retval;

                    match(input,Ident,FOLLOW_Ident_in_stmt117); if (state.failed) return retval;

                    match(input,16,FOLLOW_16_in_stmt119); if (state.failed) return retval;

                    pushFollow(FOLLOW_compoundblock_in_stmt121);
                    compoundblock();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, stmt_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "stmt"



    // $ANTLR start "type"
    // QL.g:23:1: type : ( 'boolean' | 'money' );
    public final void type() throws RecognitionException {
        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return ; }

            // QL.g:23:8: ( 'boolean' | 'money' )
            // QL.g:
            {
            if ( input.LA(1)==26||input.LA(1)==29 ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, type_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "type"



    // $ANTLR start "primary"
    // QL.g:28:1: primary returns [Expr result] : ( Int | Ident | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int1=null;
        Token Ident2=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // QL.g:29:3: ( Int | Ident | '(' x= orExpr ')' )
            int alt3=3;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt3=1;
                }
                break;
            case Ident:
                {
                alt3=2;
                }
                break;
            case 15:
                {
                alt3=3;
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
                    // QL.g:29:5: Int
                    {
                    Int1=(Token)match(input,Int,FOLLOW_Int_in_primary160); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int1!=null?Int1.getText():null))); }

                    }
                    break;
                case 2 :
                    // QL.g:30:5: Ident
                    {
                    Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_primary170); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident2!=null?Ident2.getText():null)); }

                    }
                    break;
                case 3 :
                    // QL.g:31:5: '(' x= orExpr ')'
                    {
                    match(input,15,FOLLOW_15_in_primary178); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary182);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,16,FOLLOW_16_in_primary184); if (state.failed) return result;

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
            if ( state.backtracking>0 ) { memoize(input, 5, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unExpr"
    // QL.g:34:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // QL.g:35:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt4=1;
                }
                break;
            case 19:
                {
                alt4=2;
                }
                break;
            case 12:
                {
                alt4=3;
                }
                break;
            case Ident:
            case Int:
            case 15:
                {
                alt4=4;
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
                    // QL.g:35:8: '+' x= unExpr
                    {
                    match(input,18,FOLLOW_18_in_unExpr209); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr213);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // QL.g:36:8: '-' x= unExpr
                    {
                    match(input,19,FOLLOW_19_in_unExpr224); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr228);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // QL.g:37:8: '!' x= unExpr
                    {
                    match(input,12,FOLLOW_12_in_unExpr239); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr243);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // QL.g:38:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr256);
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
            if ( state.backtracking>0 ) { memoize(input, 6, unExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // QL.g:41:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // QL.g:42:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // QL.g:42:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr294);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:42:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17||LA5_0==20) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // QL.g:42:47: op= ( '*' | '/' ) rhs= unExpr
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


            	    pushFollow(FOLLOW_unExpr_in_mulExpr314);
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
            if ( state.backtracking>0 ) { memoize(input, 7, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // QL.g:54:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // QL.g:55:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // QL.g:55:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr355);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:55:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= 18 && LA6_0 <= 19)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // QL.g:55:48: op= ( '+' | '-' ) rhs= mulExpr
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


            	    pushFollow(FOLLOW_mulExpr_in_addExpr373);
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
            if ( state.backtracking>0 ) { memoize(input, 8, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // QL.g:66:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // QL.g:67:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // QL.g:67:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr408);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:67:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==13||(LA7_0 >= 21 && LA7_0 <= 25)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // QL.g:67:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==13||(input.LA(1) >= 21 && input.LA(1) <= 25) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr432);
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
            if ( state.backtracking>0 ) { memoize(input, 9, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // QL.g:90:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // QL.g:91:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // QL.g:91:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr470);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:91:46: ( '&&' rhs= relExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==14) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // QL.g:91:48: '&&' rhs= relExpr
            	    {
            	    match(input,14,FOLLOW_14_in_andExpr476); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr480);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 10, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // QL.g:95:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // QL.g:96:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // QL.g:96:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr515);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // QL.g:96:48: ( '||' rhs= andExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==30) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // QL.g:96:50: '||' rhs= andExpr
            	    {
            	    match(input,30,FOLLOW_30_in_orExpr521); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr525);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

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
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"

    // Delegated rules


 

    public static final BitSet FOLLOW_27_in_qlprogram40 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_qlprogram42 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_compoundblock_in_qlprogram44 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_compoundblock53 = new BitSet(new long[]{0x0000000010000240L});
    public static final BitSet FOLLOW_stmt_in_compoundblock55 = new BitSet(new long[]{0x0000000010000240L});
    public static final BitSet FOLLOW_RBRACE_in_compoundblock58 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_stmt88 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COLON_in_stmt90 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_String_in_stmt94 = new BitSet(new long[]{0x0000000024000000L});
    public static final BitSet FOLLOW_type_in_stmt98 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_stmt114 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_stmt116 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_stmt117 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_stmt119 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_compoundblock_in_stmt121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_primary178 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_orExpr_in_primary182 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_primary184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unExpr209 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_unExpr224 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_unExpr239 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr294 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_set_in_mulExpr302 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr314 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr355 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_set_in_addExpr363 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr373 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr408 = new BitSet(new long[]{0x0000000003E02002L});
    public static final BitSet FOLLOW_set_in_relExpr416 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr432 = new BitSet(new long[]{0x0000000003E02002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr470 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_andExpr476 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr480 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr515 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_orExpr521 = new BitSet(new long[]{0x00000000000C90C0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr525 = new BitSet(new long[]{0x0000000040000002L});

}