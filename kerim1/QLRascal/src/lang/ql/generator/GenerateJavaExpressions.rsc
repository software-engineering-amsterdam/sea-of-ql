module lang::ql::generator::GenerateJavaExpressions

import lang::ql::ast::AST;
import lang::ql::ast::TypeEnvironment;

public str generateExpr(Expr e:ident(str name), TypeEnv env) = generateExpr(e, getTypeForIdentifier(name, env));

public str generateExpr(ident(str name), intType()) = "new Integer(<name>Model.getNumber().intValue())";
public str generateExpr(ident(str name), boolType()) = "new Boolean(<name>Question.isSelected())";
public str generateExpr(ident(str name), stringType()) = "<name>Question.getText()";

public str generateExpr(\int(int integer), _) = "new Integer(<integer>)";
public str generateExpr(\bool(bool boolean), _) = "new Boolean(<boolean>)";
public str generateExpr(string(str string), _) = "<string>";

public str generateExpr(pos(Expr val), TypeEnv env) = "new Integer(+<generateExpr(val, env)>.intValue())";
public str generateExpr(neg(Expr val), TypeEnv env) = "new Integer(-<generateExpr(val, env)>.intValue())";
public str generateExpr(not(Expr val), TypeEnv env) = "new Boolean(!<generateExpr(val, env)>.booleanValue())";

public str generateExpr(mul(Expr lhs, Expr rhs), TypeEnv env) = "new Integer(<generateExpr(lhs, env)>.intValue() * <generateExpr(rhs, env)>.intValue())";
public str generateExpr(div(Expr lhs, Expr rhs), TypeEnv env) = "new Integer(<generateExpr(lhs, env)>.intValue() / <generateExpr(rhs, env)>.intValue())";
public str generateExpr(add(Expr lhs, Expr rhs), TypeEnv env) = "new Integer(<generateExpr(lhs, env)>.intValue() + <generateExpr(rhs, env)>.intValue())";
public str generateExpr(sub(Expr lhs, Expr rhs), TypeEnv env) = "new Integer(<generateExpr(lhs, env)>.intValue() - <generateExpr(rhs, env)>.intValue())";
public str generateExpr(lt(Expr lhs, Expr rhs), TypeEnv env) = "new Boolean(<generateExpr(lhs, env)>.compareTo(<generateExpr(rhs, env)>) \< 0)";
public str generateExpr(leq(Expr lhs, Expr rhs), TypeEnv env) = "new Boolean(<generateExpr(lhs, env)>.compareTo(<generateExpr(rhs, env)>) \<= 0)";
public str generateExpr(gt(Expr lhs, Expr rhs), TypeEnv env) = "new Boolean(<generateExpr(lhs, env)>.compareTo(<generateExpr(rhs, env)>) \> 0)";
public str generateExpr(geq(Expr lhs, Expr rhs), TypeEnv env) = "new Boolean(<generateExpr(lhs, env)>.compareTo(<generateExpr(rhs, env)>) \>= 0)";
public str generateExpr(eq(Expr lhs, Expr rhs), TypeEnv env) = "new Boolean(<generateExpr(lhs, env)>.equals(<generateExpr(rhs, env)>))";
public str generateExpr(neq(Expr lhs, Expr rhs), TypeEnv env) = "new Boolean(!<generateExpr(lhs, env)>.equals(<generateExpr(rhs, env)>))";
public str generateExpr(and(Expr lhs, Expr rhs), TypeEnv env) = "new Boolean(<generateExpr(lhs, env)>.booleanValue() && <generateExpr(rhs, env)>.booleanValue())";
public str generateExpr(or(Expr lhs, Expr rhs), TypeEnv env) = "new Boolean(<generateExpr(lhs, env)>.booleanValue() || <generateExpr(rhs, env)>.booleanValue())";