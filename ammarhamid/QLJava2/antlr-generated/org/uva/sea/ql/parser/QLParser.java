// $ANTLR 3.4 src/main/org/uva/sea/ql/parser/QL.g 2013-01-21 02:02:09

	package org.uva.sea.ql.parser;
	import org.uva.sea.ql.parser.exception.ParserException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNMENT", "Boolean", "Comment", "Digit", "EXPRESSION", "FORM", "IF", "Identifier", "Integer", "Letter", "Money", "MultilineComment", "NEGATION", "NOT", "STATEMENTS", "StringLiteral", "Whitespace", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'else'", "'form'", "'if'", "'integer'", "'money'", "'string'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
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
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int ASSIGNMENT=4;
    public static final int Boolean=5;
    public static final int Comment=6;
    public static final int Digit=7;
    public static final int EXPRESSION=8;
    public static final int FORM=9;
    public static final int IF=10;
    public static final int Identifier=11;
    public static final int Integer=12;
    public static final int Letter=13;
    public static final int Money=14;
    public static final int MultilineComment=15;
    public static final int NEGATION=16;
    public static final int NOT=17;
    public static final int STATEMENTS=18;
    public static final int StringLiteral=19;
    public static final int Whitespace=20;

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
        this.state.ruleMemo = new HashMap[44+1];
         

    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "src/main/org/uva/sea/ql/parser/QL.g"; }


    	@Override
    	public void reportError(RecognitionException e)
    	{
    		super.reportError(e);
    		throw new ParserException(e.getMessage());
    	}


    public static class form_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "form"
    // src/main/org/uva/sea/ql/parser/QL.g:44:1: form : 'form' Identifier '{' ( statementBlock )* '}' -> ^( FORM Identifier ^( STATEMENTS ( statementBlock )* ) ) ;
    public final QLParser.form_return form() throws RecognitionException {
        QLParser.form_return retval = new QLParser.form_return();
        retval.start = input.LT(1);

        int form_StartIndex = input.index();

        CommonTree root_0 = null;

        Token string_literal1=null;
        Token Identifier2=null;
        Token char_literal3=null;
        Token char_literal5=null;
        QLParser.statementBlock_return statementBlock4 =null;


        CommonTree string_literal1_tree=null;
        CommonTree Identifier2_tree=null;
        CommonTree char_literal3_tree=null;
        CommonTree char_literal5_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_statementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementBlock");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:45:2: ( 'form' Identifier '{' ( statementBlock )* '}' -> ^( FORM Identifier ^( STATEMENTS ( statementBlock )* ) ) )
            // src/main/org/uva/sea/ql/parser/QL.g:45:4: 'form' Identifier '{' ( statementBlock )* '}'
            {
            string_literal1=(Token)match(input,38,FOLLOW_38_in_form140); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_38.add(string_literal1);


            Identifier2=(Token)match(input,Identifier,FOLLOW_Identifier_in_form142); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Identifier.add(Identifier2);


            char_literal3=(Token)match(input,43,FOLLOW_43_in_form144); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_43.add(char_literal3);


            // src/main/org/uva/sea/ql/parser/QL.g:45:26: ( statementBlock )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Identifier||LA1_0==39) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:45:26: statementBlock
            	    {
            	    pushFollow(FOLLOW_statementBlock_in_form146);
            	    statementBlock4=statementBlock();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statementBlock.add(statementBlock4.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            char_literal5=(Token)match(input,45,FOLLOW_45_in_form149); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_45.add(char_literal5);


            // AST REWRITE
            // elements: statementBlock, Identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 45:46: -> ^( FORM Identifier ^( STATEMENTS ( statementBlock )* ) )
            {
                // src/main/org/uva/sea/ql/parser/QL.g:45:49: ^( FORM Identifier ^( STATEMENTS ( statementBlock )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(FORM, "FORM")
                , root_1);

                adaptor.addChild(root_1, 
                stream_Identifier.nextNode()
                );

                // src/main/org/uva/sea/ql/parser/QL.g:45:67: ^( STATEMENTS ( statementBlock )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(STATEMENTS, "STATEMENTS")
                , root_2);

                // src/main/org/uva/sea/ql/parser/QL.g:45:80: ( statementBlock )*
                while ( stream_statementBlock.hasNext() ) {
                    adaptor.addChild(root_2, stream_statementBlock.nextTree());

                }
                stream_statementBlock.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, form_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "form"


    public static class statementBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statementBlock"
    // src/main/org/uva/sea/ql/parser/QL.g:48:1: statementBlock : ( ifStatement | assignmentStatement );
    public final QLParser.statementBlock_return statementBlock() throws RecognitionException {
        QLParser.statementBlock_return retval = new QLParser.statementBlock_return();
        retval.start = input.LT(1);

        int statementBlock_StartIndex = input.index();

        CommonTree root_0 = null;

        QLParser.ifStatement_return ifStatement6 =null;

        QLParser.assignmentStatement_return assignmentStatement7 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:49:2: ( ifStatement | assignmentStatement )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==39) ) {
                alt2=1;
            }
            else if ( (LA2_0==Identifier) ) {
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
                    // src/main/org/uva/sea/ql/parser/QL.g:49:4: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_ifStatement_in_statementBlock175);
                    ifStatement6=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatement6.getTree());

                    }
                    break;
                case 2 :
                    // src/main/org/uva/sea/ql/parser/QL.g:50:5: assignmentStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_assignmentStatement_in_statementBlock181);
                    assignmentStatement7=assignmentStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentStatement7.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, statementBlock_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "statementBlock"


    public static class ifStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ifStatement"
    // src/main/org/uva/sea/ql/parser/QL.g:53:1: ifStatement : ifStat ( elseIfStat )* ( elseStat )? -> ^( IF ifStat ( elseIfStat )* ( elseStat )? ) ;
    public final QLParser.ifStatement_return ifStatement() throws RecognitionException {
        QLParser.ifStatement_return retval = new QLParser.ifStatement_return();
        retval.start = input.LT(1);

        int ifStatement_StartIndex = input.index();

        CommonTree root_0 = null;

        QLParser.ifStat_return ifStat8 =null;

        QLParser.elseIfStat_return elseIfStat9 =null;

        QLParser.elseStat_return elseStat10 =null;


        RewriteRuleSubtreeStream stream_elseIfStat=new RewriteRuleSubtreeStream(adaptor,"rule elseIfStat");
        RewriteRuleSubtreeStream stream_ifStat=new RewriteRuleSubtreeStream(adaptor,"rule ifStat");
        RewriteRuleSubtreeStream stream_elseStat=new RewriteRuleSubtreeStream(adaptor,"rule elseStat");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:54:2: ( ifStat ( elseIfStat )* ( elseStat )? -> ^( IF ifStat ( elseIfStat )* ( elseStat )? ) )
            // src/main/org/uva/sea/ql/parser/QL.g:54:6: ifStat ( elseIfStat )* ( elseStat )?
            {
            pushFollow(FOLLOW_ifStat_in_ifStatement194);
            ifStat8=ifStat();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ifStat.add(ifStat8.getTree());

            // src/main/org/uva/sea/ql/parser/QL.g:54:13: ( elseIfStat )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==37) ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1==39) ) {
                        alt3=1;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:54:13: elseIfStat
            	    {
            	    pushFollow(FOLLOW_elseIfStat_in_ifStatement196);
            	    elseIfStat9=elseIfStat();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_elseIfStat.add(elseIfStat9.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // src/main/org/uva/sea/ql/parser/QL.g:54:25: ( elseStat )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==37) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // src/main/org/uva/sea/ql/parser/QL.g:54:25: elseStat
                    {
                    pushFollow(FOLLOW_elseStat_in_ifStatement199);
                    elseStat10=elseStat();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_elseStat.add(elseStat10.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: elseStat, elseIfStat, ifStat
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 54:35: -> ^( IF ifStat ( elseIfStat )* ( elseStat )? )
            {
                // src/main/org/uva/sea/ql/parser/QL.g:54:38: ^( IF ifStat ( elseIfStat )* ( elseStat )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IF, "IF")
                , root_1);

                adaptor.addChild(root_1, stream_ifStat.nextTree());

                // src/main/org/uva/sea/ql/parser/QL.g:54:50: ( elseIfStat )*
                while ( stream_elseIfStat.hasNext() ) {
                    adaptor.addChild(root_1, stream_elseIfStat.nextTree());

                }
                stream_elseIfStat.reset();

                // src/main/org/uva/sea/ql/parser/QL.g:54:62: ( elseStat )?
                if ( stream_elseStat.hasNext() ) {
                    adaptor.addChild(root_1, stream_elseStat.nextTree());

                }
                stream_elseStat.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, ifStatement_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "ifStatement"


    public static class ifStat_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ifStat"
    // src/main/org/uva/sea/ql/parser/QL.g:57:1: ifStat : 'if' expression '{' ( statementBlock )+ '}' -> ^( EXPRESSION expression ^( STATEMENTS ( statementBlock )+ ) ) ;
    public final QLParser.ifStat_return ifStat() throws RecognitionException {
        QLParser.ifStat_return retval = new QLParser.ifStat_return();
        retval.start = input.LT(1);

        int ifStat_StartIndex = input.index();

        CommonTree root_0 = null;

        Token string_literal11=null;
        Token char_literal13=null;
        Token char_literal15=null;
        QLParser.expression_return expression12 =null;

        QLParser.statementBlock_return statementBlock14 =null;


        CommonTree string_literal11_tree=null;
        CommonTree char_literal13_tree=null;
        CommonTree char_literal15_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_statementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementBlock");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:58:5: ( 'if' expression '{' ( statementBlock )+ '}' -> ^( EXPRESSION expression ^( STATEMENTS ( statementBlock )+ ) ) )
            // src/main/org/uva/sea/ql/parser/QL.g:58:9: 'if' expression '{' ( statementBlock )+ '}'
            {
            string_literal11=(Token)match(input,39,FOLLOW_39_in_ifStat230); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_39.add(string_literal11);


            pushFollow(FOLLOW_expression_in_ifStat232);
            expression12=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(expression12.getTree());

            char_literal13=(Token)match(input,43,FOLLOW_43_in_ifStat234); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_43.add(char_literal13);


            // src/main/org/uva/sea/ql/parser/QL.g:58:29: ( statementBlock )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==Identifier||LA5_0==39) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:58:29: statementBlock
            	    {
            	    pushFollow(FOLLOW_statementBlock_in_ifStat236);
            	    statementBlock14=statementBlock();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statementBlock.add(statementBlock14.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            char_literal15=(Token)match(input,45,FOLLOW_45_in_ifStat239); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_45.add(char_literal15);


            // AST REWRITE
            // elements: statementBlock, expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 58:49: -> ^( EXPRESSION expression ^( STATEMENTS ( statementBlock )+ ) )
            {
                // src/main/org/uva/sea/ql/parser/QL.g:58:52: ^( EXPRESSION expression ^( STATEMENTS ( statementBlock )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(EXPRESSION, "EXPRESSION")
                , root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());

                // src/main/org/uva/sea/ql/parser/QL.g:58:76: ^( STATEMENTS ( statementBlock )+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(STATEMENTS, "STATEMENTS")
                , root_2);

                if ( !(stream_statementBlock.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_statementBlock.hasNext() ) {
                    adaptor.addChild(root_2, stream_statementBlock.nextTree());

                }
                stream_statementBlock.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, ifStat_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "ifStat"


    public static class elseIfStat_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "elseIfStat"
    // src/main/org/uva/sea/ql/parser/QL.g:61:1: elseIfStat : 'else' 'if' expression '{' ( statementBlock )+ '}' -> ^( EXPRESSION expression ^( STATEMENTS ( statementBlock )+ ) ) ;
    public final QLParser.elseIfStat_return elseIfStat() throws RecognitionException {
        QLParser.elseIfStat_return retval = new QLParser.elseIfStat_return();
        retval.start = input.LT(1);

        int elseIfStat_StartIndex = input.index();

        CommonTree root_0 = null;

        Token string_literal16=null;
        Token string_literal17=null;
        Token char_literal19=null;
        Token char_literal21=null;
        QLParser.expression_return expression18 =null;

        QLParser.statementBlock_return statementBlock20 =null;


        CommonTree string_literal16_tree=null;
        CommonTree string_literal17_tree=null;
        CommonTree char_literal19_tree=null;
        CommonTree char_literal21_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_statementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementBlock");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:62:5: ( 'else' 'if' expression '{' ( statementBlock )+ '}' -> ^( EXPRESSION expression ^( STATEMENTS ( statementBlock )+ ) ) )
            // src/main/org/uva/sea/ql/parser/QL.g:62:9: 'else' 'if' expression '{' ( statementBlock )+ '}'
            {
            string_literal16=(Token)match(input,37,FOLLOW_37_in_elseIfStat273); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_37.add(string_literal16);


            string_literal17=(Token)match(input,39,FOLLOW_39_in_elseIfStat275); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_39.add(string_literal17);


            pushFollow(FOLLOW_expression_in_elseIfStat277);
            expression18=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(expression18.getTree());

            char_literal19=(Token)match(input,43,FOLLOW_43_in_elseIfStat279); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_43.add(char_literal19);


            // src/main/org/uva/sea/ql/parser/QL.g:62:36: ( statementBlock )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==Identifier||LA6_0==39) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:62:36: statementBlock
            	    {
            	    pushFollow(FOLLOW_statementBlock_in_elseIfStat281);
            	    statementBlock20=statementBlock();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statementBlock.add(statementBlock20.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            char_literal21=(Token)match(input,45,FOLLOW_45_in_elseIfStat284); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_45.add(char_literal21);


            // AST REWRITE
            // elements: expression, statementBlock
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 62:56: -> ^( EXPRESSION expression ^( STATEMENTS ( statementBlock )+ ) )
            {
                // src/main/org/uva/sea/ql/parser/QL.g:62:59: ^( EXPRESSION expression ^( STATEMENTS ( statementBlock )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(EXPRESSION, "EXPRESSION")
                , root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());

                // src/main/org/uva/sea/ql/parser/QL.g:62:83: ^( STATEMENTS ( statementBlock )+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(STATEMENTS, "STATEMENTS")
                , root_2);

                if ( !(stream_statementBlock.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_statementBlock.hasNext() ) {
                    adaptor.addChild(root_2, stream_statementBlock.nextTree());

                }
                stream_statementBlock.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, elseIfStat_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "elseIfStat"


    public static class elseStat_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "elseStat"
    // src/main/org/uva/sea/ql/parser/QL.g:65:1: elseStat : 'else' '{' ( statementBlock )+ '}' -> ^( EXPRESSION ^( STATEMENTS ( statementBlock )+ ) ) ;
    public final QLParser.elseStat_return elseStat() throws RecognitionException {
        QLParser.elseStat_return retval = new QLParser.elseStat_return();
        retval.start = input.LT(1);

        int elseStat_StartIndex = input.index();

        CommonTree root_0 = null;

        Token string_literal22=null;
        Token char_literal23=null;
        Token char_literal25=null;
        QLParser.statementBlock_return statementBlock24 =null;


        CommonTree string_literal22_tree=null;
        CommonTree char_literal23_tree=null;
        CommonTree char_literal25_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleSubtreeStream stream_statementBlock=new RewriteRuleSubtreeStream(adaptor,"rule statementBlock");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:66:5: ( 'else' '{' ( statementBlock )+ '}' -> ^( EXPRESSION ^( STATEMENTS ( statementBlock )+ ) ) )
            // src/main/org/uva/sea/ql/parser/QL.g:66:9: 'else' '{' ( statementBlock )+ '}'
            {
            string_literal22=(Token)match(input,37,FOLLOW_37_in_elseStat318); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_37.add(string_literal22);


            char_literal23=(Token)match(input,43,FOLLOW_43_in_elseStat320); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_43.add(char_literal23);


            // src/main/org/uva/sea/ql/parser/QL.g:66:20: ( statementBlock )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==Identifier||LA7_0==39) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:66:20: statementBlock
            	    {
            	    pushFollow(FOLLOW_statementBlock_in_elseStat322);
            	    statementBlock24=statementBlock();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statementBlock.add(statementBlock24.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            char_literal25=(Token)match(input,45,FOLLOW_45_in_elseStat325); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_45.add(char_literal25);


            // AST REWRITE
            // elements: statementBlock
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 66:40: -> ^( EXPRESSION ^( STATEMENTS ( statementBlock )+ ) )
            {
                // src/main/org/uva/sea/ql/parser/QL.g:66:43: ^( EXPRESSION ^( STATEMENTS ( statementBlock )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(EXPRESSION, "EXPRESSION")
                , root_1);

                // src/main/org/uva/sea/ql/parser/QL.g:66:56: ^( STATEMENTS ( statementBlock )+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(STATEMENTS, "STATEMENTS")
                , root_2);

                if ( !(stream_statementBlock.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_statementBlock.hasNext() ) {
                    adaptor.addChild(root_2, stream_statementBlock.nextTree());

                }
                stream_statementBlock.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, elseStat_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "elseStat"


    public static class assignmentStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assignmentStatement"
    // src/main/org/uva/sea/ql/parser/QL.g:69:1: assignmentStatement : Identifier ':' StringLiteral type -> ^( ASSIGNMENT Identifier type ) ;
    public final QLParser.assignmentStatement_return assignmentStatement() throws RecognitionException {
        QLParser.assignmentStatement_return retval = new QLParser.assignmentStatement_return();
        retval.start = input.LT(1);

        int assignmentStatement_StartIndex = input.index();

        CommonTree root_0 = null;

        Token Identifier26=null;
        Token char_literal27=null;
        Token StringLiteral28=null;
        QLParser.type_return type29 =null;


        CommonTree Identifier26_tree=null;
        CommonTree char_literal27_tree=null;
        CommonTree StringLiteral28_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_30=new RewriteRuleTokenStream(adaptor,"token 30");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:70:2: ( Identifier ':' StringLiteral type -> ^( ASSIGNMENT Identifier type ) )
            // src/main/org/uva/sea/ql/parser/QL.g:70:4: Identifier ':' StringLiteral type
            {
            Identifier26=(Token)match(input,Identifier,FOLLOW_Identifier_in_assignmentStatement352); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Identifier.add(Identifier26);


            char_literal27=(Token)match(input,30,FOLLOW_30_in_assignmentStatement354); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_30.add(char_literal27);


            StringLiteral28=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_assignmentStatement356); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_StringLiteral.add(StringLiteral28);


            pushFollow(FOLLOW_type_in_assignmentStatement358);
            type29=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_type.add(type29.getTree());

            // AST REWRITE
            // elements: Identifier, type
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 70:38: -> ^( ASSIGNMENT Identifier type )
            {
                // src/main/org/uva/sea/ql/parser/QL.g:70:41: ^( ASSIGNMENT Identifier type )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ASSIGNMENT, "ASSIGNMENT")
                , root_1);

                adaptor.addChild(root_1, 
                stream_Identifier.nextNode()
                );

                adaptor.addChild(root_1, stream_type.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, assignmentStatement_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "assignmentStatement"


    public static class type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // src/main/org/uva/sea/ql/parser/QL.g:73:1: type : ( 'boolean' | 'integer' | 'string' | 'money' );
    public final QLParser.type_return type() throws RecognitionException {
        QLParser.type_return retval = new QLParser.type_return();
        retval.start = input.LT(1);

        int type_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set30=null;

        CommonTree set30_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:74:2: ( 'boolean' | 'integer' | 'string' | 'money' )
            // src/main/org/uva/sea/ql/parser/QL.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set30=(Token)input.LT(1);

            if ( input.LA(1)==36||(input.LA(1) >= 40 && input.LA(1) <= 42) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set30)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, type_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "type"


    public static class terminal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "terminal"
    // src/main/org/uva/sea/ql/parser/QL.g:80:1: terminal : ( Boolean | Integer | StringLiteral | Money | Identifier | '(' ! expression ')' !);
    public final QLParser.terminal_return terminal() throws RecognitionException {
        QLParser.terminal_return retval = new QLParser.terminal_return();
        retval.start = input.LT(1);

        int terminal_StartIndex = input.index();

        CommonTree root_0 = null;

        Token Boolean31=null;
        Token Integer32=null;
        Token StringLiteral33=null;
        Token Money34=null;
        Token Identifier35=null;
        Token char_literal36=null;
        Token char_literal38=null;
        QLParser.expression_return expression37 =null;


        CommonTree Boolean31_tree=null;
        CommonTree Integer32_tree=null;
        CommonTree StringLiteral33_tree=null;
        CommonTree Money34_tree=null;
        CommonTree Identifier35_tree=null;
        CommonTree char_literal36_tree=null;
        CommonTree char_literal38_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:81:2: ( Boolean | Integer | StringLiteral | Money | Identifier | '(' ! expression ')' !)
            int alt8=6;
            switch ( input.LA(1) ) {
            case Boolean:
                {
                alt8=1;
                }
                break;
            case Integer:
                {
                alt8=2;
                }
                break;
            case StringLiteral:
                {
                alt8=3;
                }
                break;
            case Money:
                {
                alt8=4;
                }
                break;
            case Identifier:
                {
                alt8=5;
                }
                break;
            case 24:
                {
                alt8=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // src/main/org/uva/sea/ql/parser/QL.g:81:6: Boolean
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    Boolean31=(Token)match(input,Boolean,FOLLOW_Boolean_in_terminal410); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Boolean31_tree = 
                    (CommonTree)adaptor.create(Boolean31)
                    ;
                    adaptor.addChild(root_0, Boolean31_tree);
                    }

                    }
                    break;
                case 2 :
                    // src/main/org/uva/sea/ql/parser/QL.g:82:4: Integer
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    Integer32=(Token)match(input,Integer,FOLLOW_Integer_in_terminal415); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Integer32_tree = 
                    (CommonTree)adaptor.create(Integer32)
                    ;
                    adaptor.addChild(root_0, Integer32_tree);
                    }

                    }
                    break;
                case 3 :
                    // src/main/org/uva/sea/ql/parser/QL.g:83:6: StringLiteral
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    StringLiteral33=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_terminal422); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    StringLiteral33_tree = 
                    (CommonTree)adaptor.create(StringLiteral33)
                    ;
                    adaptor.addChild(root_0, StringLiteral33_tree);
                    }

                    }
                    break;
                case 4 :
                    // src/main/org/uva/sea/ql/parser/QL.g:84:6: Money
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    Money34=(Token)match(input,Money,FOLLOW_Money_in_terminal429); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Money34_tree = 
                    (CommonTree)adaptor.create(Money34)
                    ;
                    adaptor.addChild(root_0, Money34_tree);
                    }

                    }
                    break;
                case 5 :
                    // src/main/org/uva/sea/ql/parser/QL.g:85:4: Identifier
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    Identifier35=(Token)match(input,Identifier,FOLLOW_Identifier_in_terminal434); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Identifier35_tree = 
                    (CommonTree)adaptor.create(Identifier35)
                    ;
                    adaptor.addChild(root_0, Identifier35_tree);
                    }

                    }
                    break;
                case 6 :
                    // src/main/org/uva/sea/ql/parser/QL.g:86:4: '(' ! expression ')' !
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    char_literal36=(Token)match(input,24,FOLLOW_24_in_terminal439); if (state.failed) return retval;

                    pushFollow(FOLLOW_expression_in_terminal442);
                    expression37=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression37.getTree());

                    char_literal38=(Token)match(input,25,FOLLOW_25_in_terminal444); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, terminal_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "terminal"


    public static class unary_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "unary"
    // src/main/org/uva/sea/ql/parser/QL.g:89:1: unary : ( '!' terminal -> ^( NOT terminal ) | '-' terminal -> ^( NEGATION terminal ) | '+' ! terminal | terminal );
    public final QLParser.unary_return unary() throws RecognitionException {
        QLParser.unary_return retval = new QLParser.unary_return();
        retval.start = input.LT(1);

        int unary_StartIndex = input.index();

        CommonTree root_0 = null;

        Token char_literal39=null;
        Token char_literal41=null;
        Token char_literal43=null;
        QLParser.terminal_return terminal40 =null;

        QLParser.terminal_return terminal42 =null;

        QLParser.terminal_return terminal44 =null;

        QLParser.terminal_return terminal45 =null;


        CommonTree char_literal39_tree=null;
        CommonTree char_literal41_tree=null;
        CommonTree char_literal43_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_28=new RewriteRuleTokenStream(adaptor,"token 28");
        RewriteRuleSubtreeStream stream_terminal=new RewriteRuleSubtreeStream(adaptor,"rule terminal");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:90:2: ( '!' terminal -> ^( NOT terminal ) | '-' terminal -> ^( NEGATION terminal ) | '+' ! terminal | terminal )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt9=1;
                }
                break;
            case 28:
                {
                alt9=2;
                }
                break;
            case 27:
                {
                alt9=3;
                }
                break;
            case Boolean:
            case Identifier:
            case Integer:
            case Money:
            case StringLiteral:
            case 24:
                {
                alt9=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }

            switch (alt9) {
                case 1 :
                    // src/main/org/uva/sea/ql/parser/QL.g:90:6: '!' terminal
                    {
                    char_literal39=(Token)match(input,21,FOLLOW_21_in_unary458); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_21.add(char_literal39);


                    pushFollow(FOLLOW_terminal_in_unary460);
                    terminal40=terminal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_terminal.add(terminal40.getTree());

                    // AST REWRITE
                    // elements: terminal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 90:19: -> ^( NOT terminal )
                    {
                        // src/main/org/uva/sea/ql/parser/QL.g:90:22: ^( NOT terminal )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(NOT, "NOT")
                        , root_1);

                        adaptor.addChild(root_1, stream_terminal.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // src/main/org/uva/sea/ql/parser/QL.g:91:6: '-' terminal
                    {
                    char_literal41=(Token)match(input,28,FOLLOW_28_in_unary475); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_28.add(char_literal41);


                    pushFollow(FOLLOW_terminal_in_unary477);
                    terminal42=terminal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_terminal.add(terminal42.getTree());

                    // AST REWRITE
                    // elements: terminal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 91:19: -> ^( NEGATION terminal )
                    {
                        // src/main/org/uva/sea/ql/parser/QL.g:91:22: ^( NEGATION terminal )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(NEGATION, "NEGATION")
                        , root_1);

                        adaptor.addChild(root_1, stream_terminal.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // src/main/org/uva/sea/ql/parser/QL.g:92:6: '+' ! terminal
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    char_literal43=(Token)match(input,27,FOLLOW_27_in_unary492); if (state.failed) return retval;

                    pushFollow(FOLLOW_terminal_in_unary495);
                    terminal44=terminal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, terminal44.getTree());

                    }
                    break;
                case 4 :
                    // src/main/org/uva/sea/ql/parser/QL.g:93:6: terminal
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_terminal_in_unary502);
                    terminal45=terminal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, terminal45.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, unary_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "unary"


    public static class mult_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mult"
    // src/main/org/uva/sea/ql/parser/QL.g:96:1: mult : unary ( ( '*' | '/' ) ^ unary )* ;
    public final QLParser.mult_return mult() throws RecognitionException {
        QLParser.mult_return retval = new QLParser.mult_return();
        retval.start = input.LT(1);

        int mult_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set47=null;
        QLParser.unary_return unary46 =null;

        QLParser.unary_return unary48 =null;


        CommonTree set47_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:97:2: ( unary ( ( '*' | '/' ) ^ unary )* )
            // src/main/org/uva/sea/ql/parser/QL.g:97:4: unary ( ( '*' | '/' ) ^ unary )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_unary_in_mult513);
            unary46=unary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unary46.getTree());

            // src/main/org/uva/sea/ql/parser/QL.g:97:10: ( ( '*' | '/' ) ^ unary )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==26||LA10_0==29) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:97:11: ( '*' | '/' ) ^ unary
            	    {
            	    set47=(Token)input.LT(1);

            	    set47=(Token)input.LT(1);

            	    if ( input.LA(1)==26||input.LA(1)==29 ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(
            	        (CommonTree)adaptor.create(set47)
            	        , root_0);
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unary_in_mult525);
            	    unary48=unary();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unary48.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, mult_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "mult"


    public static class add_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "add"
    // src/main/org/uva/sea/ql/parser/QL.g:100:1: add : mult ( ( '+' | '-' ) ^ mult )* ;
    public final QLParser.add_return add() throws RecognitionException {
        QLParser.add_return retval = new QLParser.add_return();
        retval.start = input.LT(1);

        int add_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set50=null;
        QLParser.mult_return mult49 =null;

        QLParser.mult_return mult51 =null;


        CommonTree set50_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:101:2: ( mult ( ( '+' | '-' ) ^ mult )* )
            // src/main/org/uva/sea/ql/parser/QL.g:101:4: mult ( ( '+' | '-' ) ^ mult )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_mult_in_add538);
            mult49=mult();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mult49.getTree());

            // src/main/org/uva/sea/ql/parser/QL.g:101:9: ( ( '+' | '-' ) ^ mult )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0 >= 27 && LA11_0 <= 28)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:101:10: ( '+' | '-' ) ^ mult
            	    {
            	    set50=(Token)input.LT(1);

            	    set50=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 27 && input.LA(1) <= 28) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(
            	        (CommonTree)adaptor.create(set50)
            	        , root_0);
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mult_in_add550);
            	    mult51=mult();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, mult51.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, add_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "add"


    public static class relation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "relation"
    // src/main/org/uva/sea/ql/parser/QL.g:104:1: relation : add ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) ^ add )* ;
    public final QLParser.relation_return relation() throws RecognitionException {
        QLParser.relation_return retval = new QLParser.relation_return();
        retval.start = input.LT(1);

        int relation_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set53=null;
        QLParser.add_return add52 =null;

        QLParser.add_return add54 =null;


        CommonTree set53_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:105:2: ( add ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) ^ add )* )
            // src/main/org/uva/sea/ql/parser/QL.g:105:4: add ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) ^ add )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_add_in_relation563);
            add52=add();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, add52.getTree());

            // src/main/org/uva/sea/ql/parser/QL.g:105:8: ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) ^ add )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==22||(LA12_0 >= 31 && LA12_0 <= 35)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:105:9: ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) ^ add
            	    {
            	    set53=(Token)input.LT(1);

            	    set53=(Token)input.LT(1);

            	    if ( input.LA(1)==22||(input.LA(1) >= 31 && input.LA(1) <= 35) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(
            	        (CommonTree)adaptor.create(set53)
            	        , root_0);
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_add_in_relation591);
            	    add54=add();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, add54.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, relation_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "relation"


    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expression"
    // src/main/org/uva/sea/ql/parser/QL.g:108:1: expression : relation ( ( '&&' | '||' ) ^ relation )* ;
    public final QLParser.expression_return expression() throws RecognitionException {
        QLParser.expression_return retval = new QLParser.expression_return();
        retval.start = input.LT(1);

        int expression_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set56=null;
        QLParser.relation_return relation55 =null;

        QLParser.relation_return relation57 =null;


        CommonTree set56_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:109:2: ( relation ( ( '&&' | '||' ) ^ relation )* )
            // src/main/org/uva/sea/ql/parser/QL.g:109:4: relation ( ( '&&' | '||' ) ^ relation )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_relation_in_expression604);
            relation55=relation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relation55.getTree());

            // src/main/org/uva/sea/ql/parser/QL.g:109:13: ( ( '&&' | '||' ) ^ relation )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==23||LA13_0==44) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:109:14: ( '&&' | '||' ) ^ relation
            	    {
            	    set56=(Token)input.LT(1);

            	    set56=(Token)input.LT(1);

            	    if ( input.LA(1)==23||input.LA(1)==44 ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(
            	        (CommonTree)adaptor.create(set56)
            	        , root_0);
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_relation_in_expression616);
            	    relation57=relation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relation57.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, expression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "expression"

    // Delegated rules


 

    public static final BitSet FOLLOW_38_in_form140 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_Identifier_in_form142 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_form144 = new BitSet(new long[]{0x0000208000000800L});
    public static final BitSet FOLLOW_statementBlock_in_form146 = new BitSet(new long[]{0x0000208000000800L});
    public static final BitSet FOLLOW_45_in_form149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statementBlock175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_statementBlock181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStat_in_ifStatement194 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_elseIfStat_in_ifStatement196 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_elseStat_in_ifStatement199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ifStat230 = new BitSet(new long[]{0x0000000019285820L});
    public static final BitSet FOLLOW_expression_in_ifStat232 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ifStat234 = new BitSet(new long[]{0x0000008000000800L});
    public static final BitSet FOLLOW_statementBlock_in_ifStat236 = new BitSet(new long[]{0x0000208000000800L});
    public static final BitSet FOLLOW_45_in_ifStat239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_elseIfStat273 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_elseIfStat275 = new BitSet(new long[]{0x0000000019285820L});
    public static final BitSet FOLLOW_expression_in_elseIfStat277 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_elseIfStat279 = new BitSet(new long[]{0x0000008000000800L});
    public static final BitSet FOLLOW_statementBlock_in_elseIfStat281 = new BitSet(new long[]{0x0000208000000800L});
    public static final BitSet FOLLOW_45_in_elseIfStat284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_elseStat318 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_elseStat320 = new BitSet(new long[]{0x0000008000000800L});
    public static final BitSet FOLLOW_statementBlock_in_elseStat322 = new BitSet(new long[]{0x0000208000000800L});
    public static final BitSet FOLLOW_45_in_elseStat325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_assignmentStatement352 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_assignmentStatement354 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_StringLiteral_in_assignmentStatement356 = new BitSet(new long[]{0x0000071000000000L});
    public static final BitSet FOLLOW_type_in_assignmentStatement358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Boolean_in_terminal410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Integer_in_terminal415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_terminal422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Money_in_terminal429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_terminal434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_terminal439 = new BitSet(new long[]{0x0000000019285820L});
    public static final BitSet FOLLOW_expression_in_terminal442 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_terminal444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_unary458 = new BitSet(new long[]{0x0000000001085820L});
    public static final BitSet FOLLOW_terminal_in_unary460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_unary475 = new BitSet(new long[]{0x0000000001085820L});
    public static final BitSet FOLLOW_terminal_in_unary477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_unary492 = new BitSet(new long[]{0x0000000001085820L});
    public static final BitSet FOLLOW_terminal_in_unary495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_terminal_in_unary502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_in_mult513 = new BitSet(new long[]{0x0000000024000002L});
    public static final BitSet FOLLOW_set_in_mult516 = new BitSet(new long[]{0x0000000019285820L});
    public static final BitSet FOLLOW_unary_in_mult525 = new BitSet(new long[]{0x0000000024000002L});
    public static final BitSet FOLLOW_mult_in_add538 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_set_in_add541 = new BitSet(new long[]{0x0000000019285820L});
    public static final BitSet FOLLOW_mult_in_add550 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_add_in_relation563 = new BitSet(new long[]{0x0000000F80400002L});
    public static final BitSet FOLLOW_set_in_relation566 = new BitSet(new long[]{0x0000000019285820L});
    public static final BitSet FOLLOW_add_in_relation591 = new BitSet(new long[]{0x0000000F80400002L});
    public static final BitSet FOLLOW_relation_in_expression604 = new BitSet(new long[]{0x0000100000800002L});
    public static final BitSet FOLLOW_set_in_expression607 = new BitSet(new long[]{0x0000000019285820L});
    public static final BitSet FOLLOW_relation_in_expression616 = new BitSet(new long[]{0x0000100000800002L});

}