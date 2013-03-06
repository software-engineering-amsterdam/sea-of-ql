package org.uva.sea.ql.values;

public abstract class Value {
	public abstract boolean isDefined();
	public Value add(Value val){
		throw new UnsupportedOperationException();
	}
	public Value and(Value val){
		throw new UnsupportedOperationException();
	}
	public Value div(Value val){
		throw new UnsupportedOperationException();
	}
	public Value eq(Value val){
		throw new UnsupportedOperationException();
	}
	public Value geq(Value val){
		throw new UnsupportedOperationException();
	}
	public Value gt(Value val){
		throw new UnsupportedOperationException();
	}
	public Value leq(Value val){
		throw new UnsupportedOperationException();
	}
	public Value lt(Value val){
		throw new UnsupportedOperationException();
	}
	public Value mul(Value val){
		throw new UnsupportedOperationException();
	}
	public Value neq(Value val){
		throw new UnsupportedOperationException();
	}
	public Value not(Value val){
		throw new UnsupportedOperationException();
	}
	public Value or(Value val){
		throw new UnsupportedOperationException();
	}
	public Value pos(Value val){
		throw new UnsupportedOperationException();
	}
	public Value neg(Value val){
		throw new UnsupportedOperationException();
	}
	public Value sub(Value val){
		throw new UnsupportedOperationException();
	}
	
	protected Value addInt(VInt val) {
		throw new UnsupportedOperationException();
	}
	protected Value divInt(VInt arg) {
		throw new UnsupportedOperationException();
	}
	protected Value mulInt(VInt arg) {
		throw new UnsupportedOperationException();
	}
	protected Value subInt(VInt arg) {
		throw new UnsupportedOperationException();
	}
	protected Value posInt(VInt arg) {
		throw new UnsupportedOperationException();
	}
	protected Value negInt(VInt arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value addMoney(VMoney val) {
		throw new UnsupportedOperationException();
	}
	protected Value divMoney(VMoney arg) {
		throw new UnsupportedOperationException();
	}
	protected Value mulMoney(VMoney arg) {
		throw new UnsupportedOperationException();
	}
	protected Value subMoney(VMoney arg) {
		throw new UnsupportedOperationException();
	}
	protected Value posMoney(VMoney arg) {
		throw new UnsupportedOperationException();
	}
	protected Value negMoney(VMoney arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value andBool(VBool val) {
		throw new UnsupportedOperationException();
	}
	protected Value eqBool(VBool val) {
		throw new UnsupportedOperationException();
	}
	protected Value geqBool(VBool val) {
		throw new UnsupportedOperationException();
	}
	protected Value gtBool(VBool val) {
		throw new UnsupportedOperationException();
	}
	protected Value leqBool(VBool val) {
		throw new UnsupportedOperationException();
	}
	protected Value ltBool(VBool val) {
		throw new UnsupportedOperationException();
	}
	protected Value neqBool(VBool val) {
		throw new UnsupportedOperationException();
	}
	protected Value notBool(VBool val) {
		throw new UnsupportedOperationException();
	}
	protected Value orBool(VBool val) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public abstract String toString();
}
