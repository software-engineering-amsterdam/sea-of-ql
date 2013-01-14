// $ANTLR 3.4 QL.g 2013-01-14 14:35:42

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BooleanLiteral", "COLON", "COMMENT", "Ident", "IntLiteral", "LBRACE", "RBRACE", "StringLiteral", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'form'", "'if'", "'money'", "'string'", "'||'"
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
    public static final int T__32=32;
    public static final int BooleanLiteral=4;
    public static final int COLON=5;
    public static final int COMMENT=6;
    public static final int Ident=7;
    public static final int IntLiteral=8;
    public static final int LBRACE=9;
    public static final int RBRACE=10;
    public static final int StringLiteral=11;
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
        this.state.ruleMemo = new HashMap[36+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "QL.g"; }



    // $ANTLR start "qlprogram"
    // QL.g:15:1: qlprogram returns [QLProgram result] : 'form' Ident cb= compoundStatement ;
    public final QLProgram qlprogram() throws RecognitionException {
        QLProgram result = null;

        int qlprogram_StartIndex = input.index();

        Token Ident1=null;
        Statement cb =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // QL.g:16:5: ( 'form' Ident cb= compoundStatement )
            // QL.g:16:7: 'form' Ident cb= compoundStatement
            {
            match(input,28,FOLLOW_28_in_qlprogram48); if (state.failed) return result;

            Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_qlprogram50); if (state.failed) return result;

            pushFollow(FOLLOW_compoundStatement_in_qlprogram55);
            cb=compoundStatement();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new QLProgram(Ident1, cb) ; }

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



    // $ANTLR start "compoundStatement"
    // QL.g:19:1: compoundStatement returns [Statement result] : LBRACE (st= statement )* RBRACE ;
    public final Statement compoundStatement() throws RecognitionException {
        Statement result = null;

        int compoundStatement_StartIndex = input.index();

        QLParser.statement_return st =null;


         CompoundStatement compoundStatement = new CompoundStatement() ; 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // QL.g:21:5: ( LBRACE (st= statement )* RBRACE )
            // QL.g:21:7: LBRACE (st= statement )* RBRACE
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_compoundStatement86); if (state.failed) return result;

            // QL.g:22:7: (st= statement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Ident||LA1_0==LBRACE||LA1_0==29) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // QL.g:22:8: st= statement
            	    {
            	    pushFollow(FOLLOW_statement_in_compoundStatement98);
            	    st=statement();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { compoundStatement.addStatement((st!=null?st.result:null)) ; }

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input,RBRACE,FOLLOW_RBRACE_in_compoundStatement113); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = compoundStatement ; }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, compoundStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "compoundStatement"


    public static class statement_return extends ParserRuleReturnScope {
        public Statement result;
    };


    // $ANTLR start "statement"
    // QL.g:27:1: statement returns [Statement result] : ( Ident COLON st= StringLiteral ty= type | 'if' '(' ex= orExpr ')' c= compoundStatement |c= compoundStatement );
    public final QLParser.statement_return statement() throws RecognitionException {
        QLParser.statement_return retval = new QLParser.statement_return();
        retval.start = input.LT(1);

        int statement_StartIndex = input.index();

        Token st=null;
        Token Ident2=null;
        TypeDescription ty =null;

        Expr ex =null;

        Statement c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

            // QL.g:28:5: ( Ident COLON st= StringLiteral ty= type | 'if' '(' ex= orExpr ')' c= compoundStatement |c= compoundStatement )
            int alt2=3;
            switch ( input.LA(1) ) {
            case Ident:
                {
                alt2=1;
                }
                break;
            case 29:
                {
                alt2=2;
                }
                break;
            case LBRACE:
                {
                alt2=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // QL.g:28:7: Ident COLON st= StringLiteral ty= type
                    {
                    Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_statement149); if (state.failed) return retval;

                    match(input,COLON,FOLLOW_COLON_in_statement151); if (state.failed) return retval;

                    st=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_statement155); if (state.failed) return retval;

                    pushFollow(FOLLOW_type_in_statement159);
                    ty=type();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.result = new LineStatement(new String((Ident2!=null?Ident2.getText():null)),st,ty); }

                    }
                    break;
                case 2 :
                    // QL.g:29:7: 'if' '(' ex= orExpr ')' c= compoundStatement
                    {
                    match(input,29,FOLLOW_29_in_statement169); if (state.failed) return retval;

                    match(input,16,FOLLOW_16_in_statement171); if (state.failed) return retval;

                    pushFollow(FOLLOW_orExpr_in_statement175);
                    ex=orExpr();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,17,FOLLOW_17_in_statement177); if (state.failed) return retval;

                    pushFollow(FOLLOW_compoundStatement_in_statement181);
                    c=compoundStatement();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.result = new ConditionalStatement(ex,c) ; }

                    }
                    break;
                case 3 :
                    // QL.g:30:7: c= compoundStatement
                    {
                    pushFollow(FOLLOW_compoundStatement_in_statement193);
                    c=compoundStatement();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.result = c ;}

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
            if ( state.backtracking>0 ) { memoize(input, 3, statement_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "statement"



    // $ANTLR start "type"
    // QL.g:33:1: type returns [TypeDescription result] : ( 'boolean' | 'string' | 'money' ( '(' x= orExpr ')' )? );
    public final TypeDescription type() throws RecognitionException {
        TypeDescription result = null;

        int type_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // QL.g:34:5: ( 'boolean' | 'string' | 'money' ( '(' x= orExpr ')' )? )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt4=1;
                }
                break;
            case 31:
                {
                alt4=2;
                }
                break;
            case 30:
                {
                alt4=3;
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
                    // QL.g:34:7: 'boolean'
                    {
                    match(input,27,FOLLOW_27_in_type218); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new BooleanType() ;}

                    }
                    break;
                case 2 :
                    // QL.g:35:7: 'string'
                    {
                    match(input,31,FOLLOW_31_in_type228); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new StringType() ;}

                    }
                    break;
                case 3 :
                    // QL.g:36:7: 'money' ( '(' x= orExpr ')' )?
                    {
                    match(input,30,FOLLOW_30_in_type239); if (state.failed) return result;

                    // QL.g:36:15: ( '(' x= orExpr ')' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==16) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // QL.g:36:16: '(' x= orExpr ')'
                            {
                            match(input,16,FOLLOW_16_in_type242); if (state.failed) return result;

                            pushFollow(FOLLOW_orExpr_in_type246);
                            x=orExpr();

                            state._fsp--;
                            if (state.failed) return result;

                            match(input,17,FOLLOW_17_in_type248); if (state.failed) return result;

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
    // QL.g:39:1: primary returns [Expr result] : ( IntLiteral | Ident | BooleanLiteral | StringLiteral | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token IntLiteral3=null;
        Token Ident4=null;
        Token BooleanLiteral5=null;
        Token StringLiteral6=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // QL.g:40:3: ( IntLiteral | Ident | BooleanLiteral | StringLiteral | '(' x= orExpr ')' )
            int alt5=5;
            switch ( input.LA(1) ) {
            case IntLiteral:
                {
                alt5=1;
                }
                break;
            case Ident:
                {
                alt5=2;
                }
                break;
            case BooleanLiteral:
                {
                alt5=3;
                }
                break;
            case StringLiteral:
                {
                alt5=4;
                }
                break;
            case 16:
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
                    // QL.g:40:5: IntLiteral
                    {
                    IntLiteral3=(Token)match(input,IntLiteral,FOLLOW_IntLiteral_in_primary271); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IntLiteral(Integer.parseInt((IntLiteral3!=null?IntLiteral3.getText():null))); }

                    }
                    break;
                case 2 :
                    // QL.g:41:5: Ident
                    {
                    Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_primary284); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident4!=null?Ident4.getText():null)); }

                    }
                    break;
                case 3 :
                    // QL.g:42:5: BooleanLiteral
                    {
                    BooleanLiteral5=(Token)match(input,BooleanLiteral,FOLLOW_BooleanLiteral_in_primary302); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new BooleanLiteral((BooleanLiteral5!=null?BooleanLiteral5.getText():null)) ;}

                    }
                    break;
                case 4 :
                    // QL.g:43:5: StringLiteral
                    {
                    StringLiteral6=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_primary311); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new StringLiteral((StringLiteral6!=null?StringLiteral6.getText():null)) ;}

                    }
                    break;
                case 5 :
                    // QL.g:44:5: '(' x= orExpr ')'
                    {
                    match(input,16,FOLLOW_16_in_primary321); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary325);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,17,FOLLOW_17_in_primary327); if (state.failed) return result;

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
    // QL.g:47:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // QL.g:48:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
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
            case BooleanLiteral:
            case Ident:
            case IntLiteral:
            case StringLiteral:
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
                    // QL.g:48:8: '+' x= unExpr
                    {
                    match(input,19,FOLLOW_19_in_unExpr352); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr356);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // QL.g:49:8: '-' x= unExpr
                    {
                    match(input,20,FOLLOW_20_in_unExpr367); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr371);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // QL.g:50:8: '!' x= unExpr
                    {
                    match(input,13,FOLLOW_13_in_unExpr382); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr386);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // QL.g:51:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr399);
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
    // QL.g:54:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // QL.g:55:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // QL.g:55:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr437);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:55:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18||LA7_0==21) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // QL.g:55:47: op= ( '*' | '/' ) rhs= unExpr
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


            	    pushFollow(FOLLOW_unExpr_in_mulExpr457);
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
    // QL.g:66:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // QL.g:67:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // QL.g:67:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr495);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:67:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= 19 && LA8_0 <= 20)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // QL.g:67:48: op= ( '+' | '-' ) rhs= mulExpr
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


            	    pushFollow(FOLLOW_mulExpr_in_addExpr513);
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
    // QL.g:78:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // QL.g:79:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // QL.g:79:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr548);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:79:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==14||(LA9_0 >= 22 && LA9_0 <= 26)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // QL.g:79:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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


            	    pushFollow(FOLLOW_addExpr_in_relExpr572);
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
    // QL.g:102:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // QL.g:103:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // QL.g:103:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr610);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // QL.g:103:46: ( '&&' rhs= relExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==15) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // QL.g:103:48: '&&' rhs= relExpr
            	    {
            	    match(input,15,FOLLOW_15_in_andExpr616); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr620);
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
    // QL.g:106:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // QL.g:107:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // QL.g:107:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr654);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // QL.g:107:48: ( '||' rhs= andExpr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==32) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // QL.g:107:50: '||' rhs= andExpr
            	    {
            	    match(input,32,FOLLOW_32_in_orExpr660); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr664);
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
    public static final BitSet FOLLOW_compoundStatement_in_qlprogram55 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_compoundStatement86 = new BitSet(new long[]{0x0000000020000680L});
    public static final BitSet FOLLOW_statement_in_compoundStatement98 = new BitSet(new long[]{0x0000000020000680L});
    public static final BitSet FOLLOW_RBRACE_in_compoundStatement113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_statement149 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_COLON_in_statement151 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_StringLiteral_in_statement155 = new BitSet(new long[]{0x00000000C8000000L});
    public static final BitSet FOLLOW_type_in_statement159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_statement169 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_statement171 = new BitSet(new long[]{0x0000000000192990L});
    public static final BitSet FOLLOW_orExpr_in_statement175 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_statement177 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_compoundStatement_in_statement181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compoundStatement_in_statement193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_type218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_type228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_type239 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_type242 = new BitSet(new long[]{0x0000000000192990L});
    public static final BitSet FOLLOW_orExpr_in_type246 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_type248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntLiteral_in_primary271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BooleanLiteral_in_primary302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_primary311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_primary321 = new BitSet(new long[]{0x0000000000192990L});
    public static final BitSet FOLLOW_orExpr_in_primary325 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_primary327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_unExpr352 = new BitSet(new long[]{0x0000000000192990L});
    public static final BitSet FOLLOW_unExpr_in_unExpr356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_unExpr367 = new BitSet(new long[]{0x0000000000192990L});
    public static final BitSet FOLLOW_unExpr_in_unExpr371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_unExpr382 = new BitSet(new long[]{0x0000000000192990L});
    public static final BitSet FOLLOW_unExpr_in_unExpr386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr437 = new BitSet(new long[]{0x0000000000240002L});
    public static final BitSet FOLLOW_set_in_mulExpr445 = new BitSet(new long[]{0x0000000000192990L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr457 = new BitSet(new long[]{0x0000000000240002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr495 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_set_in_addExpr503 = new BitSet(new long[]{0x0000000000192990L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr513 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr548 = new BitSet(new long[]{0x0000000007C04002L});
    public static final BitSet FOLLOW_set_in_relExpr556 = new BitSet(new long[]{0x0000000000192990L});
    public static final BitSet FOLLOW_addExpr_in_relExpr572 = new BitSet(new long[]{0x0000000007C04002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr610 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_andExpr616 = new BitSet(new long[]{0x0000000000192990L});
    public static final BitSet FOLLOW_relExpr_in_andExpr620 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr654 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_orExpr660 = new BitSet(new long[]{0x0000000000192990L});
    public static final BitSet FOLLOW_andExpr_in_orExpr664 = new BitSet(new long[]{0x0000000100000002L});

}