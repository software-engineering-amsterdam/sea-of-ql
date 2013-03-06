package org.uva.sea.ql.util;

import java.util.Collection;


public interface IEnvironment<K, V> {

	public boolean contains(K key);
	public V get(K key);
	public void put(K key, V value);
	
	public IEnvironment<K,V> branchEnvironment();
	public Collection<IEnvironment<K,V>> getBranchedEnvironments();
}
