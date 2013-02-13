module util::MapHelper


@doc{
Synopsis: Delete a key from a map.

Description:
Returns the map `m` minus the key `k`.

Examples:
<screen>
import Map;
delete(("apple":1,"pear":2), "apple");
</screen>
}
public map[&K,&V] delete(map[&K,&V] m, &K k) = 
  (key: m[key] | &K key <- m, key != k);
