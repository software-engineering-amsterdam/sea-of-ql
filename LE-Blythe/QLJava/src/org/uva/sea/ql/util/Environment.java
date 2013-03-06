package org.uva.sea.ql.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Environment<K, V> {

	private Environment<K,V> parentEnvironment;
	private Map<K, V> map;
	
	private List<Environment<K,V>> branchedEnvironments;
	
	public Environment(){
		init(null);
	}
	
	
	public Environment(Environment<K,V> parentEnvironment){
		init(parentEnvironment);
	}
	
	
	private void init(Environment<K,V> parentEnvironment){
		this.map = new HashMap<K, V>();
		
		this.parentEnvironment = parentEnvironment;
		this.branchedEnvironments = new ArrayList<Environment<K,V>>();
	}
	
	
	private boolean hasParent(){
		return parentEnvironment != null;
	}
	
	
	private boolean parentContains(K key){
		return hasParent() && parentEnvironment.contains(key);
	}

	
	private boolean thisContains(K key){
		return map.containsKey(key);
	}
	
	
	public boolean contains(K key){
		return thisContains(key) || parentContains(key);
	}
	
	
	/** Child classes could override this method to return another value than null
	 */
	protected V undefinedValue(){
		return null;
	}
	
	
	public V get(K key){
		
		if(thisContains(key)){
			return map.get(key);
		}
		if(hasParent()){
			return parentEnvironment.get(key);
		}
		return undefinedValue();
	}
	
	
	public Environment<K,V> branchEnvironment(){
		
		Environment<K,V> branchedEnv = new Environment<K,V>(this);
		branchedEnvironments.add(branchedEnv);
		return branchedEnv;
	}
	
	
	public void put(K key, V val){
		
		if(parentContains(key)){
			parentEnvironment.put(key, val);
		}else{
			map.put(key, val);
		}
	}

	
	public Collection<Environment<K,V>> getBranchedEnvironments(){
		return branchedEnvironments;
	}
	
	
	public Collection<K> getIdentifiers(){
		return map.keySet();
	}
	
}
