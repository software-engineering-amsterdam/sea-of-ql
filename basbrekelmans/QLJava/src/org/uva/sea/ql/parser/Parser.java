// Output created by jacc on Mon Feb 25 14:32:07 CET 2013

package org.uva.sea.ql.parser;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expressions.Addition;
import org.uva.sea.ql.ast.expressions.And;
import org.uva.sea.ql.ast.expressions.BooleanLiteral;
import org.uva.sea.ql.ast.expressions.Division;
import org.uva.sea.ql.ast.expressions.Equals;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.GreaterThan;
import org.uva.sea.ql.ast.expressions.GreaterThanOrEquals;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.expressions.LessThan;
import org.uva.sea.ql.ast.expressions.LessThanOrEquals;
import org.uva.sea.ql.ast.expressions.Multiplication;
import org.uva.sea.ql.ast.expressions.NotEquals;
import org.uva.sea.ql.ast.expressions.Or;
import org.uva.sea.ql.ast.expressions.StringLiteral;
import org.uva.sea.ql.ast.expressions.Subtraction;
import org.uva.sea.ql.ast.expressions.UnaryMinus;
import org.uva.sea.ql.ast.expressions.UnaryNot;
import org.uva.sea.ql.ast.expressions.UnaryPlus;
import org.uva.sea.ql.ast.expressions.Xor;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.ast.statements.If;
import org.uva.sea.ql.ast.statements.IfElse;
import org.uva.sea.ql.ast.statements.InputQuestion;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.statements.Statements;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.TypeNode;

class Parser implements Tokens {
	private final int yyss = 100;
	private int yytok;
	private int yysp = 0;
	private int[] yyst;
	protected int yyerrno = -1;
	private org.uva.sea.ql.ast.Node[] yysv;
	private org.uva.sea.ql.ast.Node yyrv;

	protected String[] yyerrmsgs = {};

	private final Lexer lexer;

	private Node result;

	public Parser(final Lexer lexer) {
		this.lexer = lexer;
	}

	public Node getResult() {
		return this.result;
	}

	public boolean parse() {
		int yyn = 0;
		this.yysp = 0;
		this.yyst = new int[this.yyss];
		this.yysv = new org.uva.sea.ql.ast.Node[this.yyss];
		this.yytok = this.lexer.getToken();

		for (;;) {
			switch (yyn) {
			case 0:
				this.yyst[this.yysp] = 0;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 84:
				yyn = this.yys0();
				continue;

			case 1:
				this.yyst[this.yysp] = 1;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 85:
				switch (this.yytok) {
				case ENDINPUT:
					yyn = 168;
					continue;
				}
				yyn = 171;
				continue;

			case 2:
				this.yyst[this.yysp] = 2;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 86:
				yyn = this.yys2();
				continue;

			case 3:
				this.yyst[this.yysp] = 3;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 87:
				yyn = this.yys3();
				continue;

			case 4:
				this.yyst[this.yysp] = 4;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 88:
				yyn = this.yys4();
				continue;

			case 5:
				this.yyst[this.yysp] = 5;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 89:
				switch (this.yytok) {
				case ENDINPUT:
					yyn = this.yyr3();
					continue;
				}
				yyn = 171;
				continue;

			case 6:
				this.yyst[this.yysp] = 6;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 90:
				switch (this.yytok) {
				case IF:
				case ENDINPUT:
				case '}':
				case STRINGLITERAL:
					yyn = this.yyr9();
					continue;
				}
				yyn = 171;
				continue;

			case 7:
				this.yyst[this.yysp] = 7;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 91:
				yyn = this.yys7();
				continue;

			case 8:
				this.yyst[this.yysp] = 8;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 92:
				switch (this.yytok) {
				case ENDINPUT:
					yyn = this.yyr1();
					continue;
				}
				yyn = 171;
				continue;

			case 9:
				this.yyst[this.yysp] = 9;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 93:
				switch (this.yytok) {
				case IF:
				case ENDINPUT:
				case '}':
				case STRINGLITERAL:
					yyn = this.yyr12();
					continue;
				}
				yyn = 171;
				continue;

			case 10:
				this.yyst[this.yysp] = 10;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 94:
				yyn = this.yys10();
				continue;

			case 11:
				this.yyst[this.yysp] = 11;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 95:
				switch (this.yytok) {
				case IF:
				case ENDINPUT:
				case '}':
				case STRINGLITERAL:
					yyn = this.yyr8();
					continue;
				}
				yyn = 171;
				continue;

			case 12:
				this.yyst[this.yysp] = 12;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 96:
				switch (this.yytok) {
				case IF:
					yyn = 19;
					continue;
				case STRINGLITERAL:
					yyn = 41;
					continue;
				case ENDINPUT:
				case '}':
					yyn = this.yyr7();
					continue;
				}
				yyn = 171;
				continue;

			case 13:
				this.yyst[this.yysp] = 13;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 97:
				switch (this.yytok) {
				case ENDINPUT:
					yyn = this.yyr4();
					continue;
				}
				yyn = 171;
				continue;

			case 14:
				this.yyst[this.yysp] = 14;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 98:
				yyn = this.yys14();
				continue;

			case 15:
				this.yyst[this.yysp] = 15;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 99:
				yyn = this.yys15();
				continue;

			case 16:
				this.yyst[this.yysp] = 16;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 100:
				yyn = this.yys16();
				continue;

			case 17:
				this.yyst[this.yysp] = 17;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 101:
				switch (this.yytok) {
				case STRINGLITERAL:
					yyn = 42;
					continue;
				}
				yyn = 171;
				continue;

			case 18:
				this.yyst[this.yysp] = 18;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 102:
				yyn = this.yys18();
				continue;

			case 19:
				this.yyst[this.yysp] = 19;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 103:
				switch (this.yytok) {
				case '(':
					yyn = 43;
					continue;
				}
				yyn = 171;
				continue;

			case 20:
				this.yyst[this.yysp] = 20;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 104:
				yyn = this.yys20();
				continue;

			case 21:
				this.yyst[this.yysp] = 21;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 105:
				yyn = this.yys21();
				continue;

			case 22:
				this.yyst[this.yysp] = 22;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 106:
				yyn = this.yys22();
				continue;

			case 23:
				this.yyst[this.yysp] = 23;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 107:
				yyn = this.yys23();
				continue;

			case 24:
				this.yyst[this.yysp] = 24;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 108:
				yyn = this.yys24();
				continue;

			case 25:
				this.yyst[this.yysp] = 25;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 109:
				yyn = this.yys25();
				continue;

			case 26:
				this.yyst[this.yysp] = 26;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 110:
				yyn = this.yys26();
				continue;

			case 27:
				this.yyst[this.yysp] = 27;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 111:
				yyn = this.yys27();
				continue;

			case 28:
				this.yyst[this.yysp] = 28;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 112:
				yyn = this.yys28();
				continue;

			case 29:
				this.yyst[this.yysp] = 29;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 113:
				yyn = this.yys29();
				continue;

			case 30:
				this.yyst[this.yysp] = 30;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 114:
				yyn = this.yys30();
				continue;

			case 31:
				this.yyst[this.yysp] = 31;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 115:
				yyn = this.yys31();
				continue;

			case 32:
				this.yyst[this.yysp] = 32;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 116:
				yyn = this.yys32();
				continue;

			case 33:
				this.yyst[this.yysp] = 33;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 117:
				yyn = this.yys33();
				continue;

			case 34:
				this.yyst[this.yysp] = 34;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 118:
				yyn = this.yys34();
				continue;

			case 35:
				this.yyst[this.yysp] = 35;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 119:
				yyn = this.yys35();
				continue;

			case 36:
				this.yyst[this.yysp] = 36;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 120:
				yyn = this.yys36();
				continue;

			case 37:
				this.yyst[this.yysp] = 37;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 121:
				yyn = this.yys37();
				continue;

			case 38:
				this.yyst[this.yysp] = 38;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 122:
				yyn = this.yys38();
				continue;

			case 39:
				this.yyst[this.yysp] = 39;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 123:
				yyn = this.yys39();
				continue;

			case 40:
				this.yyst[this.yysp] = 40;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 124:
				switch (this.yytok) {
				case ENDINPUT:
				case '}':
					yyn = this.yyr6();
					continue;
				}
				yyn = 171;
				continue;

			case 41:
				this.yyst[this.yysp] = 41;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 125:
				switch (this.yytok) {
				case IDENTIFIER:
					yyn = 44;
					continue;
				}
				yyn = 171;
				continue;

			case 42:
				this.yyst[this.yysp] = 42;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 126:
				switch (this.yytok) {
				case '{':
					yyn = 63;
					continue;
				}
				yyn = 171;
				continue;

			case 43:
				this.yyst[this.yysp] = 43;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 127:
				yyn = this.yys43();
				continue;

			case 44:
				this.yyst[this.yysp] = 44;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 128:
				switch (this.yytok) {
				case ':':
					yyn = 65;
					continue;
				case '=':
					yyn = 66;
					continue;
				}
				yyn = 171;
				continue;

			case 45:
				this.yyst[this.yysp] = 45;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 129:
				yyn = this.yys45();
				continue;

			case 46:
				this.yyst[this.yysp] = 46;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 130:
				yyn = this.yys46();
				continue;

			case 47:
				this.yyst[this.yysp] = 47;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 131:
				yyn = this.yys47();
				continue;

			case 48:
				this.yyst[this.yysp] = 48;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 132:
				yyn = this.yys48();
				continue;

			case 49:
				this.yyst[this.yysp] = 49;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 133:
				yyn = this.yys49();
				continue;

			case 50:
				this.yyst[this.yysp] = 50;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 134:
				yyn = this.yys50();
				continue;

			case 51:
				this.yyst[this.yysp] = 51;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 135:
				yyn = this.yys51();
				continue;

			case 52:
				this.yyst[this.yysp] = 52;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 136:
				yyn = this.yys52();
				continue;

			case 53:
				this.yyst[this.yysp] = 53;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 137:
				yyn = this.yys53();
				continue;

			case 54:
				this.yyst[this.yysp] = 54;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 138:
				yyn = this.yys54();
				continue;

			case 55:
				this.yyst[this.yysp] = 55;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 139:
				yyn = this.yys55();
				continue;

			case 56:
				this.yyst[this.yysp] = 56;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 140:
				yyn = this.yys56();
				continue;

			case 57:
				this.yyst[this.yysp] = 57;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 141:
				yyn = this.yys57();
				continue;

			case 58:
				this.yyst[this.yysp] = 58;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 142:
				yyn = this.yys58();
				continue;

			case 59:
				this.yyst[this.yysp] = 59;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 143:
				yyn = this.yys59();
				continue;

			case 60:
				this.yyst[this.yysp] = 60;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 144:
				yyn = this.yys60();
				continue;

			case 61:
				this.yyst[this.yysp] = 61;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 145:
				yyn = this.yys61();
				continue;

			case 62:
				this.yyst[this.yysp] = 62;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 146:
				yyn = this.yys62();
				continue;

			case 63:
				this.yyst[this.yysp] = 63;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 147:
				switch (this.yytok) {
				case IF:
					yyn = 19;
					continue;
				case STRINGLITERAL:
					yyn = 41;
					continue;
				}
				yyn = 171;
				continue;

			case 64:
				this.yyst[this.yysp] = 64;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 148:
				yyn = this.yys64();
				continue;

			case 65:
				this.yyst[this.yysp] = 65;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 149:
				switch (this.yytok) {
				case BOOLEAN:
					yyn = 71;
					continue;
				case INTEGER:
					yyn = 72;
					continue;
				case MONEY:
					yyn = 73;
					continue;
				case STRING:
					yyn = 74;
					continue;
				}
				yyn = 171;
				continue;

			case 66:
				this.yyst[this.yysp] = 66;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 150:
				yyn = this.yys66();
				continue;

			case 67:
				this.yyst[this.yysp] = 67;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 151:
				yyn = this.yys67();
				continue;

			case 68:
				this.yyst[this.yysp] = 68;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 152:
				switch (this.yytok) {
				case '}':
					yyn = 76;
					continue;
				}
				yyn = 171;
				continue;

			case 69:
				this.yyst[this.yysp] = 69;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 153:
				switch (this.yytok) {
				case '{':
					yyn = 77;
					continue;
				}
				yyn = 171;
				continue;

			case 70:
				this.yyst[this.yysp] = 70;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 154:
				switch (this.yytok) {
				case IF:
				case ENDINPUT:
				case '}':
				case STRINGLITERAL:
					yyn = this.yyr13();
					continue;
				}
				yyn = 171;
				continue;

			case 71:
				this.yyst[this.yysp] = 71;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 155:
				switch (this.yytok) {
				case IF:
				case ENDINPUT:
				case '}':
				case STRINGLITERAL:
					yyn = this.yyr15();
					continue;
				}
				yyn = 171;
				continue;

			case 72:
				this.yyst[this.yysp] = 72;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 156:
				switch (this.yytok) {
				case IF:
				case ENDINPUT:
				case '}':
				case STRINGLITERAL:
					yyn = this.yyr17();
					continue;
				}
				yyn = 171;
				continue;

			case 73:
				this.yyst[this.yysp] = 73;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 157:
				switch (this.yytok) {
				case IF:
				case ENDINPUT:
				case '}':
				case STRINGLITERAL:
					yyn = this.yyr18();
					continue;
				}
				yyn = 171;
				continue;

			case 74:
				this.yyst[this.yysp] = 74;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 158:
				switch (this.yytok) {
				case IF:
				case ENDINPUT:
				case '}':
				case STRINGLITERAL:
					yyn = this.yyr16();
					continue;
				}
				yyn = 171;
				continue;

			case 75:
				this.yyst[this.yysp] = 75;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 159:
				yyn = this.yys75();
				continue;

			case 76:
				this.yyst[this.yysp] = 76;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 160:
				switch (this.yytok) {
				case ENDINPUT:
					yyn = this.yyr5();
					continue;
				}
				yyn = 171;
				continue;

			case 77:
				this.yyst[this.yysp] = 77;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 161:
				switch (this.yytok) {
				case IF:
					yyn = 19;
					continue;
				case STRINGLITERAL:
					yyn = 41;
					continue;
				}
				yyn = 171;
				continue;

			case 78:
				this.yyst[this.yysp] = 78;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 162:
				switch (this.yytok) {
				case '}':
					yyn = 79;
					continue;
				}
				yyn = 171;
				continue;

			case 79:
				this.yyst[this.yysp] = 79;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 163:
				switch (this.yytok) {
				case ELSE:
					yyn = 80;
					continue;
				case IF:
				case ENDINPUT:
				case '}':
				case STRINGLITERAL:
					yyn = this.yyr10();
					continue;
				}
				yyn = 171;
				continue;

			case 80:
				this.yyst[this.yysp] = 80;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 164:
				switch (this.yytok) {
				case '{':
					yyn = 81;
					continue;
				}
				yyn = 171;
				continue;

			case 81:
				this.yyst[this.yysp] = 81;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 165:
				switch (this.yytok) {
				case IF:
					yyn = 19;
					continue;
				case STRINGLITERAL:
					yyn = 41;
					continue;
				}
				yyn = 171;
				continue;

			case 82:
				this.yyst[this.yysp] = 82;
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 166:
				switch (this.yytok) {
				case '}':
					yyn = 83;
					continue;
				}
				yyn = 171;
				continue;

			case 83:
				this.yyst[this.yysp] = 83;
				this.yysv[this.yysp] = this.lexer.getSemantic();
				this.yytok = this.lexer.nextToken();
				if (++this.yysp >= this.yyst.length) {
					this.yyexpand();
				}
			case 167:
				switch (this.yytok) {
				case IF:
				case ENDINPUT:
				case '}':
				case STRINGLITERAL:
					yyn = this.yyr11();
					continue;
				}
				yyn = 171;
				continue;

			case 168:
				return true;
			case 169:
				this.yyerror("stack overflow");
			case 170:
				return false;
			case 171:
				this.yyerror("syntax error");
				return false;
			}
		}
	}

	private void yyerror(final String msg) {
		final ICodeLocationInformation info = this.lexer.location();
		System.err.println(String.format(
				"'%s' near line %d, column %d in '%s'", msg,
				info.getLineNumber(), info.getColumn(), info.getFileName()));
	}

	protected void yyexpand() {
		final int[] newyyst = new int[2 * this.yyst.length];
		final org.uva.sea.ql.ast.Node[] newyysv = new org.uva.sea.ql.ast.Node[2 * this.yyst.length];
		for (int i = 0; i < this.yyst.length; i++) {
			newyyst[i] = this.yyst[i];
			newyysv[i] = this.yysv[i];
		}
		this.yyst = newyyst;
		this.yysv = newyysv;
	}

	private int yypexpression() {
		switch (this.yyst[this.yysp - 1]) {
		case 43:
			return 64;
		case 39:
			return 62;
		case 38:
			return 61;
		case 37:
			return 60;
		case 36:
			return 59;
		case 35:
			return 58;
		case 34:
			return 57;
		case 33:
			return 56;
		case 32:
			return 55;
		case 31:
			return 54;
		case 30:
			return 53;
		case 29:
			return 52;
		case 28:
			return 51;
		case 27:
			return 50;
		case 26:
			return 49;
		case 25:
			return 48;
		case 24:
			return 47;
		case 23:
			return 45;
		case 0:
			return 4;
		default:
			return 75;
		}
	}

	private int yypstatements() {
		switch (this.yyst[this.yysp - 1]) {
		case 77:
			return 78;
		case 63:
			return 68;
		case 12:
			return 40;
		case 0:
			return 13;
		default:
			return 82;
		}
	}

	private int yyr1() { // top : node
		{
			this.result = this.yysv[this.yysp - 1];
		}
		this.yysv[this.yysp -= 1] = this.yyrv;
		return 1;
	}

	private int yyr10() { // ifstatement : IF '(' expression ')' '{' statements
							// '}'
		{
			this.yyrv = new If(this.lexer.location(),
					(Expression) this.yysv[this.yysp - 5],
					(Statements) this.yysv[this.yysp - 2]);
		}
		this.yysv[this.yysp -= 7] = this.yyrv;
		return 6;
	}

	private int yyr11() { // ifstatement : IF '(' expression ')' '{' statements
							// '}' ELSE '{' statements '}'
		{
			this.yyrv = new IfElse(this.lexer.location(),
					(Expression) this.yysv[this.yysp - 9],
					(Statements) this.yysv[this.yysp - 6],
					(Statements) this.yysv[this.yysp - 2]);
		}
		this.yysv[this.yysp -= 11] = this.yyrv;
		return 6;
	}

	private int yyr12() { // simplestatement : question
		this.yysp -= 1;
		return 11;
	}

	private int yyr13() { // question : STRINGLITERAL IDENTIFIER ':' type
		{
			this.yyrv = new InputQuestion(this.lexer.location(),
					(StringLiteral) this.yysv[this.yysp - 4],
					(Identifier) this.yysv[this.yysp - 3],
					((TypeNode) this.yysv[this.yysp - 1]).getType());
		}
		this.yysv[this.yysp -= 4] = this.yyrv;
		return 9;
	}

	private int yyr14() { // question : STRINGLITERAL IDENTIFIER '=' expression
		{
			this.yyrv = new ComputedQuestion(this.lexer.location(),
					(StringLiteral) this.yysv[this.yysp - 4],
					(Identifier) this.yysv[this.yysp - 3],
					(Expression) this.yysv[this.yysp - 1]);
		}
		this.yysv[this.yysp -= 4] = this.yyrv;
		return 9;
	}

	private int yyr15() { // type : BOOLEAN
		{
			this.yyrv = new TypeNode(this.lexer.location(), Type.BOOLEAN);
		}
		this.yysv[this.yysp -= 1] = this.yyrv;
		return 70;
	}

	private int yyr16() { // type : STRING
		{
			this.yyrv = new TypeNode(this.lexer.location(), Type.STRING);
		}
		this.yysv[this.yysp -= 1] = this.yyrv;
		return 70;
	}

	private int yyr17() { // type : INTEGER
		{
			this.yyrv = new TypeNode(this.lexer.location(), Type.INTEGER);
		}
		this.yysv[this.yysp -= 1] = this.yyrv;
		return 70;
	}

	private int yyr18() { // type : MONEY
		{
			this.yyrv = new TypeNode(this.lexer.location(), Type.MONEY);
		}
		this.yysv[this.yysp -= 1] = this.yyrv;
		return 70;
	}

	private int yyr19() { // expression : unary
		{
			this.yyrv = this.yysv[this.yysp - 1];
		}
		this.yysv[this.yysp -= 1] = this.yyrv;
		return this.yypexpression();
	}

	private int yyr2() { // node : expression
		{
			this.yyrv = this.yysv[this.yysp - 1];
		}
		this.yysv[this.yysp -= 1] = this.yyrv;
		return 8;
	}

	private int yyr20() { // expression : logical
		{
			this.yyrv = this.yysv[this.yysp - 1];
		}
		this.yysv[this.yysp -= 1] = this.yyrv;
		return this.yypexpression();
	}

	private int yyr21() { // expression : arithmetic
		{
			this.yyrv = this.yysv[this.yysp - 1];
		}
		this.yysv[this.yysp -= 1] = this.yyrv;
		return this.yypexpression();
	}

	private int yyr22() { // expression : simple
		{
			this.yyrv = this.yysv[this.yysp - 1];
		}
		this.yysv[this.yysp -= 1] = this.yyrv;
		return this.yypexpression();
	}

	private int yyr23() { // expression : comparison
		{
			this.yyrv = this.yysv[this.yysp - 1];
		}
		this.yysv[this.yysp -= 1] = this.yyrv;
		return this.yypexpression();
	}

	private int yyr24() { // expression : '(' expression ')'
		{
			this.yyrv = this.yysv[this.yysp - 2];
		}
		this.yysv[this.yysp -= 3] = this.yyrv;
		return this.yypexpression();
	}

	private int yyr25() { // comparison : expression EQ expression
		{
			this.yyrv = new Equals(this.lexer.location(),
					(Expression) this.yysv[this.yysp - 3],
					(Expression) this.yysv[this.yysp - 1]);
		}
		this.yysv[this.yysp -= 3] = this.yyrv;
		return 3;
	}

	private int yyr26() { // comparison : expression NEQ expression
		{
			this.yyrv = new NotEquals(this.lexer.location(),
					(Expression) this.yysv[this.yysp - 3],
					(Expression) this.yysv[this.yysp - 1]);
		}
		this.yysv[this.yysp -= 3] = this.yyrv;
		return 3;
	}

	private int yyr27() { // comparison : expression '>' expression
		{
			this.yyrv = new GreaterThan(this.lexer.location(),
					(Expression) this.yysv[this.yysp - 3],
					(Expression) this.yysv[this.yysp - 1]);
		}
		this.yysv[this.yysp -= 3] = this.yyrv;
		return 3;
	}

	private int yyr28() { // comparison : expression GEQ expression
		{
			this.yyrv = new GreaterThanOrEquals(this.lexer.location(),
					(Expression) this.yysv[this.yysp - 3],
					(Expression) this.yysv[this.yysp - 1]);
		}
		this.yysv[this.yysp -= 3] = this.yyrv;
		return 3;
	}

	private int yyr29() { // comparison : expression '<' expression
		{
			this.yyrv = new LessThan(this.lexer.location(),
					(Expression) this.yysv[this.yysp - 3],
					(Expression) this.yysv[this.yysp - 1]);
		}
		this.yysv[this.yysp -= 3] = this.yyrv;
		return 3;
	}

	private int yyr3() { // node : form
		{
			this.yyrv = this.yysv[this.yysp - 1];
		}
		this.yysv[this.yysp -= 1] = this.yyrv;
		return 8;
	}

	private int yyr30() { // comparison : expression LEQ expression
		{
			this.yyrv = new LessThanOrEquals(this.lexer.location(),
					(Expression) this.yysv[this.yysp - 3],
					(Expression) this.yysv[this.yysp - 1]);
		}
		this.yysv[this.yysp -= 3] = this.yyrv;
		return 3;
	}

	private int yyr31() { // unary : '+' expression
		{
			this.yyrv = new UnaryPlus(this.lexer.location(),
					(Expression) this.yysv[this.yysp - 1]);
		}
		this.yysv[this.yysp -= 2] = this.yyrv;
		return 15;
	}

	private int yyr32() { // unary : '-' expression
		{
			this.yyrv = new UnaryMinus(this.lexer.location(),
					(Expression) this.yysv[this.yysp - 1]);
		}
		this.yysv[this.yysp -= 2] = this.yyrv;
		return 15;
	}

	private int yyr33() { // unary : '!' expression
		{
			this.yyrv = new UnaryNot(this.lexer.location(),
					(Expression) this.yysv[this.yysp - 1]);
		}
		this.yysv[this.yysp -= 2] = this.yyrv;
		return 15;
	}

	private int yyr34() { // logical : expression AND expression
		{
			this.yyrv = new And(this.lexer.location(),
					(Expression) this.yysv[this.yysp - 3],
					(Expression) this.yysv[this.yysp - 1]);
		}
		this.yysv[this.yysp -= 3] = this.yyrv;
		return 7;
	}

	private int yyr35() { // logical : expression OR expression
		{
			this.yyrv = new Or(this.lexer.location(),
					(Expression) this.yysv[this.yysp - 3],
					(Expression) this.yysv[this.yysp - 1]);
		}
		this.yysv[this.yysp -= 3] = this.yyrv;
		return 7;
	}

	private int yyr36() { // logical : expression '^' expression
		{
			this.yyrv = new Xor(this.lexer.location(),
					(Expression) this.yysv[this.yysp - 3],
					(Expression) this.yysv[this.yysp - 1]);
		}
		this.yysv[this.yysp -= 3] = this.yyrv;
		return 7;
	}

	private int yyr37() { // arithmetic : expression '*' expression
		{
			this.yyrv = new Multiplication(this.lexer.location(),
					(Expression) this.yysv[this.yysp - 3],
					(Expression) this.yysv[this.yysp - 1]);
		}
		this.yysv[this.yysp -= 3] = this.yyrv;
		return 14;
	}

	private int yyr38() { // arithmetic : expression '/' expression
		{
			this.yyrv = new Division(this.lexer.location(),
					(Expression) this.yysv[this.yysp - 3],
					(Expression) this.yysv[this.yysp - 1]);
		}
		this.yysv[this.yysp -= 3] = this.yyrv;
		return 14;
	}

	private int yyr39() { // arithmetic : expression '+' expression
		{
			this.yyrv = new Addition(this.lexer.location(),
					(Expression) this.yysv[this.yysp - 3],
					(Expression) this.yysv[this.yysp - 1]);
		}
		this.yysv[this.yysp -= 3] = this.yyrv;
		return 14;
	}

	private int yyr4() { // node : statements
		{
			this.yyrv = this.yysv[this.yysp - 1];
		}
		this.yysv[this.yysp -= 1] = this.yyrv;
		return 8;
	}

	private int yyr40() { // arithmetic : expression '-' expression
		{
			this.yyrv = new Subtraction(this.lexer.location(),
					(Expression) this.yysv[this.yysp - 3],
					(Expression) this.yysv[this.yysp - 1]);
		}
		this.yysv[this.yysp -= 3] = this.yyrv;
		return 14;
	}

	private int yyr41() { // simple : NUMBERLITERAL
		this.yysp -= 1;
		return 10;
	}

	private int yyr42() { // simple : STRINGLITERAL
		this.yysp -= 1;
		return 10;
	}

	private int yyr43() { // simple : booleanliteral
		this.yysp -= 1;
		return 10;
	}

	private int yyr44() { // simple : IDENTIFIER
		this.yysp -= 1;
		return 10;
	}

	private int yyr45() { // booleanliteral : TRUE
		{
			this.yyrv = new BooleanLiteral(this.lexer.location(), true);
		}
		this.yysv[this.yysp -= 1] = this.yyrv;
		return 2;
	}

	private int yyr46() { // booleanliteral : FALSE
		{
			this.yyrv = new BooleanLiteral(this.lexer.location(), false);
		}
		this.yysv[this.yysp -= 1] = this.yyrv;
		return 2;
	}

	private int yyr5() { // form : FORM STRINGLITERAL '{' statements '}'
		{
			this.yyrv = new Form(this.lexer.location(),
					((StringLiteral) this.yysv[this.yysp - 4]).getValue(),
					(Statements) this.yysv[this.yysp - 2]);
		}
		this.yysv[this.yysp -= 5] = this.yyrv;
		return 5;
	}

	private int yyr6() { // statements : statement statements
		{
			this.yyrv = new Statements(this.lexer.location(),
					(Statement) this.yysv[this.yysp - 2],
					(Statements) this.yysv[this.yysp - 1]);
		}
		this.yysv[this.yysp -= 2] = this.yyrv;
		return this.yypstatements();
	}

	private int yyr7() { // statements : statement
		{
			this.yyrv = new Statements(this.lexer.location(),
					(Statement) this.yysv[this.yysp - 1]);
		}
		this.yysv[this.yysp -= 1] = this.yyrv;
		return this.yypstatements();
	}

	private int yyr8() { // statement : simplestatement
		this.yysp -= 1;
		return 12;
	}

	private int yyr9() { // statement : ifstatement
		this.yysp -= 1;
		return 12;
	}

	private int yys0() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case FORM:
			return 17;
		case IDENTIFIER:
			return 18;
		case IF:
			return 19;
		case NUMBERLITERAL:
			return 20;
		case STRINGLITERAL:
			return 21;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		}
		return 171;
	}

	private int yys10() {
		switch (this.yytok) {
		case FORM:
		case error:
		case '=':
		case ':':
		case NUMBERLITERAL:
		case '!':
		case '{':
		case STRING:
		case INTEGER:
		case ';':
		case ELSE:
		case MONEY:
		case FALSE:
		case '(':
		case IDENTIFIER:
		case BOOLEAN:
		case TRUE:
			return 171;
		}
		return this.yyr22();
	}

	private int yys14() {
		switch (this.yytok) {
		case FORM:
		case error:
		case '=':
		case ':':
		case NUMBERLITERAL:
		case '!':
		case '{':
		case STRING:
		case INTEGER:
		case ';':
		case ELSE:
		case MONEY:
		case FALSE:
		case '(':
		case IDENTIFIER:
		case BOOLEAN:
		case TRUE:
			return 171;
		}
		return this.yyr21();
	}

	private int yys15() {
		switch (this.yytok) {
		case FORM:
		case error:
		case '=':
		case ':':
		case NUMBERLITERAL:
		case '!':
		case '{':
		case STRING:
		case INTEGER:
		case ';':
		case ELSE:
		case MONEY:
		case FALSE:
		case '(':
		case IDENTIFIER:
		case BOOLEAN:
		case TRUE:
			return 171;
		}
		return this.yyr19();
	}

	private int yys16() {
		switch (this.yytok) {
		case FORM:
		case error:
		case '=':
		case ':':
		case NUMBERLITERAL:
		case '!':
		case '{':
		case STRING:
		case INTEGER:
		case ';':
		case ELSE:
		case MONEY:
		case FALSE:
		case '(':
		case IDENTIFIER:
		case BOOLEAN:
		case TRUE:
			return 171;
		}
		return this.yyr46();
	}

	private int yys18() {
		switch (this.yytok) {
		case FORM:
		case error:
		case '=':
		case ':':
		case NUMBERLITERAL:
		case '!':
		case '{':
		case STRING:
		case INTEGER:
		case ';':
		case ELSE:
		case MONEY:
		case FALSE:
		case '(':
		case IDENTIFIER:
		case BOOLEAN:
		case TRUE:
			return 171;
		}
		return this.yyr44();
	}

	private int yys2() {
		switch (this.yytok) {
		case FORM:
		case error:
		case '=':
		case ':':
		case NUMBERLITERAL:
		case '!':
		case '{':
		case STRING:
		case INTEGER:
		case ';':
		case ELSE:
		case MONEY:
		case FALSE:
		case '(':
		case IDENTIFIER:
		case BOOLEAN:
		case TRUE:
			return 171;
		}
		return this.yyr43();
	}

	private int yys20() {
		switch (this.yytok) {
		case FORM:
		case error:
		case '=':
		case ':':
		case NUMBERLITERAL:
		case '!':
		case '{':
		case STRING:
		case INTEGER:
		case ';':
		case ELSE:
		case MONEY:
		case FALSE:
		case '(':
		case IDENTIFIER:
		case BOOLEAN:
		case TRUE:
			return 171;
		}
		return this.yyr41();
	}

	private int yys21() {
		switch (this.yytok) {
		case IDENTIFIER:
			return 44;
		case OR:
		case '<':
		case GEQ:
		case '/':
		case NEQ:
		case '-':
		case '+':
		case '*':
		case '>':
		case LEQ:
		case ENDINPUT:
		case '^':
		case EQ:
		case AND:
			return this.yyr42();
		}
		return 171;
	}

	private int yys22() {
		switch (this.yytok) {
		case FORM:
		case error:
		case '=':
		case ':':
		case NUMBERLITERAL:
		case '!':
		case '{':
		case STRING:
		case INTEGER:
		case ';':
		case ELSE:
		case MONEY:
		case FALSE:
		case '(':
		case IDENTIFIER:
		case BOOLEAN:
		case TRUE:
			return 171;
		}
		return this.yyr45();
	}

	private int yys23() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case IDENTIFIER:
			return 18;
		case NUMBERLITERAL:
			return 20;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		case STRINGLITERAL:
			return 46;
		}
		return 171;
	}

	private int yys24() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case IDENTIFIER:
			return 18;
		case NUMBERLITERAL:
			return 20;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		case STRINGLITERAL:
			return 46;
		}
		return 171;
	}

	private int yys25() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case IDENTIFIER:
			return 18;
		case NUMBERLITERAL:
			return 20;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		case STRINGLITERAL:
			return 46;
		}
		return 171;
	}

	private int yys26() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case IDENTIFIER:
			return 18;
		case NUMBERLITERAL:
			return 20;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		case STRINGLITERAL:
			return 46;
		}
		return 171;
	}

	private int yys27() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case IDENTIFIER:
			return 18;
		case NUMBERLITERAL:
			return 20;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		case STRINGLITERAL:
			return 46;
		}
		return 171;
	}

	private int yys28() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case IDENTIFIER:
			return 18;
		case NUMBERLITERAL:
			return 20;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		case STRINGLITERAL:
			return 46;
		}
		return 171;
	}

	private int yys29() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case IDENTIFIER:
			return 18;
		case NUMBERLITERAL:
			return 20;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		case STRINGLITERAL:
			return 46;
		}
		return 171;
	}

	private int yys3() {
		switch (this.yytok) {
		case FORM:
		case error:
		case '=':
		case ':':
		case NUMBERLITERAL:
		case '!':
		case '{':
		case STRING:
		case INTEGER:
		case ';':
		case ELSE:
		case MONEY:
		case FALSE:
		case '(':
		case IDENTIFIER:
		case BOOLEAN:
		case TRUE:
			return 171;
		}
		return this.yyr23();
	}

	private int yys30() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case IDENTIFIER:
			return 18;
		case NUMBERLITERAL:
			return 20;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		case STRINGLITERAL:
			return 46;
		}
		return 171;
	}

	private int yys31() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case IDENTIFIER:
			return 18;
		case NUMBERLITERAL:
			return 20;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		case STRINGLITERAL:
			return 46;
		}
		return 171;
	}

	private int yys32() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case IDENTIFIER:
			return 18;
		case NUMBERLITERAL:
			return 20;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		case STRINGLITERAL:
			return 46;
		}
		return 171;
	}

	private int yys33() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case IDENTIFIER:
			return 18;
		case NUMBERLITERAL:
			return 20;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		case STRINGLITERAL:
			return 46;
		}
		return 171;
	}

	private int yys34() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case IDENTIFIER:
			return 18;
		case NUMBERLITERAL:
			return 20;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		case STRINGLITERAL:
			return 46;
		}
		return 171;
	}

	private int yys35() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case IDENTIFIER:
			return 18;
		case NUMBERLITERAL:
			return 20;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		case STRINGLITERAL:
			return 46;
		}
		return 171;
	}

	private int yys36() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case IDENTIFIER:
			return 18;
		case NUMBERLITERAL:
			return 20;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		case STRINGLITERAL:
			return 46;
		}
		return 171;
	}

	private int yys37() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case IDENTIFIER:
			return 18;
		case NUMBERLITERAL:
			return 20;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		case STRINGLITERAL:
			return 46;
		}
		return 171;
	}

	private int yys38() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case IDENTIFIER:
			return 18;
		case NUMBERLITERAL:
			return 20;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		case STRINGLITERAL:
			return 46;
		}
		return 171;
	}

	private int yys39() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case IDENTIFIER:
			return 18;
		case NUMBERLITERAL:
			return 20;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		case STRINGLITERAL:
			return 46;
		}
		return 171;
	}

	private int yys4() {
		switch (this.yytok) {
		case AND:
			return 27;
		case EQ:
			return 28;
		case GEQ:
			return 29;
		case LEQ:
			return 30;
		case NEQ:
			return 31;
		case OR:
			return 32;
		case '*':
			return 33;
		case '+':
			return 34;
		case '-':
			return 35;
		case '/':
			return 36;
		case '<':
			return 37;
		case '>':
			return 38;
		case '^':
			return 39;
		case ENDINPUT:
			return this.yyr2();
		}
		return 171;
	}

	private int yys43() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case IDENTIFIER:
			return 18;
		case NUMBERLITERAL:
			return 20;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		case STRINGLITERAL:
			return 46;
		}
		return 171;
	}

	private int yys45() {
		switch (this.yytok) {
		case '*':
			return 33;
		case '/':
			return 36;
		case OR:
		case '<':
		case GEQ:
		case NEQ:
		case '-':
		case '+':
		case ')':
		case LEQ:
		case IF:
		case '}':
		case '>':
		case STRINGLITERAL:
		case '^':
		case EQ:
		case ENDINPUT:
		case AND:
			return this.yyr33();
		}
		return 171;
	}

	private int yys46() {
		switch (this.yytok) {
		case FORM:
		case error:
		case '=':
		case ':':
		case NUMBERLITERAL:
		case '!':
		case '{':
		case STRING:
		case INTEGER:
		case ';':
		case ELSE:
		case MONEY:
		case FALSE:
		case '(':
		case IDENTIFIER:
		case BOOLEAN:
		case TRUE:
			return 171;
		}
		return this.yyr42();
	}

	private int yys47() {
		switch (this.yytok) {
		case AND:
			return 27;
		case EQ:
			return 28;
		case GEQ:
			return 29;
		case LEQ:
			return 30;
		case NEQ:
			return 31;
		case OR:
			return 32;
		case '*':
			return 33;
		case '+':
			return 34;
		case '-':
			return 35;
		case '/':
			return 36;
		case '<':
			return 37;
		case '>':
			return 38;
		case '^':
			return 39;
		case ')':
			return 67;
		}
		return 171;
	}

	private int yys48() {
		switch (this.yytok) {
		case '*':
			return 33;
		case '/':
			return 36;
		case OR:
		case '<':
		case GEQ:
		case NEQ:
		case '-':
		case '+':
		case ')':
		case LEQ:
		case IF:
		case '}':
		case '>':
		case STRINGLITERAL:
		case '^':
		case EQ:
		case ENDINPUT:
		case AND:
			return this.yyr31();
		}
		return 171;
	}

	private int yys49() {
		switch (this.yytok) {
		case '*':
			return 33;
		case '/':
			return 36;
		case OR:
		case '<':
		case GEQ:
		case NEQ:
		case '-':
		case '+':
		case ')':
		case LEQ:
		case IF:
		case '}':
		case '>':
		case STRINGLITERAL:
		case '^':
		case EQ:
		case ENDINPUT:
		case AND:
			return this.yyr32();
		}
		return 171;
	}

	private int yys50() {
		switch (this.yytok) {
		case EQ:
			return 28;
		case GEQ:
			return 29;
		case LEQ:
			return 30;
		case NEQ:
			return 31;
		case '*':
			return 33;
		case '+':
			return 34;
		case '-':
			return 35;
		case '/':
			return 36;
		case '<':
			return 37;
		case '>':
			return 38;
		case OR:
		case ')':
		case IF:
		case ENDINPUT:
		case '}':
		case STRINGLITERAL:
		case '^':
		case AND:
			return this.yyr34();
		}
		return 171;
	}

	private int yys51() {
		switch (this.yytok) {
		case '*':
			return 33;
		case '+':
			return 34;
		case '-':
			return 35;
		case '/':
			return 36;
		case OR:
		case '<':
		case GEQ:
		case NEQ:
		case ')':
		case LEQ:
		case IF:
		case '}':
		case '>':
		case STRINGLITERAL:
		case '^':
		case EQ:
		case ENDINPUT:
		case AND:
			return this.yyr25();
		}
		return 171;
	}

	private int yys52() {
		switch (this.yytok) {
		case '*':
			return 33;
		case '+':
			return 34;
		case '-':
			return 35;
		case '/':
			return 36;
		case OR:
		case '<':
		case GEQ:
		case NEQ:
		case ')':
		case LEQ:
		case IF:
		case '}':
		case '>':
		case STRINGLITERAL:
		case '^':
		case EQ:
		case ENDINPUT:
		case AND:
			return this.yyr28();
		}
		return 171;
	}

	private int yys53() {
		switch (this.yytok) {
		case '*':
			return 33;
		case '+':
			return 34;
		case '-':
			return 35;
		case '/':
			return 36;
		case OR:
		case '<':
		case GEQ:
		case NEQ:
		case ')':
		case LEQ:
		case IF:
		case '}':
		case '>':
		case STRINGLITERAL:
		case '^':
		case EQ:
		case ENDINPUT:
		case AND:
			return this.yyr30();
		}
		return 171;
	}

	private int yys54() {
		switch (this.yytok) {
		case '*':
			return 33;
		case '+':
			return 34;
		case '-':
			return 35;
		case '/':
			return 36;
		case OR:
		case '<':
		case GEQ:
		case NEQ:
		case ')':
		case LEQ:
		case IF:
		case '}':
		case '>':
		case STRINGLITERAL:
		case '^':
		case EQ:
		case ENDINPUT:
		case AND:
			return this.yyr26();
		}
		return 171;
	}

	private int yys55() {
		switch (this.yytok) {
		case AND:
			return 27;
		case EQ:
			return 28;
		case GEQ:
			return 29;
		case LEQ:
			return 30;
		case NEQ:
			return 31;
		case '*':
			return 33;
		case '+':
			return 34;
		case '-':
			return 35;
		case '/':
			return 36;
		case '<':
			return 37;
		case '>':
			return 38;
		case OR:
		case ')':
		case IF:
		case ENDINPUT:
		case '}':
		case STRINGLITERAL:
		case '^':
			return this.yyr35();
		}
		return 171;
	}

	private int yys56() {
		switch (this.yytok) {
		case FORM:
		case error:
		case '=':
		case ':':
		case NUMBERLITERAL:
		case '!':
		case '{':
		case STRING:
		case INTEGER:
		case ';':
		case ELSE:
		case MONEY:
		case FALSE:
		case '(':
		case IDENTIFIER:
		case BOOLEAN:
		case TRUE:
			return 171;
		}
		return this.yyr37();
	}

	private int yys57() {
		switch (this.yytok) {
		case '*':
			return 33;
		case '/':
			return 36;
		case OR:
		case '<':
		case GEQ:
		case NEQ:
		case '-':
		case '+':
		case ')':
		case LEQ:
		case IF:
		case '}':
		case '>':
		case STRINGLITERAL:
		case '^':
		case EQ:
		case ENDINPUT:
		case AND:
			return this.yyr39();
		}
		return 171;
	}

	private int yys58() {
		switch (this.yytok) {
		case '*':
			return 33;
		case '/':
			return 36;
		case OR:
		case '<':
		case GEQ:
		case NEQ:
		case '-':
		case '+':
		case ')':
		case LEQ:
		case IF:
		case '}':
		case '>':
		case STRINGLITERAL:
		case '^':
		case EQ:
		case ENDINPUT:
		case AND:
			return this.yyr40();
		}
		return 171;
	}

	private int yys59() {
		switch (this.yytok) {
		case FORM:
		case error:
		case '=':
		case ':':
		case NUMBERLITERAL:
		case '!':
		case '{':
		case STRING:
		case INTEGER:
		case ';':
		case ELSE:
		case MONEY:
		case FALSE:
		case '(':
		case IDENTIFIER:
		case BOOLEAN:
		case TRUE:
			return 171;
		}
		return this.yyr38();
	}

	private int yys60() {
		switch (this.yytok) {
		case '*':
			return 33;
		case '+':
			return 34;
		case '-':
			return 35;
		case '/':
			return 36;
		case OR:
		case '<':
		case GEQ:
		case NEQ:
		case ')':
		case LEQ:
		case IF:
		case '}':
		case '>':
		case STRINGLITERAL:
		case '^':
		case EQ:
		case ENDINPUT:
		case AND:
			return this.yyr29();
		}
		return 171;
	}

	private int yys61() {
		switch (this.yytok) {
		case '*':
			return 33;
		case '+':
			return 34;
		case '-':
			return 35;
		case '/':
			return 36;
		case OR:
		case '<':
		case GEQ:
		case NEQ:
		case ')':
		case LEQ:
		case IF:
		case '}':
		case '>':
		case STRINGLITERAL:
		case '^':
		case EQ:
		case ENDINPUT:
		case AND:
			return this.yyr27();
		}
		return 171;
	}

	private int yys62() {
		switch (this.yytok) {
		case AND:
			return 27;
		case EQ:
			return 28;
		case GEQ:
			return 29;
		case LEQ:
			return 30;
		case NEQ:
			return 31;
		case '*':
			return 33;
		case '+':
			return 34;
		case '-':
			return 35;
		case '/':
			return 36;
		case '<':
			return 37;
		case '>':
			return 38;
		case OR:
		case ')':
		case IF:
		case ENDINPUT:
		case '}':
		case STRINGLITERAL:
		case '^':
			return this.yyr36();
		}
		return 171;
	}

	private int yys64() {
		switch (this.yytok) {
		case AND:
			return 27;
		case EQ:
			return 28;
		case GEQ:
			return 29;
		case LEQ:
			return 30;
		case NEQ:
			return 31;
		case OR:
			return 32;
		case '*':
			return 33;
		case '+':
			return 34;
		case '-':
			return 35;
		case '/':
			return 36;
		case '<':
			return 37;
		case '>':
			return 38;
		case '^':
			return 39;
		case ')':
			return 69;
		}
		return 171;
	}

	private int yys66() {
		switch (this.yytok) {
		case FALSE:
			return 16;
		case IDENTIFIER:
			return 18;
		case NUMBERLITERAL:
			return 20;
		case TRUE:
			return 22;
		case '!':
			return 23;
		case '(':
			return 24;
		case '+':
			return 25;
		case '-':
			return 26;
		case STRINGLITERAL:
			return 46;
		}
		return 171;
	}

	private int yys67() {
		switch (this.yytok) {
		case FORM:
		case error:
		case '=':
		case ':':
		case NUMBERLITERAL:
		case '!':
		case '{':
		case STRING:
		case INTEGER:
		case ';':
		case ELSE:
		case MONEY:
		case FALSE:
		case '(':
		case IDENTIFIER:
		case BOOLEAN:
		case TRUE:
			return 171;
		}
		return this.yyr24();
	}

	private int yys7() {
		switch (this.yytok) {
		case FORM:
		case error:
		case '=':
		case ':':
		case NUMBERLITERAL:
		case '!':
		case '{':
		case STRING:
		case INTEGER:
		case ';':
		case ELSE:
		case MONEY:
		case FALSE:
		case '(':
		case IDENTIFIER:
		case BOOLEAN:
		case TRUE:
			return 171;
		}
		return this.yyr20();
	}

	private int yys75() {
		switch (this.yytok) {
		case AND:
			return 27;
		case EQ:
			return 28;
		case GEQ:
			return 29;
		case LEQ:
			return 30;
		case NEQ:
			return 31;
		case OR:
			return 32;
		case '*':
			return 33;
		case '+':
			return 34;
		case '-':
			return 35;
		case '/':
			return 36;
		case '<':
			return 37;
		case '>':
			return 38;
		case '^':
			return 39;
		case IF:
		case ENDINPUT:
		case '}':
		case STRINGLITERAL:
			return this.yyr14();
		}
		return 171;
	}

}
