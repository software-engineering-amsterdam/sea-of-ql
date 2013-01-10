// $ANTLR 3.4 QL.g 2013-01-08 22:08:48

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Boolean", "COLON", "COMMENT", "Ident", "Int", "LBRACE", "RBRACE", "String", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'form'", "'if'", "'money'", "'||'"
    };

    public static final int EOF=-1;
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
    public static final int T__31=31;
    public static final int Boolean=4;
    public static final int COLON=5;
    public static final int COMMENT=6;
    public static final int Ident=7;
    public static final int Int=8;
    public static final int LBRACE=9;
    public static final int RBRACE=10;
    public static final int String=11;
    public static final int WS=12;

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
        this.state.ruleMemo = new HashMap[33+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "QL.g"; }



    // $ANTLR start "qlprogram"
    // QL.g:15:1: qlprogram returns [QLProgram result] : 'form' Ident cb= compoundblock ;
    public final QLProgram qlprogram() throws RecognitionException {
        QLProgram result = null;

        int qlprogram_StartIndex = input.index();

        Token Ident1=null;
        CompoundBlock cb =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // QL.g:16:5: ( 'form' Ident cb= compoundblock )
            // QL.g:16:7: 'form' Ident cb= compoundblock
            {
            match(input,28,FOLLOW_28_in_qlprogram48); if (state.failed) return result;

            Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_qlprogram50); if (state.failed) return result;

            pushFollow(FOLLOW_compoundblock_in_qlprogram55);
            cb=compoundblock();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new QLProgram(new String((Ident1!=null?Ident1.getText():null)), cb) ; }

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
        return result;
    }
    // $ANTLR end "qlprogram"



    // $ANTLR start "compoundblock"
    // QL.g:19:1: compoundblock returns [CompoundBlock result] : LBRACE (st= stmt )* RBRACE ;
    public final CompoundBlock compoundblock() throws RecognitionException {
        CompoundBlock result = null;

        int compoundblock_StartIndex = input.index();

        QLParser.stmt_return st =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // QL.g:20:5: ( LBRACE (st= stmt )* RBRACE )
            // QL.g:20:7: LBRACE (st= stmt )* RBRACE
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_compoundblock79); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new CompoundBlock() ; }

            // QL.g:21:43: (st= stmt )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Ident||LA1_0==29) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // QL.g:21:44: st= stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_compoundblock93);
            	    st=stmt();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result.addStatement((st!=null?st.result:null)) ; }

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input,RBRACE,FOLLOW_RBRACE_in_compoundblock108); if (state.failed) return result;

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
        return result;
    }
    // $ANTLR end "compoundblock"


    public static class stmt_return extends ParserRuleReturnScope {
        public Statement result;
    };


    // $ANTLR start "stmt"
    // QL.g:25:1: stmt returns [Statement result] : ( Ident COLON st= String ty= type | 'if' '(' ex= orExpr ')' c= compoundblock );
    public final QLParser.stmt_return stmt() throws RecognitionException {
        QLParser.stmt_return retval = new QLParser.stmt_return();
        retval.start = input.LT(1);

        int stmt_StartIndex = input.index();

        Token st=null;
        Token Ident2=null;
        TypeDescription ty =null;

        Expr ex =null;

        CompoundBlock c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

            // QL.g:26:5: ( Ident COLON st= String ty= type | 'if' '(' ex= orExpr ')' c= compoundblock )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Ident) ) {
                alt2=1;
            }
            else if ( (LA2_0==29) ) {
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
                    // QL.g:26:7: Ident COLON st= String ty= type
                    {
                    Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_stmt136); if (state.failed) return retval;

                    match(input,COLON,FOLLOW_COLON_in_stmt138); if (state.failed) return retval;

                    st=(Token)match(input,String,FOLLOW_String_in_stmt142); if (state.failed) return retval;

                    pushFollow(FOLLOW_type_in_stmt146);
                    ty=type();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.result = new LineStatement(new String((Ident2!=null?Ident2.getText():null)),st,ty); }

                    }
                    break;
                case 2 :
                    // QL.g:27:7: 'if' '(' ex= orExpr ')' c= compoundblock
                    {
                    match(input,29,FOLLOW_29_in_stmt156); if (state.failed) return retval;

                    match(input,16,FOLLOW_16_in_stmt158); if (state.failed) return retval;

                    pushFollow(FOLLOW_orExpr_in_stmt162);
                    ex=orExpr();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,17,FOLLOW_17_in_stmt164); if (state.failed) return retval;

                    pushFollow(FOLLOW_compoundblock_in_stmt168);
                    c=compoundblock();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.result = new ConditionalStatement(ex,c) ; }

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
    // QL.g:30:1: type returns [TypeDescription result] : ( 'boolean' | 'money' ( '(' x= orExpr ')' )? );
    public final TypeDescription type() throws RecognitionException {
        TypeDescription result = null;

        int type_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // QL.g:31:5: ( 'boolean' | 'money' ( '(' x= orExpr ')' )? )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==27) ) {
                alt4=1;
            }
            else if ( (LA4_0==30) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // QL.g:31:7: 'boolean'
                    {
                    match(input,27,FOLLOW_27_in_type195); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new BooleanType() ;}

                    }
                    break;
                case 2 :
                    // QL.g:32:7: 'money' ( '(' x= orExpr ')' )?
                    {
                    match(input,30,FOLLOW_30_in_type205); if (state.failed) return result;

                    // QL.g:32:15: ( '(' x= orExpr ')' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==16) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // QL.g:32:16: '(' x= orExpr ')'
                            {
                            match(input,16,FOLLOW_16_in_type208); if (state.failed) return result;

                            pushFollow(FOLLOW_orExpr_in_type212);
                            x=orExpr();

                            state._fsp--;
                            if (state.failed) return result;

                            match(input,17,FOLLOW_17_in_type214); if (state.failed) return result;

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { result = new MoneyType(x) ;}

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
            if ( state.backtracking>0 ) { memoize(input, 4, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"



    // $ANTLR start "primary"
    // QL.g:37:1: primary returns [Expr result] : ( Int | Ident | Boolean | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int3=null;
        Token Ident4=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // QL.g:38:3: ( Int | Ident | Boolean | '(' x= orExpr ')' )
            int alt5=4;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt5=1;
                }
                break;
            case Ident:
                {
                alt5=2;
                }
                break;
            case Boolean:
                {
                alt5=3;
                }
                break;
            case 16:
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
                    // QL.g:38:5: Int
                    {
                    Int3=(Token)match(input,Int,FOLLOW_Int_in_primary240); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int3!=null?Int3.getText():null))); }

                    }
                    break;
                case 2 :
                    // QL.g:39:5: Ident
                    {
                    Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_primary250); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident4!=null?Ident4.getText():null)); }

                    }
                    break;
                case 3 :
                    // QL.g:40:5: Boolean
                    {
                    match(input,Boolean,FOLLOW_Boolean_in_primary258); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new BooleanType($Ident.text) ;}

                    }
                    break;
                case 4 :
                    // QL.g:41:5: '(' x= orExpr ')'
                    {
                    match(input,16,FOLLOW_16_in_primary266); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary270);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,17,FOLLOW_17_in_primary272); if (state.failed) return result;

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
    // QL.g:44:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // QL.g:45:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
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
            case 13:
                {
                alt6=3;
                }
                break;
            case Boolean:
            case Ident:
            case Int:
            case 16:
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
                    // QL.g:45:8: '+' x= unExpr
                    {
                    match(input,19,FOLLOW_19_in_unExpr297); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr301);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // QL.g:46:8: '-' x= unExpr
                    {
                    match(input,20,FOLLOW_20_in_unExpr312); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr316);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // QL.g:47:8: '!' x= unExpr
                    {
                    match(input,13,FOLLOW_13_in_unExpr327); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr331);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // QL.g:48:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr344);
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
    // QL.g:51:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // QL.g:52:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // QL.g:52:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr382);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:52:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18||LA7_0==21) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // QL.g:52:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==18||input.LA(1)==21 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr402);
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
            if ( state.backtracking>0 ) { memoize(input, 7, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // QL.g:64:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // QL.g:65:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // QL.g:65:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr443);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:65:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= 19 && LA8_0 <= 20)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // QL.g:65:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 19 && input.LA(1) <= 20) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr461);
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
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // QL.g:76:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // QL.g:77:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // QL.g:77:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr496);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:77:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==14||(LA9_0 >= 22 && LA9_0 <= 26)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // QL.g:77:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==14||(input.LA(1) >= 22 && input.LA(1) <= 26) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr520);
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
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // QL.g:100:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // QL.g:101:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // QL.g:101:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr558);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:101:46: ( '&&' rhs= relExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==15) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // QL.g:101:48: '&&' rhs= relExpr
            	    {
            	    match(input,15,FOLLOW_15_in_andExpr564); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr568);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

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
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // QL.g:105:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // QL.g:106:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // QL.g:106:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr603);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // QL.g:106:48: ( '||' rhs= andExpr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==31) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // QL.g:106:50: '||' rhs= andExpr
            	    {
            	    match(input,31,FOLLOW_31_in_orExpr609); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr613);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

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
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"

    // Delegated rules


 

    public static final BitSet FOLLOW_28_in_qlprogram48 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Ident_in_qlprogram50 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_compoundblock_in_qlprogram55 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_compoundblock79 = new BitSet(new long[]{0x0000000020000480L});
    public static final BitSet FOLLOW_stmt_in_compoundblock93 = new BitSet(new long[]{0x0000000020000480L});
    public static final BitSet FOLLOW_RBRACE_in_compoundblock108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_stmt136 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_COLON_in_stmt138 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_String_in_stmt142 = new BitSet(new long[]{0x0000000048000000L});
    public static final BitSet FOLLOW_type_in_stmt146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_stmt156 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_stmt158 = new BitSet(new long[]{0x0000000000192190L});
    public static final BitSet FOLLOW_orExpr_in_stmt162 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_stmt164 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_compoundblock_in_stmt168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_type195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_type205 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_type208 = new BitSet(new long[]{0x0000000000192190L});
    public static final BitSet FOLLOW_orExpr_in_type212 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_type214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Boolean_in_primary258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_primary266 = new BitSet(new long[]{0x0000000000192190L});
    public static final BitSet FOLLOW_orExpr_in_primary270 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_primary272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_unExpr297 = new BitSet(new long[]{0x0000000000192190L});
    public static final BitSet FOLLOW_unExpr_in_unExpr301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_unExpr312 = new BitSet(new long[]{0x0000000000192190L});
    public static final BitSet FOLLOW_unExpr_in_unExpr316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_unExpr327 = new BitSet(new long[]{0x0000000000192190L});
    public static final BitSet FOLLOW_unExpr_in_unExpr331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr382 = new BitSet(new long[]{0x0000000000240002L});
    public static final BitSet FOLLOW_set_in_mulExpr390 = new BitSet(new long[]{0x0000000000192190L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr402 = new BitSet(new long[]{0x0000000000240002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr443 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_set_in_addExpr451 = new BitSet(new long[]{0x0000000000192190L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr461 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr496 = new BitSet(new long[]{0x0000000007C04002L});
    public static final BitSet FOLLOW_set_in_relExpr504 = new BitSet(new long[]{0x0000000000192190L});
    public static final BitSet FOLLOW_addExpr_in_relExpr520 = new BitSet(new long[]{0x0000000007C04002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr558 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_andExpr564 = new BitSet(new long[]{0x0000000000192190L});
    public static final BitSet FOLLOW_relExpr_in_andExpr568 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr603 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_orExpr609 = new BitSet(new long[]{0x0000000000192190L});
    public static final BitSet FOLLOW_andExpr_in_orExpr613 = new BitSet(new long[]{0x0000000080000002L});

}